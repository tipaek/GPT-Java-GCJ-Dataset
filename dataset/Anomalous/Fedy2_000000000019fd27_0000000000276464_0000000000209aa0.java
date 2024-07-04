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

    private static void processTestCase(int testCaseNumber, int n, int k) {
        int[][] matrix = generateInitialMatrix(n);

        boolean isPossible = rearrangeRows(matrix, n, k, 0, n);
        
        if (isPossible) {
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            printMatrix(matrix, n);
        } else {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        }
    }

    private static int[][] generateInitialMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][(col + row) % n] = col + 1;
            }
        }
        return matrix;
    }

    private static boolean rearrangeRows(int[][] matrix, int n, int k, int currentRow, int currentSum) {
        if (currentSum == k) return true;

        for (int i = currentRow + 1; i < n; i++) {
            int delta1 = matrix[i][currentRow] - matrix[currentRow][currentRow];
            int delta2 = matrix[currentRow][i] - matrix[i][i];
            int newSum = currentSum + delta1 + delta2;

            if (newSum > k) continue;

            swapRows(matrix, currentRow, i);
            boolean found = rearrangeRows(matrix, n, k, currentRow + 1, newSum);
            if (found) return true;
            swapRows(matrix, currentRow, i); // Revert swap if not found
        }
        return false;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
                if (col < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}