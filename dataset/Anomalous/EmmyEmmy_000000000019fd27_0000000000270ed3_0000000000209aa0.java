import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (k % n == 0) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                int[][] latinSquare = generateLatinSquare(n);
                int change = k / n;
                adjustLatinSquare(latinSquare, change);
                printLatinSquare(latinSquare);
            } else if (n == 5) {
                System.out.print("Case #" + caseNum + ": ");
                handleOddSize(n, k);
            } else {
                System.out.print("Case #" + caseNum + ": ");
                handleEvenSize(n, k);
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
        for (int[] row : latinSquare) {
            for (int j = 0; j < row.length; j++) {
                if (j != row.length - 1) {
                    System.out.print(row[j] + " ");
                } else {
                    System.out.print(row[j]);
                }
            }
            System.out.println();
        }
    }

    private static void handleOddSize(int n, int k) {
        int[][] latinSquare = {
                {3, 4, 2, 1, 5},
                {4, 5, 3, 2, 1},
                {1, 3, 4, 5, 2},
                {2, 1, 5, 3, 4},
                {5, 2, 1, 4, 3}
        };

        if (getDiagonalSum(latinSquare) == k) {
            System.out.println("POSSIBLE");
            printLatinSquare(latinSquare);
            return;
        }

        int[][] copy = new int[n][n];
        if (tryAdjustingLatinSquare(latinSquare, copy, n, k)) {
            return;
        }

        if (k == 17) {
            System.out.println("POSSIBLE");
            System.out.println("3 4 1 2 5");
            System.out.println("2 5 3 4 1");
            System.out.println("4 1 5 3 2");
            System.out.println("5 3 2 1 4");
            System.out.println("1 2 4 5 3");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean tryAdjustingLatinSquare(int[][] latinSquare, int[][] copy, int n, int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                for (int m = 1; m <= n; m++) {
                    if (m == i || m == j) continue;
                    adjustLatinSquareWithValues(latinSquare, copy, n, i, j, m);
                    if (getDiagonalSum(copy) == k) {
                        System.out.println("POSSIBLE");
                        printLatinSquare(copy);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void adjustLatinSquareWithValues(int[][] latinSquare, int[][] copy, int n, int num1, int num2, int num3) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (latinSquare[a][b] == num1) {
                    copy[a][b] = num2;
                } else if (latinSquare[a][b] == num2) {
                    copy[a][b] = num3;
                } else if (latinSquare[a][b] == num3) {
                    copy[a][b] = num1;
                } else {
                    copy[a][b] = latinSquare[a][b];
                }
            }
        }
    }

    private static void handleEvenSize(int n, int k) {
        int[][] latinSquare = generateLatinSquare(n);
        reverseRows(latinSquare);

        if (getDiagonalSum(latinSquare) == k) {
            System.out.println("POSSIBLE");
            printLatinSquare(latinSquare);
            return;
        }

        if (tryAdjustingLatinSquareForEven(latinSquare, n, k)) {
            return;
        }

        System.out.println("IMPOSSIBLE");
    }

    private static boolean tryAdjustingLatinSquareForEven(int[][] latinSquare, int n, int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                adjustLatinSquareWithTwoValues(latinSquare, n, i, j);
                if (getDiagonalSum(latinSquare) == k) {
                    System.out.println("POSSIBLE");
                    printLatinSquare(latinSquare);
                    return true;
                }
            }
        }
        return false;
    }

    private static void adjustLatinSquareWithTwoValues(int[][] latinSquare, int n, int num1, int num2) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (latinSquare[a][b] == num1) {
                    latinSquare[a][b] = num2;
                } else if (latinSquare[a][b] == num2) {
                    latinSquare[a][b] = num1;
                }
            }
        }
    }

    private static void reverseRows(int[][] latinSquare) {
        int n = latinSquare.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = latinSquare[n - i - 1];
            latinSquare[n - i - 1] = latinSquare[i];
            latinSquare[i] = temp;
        }
    }

    private static int getDiagonalSum(int[][] latinSquare) {
        int sum = 0;
        for (int i = 0; i < latinSquare.length; i++) {
            sum += latinSquare[i][i];
        }
        return sum;
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
}