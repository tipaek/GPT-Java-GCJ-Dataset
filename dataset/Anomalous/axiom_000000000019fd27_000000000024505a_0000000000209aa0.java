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

    private static void processTestCase(int testCaseNumber, int n, int k) {
        if (k % n != 0) {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            int m = k / n;
            int[][] matrix = generateMatrix(n, m);
            printMatrix(matrix);
        }
    }

    private static int[][] generateMatrix(int n, int m) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int value = m;
            for (int j = i; j < n; j++, value++) {
                matrix[i][j] = value > n ? value % n : value;
            }
            for (int j = 0; j < i; j++, value++) {
                matrix[i][j] = value > n ? value % n : value;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}