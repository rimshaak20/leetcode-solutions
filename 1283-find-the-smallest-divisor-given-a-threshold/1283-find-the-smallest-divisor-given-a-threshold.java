class Solution {
    private boolean canDivideWithinThreshold(
        int[] nums,
        int divisor,
        int threshold) {
        
        int total = 0;

        for (int num : nums) {
            total += (num + divisor - 1) / divisor;

            // Once total is too large, this divisor has failed.
            if (total > threshold) {
                return false;
            }
        }

        // A divisor is valid only if its final sum
        // does not go beyond the threshold.
        return total <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        long totalSum = 0;
        int high = 0;

        for (int num : nums) {
            totalSum += num;
            high = Math.max(high, num);
        }

        // If threshold >= total sum, divisor 1 is sufficient.
        if (threshold >= totalSum) {
            return 1;
        }

        // If threshold equals array length, each number must contribute 1, requiring max element.
        if (threshold == nums.length) {
            return high;
        }

        // The divisor cannot be smaller than 1.
        int low = 1;

        while (low < high) {
            // mid is the divisor being tested in this round.
            int mid = low + (high - low) / 2;

            // If mid works, try to find an even smaller divisor.
            if (canDivideWithinThreshold(nums, mid, threshold)) {
                high = mid;
            } else {
                // If mid fails, every smaller divisor will also fail.
                low = mid + 1;
            }
        }

        return low;
    }
}
