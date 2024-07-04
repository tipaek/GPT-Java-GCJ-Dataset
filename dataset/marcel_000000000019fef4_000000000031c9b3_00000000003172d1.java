import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static final int MAX = (int) 1e9;

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int numtests = in.nextInt();
		for (int t = 1; t <= numtests; ++t) {
			int n = in.nextInt();
			int d = in.nextInt();
			long[] ar = new long[n];
			Set<Long> values = new HashSet<>();
			for (int i = 0; i < n; i++) {
				ar[i] = in.nextLong();
				values.add(ar[i]);
			}
			int ret = solveLine(n, d, ar, values);
			out.printf(Locale.ENGLISH, "Case #%d: %d%n", t, ret);
		}
	}

	private static int solveLine(int n, int d, long[] ar, Set<Long> values) {
		int len = ar.length;
		Arrays.sort(ar);
		if (d == 2) {
			for (int i = 0; i < len - 1; i++)
				if (ar[i] == ar[i + 1]) return 0;
			return 1;
		} else if (d == 3) {
			int cnt = 1, ans = 2;
			for (int i = 0; i < len - 1; i++) {
				if (ar[i] == ar[i + 1]) {
					cnt++;
					if (cnt == 3) return 0;
					if (cnt == 2 && i != len - 2) ans = 1;
				} else {
					cnt = 1;
					if ((ar[i] & 1) == 0 && values.contains(ar[i] / 2)) ans = 1;
				}
				if ((ar[len - 1] & 1) == 0 && values.contains(ar[len - 1] / 2)) ans = 1;
			}
			return ans;
		} else {
			return 0;
		}
	}

}
