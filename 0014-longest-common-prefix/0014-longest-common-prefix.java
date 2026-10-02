class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l=Integer.MAX_VALUE;
        String prefix="";
        for(String s: strs){
            l=Math.min(l,s.length());
        }
        for(int i=0;i<l;i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(ch!=strs[j].charAt(i))
                    return prefix;
            }
            prefix+=ch;
        }
        return prefix;
    }
}