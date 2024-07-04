import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = sc.next();

			rs.append(String.format("Case #%d: ", t))
				.append(solve(s))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(String s) {
		char[] digits = s.toCharArray();
		int[] d = new int[digits.length];
		for (int i = 0; i < digits.length; i++) {
			d[i] = digits[i] - '0';
		}

		int[] l = new int[d.length];
		int[] r = new int[d.length];
		int maxL = 0;
		int maxR = 0;
		for (int i = 0; i < d.length; i++) {
			l[i] = maxL;
			maxL = d[i] == 0 ? 0 : Math.max(d[i], maxL);

			r[d.length - i - 1] = maxR;
			maxR = d[d.length - i - 1] == 0 ? 0 : Math.max(d[d.length - i - 1], maxR);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int lp = d[i] - l[i];
			int rp = d[i] - r[i];

			if (lp > 0) {
				for (int j = 0; j < lp; j++) {
					sb.append("(");
				}
			}
			sb.append(d[i]);
			if (rp > 0) {
				for (int j = 0; j < rp; j++) {
					sb.append(")");
				}
			}
		}

		return sb.toString();
	}
}