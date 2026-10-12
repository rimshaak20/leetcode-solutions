class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack( 1, new ArrayList<>(), result, k, n);
        return result;      
    }
    private void backtrack(int idx, List<Integer> ls, List<List<Integer>> result,int k,int n ) {
        if (ls.size() == k) {
            if(n==0){
                result.add(new ArrayList<>(ls));
            }
            return;
        }

        for (int i = idx; i < 10; i++) {
            // if (i > start && candidates[i] == candidates[i - 1]) continue;

            // sorted, so every later number is also too big
            // if (candidates[i] > remaining) break;

            ls.add(i);
            backtrack(i + 1,ls, result,k,n-i);
            ls.remove(ls.size() - 1);
        }
    }
}