import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int targetSum = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Initialize the diagonal
            for (int j = 0; j < n; j++) {
                matrix[j][j] = 1;
            }

            // Fill the first row
            int value = 1;
            for (int j = 0; j < n; j++) {
                matrix[0][j] = value++;
            }

            // Fill the first column
            value = n;
            for (int j = 1; j < n; j++) {
                matrix[j][0] = value--;
            }

            // Fill the last column
            value = n;
            for (int j = 0; j < n - 1; j++) {
                matrix[j][n - 1] = value--;
            }

            // Fill the last row
            value = 2;
            for (int j = 0; j < n - 1; j++) {
                matrix[n - 1][j] = value++;
            }

            // Lower left part of the matrix
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k < j; k++) {
                    matrix[j - 1][k - 1] = matrix[j][k];
                }
            }

            // Upper right part of the matrix
            for (int j = 0; j < n - 1; j++) {
                for (int k = 1; k < n - 1; k++) {
                    matrix[j + 1][k + 1] = matrix[j][k];
                }
            }

            // Calculate the sum of the anti-diagonal
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((k + j) == (n - 1)) {
                        sum += matrix[j][k];
                    }
                }
            }

            String result = sum == targetSum ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);

            if (result.equals("POSSIBLE")) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        System.out.print(matrix[j][k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}