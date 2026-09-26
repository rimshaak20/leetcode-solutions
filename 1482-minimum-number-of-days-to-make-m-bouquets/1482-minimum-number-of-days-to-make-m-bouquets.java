class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long) m*k > bloomDay.length)  return -1;

        int low=bloomDay[0];
        int high=bloomDay[0];
        int ans=-1;

        for(int day: bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        while(low<=high){
            
            int mid=low+(high-low)/2;
            if(canMakeBouquet(bloomDay,mid,m,k)){
                 ans=mid;
                 high=mid-1;
            }
            else    low=mid+1;
        }
        return ans;
    }
    private boolean canMakeBouquet(int[] bloomDay, int day, int m, int k){
        int bouquet=0;
        int consecutive=0;

        for(int bloom: bloomDay){
            if(bloom<=day){
                consecutive++;
                if(consecutive==k){
                    bouquet++;
                    consecutive=0;
                }
            }else   consecutive =0;
        }return bouquet>=m;
    }
}