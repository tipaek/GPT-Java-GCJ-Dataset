import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;

            // Initialize the diagonal
            for (int i = 0; i < n; i++) {
                matrix[i][i] = 1;
            }

            // Initialize the first row
            int value = 1;
            for (int i = 0; i < n; i++) {
                matrix[0][i] = value++;
            }

            // Initialize the first column
            value = n;
            for (int i = 1; i < n; i++) {
                matrix[i][0] = value--;
            }

            // Initialize the last column
            value = n;
            for (int i = 0; i < n - 1; i++) {
                matrix[i][n - 1] = value--;
            }

            // Initialize the last row
            value = 2;
            for (int i = 0; i < n - 1; i++) {
                matrix[n - 1][i] = value++;
            }

            // Fill lower left triangle
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1; j < i; j++) {
                    matrix[i - 1][j - 1] = matrix[i][j];
                }
            }

            // Fill upper right triangle
            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    matrix[i + 1][j + 1] = matrix[i][j];
                }
            }

            // Calculate the sum of the secondary diagonal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i + j) == (n - 1)) {
                        sum += matrix[i][j];
                    }
                }
            }

            // Determine if the sum matches k
            String result = (sum == k) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + (t + 1) + ": " + result);

            // Print the matrix if possible
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