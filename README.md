A collection of LeetCode questions to ace the coding interview! - Created using [LeetHub v2](https://github.com/arunbhardwaj/LeetHub-2.0)
<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0026-remove-duplicates-from-sorted-array](https://github.com/rimshaak20/leetcode-solutions/tree/master/0026-remove-duplicates-from-sorted-array) |
| [1752-check-if-array-is-sorted-and-rotated](https://github.com/rimshaak20/leetcode-solutions/tree/master/1752-check-if-array-is-sorted-and-rotated) |
## Two Pointers
|  |
| ------- |
| [0026-remove-duplicates-from-sorted-array](https://github.com/rimshaak20/leetcode-solutions/tree/master/0026-remove-duplicates-from-sorted-array) |
## Math
|  |
| ------- |
| [3870-count-commas-in-range](https://github.com/rimshaak20/leetcode-solutions/tree/master/3870-count-commas-in-range) |

#Bugs & learning
Bug: Integer Overflow in reversePairs (Merge Sort)

Problem: LeetCode 493 – Reverse Pairs (nums[i] > 2 * nums[j])

Bug faced:
Test case [2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647] gave output 15 instead of expected 0.

Root cause:
2 * arr[right] overflows when arr[right] is near Integer.MAX_VALUE, wrapping to a negative number in int arithmetic. So arr[left] > (negative number) becomes true for every pair — false positives.

Also learned: casting after the multiplication ((long)(2*arr[right])) doesn't help — the overflow already happened inside the parentheses. The cast must be applied before the multiplication so the whole operation runs in long.

Fix:
while (right <= high && (long) arr[left] > 2L * arr[right])
    right++;

Takeaway: Whenever a problem involves 2 * x (or any multiplication) on int[] values that could be near Integer.MAX_VALUE, cast to long before the multiplication, not after.

<!---LeetCode Topics End-->