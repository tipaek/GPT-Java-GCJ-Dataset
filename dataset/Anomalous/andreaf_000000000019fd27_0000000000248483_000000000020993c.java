import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int trace = 0;
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }
                int repeatedRows = countRepeatedRows(matrix, n);
                int repeatedColumns = countRepeatedColumns(matrix, n);
                System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedColumns);
            }
        }
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != n) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() != n) {
                count++;
            }
        }
        return count;
    }
}