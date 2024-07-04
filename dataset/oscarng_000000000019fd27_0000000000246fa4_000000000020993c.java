import java.util.Arrays;
import java.util.Scanner;

//Vestigium
public class Solution {
    public static int[] solve(int[][] matrix, int n) {
        int trace = 0, repeatedRow = 0, repeatedCol = 0;
        boolean[] seen = new boolean[n + 1]; // 1..n

        for (int i = 0; i < n; ++i) {
            trace += matrix[i][i];

            for (int r = 0; r < n; ++r) {
                if (seen[matrix[r][i]]) {
                    ++repeatedCol;
                    break;
                }
                seen[matrix[r][i]] = true;
            }
            Arrays.fill(seen, false);

            for (int c = 0; c < n; ++c) {
                if (seen[matrix[i][c]]) {
                    ++repeatedRow;
                    break;
                }
                seen[matrix[i][c]] = true;
            }
            Arrays.fill(seen, false);
        }

        return new int[] { trace, repeatedRow, repeatedCol };
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        // System.out.println("num of case: " + t);
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            // System.out.println(n);
            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    matrix[r][c] = in.nextInt();
                }
            }
            // for (int[] row : m) {
            // for (int e : row) {
            // System.out.print(e + ",");
            // }
            // System.out.println();
            // }

            int[] ans = solve(matrix, n);
            System.out.print(String.format("Case #%d: %d %d %d\n", i, ans[0], ans[1], ans[2]));
        }
    }
}