
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean negative = N < 0;
        if (negative) N = -N;

        double result = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return negative ? 1 / result : result;
    }
}