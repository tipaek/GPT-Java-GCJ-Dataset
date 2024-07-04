import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean possible = false;

            if (n == 0) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                System.out.println();
                continue;
            }

            int[] a = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = n * (i + 1);
            }

            if (n % 2 == 1) {
                a[n] = (n * (n + 1)) / 2;
            } else {
                a[n] = 0;
            }

            for (int i = 0; i <= n; i++) {
                if (k == a[i]) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println();
                    possible = true;

                    if (i == n) {
                        printLatinSquare(n);
                    } else {
                        printMatrixWithDiagonal(n, i + 1);
                    }
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                System.out.println();
            }
        }
    }

    private static void printLatinSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = (i + j + 1) % n;
                if (value == 0) value = n;
                System.out.print(value + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printMatrixWithDiagonal(int n, int diagonalValue) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i][i] = diagonalValue;
        }

        for (int col = 0; col < n; col++) {
            int value = diagonalValue + 1;
            for (int row = col + 1; row < n; row++) {
                matrix[row][col] = value++ % n;
                if (matrix[row][col] == 0) matrix[row][col] = n;
            }
            for (int row = 0; row < col; row++) {
                matrix[row][col] = value++ % n;
                if (matrix[row][col] == 0) matrix[row][col] = n;
            }
        }

        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(row[j] + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
        System.out.println();
    }
}