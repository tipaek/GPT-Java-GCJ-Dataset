import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean isPossible = false;

            int[] sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i] = n * (i + 1);
            }
            sums[n] = (n % 2 == 1) ? (n * (n + 1)) / 2 : 0;

            for (int i = 0; i <= n; i++) {
                if (k == sums[i]) {
                    System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                    isPossible = true;

                    if (i == n) {
                        printLatinSquare(n);
                    } else {
                        printCustomSquare(n, i);
                    }
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void printLatinSquare(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = (row + col + 1) % n;
                if (value == 0) value = n;
                System.out.print(value + (col == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void printCustomSquare(int n, int i) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) {
                    matrix[row][col] = i + 1;
                }
            }
        }

        for (int col = 0; col < n; col++) {
            int fillValue = i + 2;
            for (int row = col + 1; row < n; row++) {
                matrix[row][col] = (fillValue++ % n == 0) ? n : fillValue % n;
            }
            for (int row = 0; row < col; row++) {
                matrix[row][col] = (fillValue++ % n == 0) ? n : fillValue % n;
            }
        }

        for (int[] row : matrix) {
            for (int col = 0; col < n; col++) {
                System.out.print(row[col] + (col == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}