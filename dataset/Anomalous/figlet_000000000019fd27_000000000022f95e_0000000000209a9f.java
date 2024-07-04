import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	private static int charToInt(char ch) {
		return ch - '0';
	}

	private static String stackToString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		for (Character ch : stack) {
			sb.append(ch);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());

			for (int i = 1; i <= t; i++) {
				Stack<Character> exp = new Stack<>();
				String digitsStr = br.readLine();
				int len = digitsStr.length();
				int currentVal = charToInt(digitsStr.charAt(0));

				// Push initial opening parentheses
				for (int k = 0; k < currentVal; k++) {
					exp.push('(');
				}
				exp.push(digitsStr.charAt(0));

				int openParenthesesCount = currentVal;

				for (int j = 1; j < len; j++) {
					int nextVal = charToInt(digitsStr.charAt(j));

					if (openParenthesesCount < nextVal) {
						// Add opening parentheses
						for (int k = 0; k < nextVal - openParenthesesCount; k++) {
							exp.push('(');
						}
						openParenthesesCount = nextVal;
					} else if (openParenthesesCount > nextVal) {
						// Add closing parentheses
						for (int k = 0; k < openParenthesesCount - nextVal; k++) {
							exp.push(')');
						}
						openParenthesesCount = nextVal;
					}
					exp.push(digitsStr.charAt(j));
				}

				// Close any remaining open parentheses
				for (int k = 0; k < openParenthesesCount; k++) {
					exp.push(')');
				}

				System.out.println("Case #" + i + ": " + stackToString(exp));
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}