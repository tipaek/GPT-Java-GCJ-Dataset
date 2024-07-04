package codeJam;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.print("Case #" + i + ": ");
            if (k % n == 0) {
                System.out.println("POSSIBLE");
                int[][] latin = generateLatinSquare(n);
                int change = k / n;
                for (int j = 0; j < n; j++) {
                    for (int m = 0; m < n; m++) {
                        if (latin[j][m] == change) {
                            latin[j][m] = 1;
                        } else if (latin[j][m] == 1) {
                            latin[j][m] = change;
                        }
                        System.out.print(latin[j][m] + (m != n - 1 ? " " : ""));
                    }
                    System.out.println();
                }
            } else if (n == 5) {
                printResultOdd(n, k);
            } else if (n == 4 && k % n != 0) {
                printSpecialCaseFor4(n, k);
            } else {
                printResultEven(n, k);
            }
        }
    }

    private static void printSpecialCaseFor4(int n, int k) {
        switch (k) {
            case 7:
                System.out.println("POSSIBLE");
                System.out.println("2 1 3 4");
                System.out.println("1 3 4 2");
                System.out.println("4 2 1 3");
                System.out.println("3 4 2 1");
                break;
            case 9:
                System.out.println("POSSIBLE");
                System.out.println("4 1 3 2");
                System.out.println("1 3 2 4");
                System.out.println("2 4 1 3");
                System.out.println("3 2 4 1");
                break;
            case 11:
                System.out.println("POSSIBLE");
                System.out.println("4 2 3 1");
                System.out.println("2 3 1 4");
                System.out.println("1 4 2 3");
                System.out.println("3 1 4 2");
                break;
            default:
                System.out.println("IMPOSSIBLE");
        }
    }

    private static void printResultOdd(int n, int k) {
        int[][] latin = {
                {3, 4, 2, 1, 5},
                {4, 5, 3, 2, 1},
                {1, 3, 4, 5, 2},
                {2, 1, 5, 3, 4},
                {5, 2, 1, 4, 3}
        };

        if (calculateDiagonalSum(latin) == k) {
            printLatinSquare(latin);
            return;
        }

        int[][] copy = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                for (int m = 1; m <= n; m++) {
                    if (m == i || m == j) continue;
                    copyLatinSquareWithSwaps(latin, copy, i, j, m);
                    if (calculateDiagonalSum(copy) == k) {
                        printLatinSquare(copy);
                        return;
                    }
                }
            }
        }

        if (k == 17) {
            System.out.println("POSSIBLE");
            System.out.println("3 4 1 2 5");
            System.out.println("2 5 3 4 1");
            System.out.println("4 1 5 3 2");
            System.out.println("5 3 2 1 4");
            System.out.println("1 2 4 5 3");
        } else if (k == 9) {
            System.out.println("POSSIBLE");
            System.out.println("1 4 3 5 2");
            System.out.println("5 2 1 4 3");
            System.out.println("4 3 2 1 5");
            System.out.println("2 1 5 3 4");
            System.out.println("3 5 4 2 1");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static void printResultEven(int n, int k) {
        int[][] latin = generateLatinSquare(n);
        reverseRows(latin);

        if (calculateDiagonalSum(latin) == k) {
            printLatinSquare(latin);
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                swapValuesInLatinSquare(latin, i, j);
                if (calculateDiagonalSum(latin) == k) {
                    printLatinSquare(latin);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] arr = new int[n][n];
        int k = n + 1;
        for (int i = 0; i < n; i++) {
            int temp = k;
            int count = 0;
            while (temp <= n) {
                arr[i][count++] = temp++;
            }
            for (int j = 1; j < k; j++) {
                arr[i][count++] = j;
            }
            k--;
        }
        return arr;
    }

    private static void printLatinSquare(int[][] latin) {
        System.out.println("POSSIBLE");
        for (int[] row : latin) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + (j != row.length - 1 ? " " : ""));
            }
            System.out.println();
        }
    }

    private static int calculateDiagonalSum(int[][] latin) {
        int sum = 0;
        for (int i = 0; i < latin.length; i++) {
            sum += latin[i][i];
        }
        return sum;
    }

    private static void copyLatinSquareWithSwaps(int[][] latin, int[][] copy, int num1, int num2, int num3) {
        for (int a = 0; a < latin.length; a++) {
            for (int b = 0; b < latin[a].length; b++) {
                if (latin[a][b] == num1) {
                    copy[a][b] = num2;
                } else if (latin[a][b] == num2) {
                    copy[a][b] = num3;
                } else if (latin[a][b] == num3) {
                    copy[a][b] = num1;
                } else {
                    copy[a][b] = latin[a][b];
                }
            }
        }
    }

    private static void reverseRows(int[][] latin) {
        for (int i = 0; i < latin.length / 2; i++) {
            int[] temp = latin[latin.length - i - 1];
            latin[latin.length - i - 1] = latin[i];
            latin[i] = temp;
        }
    }

    private static void swapValuesInLatinSquare(int[][] latin, int num1, int num2) {
        for (int a = 0; a < latin.length; a++) {
            for (int b = 0; b < latin[a].length; b++) {
                if (latin[a][b] == num1) {
                    latin[a][b] = num2;
                } else if (latin[a][b] == num2) {
                    latin[a][b] = num1;
                }
            }
        }
    }
}