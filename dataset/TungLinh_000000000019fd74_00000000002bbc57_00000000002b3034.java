
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Many terminals use asterisks (*) to signify "any string", including the empty string. 
For example, when listing files matching BASH*, a terminal may list BASH, BASHER and BASHFUL. 
For *FUL, it may list BEAUTIFUL, AWFUL and BASHFUL. When listing B*L, BASHFUL, BEAUTIFUL and BULL may be listed.

In this problem, formally, a pattern is a string consisting of only uppercase English letters and asterisks (*), 
and a name is a string consisting of only uppercase English letters. 
A pattern p matches a name m if there is a way of replacing every asterisk in p with a (possibly empty) string to obtain m. 
Notice that each asterisk may be replaced by a different string.

Given N patterns, can you find a single name of at most 104 letters that matches all those patterns at once, or report that it cannot be done?

Input
The first line of the input gives the number of test cases, T. T test cases follow. 
Each test case starts with a line with a single integer N: the number of patterns to simultaneously match. 
Then, N lines follow, each one containing a single string Pi representing the i-th pattern.

1 ≤ T ≤ 100.
2 ≤ N ≤ 50.
2 ≤ length of Pi ≤ 100, for all i.

 * */
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
			// _middlePart = pattern.substring(first + 1, last);

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