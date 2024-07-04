import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= nTestCases; ++i) {
			String input = in.next();
			int maxDigit = 0;
			String result = input;
			for (int j = 0; j < input.length(); j++) {
				maxDigit = Math.max(input.charAt(j) - '0', maxDigit);
			}

			for (int run = 1; run <= maxDigit ; run++) {
				StringBuilder builder = new StringBuilder();
				boolean open = false;
				for (int j = 0; j < result.length(); j++) {
					char c = result.charAt(j);
					if (c == ')') {
						if (open) {
							open = false;
							builder.append(')');
						}
					} else if (c == '(') {
					} else {
						int value = c - '0';
						if (value >= run) {
							if (!open) {
								open = true;
								builder.append('(');
							}
						} else {
							if (open) {
								open = false;
								builder.append(')');
							}
						}
					}
					builder.append(c);
				}
				if (open) {
					builder.append(')');
				}
				result = builder.toString();
			}

			System.out.printf("Case #%d: %s%n", i, result);
		}
	}
}
