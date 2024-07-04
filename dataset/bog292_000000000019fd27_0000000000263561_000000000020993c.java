import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int nr = 1; nr <= t; ++nr) {
            int n = in.nextInt();

            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                }
            }

            solve(nr, n, mat);
        }
    }

    private static void solve(int testNr, int n, int[][] mat) {
        int diag = 0;

        for (int i = 0; i < n; i++) {
            diag += mat[i][i];
        }

        int rows = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(mat[i][j]) - 1;
                mat[i][val] *= -1;
            }

            int x = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > 0) {
                    x = 1;
                } else {
                    mat[i][j] = Math.abs(mat[i][j]);
                }
            }
            rows += x;
        }

        int cols = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(mat[j][i]) - 1;
                mat[val][i] *= -1;
            }

            int x = 0;
            for (int j = 0; j < n; j++) {
                if (mat[j][i] > 0) {
                    x = 1;
                } else {
                    mat[j][i] = Math.abs(mat[j][i]);
                }
            }
            cols += x;
        }

        System.out.println("Case #" + testNr + " " + diag + " " + rows + " " + cols);
    }
}