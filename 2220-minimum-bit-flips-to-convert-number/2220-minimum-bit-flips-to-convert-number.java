class Solution {
    public int minBitFlips(int start, int goal) {
        int c=0;
        int x=start^goal;
        while(x!=0){
            x= x & x-1;
            c++;
        }
        return c;
    }
}