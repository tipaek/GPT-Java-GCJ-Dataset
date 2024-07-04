import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static final String POSSIBLE = "POSSIBLE";
	static final String IMPOSSIBLE = "IMPOSSIBLE";
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testNumber = in.nextInt();

		for (int i = 1; i <= testNumber; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			outputTestResult(i, n, k);
		}
	}
	
	static void outputTestResult(int i, int n, int k) {
		matrix = calcMatrix(n, k);
		if (matrix == null) System.out.println("Case #" + i + ": " + IMPOSSIBLE);
		else {
			System.out.println("Case #" + i + ": " + POSSIBLE);
			printMatrix(matrix);
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) printRow(row);
	}

	private static void printRow(int[] row) {
		StringBuilder sb = new StringBuilder();
		for (int num : row) sb.append(num).append(" ");
		System.out.println(sb.toString());
	}

	private static int[][] calcMatrix(int n, Integer k) {
		List<Set<Integer>> rows = new ArrayList<>(), cols = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			rows.add(new HashSet<>());
			cols.add(new HashSet<>());
		}

		matrix = new int[n][n];
		if (canCreateMatrix(0, 0, n, k, rows, cols)) {
			return matrix;
		}

		return null;
	}

private static boolean canCreateMatrix(int row, int col, int n, int k, List<Set<Integer>> rows, List<Set<Integer>> cols) {
		if (row == n) {
			return k == 0;
		}

		if (k < 0) return false;

		for (int i = n; i >= 1; i--) {
			if (rows.get(row).contains(i) || cols.get(col).contains(i)) continue;
			rows.get(row).add(i);
			cols.get(col).add(i);

			int[] next = getNext(row, col, n);

			matrix[row][col] = i;
			if (row == col) {
				k = k - i;
			}
			if (canCreateMatrix(next[0], next[1], n, k, rows, cols)) {
				return true;
			}
			if (row == col) {
				k = k + i;
			}

			matrix[row][col] = 0;
			rows.get(row).remove(i);
			cols.get(col).remove(i);
		}

		return false;
	}

	private static int[] getNext(int row, int col, int n) {
		if (col == n - 1) return new int[]{row + 1, 0};
		return new int[]{row, col + 1};
	}
}