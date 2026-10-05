
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean negative = N < 0;
        if (negative) N = -N;

        double result = 1;
        while (N > 0) {
            if (N % 2 == 0) {
                x *= x;
                N /= 2;
            }
            else{
                result *= x;
                N=N-1;
            }
        }
        return negative ? 1 / result : result;
        
    }
}