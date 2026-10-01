
class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int val=0;
        int sign =1;
        int i=0;

        while(i<n && s.charAt(i)==' ')
            i++;
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            if(s.charAt(i)=='-')    sign=-1;
            i++;
        }

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            // 4. Check overflow BEFORE val * 10 + digit
            if (val > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            val = val * 10 + digit;
            i++;
        }
        
        return val*sign;
    }
}