import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Diagonal sum
            results[k][0] = 0;
            for (int i = 0; i < n; i++) {
                results[k][0] += matrix[i][i];
            }

            // Row repeat calculation
            results[k][1] = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        results[k][1]++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Column repeat calculation
            results[k][2] = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        results[k][2]++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            // Print the result for this test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}