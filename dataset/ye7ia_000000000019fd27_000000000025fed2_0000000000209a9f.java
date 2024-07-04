import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] str = in.next().toCharArray();
			StringBuilder result = new StringBuilder("");
			int windowStart = 0;
			for (int windowEnd = 0; windowEnd < str.length; windowEnd++) {
				if (str[windowEnd] == '0') {
					if (windowEnd > windowStart) {
						result.append("(");
						for (int i = windowStart; i < windowEnd; i++) {
							result.append("1");
						}
						result.append(")");
					}
					result.append("0");
					windowStart = windowEnd + 1;
				}
			}
			if (windowStart < str.length) {
				result.append("(");
				for (int i = windowStart; i < str.length; i++) {
					result.append("1");
				}
				result.append(")");
			}
			System.out.printf("Case #%d: %s\n", tc, result.toString());
		}
		in.close();
	}
}
