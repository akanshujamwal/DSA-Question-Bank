/*You're given a 2D array of integers matrix. Write a function that returns the transpose of the matrix.

The transpose of a matrix is a flipped version of the original matrix across its main diagonal 
(which runs from top-left to bottom-right); it switches the row and column indices of the original matrix.

You can assume the input matrix always has at least 1 value; however its width and height are not necessarily the same.

Sample Input #1
matrix = [
  [1, 2],
]
Sample Output # 1
[
  [1],
  [2]
]
Sample Input #2
matrix = [
  [1, 2],
  [3, 4],
  [5, 6]
]
Sample Output #2
[
  [1, 3, 5],
  [2, 4, 6]
]
Sample Input #3
matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
Sample Output #3
[
  [1, 4, 7],
  [2, 5, 8],
  [3, 6, 9]
]  */

import java.util.*;

class Program {
    public int[][] transposeMatrix(int[][] matrix) {
        // Write your code here.
        // First, get the dimensions of the original matrix.
        // number of rows = number of inner arrays
        int numRows = matrix.length;
        // number of columns = length of the first inner array
        // (We assume the matrix is not empty and not jagged)
        int numCols = matrix[0].length;

        // Create a new matrix with swapped dimensions.
        // The number of rows in the new matrix is the number of columns in the old one.
        int[][] transposedMatrix = new int[numCols][numRows];

        // Loop through each cell of the ORIGINAL matrix.
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                // This is the main trick:
                // Copy the element from the original matrix to the new, swapped position.
                // The element at [row][col] goes to [col][row].
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        // Return the newly created and populated transposed matrix.
        return transposedMatrix;

    }
}
