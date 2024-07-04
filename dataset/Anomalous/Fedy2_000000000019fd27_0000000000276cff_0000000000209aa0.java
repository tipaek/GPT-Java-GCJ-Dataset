import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            processTestCase(testCase, n, k);
        }
        scanner.close();
    }

    private static void processTestCase(int testCase, int n, int k) {
        int[][] matrix = generateMatrix(n);
        
        boolean isPossible = rearrangeMatrix(matrix, n, k, 0, n);

        if (!isPossible) {
            matrix = generateAlternativeMatrix(n);
            isPossible = rearrangeMatrix(matrix, n, k, 0, n);
        }

        printResult(testCase, isPossible, matrix, n);
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][(col + row) % n] = col + 1;
            }
        }
        return matrix;
    }

    private static int[][] generateAlternativeMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[(col + row) % n][row] = col + 1;
            }
        }
        return matrix;
    }

    private static boolean rearrangeMatrix(int[][] matrix, int n, int k, int rowIndex, int currentSum) {
        if (currentSum == k) return true;

        for (int i = rowIndex + 1; i < n; i++) {
            int delta1 = matrix[i][rowIndex] - matrix[rowIndex][rowIndex];
            int delta2 = matrix[rowIndex][i] - matrix[i][i];
            int newSum = currentSum + delta1 + delta2;

            if (newSum > k) continue;

            swapRows(matrix, i, rowIndex);
            boolean found = rearrangeMatrix(matrix, n, k, rowIndex + 1, newSum);
            if (found) return true;
            swapRows(matrix, i, rowIndex);
        }
        return false;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void printResult(int testCase, boolean isPossible, int[][] matrix, int n) {
        if (isPossible) {
            System.out.println("Case #" + testCase + ": POSSIBLE");
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    System.out.print(matrix[row][col]);
                    if (col < n - 1) System.out.print(" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }
    }
}