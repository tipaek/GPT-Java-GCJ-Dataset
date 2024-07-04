import java.io.*;
import java.util.*;

class Solution {
    static boolean isPossible = false;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] board = new int[n][n];
            isPossible = false;
            
            generateLatinSquare(board, n, k, 0, 0);
            
            if (!isPossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": POSSIBLE");
                printBoard(board);
            }
        }
    }

    static void generateLatinSquare(int[][] board, int n, int k, int row, int col) {
        solve(board, n, k, row, col);
    }

    static boolean solve(int[][] board, int n, int k, int row, int col) {
        if (row == n) {
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += board[i][i];
            }
            if (diagonalSum == k) {
                isPossible = true;
                return true;
            }
            return false;
        }

        if (col == n) {
            return solve(board, n, k, row + 1, 0);
        }

        if (board[row][col] != 0) {
            return solve(board, n, k, row, col + 1);
        }

        for (int num = 1; num <= n; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, n, k, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int i = 0; i < row.length; i++) {
                if (i == row.length - 1) {
                    System.out.print(row[i]);
                } else {
                    System.out.print(row[i] + " ");
                }
            }
            System.out.println();
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}