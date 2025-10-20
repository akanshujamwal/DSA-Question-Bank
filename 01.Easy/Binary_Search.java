/*
 * Binary Search
Write a function that takes in a sorted array of integers as well as a target integer. The function should use the Binary Search algorithm to determine if the target integer is contained in the array and should return its index if it is, otherwise -1.

If you're unfamiliar with Binary Search, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.

Sample Input
array = [0, 1, 21, 33, 45, 45, 61, 71, 72, 73]
target = 33
Sample Output
3
 */

 import java.util.*;

class Program {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;

            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }
}
