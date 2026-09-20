class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int start=-1;   int end=-1;
        int low=0;  int high=n-1;
        
        if(n==0 || target > nums[n-1] || target < nums[0])  return new int[]{start,end};

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid] == target){
                start=mid;
                high=mid-1;
            }
            else if(target < nums[mid]){
                high=mid-1;
            }
            else low=mid+1;
        }

        low=0;  high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid] == target){
                end=mid;
                low=mid+1;
            }
            else if(target < nums[mid]){
                high=mid-1;
            }
            else low=mid+1;
        }
        
        return new int[]{start,end};
    }
}