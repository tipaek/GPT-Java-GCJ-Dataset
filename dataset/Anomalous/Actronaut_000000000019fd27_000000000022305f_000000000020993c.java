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
    private static int computeTrace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    /**
     * Checks an array for repeated numbers.
     * @param array an array of ints
     * @return 1 if there is a number repeated, 0 if not.
     */
    private static int hasRepeats(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return 1;
            }
            seen[num] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int size = scanner.nextInt();
            int[][] matrix = createMatrix(size);

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = computeTrace(matrix);
            int rowRepeats = 0;
            for (int[] row : matrix) {
                rowRepeats += hasRepeats(row);
            }

            int columnRepeats = 0;
            for (int col = 0; col < size; col++) {
                int[] column = new int[size];
                for (int row = 0; row < size; row++) {
                    column[row] = matrix[row][col];
                }
                columnRepeats += hasRepeats(column);
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}