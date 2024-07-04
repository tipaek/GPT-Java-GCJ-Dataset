import java.util.Scanner;

public class Solution {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tt = 1; tt <= t; tt++) {
			String input = sc.next();
			StringBuilder sb = new StringBuilder();
			helper(input, 0, sb, 0);

			System.out.println("Case #" + tt + ": " + sb.toString());
		}
	}

	static void helper(String s, int index, StringBuilder sb, int unclosed) {
		if (index == s.length()) {
			for (int i = 0; i < unclosed; i++)
				sb.append(")");
			return;
		}

		int n = s.charAt(index) - '0';
		if (unclosed > n) {
			for (int i = 0; i < unclosed - n; i++)
				sb.append(")");
			unclosed -= n;
		}
		for (int i = 0; i < n - unclosed; i++)
			sb.append("(");
		sb.append(n);
		helper(s, index + 1, sb, n);
	}
}