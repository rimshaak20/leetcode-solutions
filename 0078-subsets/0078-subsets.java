class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        subsets(ans,new ArrayList<>(), nums, 0);
        return ans;
    }
    private void subsets( List<List<Integer>> ans, List<Integer> sub, int[] nums, int idx){
        if(idx == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[idx]);
        subsets(ans,sub,nums,idx+1);

        sub.remove(sub.size()-1);
        subsets(ans,sub,nums,idx+1);
    }
}