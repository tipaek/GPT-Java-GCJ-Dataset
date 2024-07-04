import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            processTestCase(testCase, n, k);
        }
    }

    private static void processTestCase(int testCase, int n, int k) {
        if (k % n != 0) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + testCase + ": POSSIBLE");
        int quotient = k / n;
        int[][] matrix = new int[n][n];
        fillMatrix(matrix, n, quotient);
        printMatrix(matrix, n);
    }

    private static void fillMatrix(int[][] matrix, int n, int value) {
        for (int i = 0; i < n; i++) {
            int currentValue = value;
            for (int j = i; j < n; j++, currentValue++) {
                if (currentValue > n) {
                    currentValue %= n;
                }
                matrix[i][j] = currentValue;
            }
            for (int j = 0; j < i; j++, currentValue++) {
                if (currentValue > n) {
                    currentValue %= n;
                }
                matrix[i][j] = currentValue;
            }
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}