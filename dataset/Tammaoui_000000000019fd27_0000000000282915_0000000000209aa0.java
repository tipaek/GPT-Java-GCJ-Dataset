

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.exit;

public class Sud {

    static int[][] grid;
    static StringBuilder sb = new StringBuilder();
    static int k;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < testCases; i++) {
            int n = in.nextInt();
            k = in.nextInt();
            grid = new int[n][n];
            if (solve(grid)){
                sb.append("Case #" + (i+1) + ": POSSIBLE" + "\n" + displayGrid(grid));
            }
            else {
                sb.append("Case #" + (i+1) + ": IMPOSSIBLE" + "\n");
            }
        }
        System.out.println(sb);
    }

    public static String displayGrid(int[][] grid){
        StringBuilder s = new StringBuilder();
        for (int[] row: grid) {
            for (int i: row) {
                s.append(i + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public static int get_trace(int[][] grid){
        int i = 0;
        int res = 0;
        for (int[] row: grid) {
            res += row[i];
            i++;
        }
        return  res;
    }

    public static int[] find_empty(int[][] board){
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length ; x++) {
                if(board[y][x] == 0) return new int[]{y, x};
            }
        }
        return null;
    }

    public static boolean solve(int[][] board){
        int[] find = find_empty(board);
        if (find == null) {
            if (get_trace(board) == k){
                return true;
            }
            return false;
        }
        else {
            int row = find[0];
            int col = find[1];

            for (int i = 1; i < board.length + 1; i++) {
                if(valid(board, i, find)){
                    board[row][col] = i;
                    if (solve(board)) return true;
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean valid(int[][] board, int num, int[] pos) {
        for (int i = 0; i < board.length; i++) {
            if(board[pos[0]][i] == num && pos[1] != i) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][pos[1]] == num && pos[0] != i){
                return false;
            }
        }
        return true;
    }
}
