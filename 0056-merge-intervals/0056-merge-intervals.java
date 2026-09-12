class Solution {
    public int[][] merge(int[][] intervals) {
        int maxend=-1;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<List<Integer>> merged= new ArrayList<>();
        for(int []interval: intervals){
            if(merged.isEmpty() || merged.get(merged.size()-1).get(1) < interval[0])
                merged.add(Arrays.asList(interval[0],interval[1]));
            else{
                int last= merged.size()-1;
                maxend=Math.max(merged.get(last).get(1), interval[1]);
                merged.get(last).set(1,maxend);
            }
        }
        int [][] ans=new int[merged.size()][2];
        for(int i=0; i<ans.length; i++){
            ans[i][0]= merged.get(i).get(0);
            ans[i][1]= merged.get(i).get(1);
        }
        return ans;
    }
}