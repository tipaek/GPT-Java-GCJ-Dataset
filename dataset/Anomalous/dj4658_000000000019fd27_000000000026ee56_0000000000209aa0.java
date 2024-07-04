import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;

            // Fill the matrix with initial values
            for (int i = 0; i < n; i++) {
                matrix[i][i] = 1; // Diagonal
            }

            // Fill the first row
            for (int j = 0, value = 1; j < n; j++) {
                matrix[0][j] = value++;
            }

            // Fill the first column
            for (int i = 1, value = n; i < n; i++) {
                matrix[i][0] = value--;
            }

            // Fill the last column
            for (int i = 0, value = n; i < n - 1; i++) {
                matrix[i][n - 1] = value--;
            }

            // Fill the last row
            for (int j = 0, value = 2; j < n - 1; j++) {
                matrix[n - 1][j] = value++;
            }

            // Lower left triangle
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1; j < i; j++) {
                    matrix[i - 1][j - 1] = matrix[i][j];
                }
            }

            // Upper right triangle
            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    matrix[i + 1][j + 1] = matrix[i][j];
                }
            }

            // Calculate the sum of the anti-diagonal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i + j) == (n - 1)) {
                        sum += matrix[i][j];
                    }
                }
            }

            String result = (sum == K) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + (testCase + 1) + ": " + result);

            if (result.equals("POSSIBLE")) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}