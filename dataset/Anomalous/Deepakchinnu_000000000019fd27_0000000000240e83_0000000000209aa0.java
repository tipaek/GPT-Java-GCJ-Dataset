import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (n == 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
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

            boolean possible = false;
            for (int i = 0; i <= n; i++) {
                if (k == a[i]) {
                    System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                    possible = true;

                    if (i == n) {
                        printLatinSquare(n);
                    } else {
                        printDiagonalLatinSquare(n, i + 1);
                    }
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
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
    }

    private static void printDiagonalLatinSquare(int n, int diagonalValue) {
        int[][] square = new int[n][n];

        for (int i = 0; i < n; i++) {
            square[i][i] = diagonalValue;
        }

        int fillValue;
        for (int i = 0; i < n; i++) {
            fillValue = diagonalValue + 1;
            for (int j = i + 1; j < n; j++) {
                square[j][i] = fillValue++ % n;
                if (square[j][i] == 0) square[j][i] = n;
            }
            for (int j = 0; j < i; j++) {
                square[j][i] = fillValue++ % n;
                if (square[j][i] == 0) square[j][i] = n;
            }
        }

        for (int[] row : square) {
            for (int j = 0; j < n; j++) {
                System.out.print(row[j] + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}