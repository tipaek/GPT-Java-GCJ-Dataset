import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        int[][] results = new int[t][3];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int r = 0;
            int c = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int next = sc.nextInt();
                    if (row == col) {
                        trace += next;
                    }
                    matrix[row][col] = next;
                }
            }
            // find repeats in each row
            for (int row = 0; row < n; row++) {
                int[] curr = matrix[row];
                for (int e = 0; e < n; e++) {
                    if (curr[Math.abs(curr[e]) - 1] < 0) {
                        r++;
                        break;
                    } else {
                        curr[Math.abs(curr[e]) - 1] = -curr[Math.abs(curr[e]) - 1];
                    }
                }
            }
            // reset
            for (int row = 0; row < n; row++) {
                int[] curr = matrix[row];
                for (int e = 0; e < n; e++) {
                    if (curr[e] < 0) {
                        curr[e] = -curr[e];
                    }
                }
            }
            // find repeats in each column
            for (int col = 0; col < n; col++) {
                for (int e = 0; e < n; e++) {
                    if (matrix[Math.abs(matrix[e][col]) - 1][col] < 0) {
                        c++;
                        break;
                    } else {
                        matrix[Math.abs(matrix[e][col]) - 1][col] =
                                -matrix[Math.abs(matrix[e][col]) - 1][col];
                    }
                }
            }
            results[i][0] = trace;
            results[i][1] = r;
            results[i][2] = c;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(String.format("Case %d: %d %d %d",
                    i + 1, results[i][0], results[i][1], results[i][2]));
        }
    }
}
