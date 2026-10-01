class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int low=0;
        int high=n-1;
        while(low<high){
            char a = s.charAt(low);
            char b = s.charAt(high);

            if (!Character.isLetterOrDigit(a)) {
                low++;
            } else if (!Character.isLetterOrDigit(b)) {
                high--;
            } else {
                if (Character.toLowerCase(a) != Character.toLowerCase(b)) return false;
                low++;
                high--;
            }
        } 
        return true;   
    }
}