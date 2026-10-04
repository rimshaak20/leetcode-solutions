class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(n != goal.length()) return false;
        if(s.equals(goal))  return true;
        String rotate="";
        
        for(int i=0; i<s.length()-1; i++){
            rotate=s.substring(i+1,n) + s.substring(0,i+1);
            if(rotate.equals(goal)) return true;
        }
        return false;
    }
}