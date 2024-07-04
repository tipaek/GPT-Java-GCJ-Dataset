import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k % n > 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            System.out.println("Case #" + i + ": POSSIBLE");

            int diag = k / n;

            printMatrix(buildMatrix(diag, n));
        }
    }

    private static void printMatrix(int[][] buildMatrix) {
        for (int[] line : buildMatrix) {
            StringBuilder l = new StringBuilder("");
            for (int v : line) {
                l.append(v + " ");
            }
            System.out.println(l.toString().trim());
        }
    }

    private static int[][] buildMatrix(int diag, int n) {
        int[][] mat = new int[n][n];

        for (int r = 0; r < n; r++) {
            mat[r][r] = diag;
            int start = diag == 1 ? 2 : 1;
            for (int c = r + 1;; c++) {
                if (c == n) {
                    c = 0;
                }
                if (c == r) {
                    break;
                }
                mat[r][c] = start;
                start++;
            }
        }

        return mat;
    }
}