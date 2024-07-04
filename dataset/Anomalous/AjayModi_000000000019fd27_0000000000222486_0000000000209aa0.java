import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int it = 1; it <= t; it++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] arr = new int[n][n];

            if (k % n == 0) {
                for (int i = 0; i < n; i++) {
                    arr[i][i] = k / n;
                }

                if (!solve(arr, n)) {
                    int sum = n * (n + 1) / 2;
                    if (sum == k) {
                        for (int i = 0; i < n; i++) {
                            arr[i][i] = i + 1;
                        }

                        if (!solve(arr, n)) {
                            System.out.println("Case #" + it + ": IMPOSSIBLE");
                        } else {
                            System.out.println("Case #" + it + ": POSSIBLE");
                            print(arr, n);
                        }
                    }
                } else {
                    System.out.println("Case #" + it + ": POSSIBLE");
                    print(arr, n);
                }
            } else {
                System.out.println("Case #" + it + ": IMPOSSIBLE");
            }
        }
    }

    public static void print(int[][] arr, int n) {
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }
        return true;
    }
}