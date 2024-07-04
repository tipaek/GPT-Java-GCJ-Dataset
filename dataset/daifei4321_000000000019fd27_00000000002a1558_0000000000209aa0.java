import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			int[][] rows = getRows(N);
			int[] valid = getValid(rows, K - N);
			if (null != valid) {
				System.out.println("CASE #" + (t + 1) + ": " + "POSSIBLE");
				for (int y = 0; y < N; y++) {
					int[] row = rows[valid[y]];
					for (int x = 0; x < N; x++) {
						if (x > 0) {
							System.out.print(' ');
						}
						System.out.print(row[x] + 1);
					}
					System.out.println();
				}
			} else {
				System.out.println("CASE #" + (t + 1) + ": " + "IMPOSSIBLE");
			}
//			int[][] grid = new int[N][N];
//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < N; x++) {
//					grid[y][x] = 1 + (y + x) % N;
//				}
//			}
//			int[] cs = new int[N];
//			boolean[] cUsed = new boolean[N];
//			if (getCs(grid, K, cs, cUsed, 0, 0)) {
//				System.out.println("CASE #" + (t + 1) + ": " + "POSSIBLE");
//				for (int r = 0; r < N; r++) {
//					int c1 = cs[r];
//					if (c1 != r) {
//						for (int r2 = r + 1; ; r2++) {
//							if (cs[r2] == r) {
//								int[] tmp = grid[r];
//								grid[r] = grid[r2];
//								grid[r2] = tmp;
//								cs[r] = r;
//								cs[r2] = c1;
//								break;
//							}
//						}
//					}
//				}
//				for (int y = 0; y < N; y++) {
//					for (int x = 0; x < N; x++) {
//						if (x > 0) {
//							System.out.print(' ');
//						}
//						System.out.print(grid[y][x]);
//					}
//					System.out.println();
//				}
//			} else {
//				System.out.println("CASE #" + (t + 1) + ": " + "IMPOSSIBLE");
//			}
		}
	}

	private static int[] getValid(int[][] rows, int k) {
		int n = rows[0].length;
		int rowTypeCount = rows.length;
		return getValidAt(rows, k, 0, new int[n], new boolean[rowTypeCount]);
//		boolean found = false;
//		for (int[] combination : rows) {
//			if (isValid(combination, rows, K - N)) {
//				found = true;
//				System.out.println("CASE #" + (t + 1) + ": " + "POSSIBLE");
//				for (int y = 0; y < N; y++) {
//					int[] row = rows[combination[y]];
//					for (int x = 0; x < N; x++) {
//						if (x > 0) {
//							System.out.print(' ');
//						}
//						System.out.print(row[x]);
//					}
//					System.out.println();
//				}
//				break;
//			}
//		}
//		return null;
	}

	private static int[] getValidAt(int[][] rows, int k, int at, int[] buffer, boolean[] used) {
		int n = rows[0].length;
		int rowTypeCount = rows.length;
		for (int v = 0; v < rowTypeCount; v++) {
			if (used[v]) {
				continue;
			}
			buffer[at] = v;
			if (at == n - 1) {
				if (isValid(buffer, rows, k)) {
					return buffer;
				}
				continue;
			}
			used[v] = true;
			if (null != getValidAt(rows, k, at + 1, buffer, used)) {
				return buffer;
			}
			used[v] = false;
		}
		return null;
	}

	private static boolean isValid(int[] rowIndexes, int[][] rowData, int k) {
		int n = rowIndexes.length;

//		System.out.println("Check " + Arrays.toString(rowIndexes));
//		for (int y = 0; y < n; y++) {
//			int[] row = rowData[rowIndexes[y]];
//			for (int x = 0; x < n; x++) {
//				if (x > 0) {
//					System.out.print(' ');
//				}
//				System.out.print(row[x]);
//			}
//			System.out.println();
//		}

		int tSum = 0;
		for (int i = 0; i < n; i++) {
			tSum += rowData[rowIndexes[i]][i];
		}
		if (k != tSum) {
			return false;
		}
		boolean[] buffer = new boolean[n];
		for (int c = 0; c < n; c++) {
			Arrays.fill(buffer, false);
			for (int r = 0; r < n; r++) {
				int[] row = rowData[rowIndexes[r]];
				int v = row[c];
				if (buffer[v]) {
					return false;
				}
				buffer[v] = true;
			}
		}
		return true;
	}

	private static int[][] getRows(int n) {
		List<int[]> rows = new ArrayList<>(fac(n));
		fillRows(n, rows, new int[n], new boolean[n], 0);
//		for (int[] r : rows) {
//			System.err.println(Arrays.toString(r));
//		}
		return rows.toArray(i -> new int[i][]);
	}

	private static void fillRows(int n, List<int[]> rows, int[] rowBuffer, boolean[] used, int col) {
		int nextCol = col + 1;
		for (int i = 0; i < n; i++) {
			if (used[i]) {
				continue;
			}
			rowBuffer[col] = i;
			if (nextCol < n) {
				used[i] = true;
				fillRows(n, rows, rowBuffer, used, nextCol);
				used[i] = false;
			} else {
				rows.add(Arrays.copyOf(rowBuffer, n));
			}
		}
	}

	private static int fac(int n) {
		int fac = 1;
		for (int i = 2; i <= n; i++) {
			fac *= i;
		}
		return fac;
	}
}
