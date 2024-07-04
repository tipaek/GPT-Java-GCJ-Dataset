import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			List<String> patterns = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				patterns.add(in.next());
			}
			String res = process(patterns);
			System.out.println("Case #" + i + ": " + res);
		}
	}

	private static String process(List<String> patterns) {
		String suf = getSuf(patterns);
		if (suf.equals("*")) {
			return "*";
		}
		String pref = getPref(patterns);
		if (pref.equals("*")) {
			return "*";
		}
		String middle = getMiddle(patterns);
		return pref + middle + suf;
	}

	private static String getMiddle(List<String> patterns) {
		StringBuilder sb = new StringBuilder();
		for (String s : patterns) {
			int from = s.indexOf("*");
			int to = s.lastIndexOf("*");
			if (from != to) {
				String mid = s.substring( from + 1, to);
				mid = mid.replace("*", "");
				sb.append(mid);
			}
		}
		return sb.toString();
	}

	private static String getPref(List<String> patterns) {
		List<String> inv = new ArrayList<>();
		for (String s : patterns) {
			inv.add(new StringBuilder(s).reverse().toString());
		}
		String invPref = getSuf(inv);
		return new StringBuilder(invPref).reverse().toString();
	}


	private static String getSuf(List<String> patterns) {
		List<String> suffixes = new ArrayList<>();
		String longestSuf = "";
		for (String s : patterns) {
			String suf = s.substring(s.lastIndexOf("*") + 1);
			suffixes.add(suf);
			if (suf.length() > longestSuf.length()) {
				longestSuf = suf;
			}
		}
		for (String s : suffixes) {
			if (!longestSuf.endsWith(s)) {
				return "*";
			}
		}
		return longestSuf;
	}
}
