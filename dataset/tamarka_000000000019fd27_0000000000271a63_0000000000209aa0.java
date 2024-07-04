import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();


            boolean success = false;
            List<List<Integer>> traces = new ArrayList<>();
            blah(n, n, k, Collections.emptyList(), traces);
            for (List<Integer> trace : traces) {
                int[][] board = generateBoard(trace);
                if (solveSquare(board)) {
                    System.out.println(String.format("Case #%d: %s", i, "POSSIBLE"));
                    print(board);
                    success = true;
                    break;
                }
            }
            if (!success) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
            }
        }
    }

    private static int[][] generateBoard(List<Integer> trace) {
        int[][] board = new int[trace.size()][trace.size()];
        for (int r = 0; r < trace.size(); r++) {
            for (int c = 0; c < trace.size(); c++) {
                if (r == c) {
                    board[c][r] = trace.get(r);
                } else {
                    board[c][r] = 0;
                }
            }
        }
        return board;
    }

    private static void blah(int n, int level, int k, List<Integer> trace, List<List<Integer>> results) {
        if (level == 0) {
            if (k == 0) {
                results.add(trace);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> tr = new ArrayList<>(trace);
            tr.add(i);
            blah(n, level - 1, k - i, tr, results);
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

    public static boolean solveSquare(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
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

        for (int num = 1; num <= board.length; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSquare(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int d = 0; d < board.length; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}