import java.util.Scanner;

public class Solution {

	private static String processToughSet(String s) {
		int len = s.length() - 1;
		String r = "";
		int prev = -1;
		char[] g = s.toCharArray();
		for (int i = 0; i < g.length; i++) {
			// num
			int f = Integer.parseInt(String.valueOf(g[i]));

			// open bracket
			if (i == 0 || (i - 1 >= 0 && prev < f)) {
				int limit = prev == -1 ? f : Math.abs(f - prev);
				for (int j = 0; j < limit; j++) {
					r += "(";
				}
			}
			r += g[i];
			// closed brackets
			if (i == len) {
				for (int j = 0; j < f; j++) {
					r += ")";
				}
			} else if ((i + 1) <= len) {
				int fn = Integer.parseInt(String.valueOf(g[i + 1]));
				if (f > fn) {
					for (int j = 0; j < Math.abs(f - fn); j++) {
						r += ")";
					}
				}
			}
			prev = f;
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String y = in.nextLine();
		int T = Integer.parseInt(y);
		for (int t = 0; t < T; t++) {
			String s = in.nextLine();
			System.out.println("Case #" + (t + 1) + ": " + processToughSet(s));
		}
		in.close();
	}
}
