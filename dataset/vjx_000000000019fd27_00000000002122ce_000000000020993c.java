import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            int[] trace = trace(matrix);

            System.out.println("Case #" + i + ": " + trace[0] + " " + trace[1] + " " + trace[2]);
        }
    }

    static int[] trace(int[][] matrix) {
        int n = matrix.length;

        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];

        boolean[] repeatedRows = new boolean[n];
        boolean[] repeatedCols = new boolean[n];

        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];

                if (rows[i][value - 1] && !repeatedRows[i]) {
                    rowRepeats++;
                    repeatedRows[i] = true;
                }

                if (cols[j][value - 1] && !repeatedCols[j]) {
                    colRepeats++;
                    repeatedCols[j] = true;
                }

                if (i == j) {
                    trace += value;
                }

                rows[i][value - 1] = true;
                cols[j][value - 1] = true;
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }
}