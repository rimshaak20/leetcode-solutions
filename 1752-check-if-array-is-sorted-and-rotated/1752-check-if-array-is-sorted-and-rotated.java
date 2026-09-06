class Solution {
    public boolean check(int[] nums) {
        int n= nums.length;
        int j=-1;
        for(int i=0; i< n-1 ; i++){
            if(nums[i]>nums[i+1]){
                j=i+1;
                break;
            }
        }
        if(j==-1) return true;
        boolean flag=true; 
        int r=j; int l=j+1;
        l=l%n;
        while( l!=j){
            if(nums[r]>nums[l]){
                flag=false;
                break;
            }
            r++; l++;
            r=r%n; l=l%n;
        }
        return flag;
    }
}