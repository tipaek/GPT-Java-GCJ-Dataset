import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n == 0) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                int[][] latinSquare = generateLatinSquare(n);
                int change = k / n;
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        if (latinSquare[row][col] == change) {
                            latinSquare[row][col] = 1;
                        } else if (latinSquare[row][col] == 1) {
                            latinSquare[row][col] = change;
                        }
                        System.out.print(latinSquare[row][col] + (col != n - 1 ? " " : ""));
                    }
                    System.out.println();
                }
            } else if (n == 5) {
                System.out.print("Case #" + caseNumber + ": ");
                handleOddCase(n, k);
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                handleEvenCase(n, k);
            }
        }
    }

    private static void handleOddCase(int n, int k) {
        int[][] latinSquare = {
            {3, 4, 2, 1, 5},
            {4, 5, 3, 2, 1},
            {1, 3, 4, 5, 2},
            {2, 1, 5, 3, 4},
            {5, 2, 1, 4, 3}
        };

        int diagonalSum = calculateDiagonalSum(latinSquare, n);
        if (diagonalSum == k) {
            printSquare(latinSquare, n);
            return;
        }

        int[][] copy = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                for (int m = 1; m <= n; m++) {
                    if (m == i || m == j) continue;
                    diagonalSum = swapAndCalculate(latinSquare, copy, n, i, j, m);
                    if (diagonalSum == k) {
                        printSquare(copy, n);
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void handleEvenCase(int n, int k) {
        int[][] latinSquare = generateLatinSquare(n);

        for (int i = 0; i < n / 2; i++) {
            int[] temp = latinSquare[n - i - 1];
            latinSquare[n - i - 1] = latinSquare[i];
            latinSquare[i] = temp;
        }

        int diagonalSum = calculateDiagonalSum(latinSquare, n);
        if (diagonalSum == k) {
            printSquare(latinSquare, n);
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                diagonalSum = swapAndCalculate(latinSquare, latinSquare, n, i, j, -1);
                if (diagonalSum == k) {
                    printSquare(latinSquare, n);
                    return;
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

    private static int calculateDiagonalSum(int[][] square, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    private static int swapAndCalculate(int[][] original, int[][] copy, int n, int num1, int num2, int num3) {
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (original[i][j] == num1) {
                    copy[i][j] = num2;
                } else if (original[i][j] == num2) {
                    copy[i][j] = num3;
                } else if (original[i][j] == num3) {
                    copy[i][j] = num1;
                } else {
                    copy[i][j] = original[i][j];
                }
            }
            diagonalSum += copy[i][i];
        }
        return diagonalSum;
    }

    private static void printSquare(int[][] square, int n) {
        System.out.println("POSSIBLE");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j] + (j != n - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}