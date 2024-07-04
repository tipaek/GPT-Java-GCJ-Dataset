import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * @author itsypkin
 * @since 04.04.20
 */
class Solution {

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        // System.out.println(t);

        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

//            printMatrix(matrix);
            int[] result = calculateTest(matrix, n);

            System.out.println("Case #" + k + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] calculateTest(int[][] matrix, int n) {
        int[][] rows = new int[n][n];
        int[][] cols = new int[n][n];
        int[] colsWithD = new int[n];
        int trace = 0;
        int colsWithDuplicates = 0;
        int rowsWithDuplicates = 0;

//        System.out.println("N: " + n);
//
//        printMatrix(matrix);

        for (int i = 0; i < n; i++) {

            boolean duplicatesInRow = false;

            for (int j = 0; j < n; j++) {

                int x = matrix[i][j];

                if (rows[i][x - 1] == 1) {
                    duplicatesInRow = true;
                } else {
                    rows[i][x - 1] = 1;
                }

                if (cols[j][x - 1] == 1) {
                    colsWithD[j] = colsWithD[j] + 1;
                } else {
                    cols[j][x - 1] = 1;
                }

                if (i == j) trace += x;
            }

            if (duplicatesInRow) rowsWithDuplicates ++;
        }

        for (int i = 0; i < n; i++) {
            if (colsWithD[i] > 0) colsWithDuplicates += 1;
        }


        return new int[]{trace, rowsWithDuplicates, colsWithDuplicates};
    }
}
