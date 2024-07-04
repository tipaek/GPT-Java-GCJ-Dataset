package Main;

import java.util.*;
import java.io.*;

public class Solution {

    public static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static int countNonUniqueColumns(int[][] matrix, int size) {
        int nonUniqueColCount = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> columnValues = new HashSet<>();
            for (int row = 0; row < size; row++) {
                columnValues.add(matrix[row][col]);
            }
            if (columnValues.size() < size) {
                nonUniqueColCount++;
            }
        }

        return nonUniqueColCount;
    }

    public static int countNonUniqueRows(int[][] matrix, int size) {
        int nonUniqueRowCount = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int col = 0; col < size; col++) {
                rowValues.add(matrix[row][col]);
            }
            if (rowValues.size() < size) {
                nonUniqueRowCount++;
            }
        }
        return nonUniqueRowCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            int trace = calculateTrace(matrix, matrixSize);
            int nonUniqueRows = countNonUniqueRows(matrix, matrixSize);
            int nonUniqueCols = countNonUniqueColumns(matrix, matrixSize);

            System.out.println("Case #" + testCase + ": " + trace + " " + nonUniqueRows + " " + nonUniqueCols);
        }
    }
}