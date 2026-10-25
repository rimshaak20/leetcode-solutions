class Solution {
    public int[] singleNumber(int[] arr) {
        int xorResult = 0;

        for (int num : arr) {
            xorResult ^= num;
        }

        int mask = xorResult & -xorResult;

        int group1 = 0;
        int group2 = 0;

        for (int num : arr) {
            if ((num & mask) != 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }

        return new int[]{group1, group2};
    }
}
