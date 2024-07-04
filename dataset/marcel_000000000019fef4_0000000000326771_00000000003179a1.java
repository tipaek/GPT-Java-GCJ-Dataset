import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static final int MAX = (int) 1e4;

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int numtests = in.nextInt();
		for (int t = 1; t <= numtests; ++t) {
			int u = in.nextInt();
			String[][] ar = new String[MAX][2];
			for (int i = 0; i < MAX; i++) {
				ar[i][0] = in.next();
				ar[i][1] = in.next();
			}
			String ret = solveLine(u, ar);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", t, ret);
		}
	}

	private static String solveLine(int u, String[][] ar) {
//		String ans = "";
		Arrays.sort(ar, (a,b) -> a[0].compareTo(b[0]));
		char[] ans = new char[10];
		Arrays.fill(ans, ' ');
		Set<Character> nonzero = new HashSet<>();
		Set<Character> found = new HashSet<>();
		for (String[] val : ar) {
			nonzero.add(val[1].charAt(0));
			if (nonzero.size() == 9) break;
		}
		for (String[] val : ar) for (char ch : val[1].toCharArray()) {
			if (!nonzero.contains(ch)) {
				ans[0] = ch;
				found.add(ch);
				break;
			}
		}
		l0: for (int num = 1; num <= 9; num++) {
			for (String[] val : ar) {
				if (val[0].length() == val[1].length()) {
					char ch = val[1].charAt(0);
					if (!found.contains(ch)) {
						ans[num] = ch;
						found.add(ch);
						continue l0;
					}
				}
			}
		}
		if (ans[9] == ' ') {
			for (char ch : nonzero) if (!found.contains(ch)) ans[9] = ch;
		}
		String ret = "";
		for (char ch : ans) ret += ch;
		return ret;
	}

	private static int dist(Pair pair) {
		return abs(pair.x) + abs(pair.y);
	}

	private static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
}
