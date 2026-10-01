class Solution {
    public int romanToInt(String s) {
       int n=s.length();
       int val=0;
       
       for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(i!=n-1 && func(ch) < func(s.charAt(i+1))){
                val+=func(s.charAt(i+1))-func(ch);
                i++;
            }
            else{
                val+=func(ch);
            }
       }
       return val;
    }
    private int func(char ch){
        int val=-1;
        switch(ch){
            case 'I':
                val=1;
                break;
            case 'V':
                val=5;
                break;
            case 'X':
                val=10;
                break;
            case 'L':
                val=50;
                break;
            case 'C':
                val=100;
                break;
            case 'D':
                val=500;
                break;
            case 'M':
                val=1000;
                break;
        }
        return val;
    }
}