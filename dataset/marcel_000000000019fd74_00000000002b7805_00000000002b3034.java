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
			String[] ar = new String[n];
			for (int j = 0; j < n; j++) {
				ar[j] = in.next();
			}
			String ret = solveLine(n, ar);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", i, ret);
		}
	}

	private static String solveLine(int n, String[] ar) {
		String pref = "";
		String suff = "";
		for (String str : ar) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '*') {
					if (i > pref.length()) pref = str.substring(0, i);
					if (str.length() - i > suff.length()) suff = str.substring(i + 1);
					break;
				}
			}
		}
		for (String str : ar) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '*') break;
				if (str.charAt(i) != pref.charAt(i)) return "*";
			}
			for (int i = str.length() - 1, isuf = suff.length() - 1; i >= 0; i--, isuf--) {
				if (str.charAt(i) == '*') break;
				if (str.charAt(i) != suff.charAt(isuf)) return "*";
			}
		}
		return pref + suff;
	}

	
}
