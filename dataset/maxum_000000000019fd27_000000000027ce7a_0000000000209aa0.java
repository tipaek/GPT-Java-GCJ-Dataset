import java.util.*;
import java.io.*;


public class Solution {

	public static List<Set<Integer>> rowList = new ArrayList<>();
	public static List<Set<Integer>> colList = new ArrayList<>();

	public static boolean compute(int[][] board, int idx) {
		if (idx >= board.length*board.length)  { return true; }

		int row = idx / board.length;
		int col = idx % board.length;
		if (row == col) { return compute(board, idx+1); }

		for (int num = 1; num <= board.length; num++) {
			if (isValid(board, row, col, num)) {
				board[row][col] = num;

				rowList.get(row).add(num);
				colList.get(col).add(num);
				if (compute(board, idx+1)) { return true; }
				rowList.get(row).remove(num);
				colList.get(col).remove(num);
			}
		}

		return false;
	}


	public static boolean isValid(int[][] board, int row, int col, int num) {
		/* check if already exists in current row */
		if (rowList.get(row).contains(num)) {
			return false;
		}
		/* check if already exists in current column */
		if (colList.get(col).contains(num)) {
			return false;
		}
		return true;
	}


	public static void genMatrixDiagonal(int num, int k, int n,
			ArrayList<Integer> comb, List<List<Integer>> res) {

		if ((k == 0) && (comb.size() == n)) {
			res.add(new ArrayList<>(comb));
			return;
		}

		for (int i = num; i <= n; i++) {
			if (k - i < 0) { return; }
			comb.add(i);
			genMatrixDiagonal(i, k-i, n, comb, res);
			comb.remove(comb.size()-1);
		}

	}


	private static void printResult(int[][] board, boolean possible, int t) {
		String sol = (possible) ? "POSSIBLE" : "IMPOSSIBLE";
		System.out.println("Case #" + t + ": " + sol);
		if (possible) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(
				new InputStreamReader(System.in)));

		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[][] board = new int[n][n];
			for (int[] row: board) {
				Arrays.fill(row, -1);
				rowList.add(new HashSet<Integer>());
				colList.add(new HashSet<Integer>());
			}

			boolean possible = false;

			List<List<Integer>> diagonalCombs = new ArrayList<>();
			genMatrixDiagonal(1, k, n, new ArrayList<Integer>(), diagonalCombs);
			//System.out.println("Generated combinations: " + diagonalCombs.size());
			for (List<Integer> l: diagonalCombs) {
				for (int m = 0; m < n; m++) {
					board[m][m] = l.get(m);
					rowList.get(m).add(board[m][m]);
					colList.get(m).add(board[m][m]);
				}

				possible = compute(board, 1);
				if (possible) { break; }
			}

			printResult(board, possible, i);
		}


	}


}
