import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[] rowCheck = new int[n];
            int[] colCheck = new int[n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < n; row++) {
                Arrays.fill(rowCheck, 0);
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    rowCheck[matrix[row][col] - 1]++;
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                // Check for row repeats
                for (int count : rowCheck) {
                    if (count > 1) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column repeats
            for (int col = 0; col < n; col++) {
                Arrays.fill(colCheck, 0);
                for (int row = 0; row < n; row++) {
                    colCheck[matrix[row][col] - 1]++;
                }
                for (int count : colCheck) {
                    if (count > 1) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}