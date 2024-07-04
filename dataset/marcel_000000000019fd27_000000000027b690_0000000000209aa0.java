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
			int k = in.nextInt();
			String ret = solveLine(n, k);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", i, ret);
		}
	}

	private static String solveLine(int n, int k) {
		if (k < n || k > n * n) return "IMPOSSIBLE";
		if (k % n != 0) return "IMPOSSIBLE";
		int diag = k / n;
		StringBuilder ans = new StringBuilder();
		ans.append("POSSIBLE\n");
		for (int row = 0; row < n; row++) {
			int val = diag - row;
			if (val <= 0) val += n;
			for (int col = 0; col < n; col++) {
				ans.append(val).append(col == n - 1 ? "" : " ");
				val++;
				if (val > n) val = 1;
			}
			if (row != n - 1) ans.append("\n");
		}
		return ans.toString();
	}

}
