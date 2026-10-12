class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> ans = new ArrayList<>();
        func(0,ans,new ArrayList<>(),candidates,target);
        return ans;   
    }

    private void func(int i, List<List<Integer>>ans, List<Integer> comb, int[] nums, int t){
        if(nums.length == i){
            if(t == 0){
                ans.add(new ArrayList<>(comb));
            }
            return;
        }
        if(t >= nums[i]){
            comb.add(nums[i]);
            func(i, ans, comb, nums, t-nums[i]);
            comb.remove(comb.size()-1);
        }
        func(i+1, ans, comb, nums, t);
    }
}
        
