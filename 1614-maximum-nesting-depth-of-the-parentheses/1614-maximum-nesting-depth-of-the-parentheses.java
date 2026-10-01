class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        if(n<=1)    return 0;
        StringBuilder sent=new StringBuilder();
        int c=0;
        int maxNest=0;
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            switch(ch){
                case '(':
                    c++;
                    break;
                case ')':
                    c--;
                    break;
                default:
                    break;
            }
            sent.append(ch);
            maxNest=Math.max(maxNest,c);
        }
        return maxNest;
    }
}