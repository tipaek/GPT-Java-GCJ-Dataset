import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			String input = sc.next();
			String output = "";
			for (int i = 0; i < input.length(); i++) {
				int n = Solution.getInt(input.charAt(i));
				if (input.length() == 1) {
					output += Solution.getBracesString(n, n, n);
					break;
				}
				int l = 0, r = 0;
				if (i == 0) {
					int next = Solution.getInt(input.charAt(i + 1));
					l = n;
					r = (n > next) ? n - next : 0;
				} else if (i == input.length() - 1) {
					int prev = Solution.getInt(input.charAt(i - 1));
					r = n;
					l = (n > prev) ? n - prev : 0;
				} else {
					int prev = Solution.getInt(input.charAt(i - 1));
					int next = Solution.getInt(input.charAt(i + 1));
					l = (n > prev) ? n - prev : 0;
					r = (n > next) ? n - next : 0;
				}
				output += Solution.getBracesString(n, l, r);
			}
			System.out.println("Case #" + cases + ": " + output);
		}
		sc.close();
	}

	private static String getBracesString(int n, int l, int r) {
		String left = "";
		String right = "";
		while (l-- > 0) {
			left += "(";
		}
		while (r-- > 0) {
			right += ")";
		}
		return left + n + right;
	}

	private static int getInt(char charAt) {
		switch (charAt) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		}
		return 0;
	}

}