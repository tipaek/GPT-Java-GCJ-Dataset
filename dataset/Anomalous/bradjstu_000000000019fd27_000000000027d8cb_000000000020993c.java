import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = readMatrix(matrixSize, scanner);

        int trace = computeTrace(matrix);
        int repeatedRows = countRepeatedRows(matrix);
        int repeatedColumns = countRepeatedColumns(matrix);

        String result = trace + " " + repeatedRows + " " + repeatedColumns;
        printResult(testCaseNumber, result);
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int computeTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}