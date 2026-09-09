class Solution {
    public long countCommas(long num) {
        int n = String.valueOf(num).length();
        //int n= (int)(Math.log(num)/Math.log(10))+ 1;
        if(n<4) return 0;

        int x= n/3;
        int y= n%3;
        if(y==0)    x=x-1;
        long pro= (long)Math.pow(10,3*x);
        long cnt=0;
        while(x>0){
            cnt += (num-pro+1)*x;
            num=pro-1;
            pro= pro/1000;
            x--;
        }
        return cnt;
    }
}
