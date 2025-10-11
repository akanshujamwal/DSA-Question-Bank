/*
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. 
If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. 
If no two numbers sum up to the target sum, the function should return an empty array.

Note that the target sum has to be obtained by summing two different integers in the array; 
you can't add a single integer to itself in order to obtain the target sum.

You can assume that there will be at most one pair of numbers summing up to the target sum.

Sample Input
array = [3, 5, -4, 8, 11, 1, -1, 6]
targetSum = 10

Sample Output
[-1, 11] // the numbers could be in reverse order 

*/

//!------------------brute-force solution------------------
import java.util.Arrays;

class Program {

    /**
     * Finds two numbers in an array that sum up to a target value.
     * This is the brute-force approach with a time complexity of O(n^2).
     *
     * @param array     An array of distinct integers.
     * @param targetSum The target sum.
     * @return An array containing the two numbers that sum to the target, or an
     *         empty array if no such pair is found.
     */
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Iterate through each element in the array
        for (int i = 0; i < array.length; i++) {
            // Iterate through the rest of the array starting from the next element
            for (int j = i + 1; j < array.length; j++) {
                // Check if the sum of the two numbers equals the target sum
                if (array[i] + array[j] == targetSum) {
                    // If they do, return them in a new array
                    return new int[] { array[i], array[j] };
                }
            }
        }
        // If no pair is found after checking all combinations, return an empty array
        return new int[0];
    }

    /**
     * The main method to run and test the twoNumberSum function.
     */
    public static void main(String[] args) {
        // Sample Input
        int[] array = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int targetSum = 10;

        // Call the function
        int[] result = twoNumberSum(array, targetSum);

        // Print the output
        if (result.length == 0) {
            System.out.println("No pair found that sums up to the target.");
        } else {
            // Arrays.toString() provides a nice string representation of an array
            System.out.println("Pair found: " + Arrays.toString(result));
        }

        // --- Test Case 2: No solution ---
        int[] array2 = { 1, 2, 3, 4, 5 };
        int targetSum2 = 10;
        int[] result2 = twoNumberSum(array2, targetSum2);
        if (result2.length == 0) {
            System.out.println("Test Case 2 (No Solution): Correctly returned an empty array.");
        } else {
            System.out.println("Test Case 2 (No Solution): Incorrectly found a pair: " + Arrays.toString(result2));
        }
    }
}