package codejam;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution01 {

    static class TestResult {
        int trace;
        int numOfRows;
        int numOfColumns;

        TestResult(int trace, int numOfRows, int numOfColumns) {
            this.trace = trace;
            this.numOfRows = numOfRows;
            this.numOfColumns = numOfColumns;
        }
    }

    static TestResult calculateTraceInfo(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        int duplicateColumns = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }

        return new TestResult(trace, duplicateRows, duplicateColumns);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            TestResult result = calculateTraceInfo(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, result.trace, result.numOfRows, result.numOfColumns);
        }
        scanner.close();
    }
}