import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
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
			Activity[] ar = new Activity[n];
			for (int j = 0; j < n; j++) {
				ar[j] = new Activity(j, in.nextInt(), in.nextInt());
			}
			String ret = solveLine(n, ar);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", i, ret);
		}
	}

	private static String solveLine(int n, Activity[] ar) {
		char[] sch = new char[n];
		// Arrays.sort(ar, (a, b) -> a.init == b.init ? a.end - b.end : a.init - b.init);
		Arrays.sort(ar, (a, b) -> a.init - b.init);
		Activity curC = new Activity(-1, 0, 0);
		Activity curJ = new Activity(-1, 0, 0);
		for (Activity next : ar) {
			if (curC.end > next.init && curJ.end > next.init) return "IMPOSSIBLE";
			if (curC.end <= curJ.end) {
				curC = next;
				sch[next.number] = 'C';
			} else {
				curJ = next;
				sch[next.number] = 'J';
			}
		}
		StringBuilder ans = new StringBuilder();
		for (char c : sch)	ans.append(c);
		return ans.toString();
	}

	protected static class Activity {
		int init;
		int end;
		int number;

		public Activity(int number, int init, int end) {
			this.number = number;
			this.init = init;
			this.end = end;
		}
	}
}
