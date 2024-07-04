import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;
    boolean sudokuSolved = false;

    private void solve() {
        sudokuSolved = false;
        int r = sc.nextInt();
        int trace = sc.nextInt();
        int[][] matrix = new int[r][r];
        int [][] rows = new int[r][r + 1];
        int [][] columns = new int[r][r + 1];
        backtrack(0, 0, matrix, r, rows, columns, trace);
        if(sudokuSolved){
            out.println("POSSIBLE");
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    out.print(matrix[i][j] + " ");
                }
                out.println();
            }
        }else{
            out.println("IMPOSSIBLE");
        }
    }

    public boolean couldPlace(int d, int row, int col, int[][] rows, int[][] columns) {
        return rows[row][d] + columns[col][d] == 0;
    }

    public void placeNumber(int d, int row, int col, int[][] rows, int[][] columns, int[][] board) {
        rows[row][d]++;
        columns[col][d]++;
        board[row][col] = d;
    }

    public int sumdiag(int[][] board){
        int sum = 0;
        for(int i=0;i<board.length;i++){
            sum += board[i][i];
        }
        return sum;
    }

    public void placeNextNumbers(int row, int col, int r, int[][] board, int[][] rows, int[][] columns, int trace) {
        // if we're in the last cell
        // that means we have the solution
        if ((col == r - 1) && (row == r - 1) && sumdiag(board) == trace) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == r - 1) backtrack(row + 1, 0, board, r, rows, columns, trace);
                // go to the next column
            else backtrack(row, col + 1, board, r, rows, columns, trace);
        }
    }

    public void removeNumber(int d, int row, int col, int[][] rows, int[][] columns, int[][] board) {
        rows[row][d]--;
        columns[col][d]--;
        board[row][col] = 0;
    }

    public void backtrack(int row, int col, int[][] board, int r, int[][] rows, int[][] columns, int trace) {
        // if the cell is empty
        if(row>=r||col>=r){
            return;
        }
        if (board[row][col] == 0) {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d <= r; d++) {
                if (couldPlace(d, row, col, rows, columns)) {
                    placeNumber(d, row, col, rows, columns, board);
                    placeNextNumbers(row, col, r, board, rows, columns, trace);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) removeNumber(d, row, col, rows, columns, board);
                }
            }
        }
        else placeNextNumbers(row, col, r,  board, rows, columns, trace);
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
