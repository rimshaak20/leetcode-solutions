import java.lang.*;
class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        int c=0;
        String sent="";
        String word="";

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                word+='(';
                c++;
            }
            if(s.charAt(i)==')'){
                word+=')';
                c--;
            }
            if(c==0){
                sent+=word.substring(1,word.length()-1);
                word="";
            }

        }
        return sent;    
    }
}