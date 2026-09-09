A collection of LeetCode questions to ace the coding interview! - Created using [LeetHub v2](https://github.com/arunbhardwaj/LeetHub-2.0)
<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0026-remove-duplicates-from-sorted-array](https://github.com/rimshaak20/leetcode-solutions/tree/master/0026-remove-duplicates-from-sorted-array) |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
| [1752-check-if-array-is-sorted-and-rotated](https://github.com/rimshaak20/leetcode-solutions/tree/master/1752-check-if-array-is-sorted-and-rotated) |
## Two Pointers
|  |
| ------- |
| [0026-remove-duplicates-from-sorted-array](https://github.com/rimshaak20/leetcode-solutions/tree/master/0026-remove-duplicates-from-sorted-array) |
## Math
|  |
| ------- |
| [3870-count-commas-in-range](https://github.com/rimshaak20/leetcode-solutions/tree/master/3870-count-commas-in-range) |
<<<<<<< HEAD



=======
## Binary Search
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
## Divide and Conquer
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
## Binary Indexed Tree
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
## Segment Tree
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
## Merge Sort
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
## Ordered Set
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
## Treap
|  |
| ------- |
| [0493-reverse-pairs](https://github.com/rimshaak20/leetcode-solutions/tree/master/0493-reverse-pairs) |
>>>>>>> 75f1ad906b448175ca4b841f5a44b4a83de02467
<!---LeetCode Topics End-->

## Bugs & Learnings

### Bug: Integer Overflow in `reversePairs` (Merge Sort)

**Problem:** LeetCode 493 – Reverse Pairs (`nums[i] > 2 * nums[j]`)

**Bug faced:**
Test case `[2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647]` gave output `15` instead of expected `0`.

**Root cause:**
`2 * arr[right]` overflows when `arr[right]` is near `Integer.MAX_VALUE`, wrapping to a negative number in `int` arithmetic. So `arr[left] > (negative number)` becomes true for every pair — false positives.
Also learned: casting *after* the multiplication (`(long)(2*arr[right])`) doesn't help — the overflow already happened inside the parentheses. The cast must be applied *before* the multiplication so the whole operation runs in `long`.

**Fix:**
```java
while (right <= high && (long) arr[left] > 2L * arr[right])
    right++;
```

**Takeaway:** Whenever a problem involves `2 * x` (or any multiplication) on `int[]` values that could be near `Integer.MAX_VALUE`, cast to `long` **before** the multiplication, not after.

# Bugs & Learnings

A running log of bugs I've hit while solving problems, and how I fixed them.

---

##  Wrong group boundary (`n/3` vs `(n-1)/3`) in `countCommas`

**Problem:** Count total commas when writing all integers from 1 to n.

**Bug faced:**
For numbers whose digit-length `n` is an exact multiple of 3 (e.g. `num = 123456`, 6 digits), the function produced a negative/garbage count.

**Root cause:**
`x` (number of commas for a `n`-digit number) should be `(n-1)/3`, and `pro = 10^(3x)` marks the lower bound of that digit-length group. Using `x = n/3` instead of `(n-1)/3` only gives the same value when `n` is *not* a multiple of 3. When `n` **is** a multiple of 3, `n/3` overshoots by one group, so `pro` ends up with *more digits than `num` itself* — making `num - pro + 1` go negative.

**Fix:**
```java
int x = n / 3;
int y = n % 3;
if (y == 0) x = x - 1;   // correct overshoot when n is an exact multiple of 3
```
(equivalent to just using `x = (n - 1) / 3` directly)

**Takeaway:** When deriving a "group size" or "bucket index" from an integer division, always check the exact-multiple boundary case separately — `n/3` and `(n-1)/3` silently diverge exactly when `n % 3 == 0`, which is easy to miss since most test cases won't land exactly on that boundary.

## 3. Boundary double-counting in `countCommas`

**Problem:** Same as above — count total commas from 1 to n.

**Bug faced:**
For `num = 1234567` (7 digits, requires 2 loop iterations across digit-groups), output was `1,468,137` instead of the correct `1,468,136` — off by exactly 1.

**Root cause:**
After processing one digit-length group, the loop set `num = pro` before moving to the next (smaller) group. But `pro` (the lower bound of the group just processed) was being reused as the *upper bound* of the next group too — so that one boundary number got counted twice: once with the correct (higher) comma-weight, and again with the wrong (lower) one.

**Fix:**
```java
num = pro - 1;   // exclude the boundary value already counted, don't reuse it
```

**Takeaway:** When splitting a range into buckets/groups in a loop and carrying a boundary value forward to the next iteration, double check whether that boundary was already included in the previous iteration's count — off-by-one bugs like this often show up only on specific digit-length transitions, not in small/simple test cases.

---
# 4. Floating-point digit-count error via `Math.log10`

**Problem:** Same as above — count total commas from 1 to n.

**Bug faced:**
For `num = 1000` (exactly 4 digits), the function returned `0` instead of the expected `1`.

**Root cause:**
Digit count was computed as:
```java
int n = (int)(Math.log(num) / Math.log(10)) + 1;
```
`Math.log(1000)/Math.log(10)` is a floating-point computation and can evaluate to something like `2.9999999999999996` instead of exactly `3.0` due to rounding error. Casting to `int` **truncates** (doesn't round), so `2.9999999999999996` becomes `2`, and `+1` gives `n = 3` — one less than the true digit count of `4`. This silently triggered the `n < 4` early-return path when it shouldn't have.

**Fix:** avoid floating-point logarithms for digit counting entirely — use exact integer/string methods instead:
```java
int n = String.valueOf(num).length();
```
or, without string conversion:
```java
int n = 0;
long temp = num;
while (temp > 0) {
    n++;
    temp /= 10;
}
```

**Takeaway:** Never use `Math.log(x)/Math.log(10)` (or any floating-point log) to count digits of an integer. Floating-point rounding error can land exactly on a power-of-10 boundary and silently produce an off-by-one result — this kind of bug is especially dangerous because it only shows up for specific inputs (exact powers of 10), so it can easily slip past casual testing. Prefer `String.valueOf(x).length()` or a simple division loop for guaranteed-exact digit counts.

---
