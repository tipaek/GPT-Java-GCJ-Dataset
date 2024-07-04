import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            solveTestCase(testCase);
        }
    }

    private static void solveTestCase(long testCaseNumber) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean isPossible = false;

        int[][] matrix = initializeMatrix(n);

        Random random = new Random();
        int attempts = 0;
        while (calculateTrace(matrix) != k && attempts < 1000) {
            swapRandomRows(matrix, random);
            if (calculateTrace(matrix) == k) {
                isPossible = true;
                break;
            }
            swapRandomColumns(matrix, random);
            if (calculateTrace(matrix) == k) {
                isPossible = true;
                break;
            }
            attempts++;
        }

        if (calculateTrace(matrix) == k) {
            isPossible = true;
        }

        printResult(testCaseNumber, isPossible, matrix);
    }

    private static int[][] initializeMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j) ? 1 : (j > i) ? size - j + 1 + i : 1 + i - j;
            }
        }
        return matrix;
    }

    private static long calculateTrace(int[][] matrix) {
        long trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void swapRandomRows(int[][] matrix, Random random) {
        int row1 = random.nextInt(matrix.length);
        int row2 = random.nextInt(matrix.length);
        swapRows(matrix, row1, row2);
    }

    private static void swapRandomColumns(int[][] matrix, Random random) {
        int col1 = random.nextInt(matrix.length);
        int col2 = random.nextInt(matrix.length);
        swapColumns(matrix, col1, col2);
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row2].clone();
        matrix[row2] = matrix[row1];
        matrix[row1] = temp;
    }

    private static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int[] row : matrix) {
            int temp = row[col1];
            row[col1] = row[col2];
            row[col2] = temp;
        }
    }

    private static void printResult(long testCaseNumber, boolean isPossible, int[][] matrix) {
        if (isPossible) {
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}