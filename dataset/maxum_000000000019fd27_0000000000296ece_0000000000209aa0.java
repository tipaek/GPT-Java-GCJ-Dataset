import java.util.*;
import java.io.*;


public class Indicium {

	public static List<Set<Integer>> rowList = new ArrayList<>();
	public static List<Set<Integer>> colList = new ArrayList<>();

	public static boolean compute(int[][] board, int k, int sum, int idx) {
		if (idx >= board.length*board.length)  { return (sum == k); }

		int row = idx / board.length;
		int col = idx % board.length;

		for (int num = 1; num <= board.length; num++) {
			if (isValid(board, k, sum, row, col, num)) {
				board[row][col] = num;
				rowList.get(row).add(num);
				colList.get(col).add(num);

				if (row == col) { sum += num; }
				if (compute(board, k, sum, idx+1)) { return true; }
				if (row == col) { sum -= num; }

				//board[row][col] = -1;
				rowList.get(row).remove(num);
				colList.get(col).remove(num);
			}
		}

		return false;
	}


	public static boolean isValid(int[][] board, int k, int tr,
			int row, int col, int num) {

		/* check if already exists in current row */
		if (rowList.get(row).contains(num)) {
			return false;
		}

		/* check if already exists in current column */
		if (colList.get(col).contains(num)) {
			return false;
		}

		/* check if trace exceeds K */
		if ((row == col) && (tr + num) > k) {
			return false;
		}

		return true;
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

			boolean possible = compute(board, k, 0, 0);
			printResult(board, possible, i);
		}


	}


}
