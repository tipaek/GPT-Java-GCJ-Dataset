import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] ar = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					ar[j][k] = in.nextInt();
				}
			}
			String ret = solveLine(n, ar);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", i, ret);
		}
	}

	private static String solveLine(int n, int[][] ar) {
		int trace = 0, c = 0, r = 0;
		for (int i = 0; i < n; i++)
			trace += ar[i][i];
		for (int row = 0; row < n; row++) {
			boolean[] done = new boolean[n + 1];
			for (int col = 0; col < n; col++) {
				if (done[ar[row][col]]) {
					r++;
					break;
				}
				done[ar[row][col]] = true;
			}
		}
		for (int col = 0; col < n; col++) {
			boolean[] done = new boolean[n + 1];
			for (int row = 0; row < n; row++) {
				if (done[ar[row][col]]) {
					c++;
					break;
				}
				done[ar[row][col]] = true;
			}
		}
		return String.format("%d %d %d", trace, r, c);
	}

}
