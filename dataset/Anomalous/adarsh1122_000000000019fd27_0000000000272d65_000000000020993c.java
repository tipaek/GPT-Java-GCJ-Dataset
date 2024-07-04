import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] c = new int[t][3];

        for (int k = 0; k < t; k++) { // Test Case
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt(); // Input Matrix
                }
            }

            // Diagonal Addition
            c[k][0] = 0;
            for (int i = 0; i < n; i++) {
                c[k][0] += arr[i][i];
            }

            // Row repeat Calculation
            c[k][1] = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        hasDuplicate = true;
                    }
                    seen[arr[i][j]] = true;
                }
                if (hasDuplicate) {
                    c[k][1]++;
                }
            }

            // Column repeat Calculation
            c[k][2] = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (seen[arr[j][i]]) {
                        hasDuplicate = true;
                    }
                    seen[arr[j][i]] = true;
                }
                if (hasDuplicate) {
                    c[k][2]++;
                }
            }

            // Output the result for this test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(c[k][q] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}