
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			solve(i, n, in);
		}

		in.close();
		return;
	}

	private static void solve(int testCase, int n, Scanner in) {

		StringBuilder nameResult = new StringBuilder(10 ^ 4);
		String firstPart = null, middlePart, lastPart = null;

		for (int i = 0; i < n; i++) {
			String pattern = in.next();
			String _firstPart = null, _middlePart, _lastPart = null;
			int first = 0, last = pattern.length();

			for (int j = 0; j < pattern.length(); j++) {
				if (pattern.charAt(j) == '*') {
					_firstPart = pattern.substring(0, j);
					first = j;
					break;
				}
			}

			for (int j = pattern.length() - 1; j >= 0; j--) {
				if (pattern.charAt(j) == '*') {
					_lastPart = pattern.substring(j + 1);
					last = j;
					break;
				}
			}


			if (firstPart == null)
				firstPart = _firstPart;

			if (_firstPart.length() > firstPart.length()) {
				if (!_firstPart.contains(firstPart)) {
					System.out.println("Case #" + testCase + ": *");
					return;
				} else {
					firstPart = _firstPart;
				}

			}

			if (lastPart == null)
				lastPart = _lastPart;

			if (_lastPart.length() > lastPart.length()) {
				if (!_lastPart.contains(lastPart)) {
					System.out.println("Case #" + testCase + ": *");
					return;
				} else {
					lastPart = _lastPart;
				}
			}
		}

		System.out.println("Case #" + testCase + ": " + lastPart);

	}

}