/**
 *  Alex Tresselt
 *  Google Code Jam
 *  Qualification Round - Vestigium
 *  4/3/20
 */

import java.util.*;
import java.io.*;


public class Solution {


    /**
     * Create a matrix as a two-dimensional array of ints
     * @param n the size of the matrix
     * @return a two dimensional array of ints
     */
    private static int[][] createMatrix(int n) {
        return new int[n][n];
    }


    /**
     * Given a matrix, compute its trace (sum of the diagonal from top left to lower right)
     * @param matrix a two-dimensional array of ints
     * @return an int representing the sum of the trace.
     */
    private static int trace(int[][] matrix) {
        int size = matrix[0].length;
        int sum = 0;
        // Calculate the sum along the diagonal
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }


    /**
     * Checks an array for repeated numbers.
     * @param array an array of ints
     * @return 1 if there is a number repeated, 0 if not.
     */
    private static int numRepeats(int[] array) {

        // Creates an array with a length of the given array plus one,
        // to use as a hash set to keep track of seen numbers.
        int[] hashset = new int[array.length + 1];

        // Check every number in the array. If it has been seen in the
        // hash set, return 1, otherwise add it to the hash set.
        for (int i = 0; i < array.length; i++) {
            if (hashset[array[i]] == 1) {
                return 1;
            } else {
                hashset[array[i]] = 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        // Standard input from the FAQ
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Number of cases
        int numCases = in.nextInt();

        // Set up each case
        for (int i = 1; i <= numCases; i++) {
            int size = in.nextInt(); // size of first matrix
            int[][] matrix = createMatrix(size); // create matrix

            // add rows to matrix
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    matrix[row][column] = in.nextInt();
                }
            }

            // compute trace
            int trace = trace(matrix);

            // find row repeats, calling numRepeats on each row
            int rowRepeats = 0;
            for (int r = 0; r < size; r++) {
                rowRepeats += numRepeats(matrix[r]);
            }

            // find column repeats, similar to numRepeats method
            int columnRepeats = 0;

            for (int c = 0; c < size; c++) {
                int[] hashC = new int[size + 1]; // create hash set
                for (int r = 0; r < size; r++) {
                    if (hashC[matrix[r][c]] == 1) { // number is repeated
                        columnRepeats ++;
                        break;
                    } else {
                        hashC[matrix[r][c]] = 1; // mark number as seen
                    }
                }
            }

            // Output results
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }

    }
}