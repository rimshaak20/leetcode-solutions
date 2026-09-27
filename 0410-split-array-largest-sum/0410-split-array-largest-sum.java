class Solution {
    public int splitArray(int[] nums, int k) {
        long low=0;  long high=0; 
        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }
        long ans=high;
        while(low<=high){

            long mid=low+(high-low)/2;

            if(ispossible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }return (int)ans;
    }
    private boolean ispossible(int[] nums,int k,long sum){
        long currentsum=0;
        int count=1;
        for(int num: nums){
            if(currentsum + num > sum){
                count++;
                currentsum=num;
                if(count>k) return false;
            }else{
                currentsum+=num;
            }
        }
        return true;
    }
}