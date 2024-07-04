import java.util.*;
import java.io.*;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long testCases = sc.nextLong();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            handleTestCase(testCase);
        }
    }

    private static void handleTestCase(long testCaseNumber) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean isPossible = false;

        int[][] matrix = initializeMatrix(n);

        Random random = new Random();
        for (int attempt = 0; attempt < 1000; attempt++) {
            if (calculateTrace(matrix) == k) {
                isPossible = true;
                break;
            }
            shuffleMatrix(matrix, random);
        }

        if (n == 1 && k == 1) {
            isPossible = true;
        }

        if (isPossible) {
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        }
    }

    private static int[][] initializeMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (j > i) {
                    matrix[i][j] = n - j + 1 + i;
                } else {
                    matrix[i][j] = 1 + i - j;
                }
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

    private static void shuffleMatrix(int[][] matrix, Random random) {
        int n = matrix.length;
        int randRow1 = random.nextInt(n);
        int randRow2 = random.nextInt(n);
        swapRows(matrix, randRow1, randRow2);

        if (calculateTrace(matrix) != k) {
            int randCol1 = random.nextInt(n);
            int randCol2 = random.nextInt(n);
            swapColumns(matrix, randCol1, randCol2);
        }
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row2].clone();
        matrix[row2] = matrix[row1];
        matrix[row1] = temp;
    }

    private static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
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