import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static final int DUP_FLAG = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= nTestCases; ++i) {
			int N = in.nextInt();

			// Init matrix
			boolean[][] rows = new boolean[N + 1][N + 1];
			boolean[][] cols = new boolean[N + 1][N + 1];
			for (int j = 0; j <= N; j++) {
				rows[j] = new boolean[N + 1];
				cols[j] = new boolean[N + 1];
			}

			int trace = 0;
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					int value = in.nextInt();
					if (j == k) trace += value;

					if (rows[j][value]) {
						rows[j][DUP_FLAG] = true;
					} else {
						rows[j][value] = true;
					}

					if (cols[k][value]) {
						cols[k][DUP_FLAG] = true;
					} else {
						cols[k][value] = true;
					}
				}
			}

			int dupRows = 0, dupCols = 0;
			for (int j = 0; j <= N; j++) {
				if (rows[j][DUP_FLAG]) {
					dupRows++;
				}
				if (cols[j][DUP_FLAG]) {
					dupCols++;
				}
			}

			System.out.printf("Case #%d: %d %d %d%n", i, trace, dupRows, dupCols);
		}
	}
}
