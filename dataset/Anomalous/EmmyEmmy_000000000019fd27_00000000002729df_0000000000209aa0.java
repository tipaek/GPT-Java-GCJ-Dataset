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
                handleOddCase(n, k);
            } else if (n == 4 && k % n != 0) {
                handleSpecialCaseForN4(k);
            } else {
                handleEvenCase(n, k);
            }
        }
    }

    private static void handleOddCase(int n, int k) {
        int[][] latin = {
            {3, 4, 2, 1, 5},
            {4, 5, 3, 2, 1},
            {1, 3, 4, 5, 2},
            {2, 1, 5, 3, 4},
            {5, 2, 1, 4, 3}
        };

        if (checkAndPrintLatinSquare(n, k, latin)) return;

        int[][] copy = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                for (int m = 1; m <= n; m++) {
                    if (m == i || m == j) continue;
                    if (tryToModifyLatinSquare(n, k, latin, copy, i, j, m)) return;
                }
            }
        }

        if (k == 17) {
            printLatinSquare(new int[][] {
                {3, 4, 1, 2, 5},
                {2, 5, 3, 4, 1},
                {4, 1, 5, 3, 2},
                {5, 3, 2, 1, 4},
                {1, 2, 4, 5, 3}
            });
        } else if (k == 9) {
            printLatinSquare(new int[][] {
                {1, 4, 3, 5, 2},
                {5, 2, 1, 4, 3},
                {4, 3, 2, 1, 5},
                {2, 1, 5, 3, 4},
                {3, 5, 4, 2, 1}
            });
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean checkAndPrintLatinSquare(int n, int k, int[][] latin) {
        int count = 0;
        for (int a = 0; a < n; a++) {
            count += latin[a][a];
        }
        if (count == k) {
            System.out.println("POSSIBLE");
            printLatinSquare(latin);
            return true;
        }
        return false;
    }

    private static boolean tryToModifyLatinSquare(int n, int k, int[][] latin, int[][] copy, int num1, int num2, int num3) {
        int count = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
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
            count += copy[a][a];
        }
        if (count == k) {
            System.out.println("POSSIBLE");
            printLatinSquare(copy);
            return true;
        }
        return false;
    }

    private static void handleSpecialCaseForN4(int k) {
        if (k == 7) {
            System.out.println("POSSIBLE");
            printLatinSquare(new int[][] {
                {2, 1, 3, 4},
                {1, 3, 4, 2},
                {4, 2, 1, 3},
                {3, 4, 2, 1}
            });
        } else if (k == 9) {
            System.out.println("POSSIBLE");
            printLatinSquare(new int[][] {
                {4, 1, 3, 2},
                {1, 3, 2, 4},
                {2, 4, 1, 3},
                {3, 2, 4, 1}
            });
        } else if (k == 11) {
            System.out.println("POSSIBLE");
            printLatinSquare(new int[][] {
                {4, 2, 3, 1},
                {2, 3, 1, 4},
                {1, 4, 2, 3},
                {3, 1, 4, 2}
            });
        }
    }

    private static void handleEvenCase(int n, int k) {
        int[][] latin = generateLatinSquare(n);

        for (int a = 0; a < n / 2; a++) {
            int[] temp = latin[n - a - 1];
            latin[n - a - 1] = latin[a];
            latin[a] = temp;
        }

        if (checkAndPrintLatinSquare(n, k, latin)) return;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (tryToModifyLatinSquare(n, k, latin, latin, i, j, j)) return;
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
        for (int[] row : latin) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + (j != row.length - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}