
/* Given two non-empty arrays of integers, write a function that determines
 whether the second array is a subsequence of the first one.

 
  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4] , and so do the numbers 
  [2, 4] . Note
  that a single number in an array and the array itself are both valid
  subsequences of the array.

Sample Input
array  = [5, 1, 22, 25, 6, -1, 8, 10]
sequence  = [1, 6, -1, 10]

Sample Output
true




*/
import java.util.*;

/**
 * A class to determine if one list of integers is a subsequence of another.
 */
class Program {

    /**
     * Checks if a given sequence of integers is a subsequence of a main array.
     * A subsequence's elements must appear in the same order in the main array,
     * but they don't have to be adjacent.
     *
     * @param array    The main list of integers.
     * @param sequence The potential subsequence to check.
     * @return true if 'sequence' is a subsequence of 'array', false otherwise.
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // A pointer for the current position in the sequence list.
        int seqIndex = 0;

        // Iterate through the main array. The loop will also stop if we've found all
        // elements of the sequence.
        for (int i = 0; i < array.size() && seqIndex < sequence.size(); i++) {
            // If the current element in the array matches the current element we're looking
            // for in the sequence...
            if (array.get(i).equals(sequence.get(seqIndex))) {
                // ...then move to the next element in the sequence.
                seqIndex++;
            }
        }

        // If seqIndex has reached the length of the sequence, it means we have found
        // all elements of the sequence in the correct order within the array.
        return seqIndex == sequence.size();
    }

    /**
     * The main method to execute the program and test the isValidSubsequence
     * function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Sample Input
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);

        // Call the function and store the result
        boolean result = isValidSubsequence(array, sequence);

        // Print the result to the console
        System.out.println("Input Array: " + array);
        System.out.println("Input Sequence: " + sequence);
        System.out.println("Is it a valid subsequence? " + result); // Expected output: true

        // --- Another test case ---
        List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sequence2 = Arrays.asList(1, 3, 5);
        boolean result2 = isValidSubsequence(array2, sequence2);
        System.out.println("\nInput Array: " + array2);
        System.out.println("Input Sequence: " + sequence2);
        System.out.println("Is it a valid subsequence? " + result2); // Expected output: true

        // --- A failing test case ---
        List<Integer> array3 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence3 = Arrays.asList(1, 6, -1, 5); // '5' comes after '-1', which is incorrect order
        boolean result3 = isValidSubsequence(array3, sequence3);
        System.out.println("\nInput Array: " + array3);
        System.out.println("Input Sequence: " + sequence3);
        System.out.println("Is it a valid subsequence? " + result3); // Expected output: false
    }
}