class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);
        func(0, ans,new ArrayList<>(), nums);
        return ans;
    }
    private void func(int idx, List<List<Integer>> ans, List<Integer> ls, int[] nums){
        ans.add(new ArrayList<>(ls));
        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1])   continue;
            ls.add(nums[i]);
            func(i+1,ans,ls,nums);
            ls.remove(ls.size()-1);
        }
    }
}