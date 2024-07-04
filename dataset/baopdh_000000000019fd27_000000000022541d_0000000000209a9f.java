import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			String s = scanner.next();
			StringBuilder res = new StringBuilder();

			int numClosing = 0;
			for (char c: s.toCharArray()) {
				int n = c - '0';

				if (n == 0) {
					while (numClosing > 0) {
						res.append(")");
						--numClosing;
					}
				} else if (n < numClosing) {
					while (numClosing > n) {
						res.append(")");
						--numClosing;
					}
				} else if (n > numClosing) {
					while (numClosing < n) {
						res.append("(");
						++numClosing;
					}
				}

				res.append(c);
			}

			while (numClosing-- > 0) {
				res.append(")");
			}

			System.out.printf("Case #%d: %s\n", i, res.toString());
		}
		scanner.close();
	}
}