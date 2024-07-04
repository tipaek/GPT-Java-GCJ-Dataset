import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            solve(caseNumber);
        }
    }

    private static void solve(long caseNumber) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean isPossible = false;

        int[][] matrix = new int[n][n];
        initializeMatrix(matrix, n);

        Random random = new Random();
        int attempts = 0;
        while (calculateTrace(matrix) != k && attempts < 1000) {
            int row1 = random.nextInt(n);
            int row2 = random.nextInt(n);
            swapRows(matrix, row1, row2);
            if (calculateTrace(matrix) == k) {
                isPossible = true;
                break;
            }
            int col1 = random.nextInt(n);
            int col2 = random.nextInt(n);
            swapColumns(matrix, col1, col2);
            if (calculateTrace(matrix) == k) {
                isPossible = true;
                break;
            }
            attempts++;
        }

        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void initializeMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (j > i) {
                    matrix[i][j] = size - j + 1 + i;
                } else {
                    matrix[i][j] = 1 + i - j;
                }
            }
        }
    }

    private static long calculateTrace(int[][] matrix) {
        long traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
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