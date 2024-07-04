
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			solve(i, s);
		}

		in.close();
		return;
	}

	/**
	 * test cases: 0123 3210 1111 12321 32123
	 */
	private static void solve(int _testCase, String s) {
		StringBuilder _s = new StringBuilder();

		int currentOpenParenthesises = 0;

		for (int i = 0; i < s.length(); i++) {
			int currentValue = Integer.valueOf(s.substring(i, i + 1));

			if (currentValue == currentOpenParenthesises) {
				_s.append(currentValue);
				continue;
			}

			if (currentValue < currentOpenParenthesises) {
				int close = currentOpenParenthesises - currentValue;
				for (int j = 0; j < close; j++) {
					_s.append(")");
				}
			} else {
				int open = currentValue - currentOpenParenthesises;
				for (int j = 0; j < open; j++) {
					_s.append("(");
				}

			}
			_s.append(currentValue);
			currentOpenParenthesises = currentValue;
		}

		for (int j = 0; j < currentOpenParenthesises; j++) {
			_s.append(")");
		}

		System.out.println("Case #" + _testCase + ": " + _s.toString());
	}

}