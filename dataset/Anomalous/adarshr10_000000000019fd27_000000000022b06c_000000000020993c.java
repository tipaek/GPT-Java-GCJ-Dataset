import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            String sol = solve(matrix);
            System.out.printf("Case #%d: %s %s %s%n", x, sol.charAt(0), sol.charAt(1), sol.charAt(2));
        }
    }

    static String solve(int[][] input) {
        int n = input.length;
        int trace = 0;
        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            trace += input[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(input[i][j])) {
                    row++;
                    break;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(input[i][j])) {
                    col++;
                    break;
                }
            }
        }

        return String.format("%d%d%d", trace, row, col);
    }
}