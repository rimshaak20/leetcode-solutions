class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Stop early if the matrix has no usable cells.
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
 
        // These store the matrix dimensions for index mapping.
        int rows = matrix.length;
        int cols = matrix[0].length;
 
        // Search boundaries of the virtual 1D sorted array.
        int low = 0;
        int high = rows * cols - 1;
 
        while (low <= high) {
            // Pick the middle position of the current search space.
            int mid = low + (high - low) / 2;
 
            // Convert the virtual 1D index into the real matrix position.
            int row = mid / cols;
 
            // This gives the column inside the chosen row.
            int col = mid % cols;
 
            // Read the actual value stored at the mapped position.
            int current = matrix[row][col];
 
            // Return immediately because the target is found here.
            if (current == target) {
                return true;
            }
 
            // Move right because the target must be after this smaller value.
            if (current < target) {
                low = mid + 1;
            } else {
                // Move left because this value and everything after it are too large.
                high = mid - 1;
            }
        }
 
        return false;    
    }
}