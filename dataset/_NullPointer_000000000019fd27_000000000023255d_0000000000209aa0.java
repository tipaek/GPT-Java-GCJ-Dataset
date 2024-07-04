import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
//
		for (int tt = 1; tt <= t; tt++) {
			Solution bundling = new Solution();
			bundling.solve(in, tt);
		}

		in.close();

	}

	private void solve(Scanner in, int tt) {
		int n = in.nextInt();
		int trace = in.nextInt();

			int res[][] = generate(n, trace);
		if (res == null)
			printLine("Case #" + tt + ": IMPOSSIBLE");
		else {
			printLine("Case #" + tt + ": POSSIBLE");
//			System.out.println(Arrays.deepToString(res));
			for(int a[]:res) {
				StringBuilder sb=new StringBuilder();
				for(int elem:a) {
					sb.append(elem);
					sb.append(" ");
				}
				sb.setLength(sb.length()-1);
				System.out.println(sb);
			}
		}
	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

	boolean generate(int ind, int n, int trace, int a[][]) {

		if (trace == 0) {
			if (ind == n) {
				if (new Solution().solveSudoku(a)) {
//					System.out.println(Arrays.deepToString(a))
//					;
					return true;
				}
			}
			return false;
		}
		if (ind >= n || trace < 0)
			return false;
		;
		for (int i = 1; i <= n; i++) {
			a[ind][ind] = i;
			if (generate(ind + 1, n, trace - a[ind][ind], a))
				return true;

//			a[i]=old;
		}
		return false;
	}

	int[][] generate(int n, int trace) {

		int a[][] = new int[n][n];
		for (int i = 1; i <= n; i++) {
			a[0][0] = i;
			if (generate(1, n, trace - a[0][0], a)) {
				return a;
			}

		}
//			a[i]=old;
		return null;

	}

	// row size
	int N;

	int[][] rows = new int[N][N + 1];
	int[][] columns = new int[N][N + 1];

	int[][] board;

	boolean sudokuSolved = false;

	public boolean couldPlace(int d, int row, int col) {
		/*
		 * Check if one could place a number d in (row, col) cell
		 */
		return rows[row][d] + columns[col][d] == 0;
	}

	public void placeNumber(int d, int row, int col) {
		/*
		 * Place a number d in (row, col) cell
		 */

		rows[row][d]++;
		columns[col][d]++;
		board[row][col] = (d);
	}

	public void removeNumber(int d, int row, int col) {
		/*
		 * Remove a number which didn't lead to a solution
		 */
		rows[row][d]--;
		columns[col][d]--;
		board[row][col] = 0;
	}

	public void placeNextNumbers(int row, int col) {
		/*
		 * Call backtrack function in recursion to continue to place numbers till the
		 * moment we have a solution
		 */
		// if we're in the last cell
		// that means we have the solution
		if ((col == N - 1) && (row == N - 1)) {
			sudokuSolved = true;
		}
		// if not yet
		else {
			// if we're in the end of the row
			// go to the next row
			if (col == N - 1)
				backtrack(row + 1, 0);
			// go to the next column
			else
				backtrack(row, col + 1);
		}
	}

	public boolean backtrack(int row, int col) {
		/*
		 * Backtracking
		 */
		// if the cell is empty
		if (board[row][col] == 0) {
			// iterate over all numbers from 1 to 9
			for (int d = 1; d <= N; d++) {
				if (couldPlace(d, row, col)) {
					placeNumber(d, row, col);
					placeNextNumbers(row, col);
					// if sudoku is solved, there is no need to backtrack
					// since the single unique solution is promised
					if (!sudokuSolved)
						removeNumber(d, row, col);

				}
			}
		} else
			placeNextNumbers(row, col);
		return sudokuSolved;
	}

	public boolean solveSudoku(int[][] board) {
		this.board = board;
		N = board.length;
		rows = new int[N][N + 1];
		columns = new int[N][N + 1];

		// init rows, columns and boxes
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = board[i][j];
				if (num != 0) {
					placeNumber(num, i, j);
				}
			}
		}
		return backtrack(0, 0);
	}

}
