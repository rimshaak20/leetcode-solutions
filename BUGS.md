\# Bugs \& Learnings



A running log of bugs I've hit while solving problems, and how I fixed them.



\---



\## Integer Overflow in `reversePairs` (Merge Sort)



\*\*Problem:\*\* LeetCode 493 – Reverse Pairs (`nums\[i] > 2 \* nums\[j]`)



\*\*Bug faced:\*\*

Test case `\[2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647]` gave output `15` instead of expected `0`.



\*\*Root cause:\*\*

`2 \* arr\[right]` overflows when `arr\[right]` is near `Integer.MAX\_VALUE`, wrapping to a negative number in `int` arithmetic.



\*\*Fix:\*\*

```java

while (right <= high \&\& (long) arr\[left] > 2L \* arr\[right])

&#x20;   right++;

```



\*\*Takeaway:\*\* Cast to `long` \*before\* multiplying, not after — casting the result of an overflowed operation doesn't undo the overflow.



\---

