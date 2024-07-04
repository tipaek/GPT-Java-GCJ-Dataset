import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.run();
	}

	void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			final int T = scanner.nextInt();
			scanner.nextLine();

			for (int t = 1; t <= T; t++) {
				final int N = scanner.nextInt();
				final int[][] M = new int[N][N];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int m = scanner.nextInt();
						M[i][j] = m;
					}
				}

				String result = doIt(N, M);
				System.out.println("Case #" + t + ": " + result);
			}
		}
	}

	String doIt(final int N, final int[][] M) {
		int k = 0;

		for (int i = 0; i < N; i++) {
			k += M[i][i];
		}

		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			if (rowHasRepeatedElements(i, M)) {
				r++;
			}

			if (columnHasRepeatedElements(i, M)) {
				c++;
			}
		}

		return k + " " + r + " " + c;
	}

	private boolean rowHasRepeatedElements(final int r, final int[][] M) {
		final int N = M.length;
		final Set<Integer> unique = new HashSet<>(N);
		for (int c = 0; c < N; c++) {
			final int e = M[r][c];
			if (unique.contains(e)) {
				return true;
			}
			unique.add(e);
		}
		return false;
	}

	private boolean columnHasRepeatedElements(final int c, final int[][] M) {
		final int N = M.length;
		final Set<Integer> unique = new HashSet<>(N);
		for (int r = 0; r < N; r++) {
			final int e = M[r][c];
			if (unique.contains(e)) {
				return true;
			}
			unique.add(e);
		}
		return false;
	}
}
