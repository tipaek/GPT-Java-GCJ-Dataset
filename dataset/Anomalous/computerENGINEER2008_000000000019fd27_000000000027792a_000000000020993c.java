import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int rowsWithDuplicates = 0;
            int columnsWithDuplicates = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                        rowsWithDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j]) && !colHasDuplicate) {
                        columnsWithDuplicates++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d%n", testCase, trace, rowsWithDuplicates, columnsWithDuplicates);
        }
    }
}