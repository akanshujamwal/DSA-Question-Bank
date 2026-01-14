/*You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].*/
//solution 1
class Solution {
    public int[] plusOne(int[] digits) {
        // Start recursion from the last index
        if (helper(digits, digits.length - 1)) {
            // If helper returns true, it means we had an overflow (e.g., 99 -> 100)
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    // Helper function: returns 'true' if there is a carry to the next position
    private boolean helper(int[] digits, int index) {
        // Base Case: If we went past the first digit, we have a carry overflow
        if (index < 0)
            return true;

        if (digits[index] < 9) {
            digits[index]++;
            return false; // No more carry needed, stop recursion
        } else {
            digits[index] = 0;
            // Recursive Step: Pass the carry to the left (index - 1)
            return helper(digits, index - 1);
        }
    }
}
//solution 2
class Solution {
    public int[] plusOne(int[] digits) {
        // Start recursion from the last index
        if (helper(digits, digits.length - 1)) {
            // If helper returns true, it means we had an overflow (e.g., 99 -> 100)
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    // Helper function: returns 'true' if there is a carry to the next position
    private boolean helper(int[] digits, int index) {
        // Base Case: If we went past the first digit, we have a carry overflow
        if (index < 0)
            return true;

        if (digits[index] < 9) {
            digits[index]++;
            return false; // No more carry needed, stop recursion
        } else {
            digits[index] = 0;
            // Recursive Step: Pass the carry to the left (index - 1)
            return helper(digits, index - 1);
        }
    }
}