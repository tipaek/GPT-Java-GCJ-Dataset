import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.print("Case #" + testCase + ": ");
            if (k % n == 0) {
                System.out.println("POSSIBLE");
                int[][] latinSquare = generateLatinSquare(n);
                int change = k / n;
                adjustLatinSquare(latinSquare, change);
                printLatinSquare(latinSquare);
            } else {
                System.out.println(determinePossibility(n, k));
            }
        }
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
        for (int[] row : latinSquare) {
            for (int j = 0; j < n; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(row[j]);
            }
            System.out.println();
        }
    }

    private static String determinePossibility(int n, int k) {
        int[][] latinSquare = generateLatinSquare(n);
        reverseRows(latinSquare);

        if (calculateDiagonalSum(latinSquare) == k) {
            return formatLatinSquare(latinSquare);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                swapNumbersInLatinSquare(latinSquare, i, j);
                if (calculateDiagonalSum(latinSquare) == k) {
                    return formatLatinSquare(latinSquare);
                }
                swapNumbersInLatinSquare(latinSquare, i, j); // Swap back to original
            }
        }
        return "IMPOSSIBLE";
    }

    private static void reverseRows(int[][] latinSquare) {
        int n = latinSquare.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = latinSquare[i];
            latinSquare[i] = latinSquare[n - i - 1];
            latinSquare[n - i - 1] = temp;
        }
    }

    private static int calculateDiagonalSum(int[][] latinSquare) {
        int sum = 0;
        for (int i = 0; i < latinSquare.length; i++) {
            sum += latinSquare[i][i];
        }
        return sum;
    }

    private static void swapNumbersInLatinSquare(int[][] latinSquare, int num1, int num2) {
        int n = latinSquare.length;
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

    private static String formatLatinSquare(int[][] latinSquare) {
        StringBuilder result = new StringBuilder("POSSIBLE\n");
        int n = latinSquare.length;
        for (int[] row : latinSquare) {
            for (int j = 0; j < n; j++) {
                if (j != 0) {
                    result.append(" ");
                }
                result.append(row[j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] latinSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            int value = n - i;
            for (int j = 0; j < n; j++) {
                latinSquare[i][j] = (value + j) % n + 1;
            }
        }
        return latinSquare;
    }
}