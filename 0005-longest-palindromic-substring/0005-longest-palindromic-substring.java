class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int c=-1;
        String word="";

        if(n<=1) return s;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(pallindrome(s.substring(i,j+1)) && word.length()<(j-i+1)){
                    word = s.substring(i,j+1);    
                }
            }
        } 
        return word;       
    }
    private boolean pallindrome(String word){
        int low=0; int high=word.length()-1;
        while(low<high){
            if(word.charAt(low) != word.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}