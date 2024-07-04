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

            // Read matrix and calculate trace and rows with duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowElements = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasDuplicate && !rowElements.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                        rowsWithDuplicates++;
                    }
                }
            }

            // Calculate columns with duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> columnElements = new HashSet<>();
                boolean columnHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!columnHasDuplicate && !columnElements.add(matrix[i][j])) {
                        columnHasDuplicate = true;
                        columnsWithDuplicates++;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d%n", testCase, trace, rowsWithDuplicates, columnsWithDuplicates);
        }
    }
}