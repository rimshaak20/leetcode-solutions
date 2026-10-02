class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int c=-1;
        String word="";

        if(n<=1) return s;

        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            for(int j=n-1; j>=i; j--){
                if(s.charAt(j)==ch){
                    if(pallindrome(s.substring(i,j+1)) && c<s.substring(i,j+1).length()){
                       word="";
                       word += s.substring(i,j+1);
                       c=word.length();
                    }
                    
                }
            }
        } 
        return word;       
    }
    private boolean pallindrome(String word){
        int low=0; int high=word.length()-1;
        while(low<=high){
            if(word.charAt(low) != word.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}