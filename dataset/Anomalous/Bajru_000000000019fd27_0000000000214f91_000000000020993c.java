import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            processTestCase(matrix, n, caseNumber);
        }
    }

    private static void processTestCase(int[][] matrix, int n, int caseNumber) {
        int trace = calculateTrace(matrix, n);
        int expectedSum = n * (n + 1) / 2;
        int duplicateRows = countDuplicateRows(matrix, n, expectedSum);
        int duplicateCols = countDuplicateCols(matrix, n, expectedSum);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int n, int expectedSum) {
        int duplicateRows = 0;
        for (int row = 0; row < n; row++) {
            int rowSum = expectedSum;
            for (int col = 0; col < n; col++) {
                rowSum -= matrix[row][col];
            }
            if (rowSum != 0) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n, int expectedSum) {
        int duplicateCols = 0;
        for (int col = 0; col < n; col++) {
            int colSum = expectedSum;
            for (int row = 0; row < n; row++) {
                colSum -= matrix[row][col];
            }
            if (colSum != 0) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}