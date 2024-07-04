import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = 0, duplicateCols = 0;

            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n];
                for (int col = 0; col < n; col++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateRows++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n];
                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateCols++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}