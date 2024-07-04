package codejam;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution01 {

    static TestResult calculateTraceInfo(int[][] input) {
        int dim = input.length;
        int trace = 0;
        for (int i = 0; i < dim; i++) {
            trace += input[i][i];
        }

        int numOfRows = 0;
        for (int row = 0; row < dim; row++) {
            Set<Integer> rowData = new HashSet<>();
            for (int col = 0; col < dim; col++) {
                int data = input[row][col];
                if (rowData.contains(data)) {
                    numOfRows += 1;
                    break;
                } else {
                    rowData.add(data);
                }
            }
        }

        int numOfColumns = 0;
        for (int col = 0; col < dim; col++) {
            Set<Integer> columnData = new HashSet<>();
            for (int row = 0; row < dim; row++) {
                int data = input[row][col];
                if (columnData.contains(data)) {
                    numOfColumns += 1;
                    break;
                } else {
                    columnData.add(data);
                }
            }
        }

        return new TestResult(trace, numOfRows, numOfColumns);
    }




    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i=1; i<=t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            TestResult testResult = calculateTraceInfo(matrix);
            System.out.println("Case #" + i + " : " + testResult.trace + " " + testResult.numOfRows + " " + testResult.numOfColumns);
        }
    }

    static class TestResult {
        int trace;
        int numOfRows;
        int numOfColumns;

        public TestResult(int trace, int numOfRows, int numOfColumns) {
            this.trace = trace;
            this.numOfRows = numOfRows;
            this.numOfColumns = numOfColumns;
        }
    }
}
