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
			String s = in.next();
			String ret = solveLine(s);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", i, ret);
		}
	}

	private static String solveLine(String s) {
		StringBuilder ans = new StringBuilder();
		int open = 0;
		for (char c : s.toCharArray()) {
			int num = c - '0';
			while (num != open) {
				if (num > open) {
					ans.append("(");
					open++;
				} else {
					ans.append(")");
					open--;
				}
			}
			ans.append(c);
		}
		while (open > 0) {
			ans.append(")");
			open--;
		}
		return ans.toString();
	}

}
