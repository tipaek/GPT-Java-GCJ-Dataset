import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

//		System.out.println("char= " + (int) ('9' - '0'));

		try (Scanner s = new Scanner(System.in)) {

			int T = s.nextInt();
			s.nextLine();
			for (int i = 1; i <= T; i++) {
				String S = s.nextLine();
				String result =  solve(S);
				System.out.println("Case #" + i + ": " + result);
			}
		}
	}

	public static String solve(String S) {
		String result;
		result = "";

		int c = toInt(S.charAt(0));

		int d = c - 0;
		for (int j = 0; j < d; j++) {
			result += '(';
		}

		for (int i = 0; i < S.length() - 1; i++) {
			c = toInt(S.charAt(i));
			d = toInt(S.charAt(i + 1)) - c;

			if (d > 0) {
				result += c;
				for (int j = 0; j < d; j++) {
					result += '(';
				}
			} else if (d < 0) {
				result += c;
				for (int j = 0; j > d; j--) {
					result += ')';
				}

			} else {
				result += c;
			}
		}
		c= toInt(S.charAt(S.length() - 1));
		result +=c;
		d = 0 -c;
		for (int j = 0; j > d; j--) {
			result += ')';
		}

		return result;
	}

	private static int toInt(char c) {
		return (int) (c - '0');
	}
}
