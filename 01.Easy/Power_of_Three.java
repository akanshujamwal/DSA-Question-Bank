/*
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that n ==
 * 3x.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 33
 * Example 2:
 * 
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * Example 3:
 * 
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 * 
 * 
 * Constraints:
 * 
 * -231 <= n <= 231 - 1
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        // Base Case 1: If n is 1, we reached the end successfully
        if (n == 1)
            return true;

        // Base Case 2: If n < 1 (e.g. 0 or negative) or not divisible by 3
        if (n < 1 || n % 3 != 0)
            return false;

        // Recursive Step
        return isPowerOfThree(n / 3);
    }
}