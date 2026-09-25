class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        int low=1;
        for(int num: piles)
            high=Math.max(high,num);

        while(low <= high){
            int mid = (low + high)/2;
            if(isSpeedEnough(piles,mid,h)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }return low;
    }
    private boolean isSpeedEnough(int [] piles, int speed, int t){
        int totalsum=0;
        for(int num: piles){
            totalsum += (num+speed-1)/speed;
            if(totalsum>t)  return false;
        }
        return totalsum<=t;
    }
}