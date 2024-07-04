import java.util.Scanner;

public class Solution {

	private static String processToughSet(String s) {
		StringBuilder result = new StringBuilder();
		char[] digits = s.toCharArray();
		int previousDigit = 0;

		for (int i = 0; i < digits.length; i++) {
			int currentDigit = Character.getNumericValue(digits[i]);

			// Add opening brackets if needed
			if (currentDigit > previousDigit) {
				for (int j = 0; j < currentDigit - previousDigit; j++) {
					result.append('(');
				}
			}

			// Add closing brackets if needed
			if (currentDigit < previousDigit) {
				for (int j = 0; j < previousDigit - currentDigit; j++) {
					result.append(')');
				}
			}

			// Add the current digit
			result.append(currentDigit);
			previousDigit = currentDigit;
		}

		// Close any remaining open brackets
		for (int j = 0; j < previousDigit; j++) {
			result.append(')');
		}

		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());

		for (int t = 1; t <= testCases; t++) {
			String input = scanner.nextLine();
			String result = processToughSet(input);
			System.out.println("Case #" + t + ": " + result);
		}

		scanner.close();
	}
}