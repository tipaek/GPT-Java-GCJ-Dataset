import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] mat = new int[n][n];
            initializeMatrix(mat, n);
            fillMatrix(mat, n);
            int sum = calculateDiagonalSum(mat, n);

            String result = (sum == k) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);

            if ("POSSIBLE".equals(result)) {
                printMatrix(mat, n);
            }
        }

        scanner.close();
    }

    private static void initializeMatrix(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            mat[i][i] = 1;
        }
    }

    private static void fillMatrix(int[][] mat, int n) {
        int b = 1;
        for (int j = 0; j < n; j++) {
            mat[0][j] = b++;
        }

        b = n;
        for (int j = 1; j < n; j++) {
            mat[j][0] = b--;
        }

        b = n;
        for (int j = 0; j < n - 1; j++) {
            mat[j][n - 1] = b--;
        }

        b = 2;
        for (int j = 0; j < n - 1; j++) {
            mat[n - 1][j] = b++;
        }

        for (int j = n - 1; j >= 0; j--) {
            for (int k = 1; k < j; k++) {
                mat[j - 1][k - 1] = mat[j][k];
            }
        }

        for (int j = 0; j < n - 1; j++) {
            for (int k = 1; k < n - 1; k++) {
                mat[j + 1][k + 1] = mat[j][k];
            }
        }
    }

    private static int calculateDiagonalSum(int[][] mat, int n) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if ((k + j) == (n - 1)) {
                    sum += mat[j][k];
                }
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] mat, int n) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(mat[j][k] + " ");
            }
            System.out.println();
        }
    }
}