import java.util.Scanner;

public class Solution {

	private static int[] solve(int[][] m) {
		int N = m.length;
		int trace = 0;

		for (int i = 0; i < N; i += 1) {
			trace += m[i][i];
		}

		int dupRows = 0;
		for (int r = 0; r < N; r += 1) {
			boolean[] seen = new boolean[N + 1];
			for (int c = 0; c < N; c += 1) {
				if (seen[m[r][c]]) {
					dupRows += 1;
					break;
				}
				seen[m[r][c]] = true;
			}
		}

		int dupCols = 0;
		for (int c = 0; c < N; c += 1) {
			boolean[] seen = new boolean[N + 1];
			for (int r = 0; r < N; r += 1) {
				if (seen[m[r][c]]) {
					dupCols += 1;
					break;
				}
				seen[m[r][c]] = true;
			}
		}

		return new int[] {trace, dupRows, dupCols};
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int t = 1; t <= T; t += 1) {
			int N = s.nextInt();

			int[][] m = new int[N][N];

			for (int r = 0; r < N; r += 1) {
				for (int c = 0; c < N; c += 1) {
					m[r][c] = s.nextInt();
				}
			}

			int[] krc = solve(m);


			System.out.printf("Case #%d: %d %d %d\n", t, krc[0] , krc[1], krc[2]);
		}
	}
}
