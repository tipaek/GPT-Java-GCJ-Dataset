import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean isPossible = true;
            int x = n + 1;
            int y = n * n - 1;

            if (k == x || k == y || (n == 3 && (k == 5 || k == 7))) {
                isPossible = false;
            }

            if (isPossible) {
                int pointer = 0;
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    matrix[i][i] = 1;
                }

                while (k - n > 0) {
                    matrix[pointer][pointer]++;
                    k--;
                    pointer++;
                    if (pointer >= n) {
                        pointer = 0;
                    }
                }

                if (matrix[n - 1][n - 1] == matrix[n - 2][n - 2] - 1) {
                    matrix[n - 2][n - 2]++;
                    matrix[n - 3][n - 3]--;
                } else if (matrix[0][0] == matrix[1][1] + 1) {
                    matrix[0][0]++;
                    matrix[1][1]--;
                }

                System.out.println("Case #" + (testCase + 1) + ": POSSIBLE");
                solveSudoku(matrix, n);
                printMatrix(matrix, n);
            } else {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            }
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
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

    public static boolean solveSudoku(int[][] board, int n) {
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
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void printMatrix(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }
}