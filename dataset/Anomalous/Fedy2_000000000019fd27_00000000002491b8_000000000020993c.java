import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            processTestCase(testCase, n, matrix);
        }
        scanner.close();
    }

    private static void processTestCase(int testCase, int n, int[][] matrix) {
        int trace = calculateTrace(n, matrix);
        int duplicateRows = countDuplicateRows(n, matrix);
        int duplicateColumns = countDuplicateColumns(n, matrix);

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateTrace(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int n, int[][] matrix) {
        int duplicateRows = 0;
        for (int row = 0; row < n; row++) {
            boolean[] seen = new boolean[n + 1];
            for (int col = 0; col < n; col++) {
                int value = matrix[row][col];
                if (seen[value]) {
                    duplicateRows++;
                    break;
                }
                seen[value] = true;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int n, int[][] matrix) {
        int duplicateColumns = 0;
        for (int col = 0; col < n; col++) {
            boolean[] seen = new boolean[n + 1];
            for (int row = 0; row < n; row++) {
                int value = matrix[row][col];
                if (seen[value]) {
                    duplicateColumns++;
                    break;
                }
                seen[value] = true;
            }
        }
        return duplicateColumns;
    }
}