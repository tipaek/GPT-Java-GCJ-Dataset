import java.util.*;
import java.io.*;

public class Solution {
    static int total = 0;
    static int rowDuplicates = 0;
    static int colDuplicates = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transpose = new int[n][n];
            rowDuplicates = 0;
            colDuplicates = 0;
            total = 0;

            // Read matrix and populate transpose
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSet.add(matrix[i][j]);
                    transpose[j][i] = matrix[i][j];
                }
                if (rowSet.size() < n) {
                    rowDuplicates++;
                }
            }

            // Calculate trace and column duplicates
            calculateTraceAndColumnDuplicates(matrix, n, transpose);
            System.out.println("Case #" + caseNum + ": " + total + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static void calculateTraceAndColumnDuplicates(int[][] matrix, int n, int[][] transpose) {
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    total += matrix[i][j];
                }
                colSet.add(transpose[i][j]);
            }
            if (colSet.size() < n) {
                colDuplicates++;
            }
        }
    }
}