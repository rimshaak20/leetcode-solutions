class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        int i=0;
        int j=cols-1;
        while(i<rows && j>=0){
            int current=matrix[i][j];
            if(current==target)
                return true;
            else if(current>target)
                j--;
            else
                i++;
        }
        return false;
    }
}