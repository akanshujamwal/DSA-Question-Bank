/*
 * Write a function that takes in a non-empty array of integers that are sorted
 * in
 * ascending order and returns a new array of the same length with the squares
 * of the
 * original integers also sorted in ascending order.
 * 
 *  Sample Input
 *  array = [1, 2, 3, 5, 6, 8, 9]
 *  Sample Output
 *  [1, 4, 9, 25, 36, 64, 81]
 */

 import java.util.*;

class Program {
    /**
     * Squares each element of a sorted integer array and returns the new sorted
     * array.
     * This implementation first squares each element in place and then sorts the
     * entire array.
     * Time complexity: O(n log n) | Space complexity: O(1) (if sorting in-place)
     *
     * @param array The input array of integers, assumed to be sorted.
     * @return A new array containing the squares of the input elements in sorted
     *         order.
     */
    public int[] sortedSquaredArray(int[] array) {
        // Step 1: Square each element in the array.
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }

        // Step 2: Sort the array of squared numbers.
        Arrays.sort(array);

        // Step 3: Return the modified (now sorted and squared) array.
        return array;
    }

    /**
     * The main method to run and test the sortedSquaredArray function.
     */
    public static void main(String[] args) {
        // Create an instance of the Program class to call the method.
        Program prog = new Program();

        // Define a sample input array. A mix of negative and positive numbers is a good
        // test case.
        int[] inputArray = { -6, -4, 1, 2, 3, 5 };

        // Print the original array for context.
        System.out.println("Input Array:          " + Arrays.toString(inputArray));

        // Call the method. Note: This method modifies the original array.
        int[] resultArray = prog.sortedSquaredArray(inputArray);

        // Print the final result. Arrays.toString() is a handy utility for printing
        // arrays.
        System.out.println("Sorted Squared Array: " + Arrays.toString(resultArray));
    }
}