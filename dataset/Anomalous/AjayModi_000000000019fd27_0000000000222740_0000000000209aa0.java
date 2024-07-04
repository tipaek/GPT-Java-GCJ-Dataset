import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int it = 1; it <= t; it++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            if (k % n == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][i] = k / n;
                }
                if (!solve(matrix, n)) {
                    if (sumOfFirstNNumbers(n) == k) {
                        for (int i = 0; i < n; i++) {
                            matrix[i][i] = i + 1;
                        }
                        if (!solve(matrix, n)) {
                            printResult(it, "IMPOSSIBLE");
                        } else {
                            printResult(it, "POSSIBLE");
                            printMatrix(matrix, n);
                        }
                    }
                } else {
                    printResult(it, "POSSIBLE");
                    printMatrix(matrix, n);
                }
            } else {
                if (sumOfFirstNNumbers(n) == k) {
                    for (int i = 0; i < n; i++) {
                        matrix[i][i] = i + 1;
                    }
                    if (!solve(matrix, n)) {
                        printResult(it, "IMPOSSIBLE");
                    } else {
                        printResult(it, "POSSIBLE");
                        printMatrix(matrix, n);
                    }
                }
            }
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int sumOfFirstNNumbers(int n) {
        return n * (n + 1) / 2;
    }

    private static boolean solve(int[][] board, int n) {
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

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        return true;
    }
}