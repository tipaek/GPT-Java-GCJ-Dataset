import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] sums = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sums[i] = n * (i + 1);
            }

            sums[n] = (n % 2 == 1) ? (n * (n + 1)) / 2 : 0;

            boolean possible = false;
            for (int i = 0; i <= n; i++) {
                if (k == sums[i]) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    possible = true;

                    if (i == n) {
                        printLatinSquare(n);
                    } else {
                        printModifiedSquare(n, i + 1);
                    }
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void printLatinSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = (i + j + 1) % n;
                if (value == 0) value = n;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void printModifiedSquare(int n, int diagonalValue) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i][i] = diagonalValue;
        }

        for (int i = 0; i < n; i++) {
            int value = diagonalValue + 1;
            for (int j = i + 1; j < n; j++) {
                matrix[j][i] = (value++ % n == 0) ? n : value % n;
            }
            for (int j = 0; j < i; j++) {
                matrix[j][i] = (value++ % n == 0) ? n : value % n;
            }
        }

        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}