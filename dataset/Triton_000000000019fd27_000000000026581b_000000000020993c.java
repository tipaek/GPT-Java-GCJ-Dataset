import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] = in.nextInt();
                }
            }

            String result = String.format("Case #%d: %s", i, sol.count(matrix));
            System.out.println(result);
        }
    }

    private String count(int[][] matrix) {
        int n = matrix.length;
        int trace = 0, r = 0, c = 0;
        boolean[][] cols = new boolean[n][n];
        boolean[] repeatedCol = new boolean[n];
        for (int i = 0; i < n; ++i) {
            boolean[] rows = new boolean[n];
            boolean repeated = false;
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                int idx = matrix[i][j] - 1;
                if (rows[idx]) {
                    repeated = true;
                }
                rows[idx] = true;

                if (cols[j][idx]) {
                    repeatedCol[j] = true;
                }

                cols[j][idx] = true;
            }

            if (repeated) {
                ++r;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (repeatedCol[i]) {
                ++c;
            }
        }

        return String.format("%d %d %d", trace, r, c);
    }
}
