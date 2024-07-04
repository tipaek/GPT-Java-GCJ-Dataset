import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			int[][] grid = new int[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					grid[y][x] = 1 + (y + x) % N;
				}
			}
//			System.err.println(Arrays.stream(grid).map(r -> Arrays.stream(r).mapToObj(Integer::toString).collect(Collectors.joining())).collect(Collectors.joining("\n")));
			int[] cs = new int[N];
			boolean[] cUsed = new boolean[N];
			if (getCs(grid, K, cs, cUsed, 0, 0)) {
//				System.err.println(Arrays.toString(cs));
				System.out.println("CASE #" + (t + 1) + ": " + "POSSIBLE");
				for (int r = 0; r < N; r++) {
					int c1 = cs[r];
					if (c1 != r) {
						for (int r2 = r + 1; ; r2++) {
							if (cs[r2] == r) {
								int[] tmp = grid[r];
								grid[r] = grid[r2];
								grid[r2] = tmp;
								cs[r] = r;
								cs[r2] = c1;
								break;
							}
						}
					}
				}
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (x > 0) {
							System.out.print(' ');
						}
						System.out.print(grid[y][x]);
					}
					System.out.println();
				}
			} else {
				System.out.println("CASE #" + (t + 1) + ": " + "IMPOSSIBLE");
			}
		}
	}

	private static boolean getCs(int[][] grid, int k, int[] cs, boolean[] cUsed, int loopR, int sum) {
		int N = grid.length;
		if (loopR == N - 1) {
			int need = k - sum;
			int needIndex = indexOf(grid[loopR], need);
			if (needIndex >= 0 && !cUsed[needIndex]) {
				cs[loopR] = needIndex;
				return true;
			}
			return false;
		}
		int nextR = loopR + 1;
		for (int c = 0; c < N; c++) {
			if (cUsed[c]) {
				continue;
			}
			int newSum = sum + grid[loopR][c];
			int remain = k - newSum;
			if (remain > 0) {
				cs[loopR] = c;
				cUsed[c] = true;
				if (getCs(grid, k, cs, cUsed, nextR , newSum)) {
					return true;
				}
				cUsed[c] = false;
			}
		}
		return false;
	}

	private static int indexOf(int[] a, int need) {
		for (int i = 0, iMax = a.length; i < iMax; i++) {
			if (need == a[i]) {
				return i;
			}
		}
		return -1;
	}
}
