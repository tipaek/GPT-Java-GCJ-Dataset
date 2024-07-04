import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.print("Case #" + i + ": ");
            if (k % n == 0) {
                handleDivisibleCase(n, k);
            } else if (n % 2 == 0) {
                handleEvenCase(n, k);
            } else {
                handleOddCase(n, k);
            }
        }
    }

    private static void handleDivisibleCase(int n, int k) {
        System.out.println("POSSIBLE");
        int[][] latinSquare = generateLatinSquare(n);
        int change = k / n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (latinSquare[i][j] == change) {
                    latinSquare[i][j] = 1;
                } else if (latinSquare[i][j] == 1) {
                    latinSquare[i][j] = change;
                }
                System.out.print(latinSquare[i][j] + (j != n - 1 ? " " : ""));
            }
            System.out.println();
        }
    }

    private static void handleEvenCase(int n, int k) {
        int[][] latinSquare = generateLatinSquare(n);
        for (int i = 0; i < n / 2; i++) {
            int[] temp = latinSquare[n - i - 1];
            latinSquare[n - i - 1] = latinSquare[i];
            latinSquare[i] = temp;
        }
        if (checkAndPrintLatinSquare(latinSquare, n, k)) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                swapNumbersInSquare(latinSquare, n, i, j);
                if (checkAndPrintLatinSquare(latinSquare, n, k)) {
                    return;
                }
                swapNumbersInSquare(latinSquare, n, i, j); // swap back to original
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void handleOddCase(int n, int k) {
        int[][] latinSquare = {
                {3, 4, 2, 1, 5},
                {4, 5, 3, 2, 1},
                {1, 3, 4, 5, 2},
                {2, 1, 5, 3, 4},
                {5, 2, 1, 4, 3}
        };
        if (checkAndPrintLatinSquare(latinSquare, n, k)) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int m = 1; m <= n; m++) {
                    if (m == i || m == j) continue;
                    swapThreeNumbersInSquare(latinSquare, n, i, j, m);
                    if (checkAndPrintLatinSquare(latinSquare, n, k)) {
                        return;
                    }
                    swapThreeNumbersInSquare(latinSquare, n, i, j, m); // swap back to original
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] latinSquare = new int[n][n];
        int k = n + 1;
        for (int i = 0; i < n; i++) {
            int temp = k;
            int count = 0;
            while (temp <= n) {
                latinSquare[i][count++] = temp++;
            }
            for (int j = 1; j < k; j++) {
                latinSquare[i][count++] = j;
            }
            k--;
        }
        return latinSquare;
    }

    private static boolean checkAndPrintLatinSquare(int[][] latinSquare, int n, int k) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += latinSquare[i][i];
        }
        if (sum == k) {
            System.out.println("POSSIBLE");
            for (int[] row : latinSquare) {
                for (int j = 0; j < n; j++) {
                    System.out.print(row[j] + (j != n - 1 ? " " : ""));
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }

    private static void swapNumbersInSquare(int[][] latinSquare, int n, int num1, int num2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (latinSquare[i][j] == num1) {
                    latinSquare[i][j] = num2;
                } else if (latinSquare[i][j] == num2) {
                    latinSquare[i][j] = num1;
                }
            }
        }
    }

    private static void swapThreeNumbersInSquare(int[][] latinSquare, int n, int num1, int num2, int num3) {
        int[][] tempSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(latinSquare[i], 0, tempSquare[i], 0, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (latinSquare[i][j] == num1) {
                    tempSquare[i][j] = num2;
                } else if (latinSquare[i][j] == num2) {
                    tempSquare[i][j] = num3;
                } else if (latinSquare[i][j] == num3) {
                    tempSquare[i][j] = num1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(tempSquare[i], 0, latinSquare[i], 0, n);
        }
    }
}