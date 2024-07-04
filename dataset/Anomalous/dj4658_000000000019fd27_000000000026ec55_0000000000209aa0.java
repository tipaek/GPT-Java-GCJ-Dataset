import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] mat = new int[n][n];
            int sum = 0;

            // Initialize the diagonal
            for (int j = 0; j < n; j++) {
                mat[j][j] = 1;
            }

            // Initialize the first row
            for (int j = 0, b = 1; j < n; j++) {
                mat[0][j] = b++;
            }

            // Initialize the first column
            for (int j = 1, b = n; j < n; j++) {
                mat[j][0] = b--;
            }

            // Initialize the last column
            for (int j = 0, b = n; j < n - 1; j++) {
                mat[j][n - 1] = b--;
            }

            // Initialize the last row
            for (int j = 0, b = 2; j < n - 1; j++) {
                mat[n - 1][j] = b++;
            }

            // Fill the lower left triangle
            for (int j = n - 1; j > 0; j--) {
                for (int l = 1; l < j; l++) {
                    mat[j - 1][l - 1] = mat[j][l];
                }
            }

            // Fill the upper right triangle
            for (int j = 0; j < n - 1; j++) {
                for (int l = 1; l < n - 1; l++) {
                    mat[j + 1][l + 1] = mat[j][l];
                }
            }

            // Calculate the sum of the anti-diagonal
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (j + l == n - 1) {
                        sum += mat[j][l];
                    }
                }
            }

            String result = (sum == k) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);

            if (result.equals("POSSIBLE")) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        System.out.print(mat[j][l] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}