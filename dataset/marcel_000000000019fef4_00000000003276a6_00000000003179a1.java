import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
//		Arrays.sort(ar, (a,b) -> a[0].compareTo(b[0]));
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
		List<String[]> ar2 = new ArrayList<>();
		for (String[] val : ar) {
			if (val[0].length() != u) {
				ar2.add(val);
			}
		}		
		Collections.sort(ar2, (a,b) -> a[0].compareTo(b[0]));
		l0: for (int num = 1; num <= 9; num++) {
			for (String[] val : ar2) {
					char ch = val[1].charAt(0);
					if (!found.contains(ch)) {
						ans[num] = ch;
						found.add(ch);
						continue l0;
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

}
