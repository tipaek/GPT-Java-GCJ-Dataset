import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			HashSet<String> A = new HashSet<>(), B = new HashSet<>(), C = new HashSet<>();
			for (int j = 0; j < N; j++) {
				String P = in.next();
				int a = P.indexOf('*'), b = P.lastIndexOf('*');
				A.add(P.substring(0, a));
				if (b >= a + 1) {
					B.add(P.substring(a + 1, b).replaceAll("[*]", ""));
				}
				C.add(P.substring(b + 1));
			}
			String a = "", c = "";
			for (String s : A) {
				if (s.length() > a.length()) {
					a = s;
				}
			}
			for (String s : C) {
				if (s.length() > c.length()) {
					c = s;
				}
			}
			if (startsWith(a, A) && endsWith(c, C)) {
				StringBuilder b = new StringBuilder();
				for (String s : B) {
					b.append(s);
				}
				System.out.println("Case #" + i + ": " + a + b + c);
			} else {
				System.out.println("Case #" + i + ": *");
			}
		}
	}

	private static boolean startsWith(String prefix, HashSet<String> set) {
		for (String s : set) {
			if (!prefix.startsWith(s)) {
				return false;
			}
		}
		return true;
	}

	private static boolean endsWith(String suffix, HashSet<String> set) {
		for (String s : set) {
			if (!suffix.endsWith(s)) {
				return false;
			}
		}
		return true;
	}
}