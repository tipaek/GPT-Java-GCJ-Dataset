import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            boolean isPossible = true;
            int x = n + 1;
            int y = n * n - 1;

            if ((k == x && k == y) || (n == 3 && (k == 5 || k == 7))) {
                isPossible = false;
            }

            if (isPossible) {
                int pointer = 0;
                int[][] matrix = new int[n][n];

                while (k > 0) {
                    matrix[pointer][pointer]++;
                    k--;
                    pointer++;
                    if (pointer == n) {
                        pointer = 0;
                    }
                }

                System.out.println("Case #" + testCase + ": POSSIBLE");
                solveSudoku(matrix, n);
                printMatrix(matrix, n);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        int n = board.length;
        int sqrt = (int) Math.sqrt(n);

        for (int d = 0; d < n; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }

        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
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