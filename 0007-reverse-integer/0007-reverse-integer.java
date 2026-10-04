class Solution {
    public int reverse(int n) {
      boolean isNegative = n < 0;
 
        // Convert the absolute value to a string to avoid reversing the minus sign.
        // Use Math.abs() to discard the negative sign before string conversion.
        String s = String.valueOf(Math.abs((long) n));
 
        // Reverse the string using StringBuilder.
        String reversed = new StringBuilder(s)
                .reverse()
                .toString();
 
        // Convert the reversed string back to an integer.
        long reversedNum = Long.parseLong(reversed);
        // Restore the negative sign if the original number was negative.
        if (isNegative) reversedNum = -reversedNum;

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) return 0;
        return (int) reversedNum;
    }
}