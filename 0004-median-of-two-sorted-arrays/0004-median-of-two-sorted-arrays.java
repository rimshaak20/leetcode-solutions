class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
         int n1 = arr1.length, n2 = arr2.length;

        // Always binary search on the smaller array for efficiency
        if (n1 > n2) return findMedianSortedArrays(arr2, arr1);

        int n = n1 + n2;
        int left = (n + 1) / 2;   // how many elements should be on the left side total
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;      // elements taken from arr1 into left half
            int mid2 = left - mid1;           // remaining elements taken from arr2

            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                // valid partition found
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;   // took too much from arr1, shift left
            } else {
                low = mid1 + 1;    // took too little from arr1, shift right
            }
        }

        return 0.0; // unreachable if inputs are valid sorted arrays
    }
}