import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int n = in.nextInt();
            int[][] mat = new int[n][n];
            boolean[][] mark = new boolean[n * 2][n];
            int trace = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    mat[r][c] = in.nextInt();
                    mark[r][mat[r][c] - 1] = true;
                    mark[c + n][mat[r][c] - 1] = true;

                    if (r == c) {
                        trace += mat[r][c];
                    }
                }
            }

            int row = 0, col = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (!mark[r][c]) {
                        row++;
                        break;
                    }
                }
            }
            for (int r = n; r < n * 2; r++) {
                for (int c = 0; c < n; c++) {
                    if (!mark[r][c]) {
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
        }
    }
}