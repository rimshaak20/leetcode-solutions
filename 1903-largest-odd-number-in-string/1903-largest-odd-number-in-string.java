class Solution {
    public String largestOddNumber(String num) {
        int x=num.length()-1;
        StringBuilder ans=new StringBuilder();

        while(x>=0){
            if((int)(num.charAt(x)) % 2 ==1) {
                ans.append(num.substring(0,x+1));
                break;
            }
            else    x--;
        } 
        return ans.toString() ; 
    }
}