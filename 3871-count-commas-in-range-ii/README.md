<h2><a href="https://leetcode.com/problems/count-commas-in-range-ii">4248. Count Commas in Range II</a></h2><h3>Medium</h3><hr><p>You are given an integer <code>n</code>.</p>

<p>Return the <strong>total</strong> number of commas used when writing all integers from <code>[1, n]</code> (inclusive) in <strong>standard</strong> number formatting.</p>

<p>In <strong>standard</strong> formatting:</p>

<ul>
	<li>A comma is inserted after <strong>every three</strong> digits from the right.</li>
	<li>Numbers with <strong>fewer</strong> than 4 digits contain no commas.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 1002</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The numbers <code>&quot;1,000&quot;</code>, <code>&quot;1,001&quot;</code>, and <code>&quot;1,002&quot;</code> each contain one comma, giving a total of 3.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 998</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p><strong>​​​​​​​</strong>All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>15</sup></code></li>
</ul>


---

## 🐛 Bugs & Learnings

### 1. Wrong group boundary (`n/3` vs `(n-1)/3`)
For digit-lengths that are an exact multiple of 3 (e.g. 6-digit numbers), using `x = n/3` overshoots the group boundary, making `pro` end up with more digits than `num` itself — causing negative/garbage counts.
**Fix:** use `x = (n-1)/3`, or explicitly correct for `n % 3 == 0`:
```java
int x = n / 3;
int y = n % 3;
if (y == 0) x = x - 1;
```

### 2. Boundary double-counting
Carrying `num = pro` forward into the next loop iteration reused a boundary value that was already counted in the previous group — causing an off-by-one overcount.
**Fix:**
```java
num = pro - 1;   // exclude the boundary already counted
```

### 3. Floating-point digit-count error via `Math.log10`
`Math.log(num)/Math.log(10)` can evaluate to something like `2.9999999999999996` instead of exactly `3.0` due to floating-point rounding, and `(int)` truncation then undercounts digits by one — this silently broke exact powers of 10 (e.g. `num = 1000`).
**Fix:** avoid floating-point logs for digit counting:
```java
int n = String.valueOf(num).length();
```

**Takeaway:** Integer-division boundary math (`n/3` vs `(n-1)/3`), off-by-one range boundaries, and floating-point log-based digit counting are all recurring traps in range/digit-counting problems — worth double-checking each one explicitly rather than assuming symmetry.
