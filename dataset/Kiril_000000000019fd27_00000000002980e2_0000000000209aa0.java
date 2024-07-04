import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": " + solution(s));
		}
	}

	private static String solution(Scanner s) {
		int n = s.nextInt();
		int k = s.nextInt();

		int[][] matrix = new int[n][n];
		boolean[][] rows = new boolean[n][n + 1];
		boolean[][] cols = new boolean[n][n + 1];
		if (dioganal(matrix, rows, cols, n, 0, k)) {
			return "POSSIBLE\n" + printMatrix(matrix);
		} else {
			return "IMPOSSIBLE\n";
		}
	}

	private static String printMatrix(int[][] matrix) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			line(matrix[i], b);
			b.append('\n');
		}
		return b.toString();
	}

	private static void line(int[] line, StringBuilder b) {
		for (int i = 0; i < line.length; i++) {
			if (i != 0) {
				b.append(' ');
			}
			b.append(line[i]);
		}
	}

	static boolean fillMatrix(final int[][] matrix, final int n, boolean[][] rows, boolean[][] cols, int r, int c) {
		if (r + 1 == n && c + 1 == n) {
			return true;
		} else if (r >= n) {
			return false;
		} else if (c >= n) {
			return fillMatrix(matrix, n, rows, cols, r + 1, 0);
		} else if(r == c) {
			return fillMatrix(matrix, n, rows, cols, r, c + 1);
		}

		for (int i = 1; i <= n; i++) {
			if (!rows[r][i] && !cols[c][i]) {
				rows[r][i] = true;
				cols[c][i] = true;
				matrix[r][c] = i;
				if (fillMatrix(matrix, n, rows, cols, r, c + 1)) {
					return true;
				}
				rows[r][i] = false;
				cols[c][i] = false;
			}
		}
		return false;
	}

	static boolean dioganal(final int[][] matrix, boolean[][] rows, boolean[][] cols, final int n, int i, int k) {
		if (n == i) {
			if (k == 0) {
				for (int j = 0; j < n; j++) {
					rows[j][matrix[j][j]] = true;
					cols[j][matrix[j][j]] = true;
				}

				if (fillMatrix(matrix, n, rows, cols, 0, 0)) {
					return true;
				}

				for (int j = 0; j < n; j++) {
					rows[j][matrix[j][j]] = false;
					cols[j][matrix[j][j]] = false;
				}
			}
			return false;
		}
		int left = n - i;
		if (left * n >= k) {
			int min = Math.max(1, k - (left - 1) * n);
			int max = Math.min(n, k - left + 1);
			for (int j = min; j <= max; j++) {
				matrix[i][i] = j;
				if (dioganal(matrix, rows, cols, n, i + 1, k - j)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean findMatrix(final int[][] matrix, boolean[][] rows, boolean[][] cols, final int n, int k, int row,
			int col, int count) {
		if (row == n && col == n + 1 && count == k) {
			return true;
		} else if (row > n) {
			return false;
		} else if (col > n) {
			return findMatrix(matrix, rows, cols, n, k, row + 1, col + 1, count);
		}
		for (int i = 1; i <= n; i++) {
			if (!rows[row][i] && !cols[col][i]) {
				rows[row][i] = true;
				cols[col][i] = true;

				if (findMatrix(matrix, rows, cols, n, k, row, col + 1, count)) {

				}
				rows[row][i] = true;
				cols[col][i] = true;
			}
		}
		return false;
	}

}
