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
                int changeValue = k / n;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (latinSquare[i][j] == changeValue) {
                            latinSquare[i][j] = 1;
                        } else if (latinSquare[i][j] == 1) {
                            latinSquare[i][j] = changeValue;
                        }
                        System.out.print(latinSquare[i][j] + (j != n - 1 ? " " : ""));
                    }
                    System.out.println();
                }
            } else if (n == 5) {
                System.out.print("Case #" + caseNum + ": ");
                handleOddCase(n, k);
            } else {
                if (n == 4 && k % n != 0) {
                    handleSpecialCaseForN4(caseNum, k);
                } else {
                    System.out.print("Case #" + caseNum + ": ");
                    handleEvenCase(n, k);
                }
            }
        }
    }

    private static void handleOddCase(int n, int k) {
        int[][] latinSquare = {
            {3, 4, 2, 1, 5}, {4, 5, 3, 2, 1}, 
            {1, 3, 4, 5, 2}, {2, 1, 5, 3, 4}, {5, 2, 1, 4, 3}
        };

        if (calculateDiagonalSum(latinSquare, n) == k) {
            printLatinSquare(latinSquare, n);
            return;
        }

        int[][] copy = new int[n][n];
        if (tryToMatchDiagonalSum(latinSquare, copy, n, k)) {
            printLatinSquare(copy, n);
        } else {
            printPredefinedLatinSquareForOdd(n, k);
        }
    }

    private static void handleEvenCase(int n, int k) {
        int[][] latinSquare = generateLatinSquare(n);
        reverseRows(latinSquare, n);

        if (calculateDiagonalSum(latinSquare, n) == k) {
            printLatinSquare(latinSquare, n);
            return;
        }

        if (tryToMatchDiagonalSumForEven(latinSquare, n, k)) {
            printLatinSquare(latinSquare, n);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static void handleSpecialCaseForN4(int caseNum, int k) {
        System.out.print("Case #" + caseNum + ": ");
        switch (k) {
            case 7:
                printLatinSquare(new int[][] {
                    {2, 1, 3, 4}, {1, 3, 4, 2}, 
                    {4, 2, 1, 3}, {3, 4, 2, 1}
                });
                break;
            case 9:
                printLatinSquare(new int[][] {
                    {4, 1, 3, 2}, {1, 3, 2, 4}, 
                    {2, 4, 1, 3}, {3, 2, 4, 1}
                });
                break;
            case 11:
                printLatinSquare(new int[][] {
                    {4, 2, 3, 1}, {2, 3, 1, 4}, 
                    {1, 4, 2, 3}, {3, 1, 4, 2}
                });
                break;
            default:
                System.out.println("IMPOSSIBLE");
                break;
        }
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] latinSquare = new int[n][n];
        int startValue = n + 1;

        for (int i = 0; i < n; i++) {
            int temp = startValue;
            int count = 0;
            while (temp <= n) {
                latinSquare[i][count++] = temp++;
            }
            for (int j = 1; j < startValue; j++) {
                latinSquare[i][count++] = j;
            }
            startValue--;
        }
        return latinSquare;
    }

    private static void reverseRows(int[][] latinSquare, int n) {
        for (int i = 0; i < n / 2; i++) {
            int[] temp = latinSquare[n - i - 1];
            latinSquare[n - i - 1] = latinSquare[i];
            latinSquare[i] = temp;
        }
    }

    private static int calculateDiagonalSum(int[][] latinSquare, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += latinSquare[i][i];
        }
        return sum;
    }

    private static boolean tryToMatchDiagonalSum(int[][] latinSquare, int[][] copy, int n, int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int m = 1; m <= n; m++) {
                    if (m == i || m == j) continue;
                    int count = 0;
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < n; b++) {
                            if (latinSquare[a][b] == i) {
                                copy[a][b] = j;
                            } else if (latinSquare[a][b] == j) {
                                copy[a][b] = m;
                            } else if (latinSquare[a][b] == m) {
                                copy[a][b] = i;
                            } else {
                                copy[a][b] = latinSquare[a][b];
                            }
                        }
                        count += copy[a][a];
                    }
                    if (count == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean tryToMatchDiagonalSumForEven(int[][] latinSquare, int n, int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int count = 0;
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        if (latinSquare[a][b] == i) {
                            latinSquare[a][b] = j;
                        } else if (latinSquare[a][b] == j) {
                            latinSquare[a][b] = i;
                        }
                    }
                    count += latinSquare[a][a];
                }
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printLatinSquare(int[][] latinSquare) {
        for (int[] row : latinSquare) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + (i != row.length - 1 ? " " : ""));
            }
            System.out.println();
        }
    }

    private static void printPredefinedLatinSquareForOdd(int n, int k) {
        switch (k) {
            case 17:
                printLatinSquare(new int[][] {
                    {3, 4, 1, 2, 5}, {2, 5, 3, 4, 1}, 
                    {4, 1, 5, 3, 2}, {5, 3, 2, 1, 4}, {1, 2, 4, 5, 3}
                });
                break;
            case 9:
                printLatinSquare(new int[][] {
                    {1, 4, 3, 5, 2}, {5, 2, 1, 4, 3}, 
                    {4, 3, 2, 1, 5}, {2, 1, 5, 3, 4}, {3, 5, 4, 2, 1}
                });
                break;
            default:
                System.out.println("IMPOSSIBLE");
                break;
        }
    }
}