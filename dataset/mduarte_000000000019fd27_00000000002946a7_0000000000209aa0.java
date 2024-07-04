import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testCase = 1; testCase <= t; ++testCase) {
			int size = in.nextInt();
			int k = in.nextInt();

			int[][] ans = createMatrix(size, k);
			if (ans[0][0] == -1) {
				System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
			} else {
				System.out.println("Case #" + testCase + ": " + "POSSIBLE");
				for (int i = 0; i < ans.length; i++) {
					StringBuffer sb = new StringBuffer();
					sb.append(ans[i][0]);
					for (int j = 1; j < ans[0].length; j++) {
						sb.append(" ").append(ans[i][j]);
					}
					System.out.println(sb.toString());
				}
			}
		}
		in.close();
	}

	// static List<int[]> traces;
	public static boolean trace(int size, int k, int[] cur, int index, int sum, int[][] ans) {
		if (index == size) {
			if (sum == k) {
				return solveMatrix(cur, ans);
			} else {
				return false;
			}
		}

		for (int i = 1; i <= size; i++) {
			if (sum + i <= k) {
				cur[index] = i;
				if (!trace(size, k, cur, index + 1, sum + i, ans)) {
					cur[index] = 0;
				} else {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;

	}

	static boolean[][] rows;
	static boolean[][] cols;

	public static boolean numberAvailable(int num, int r, int c) {
		return !(rows[r][num] || cols[c][num]);
	}

	private static boolean solveMatrix(int[][] ans, int pos) {
		int size = ans.length;
		if (pos >= size * size) {
			return true;
		}

		int r = pos / size;
		int c = pos % size;

		if (ans[r][c] == -1) {
			for (int i = 1; i <= size; i++) {
				if (numberAvailable(i, r, c)) {
					changeBoard(ans, i, r, c);
					if (solveMatrix(ans, pos + 1)) {
						return true;
					}
					removeBoard(ans, i, r, c);
				}
			}
		} else {
			return solveMatrix(ans, pos + 1);
		}

		return false;

	}

	public static void changeBoard(int[][] board, int num, int row, int col) {
		board[row][col] = num;

		rows[row][num] = true;
		cols[col][num] = true;

	}

	public static void removeBoard(int[][] board, int num, int row, int col) {
		board[row][col] = -1;

		rows[row][num] = false;
		cols[col][num] = false;

	}

	private static boolean solveMatrix(int[] trace, int[][] ans) {
		int N = ans.length + 1;
		rows = new boolean[N][N];
		cols = new boolean[N][N];

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				ans[i][j] = -1;
			}
		}

		for (int i = 0; i < trace.length; i++) {
			int num = trace[i];
			ans[i][i] = num;
			rows[i][num] = true;
			cols[i][num] = true;
		}

		return solveMatrix(ans, 1);
	}

	public static int[][] createMatrix(int size, int k) {
		int[][] ans = new int[size][size];
		
		
		if (!trace(size, k, new int[size], 0, 0, ans)) {
			ans[0][0] = -1;
		}

		return ans;
		
	}

}
