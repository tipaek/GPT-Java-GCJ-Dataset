import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static int t; // number of test cases
    static int n; // matrix size
    static int[][] matrix; // the matrix

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        // for every test case
        for (int i = 1; i <= t; i++) {
            int k = 0, r = 0, c = 0; // the trace of the matrix, number of rows and columns containing repeated elements
            n = scanner.nextInt(); // get the matrix size
            matrix = new int[n][n]; // allocate memory space

            // populate the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            k = getTrace(matrix);
            r = getNumRepeatedRows(matrix);
            c = getNumRepeatedColumns(matrix);

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }

    public static int getTrace(int[][] matrix) {
        int trace = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }

    public static int getNumRepeatedRows(int[][] matrix) {
        int repeats = 0;

        for (int row = 0; row < matrix.length; row++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int col = 0; col < matrix.length; col++) {
                set.add(matrix[row][col]);
            }
            if (set.size() < matrix.length) repeats++;
        }

        return repeats;
    }

    public static int getNumRepeatedColumns(int[][] matrix) {
        int repeats = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            HashSet<Integer> set = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                set.add(matrix[row][col]);
            }

            if (set.size() < matrix.length) repeats++;
        }

        return repeats;
    }
}
