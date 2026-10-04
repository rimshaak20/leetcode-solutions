class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        if(n!=t.length())   return false;

        int[] a=new int[256];
        int[] b=new int[256];

        for(int i=0; i<n; i++){
            a[s.charAt(i)]++;
            b[t.charAt(i)]++;
        }
        // 
        //instead comparing like this we can do
        return Arrays.equals(a,b);
    }

}