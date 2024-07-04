import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			for (int t = 1; t <= T; ++t) {
				String str = in.next();
				int L = str.length();

				StringBuilder sb = new StringBuilder();
				int depth = 0;
				for (int i = 0; i < L; ++i) {
					int digit = str.charAt(i) - '0';
					while (depth < digit) {
						sb.append('(');
						++depth;
					}
					while (depth > digit) {
						sb.append(')');
						--depth;
					}
					sb.append(digit);
				}
				while (depth > 0) {
					sb.append(')');
					--depth;
				}

				System.out.println("Case #" + t + ": " + sb.toString());
			}
		}
	}
}