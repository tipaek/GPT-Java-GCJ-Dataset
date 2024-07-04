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
                int increment = k / n - 1;
                adjustAndPrintLatinSquare(latinSquare, n, increment);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int n, int k) {
        return k % n == 0 && k >= n && k <= n * n;
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] latinSquare = new int[n][n];
        int startValue = n + 1;

        for (int i = 0; i < n; i++) {
            int value = startValue;
            int column = 0;

            while (value <= n) {
                latinSquare[i][column++] = value++;
            }

            for (int j = 1; j < startValue; j++) {
                latinSquare[i][column++] = j;
            }

            startValue--;
        }

        return latinSquare;
    }

    private static void adjustAndPrintLatinSquare(int[][] latinSquare, int n, int increment) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                latinSquare[row][col] += increment;
                if (latinSquare[row][col] > n) {
                    latinSquare[row][col] -= n;
                }

                if (col != n - 1) {
                    System.out.print(latinSquare[row][col] + " ");
                } else {
                    System.out.print(latinSquare[row][col]);
                }
            }
            System.out.println();
        }
    }
}