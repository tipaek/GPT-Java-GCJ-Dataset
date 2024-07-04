import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
	private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter writer = new PrintWriter(System.out);
	private static final StringBuilder resultStringBuilder = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int testCases = scanner.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			String inputString = scanner.next();

			resultStringBuilder.append("Case #").append(testCase).append(": ")
				.append(solve(inputString))
				.append(NEW_LINE);
		}
		writer.print(resultStringBuilder.toString());
		writer.close();
	}

	private static String solve(String inputString) {
		char[] digits = inputString.toCharArray();
		int[] digitArray = new int[digits.length];
		for (int i = 0; i < digits.length; i++) {
			digitArray[i] = digits[i] - '0';
		}

		int[] left = new int[digitArray.length];
		int[] right = new int[digitArray.length];
		int maxLeft = 0;
		int maxRight = 0;
		for (int i = 0; i < digitArray.length; i++) {
			left[i] = maxLeft;
			maxLeft = digitArray[i] == 0 ? 0 : Math.max(digitArray[i], maxLeft);

			right[digitArray.length - i - 1] = maxRight;
			maxRight = digitArray[digitArray.length - i - 1] == 0 ? 0 : Math.max(digitArray[digitArray.length - i - 1], maxRight);
		}

		StringBuilder resultBuilder = new StringBuilder();
		for (int i = 0; i < digitArray.length; i++) {
			int leftParentheses = digitArray[i] - left[i];
			int rightParentheses = digitArray[i] - right[i];

			for (int j = 0; j < leftParentheses; j++) {
				resultBuilder.append("(");
			}
			resultBuilder.append(digitArray[i]);
			for (int j = 0; j < rightParentheses; j++) {
				resultBuilder.append(")");
			}
		}

		return resultBuilder.toString();
	}
}