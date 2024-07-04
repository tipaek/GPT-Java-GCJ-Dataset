import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Reading matrix and calculating trace
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = sc.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                }
            }

            // Check for repeated elements in rows
            for (int r = 0; r < n; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Check for repeated elements in columns
            for (int c = 0; c < n; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Output the result
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedRows, repeatedCols);
        }
        sc.close();
    }
}