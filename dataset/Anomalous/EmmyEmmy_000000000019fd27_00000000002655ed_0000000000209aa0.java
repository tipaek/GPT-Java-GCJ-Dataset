import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (isPossible(n, k)) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                int[][] latinSquare = generateLatinSquare(n);
                adjustLatinSquare(latinSquare, k / n);
                printLatinSquare(latinSquare);
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                printAdjustedResult(n, k);
            }
        }
    }

    private static boolean isPossible(int n, int k) {
        return k % n == 0 && k >= n && k <= n * n;
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] square = new int[n][n];
        int value = n + 1;

        for (int i = 0; i < n; i++) {
            int tempValue = value;
            int count = 0;

            while (tempValue <= n) {
                square[i][count++] = tempValue++;
            }

            for (int j = 1; j < value; j++) {
                square[i][count++] = j;
            }

            value--;
        }

        return square;
    }

    private static void adjustLatinSquare(int[][] latinSquare, int change) {
        int n = latinSquare.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (latinSquare[i][j] == change) {
                    latinSquare[i][j] = 1;
                } else if (latinSquare[i][j] == 1) {
                    latinSquare[i][j] = change;
                }
            }
        }
    }

    private static void printLatinSquare(int[][] latinSquare) {
        int n = latinSquare.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(latinSquare[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printAdjustedResult(int n, int k) {
        int[][] latinSquare = generateLatinSquare(n);
        reverseRows(latinSquare);

        if (diagonalSum(latinSquare) == k) {
            System.out.println("POSSIBLE");
            printLatinSquare(latinSquare);
            return;
        }

        if (swapAndCheck(latinSquare, n, k)) {
            return;
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void reverseRows(int[][] latinSquare) {
        int n = latinSquare.length;

        for (int i = 0; i < n / 2; i++) {
            int[] temp = latinSquare[i];
            latinSquare[i] = latinSquare[n - i - 1];
            latinSquare[n - i - 1] = temp;
        }
    }

    private static int diagonalSum(int[][] latinSquare) {
        int sum = 0;
        int n = latinSquare.length;

        for (int i = 0; i < n; i++) {
            sum += latinSquare[i][i];
        }

        return sum;
    }

    private static boolean swapAndCheck(int[][] latinSquare, int n, int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                swapValues(latinSquare, i, j);

                if (diagonalSum(latinSquare) == k) {
                    System.out.println("POSSIBLE");
                    printLatinSquare(latinSquare);
                    return true;
                }

                swapValues(latinSquare, i, j); // Swap back to original
            }
        }

        return false;
    }

    private static void swapValues(int[][] latinSquare, int val1, int val2) {
        int n = latinSquare.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (latinSquare[i][j] == val1) {
                    latinSquare[i][j] = val2;
                } else if (latinSquare[i][j] == val2) {
                    latinSquare[i][j] = val1;
                }
            }
        }
    }
}