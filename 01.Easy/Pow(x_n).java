/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104
*/
class Solution {
    public double myPow(double x, int n) {
        // Base case: anything to the power of 0 is 1
        if (n == 0)
            return 1.0;

        // Use long long to prevent overflow when n = -2147483648
        long N = n;

        // If n is negative, invert x and make N positive
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;

        // Loop until N becomes 0
        while (N > 0) {
            // If N is odd, multiply the current x to the result
            if (N % 2 == 1) {
                result = result * x;
            }

            // Square the base x and halve the exponent N
            x = x * x;
            N = N / 2;
        }

        return result;
    }
}
// Solution 2
class Solution {
    public double myPow(double x, int n) {
        long N = n;  // prevent overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) return 1.0;

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
