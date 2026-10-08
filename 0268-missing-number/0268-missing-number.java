class Solution {
    public int missingNumber(int[] nums) {
        boolean[] present = new boolean[nums.length + 1];

        // Record every value that appears in the input.
        for (int value : nums) {
            present[value] = true;
        }

        // The first unmarked index is the missing value.
        for (int value = 0; value <= nums.length; value++) {
            // An unmarked position represents the missing value.
            if (!present[value]) {
                return value;
            }
        }

        return -1;
    }
}
