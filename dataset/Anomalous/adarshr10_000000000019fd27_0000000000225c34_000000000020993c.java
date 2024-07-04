import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            String result = solve(matrix);
            System.out.printf("Case #%d: %s %s %s%n", caseNumber, result.charAt(0), result.charAt(1), result.charAt(2));
        }
    }

    static String solve(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() < n) {
                repeatedRows++;
            }
            if (colSet.size() < n) {
                repeatedCols++;
            }
        }

        return trace + "" + repeatedRows + "" + repeatedCols;
    }
}