import java.util.Scanner;

public class Solution {

	int t;
	Scanner s;
	int digits[];

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		String digitsString = s.next();
		int count = 0;
		digits = new int[digitsString.length()];
		for (char c : digitsString.toCharArray()) {
			digits[count++] = c - '0';
		}
		StringBuilder res = new StringBuilder();
		int previousValue = 0;
		for (int i = 0; i < digits.length; i++) {
			int current = digits[i];
			if (current > previousValue) {
				for (int j = 0; j < current - previousValue; j++) {
					res.append("(");
				}

			} else if (current < previousValue) {
				for (int j = 0; j < previousValue - current; j++) {
					res.append(")");
				}
			}
			res.append(digits[i]);
			previousValue = digits[i];
		}
		for (int i = 0; i < digits[digits.length - 1]; i++) {
			res.append(")");
		}

		System.out.println("Case #" + t + ": " + res);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}

		s.close();
	}

}
