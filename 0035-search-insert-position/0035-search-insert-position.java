class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;      int n=nums.length; 
        int ans=n;      int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)    return mid;
            else if (nums[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }return ans;
    }
}