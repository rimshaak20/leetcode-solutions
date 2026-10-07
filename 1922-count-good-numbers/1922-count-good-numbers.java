class Solution {
    private static final long MOD = 1000000007L;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;
        long evenWays = modPower(5, evenPositions);
        long oddWays = modPower(4, oddPositions);

        return (int) ((evenWays * oddWays) % MOD);    
    }
    private long modPower(long base, long exponent) {
        long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }

        return result;
    }
}
 