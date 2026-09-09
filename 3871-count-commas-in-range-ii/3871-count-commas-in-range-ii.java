class Solution {
    public long countCommas(long num) {
        long count = 0;
        long start = 1000;

        while (start <= num) {
            count += num - start + 1;
            start *= 1000;
        }

        return count;
    }
}
