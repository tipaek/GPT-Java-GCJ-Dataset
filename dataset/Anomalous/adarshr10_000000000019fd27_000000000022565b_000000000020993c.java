import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }
            String sol = solve(matrix, n);
            System.out.println("Case #" + i + ": " + sol.charAt(0) + " " + sol.charAt(1) + " " + sol.charAt(2));
        }
    }

    public static String solve(int[][] matrix, int n) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Calculate row duplicates
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }

        // Calculate column duplicates
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return trace + "" + rowDuplicates + "" + colDuplicates;
    }
}