class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int bit=0; bit<32; bit++){
            int count=0;
            for(int x:nums){
                if(((x >> bit) & 1) == 1 )  count++;
            }
            if(count % 3 == 1){
                ans = ans | (1 << bit);
            }
        }
        return ans;
    }
}