import java.util.Scanner;

public class Solution {

	private static String processToughSet(String s) {
		StringBuilder result = new StringBuilder();
		int prevDigit = -1;
		char[] digits = s.toCharArray();
		
		for (int i = 0; i < digits.length; i++) {
			int currentDigit = Character.getNumericValue(digits[i]);
			
			if (i == 0 || prevDigit < currentDigit) {
				for (int j = 0; j < currentDigit; j++) {
					result.append("(");
				}
			}
			
			result.append(digits[i]);
			
			if (i == digits.length - 1) {
				for (int j = 0; j < currentDigit; j++) {
					result.append(")");
				}
			} else {
				int nextDigit = Character.getNumericValue(digits[i + 1]);
				if (currentDigit > nextDigit) {
					for (int j = 0; j < currentDigit - nextDigit; j++) {
						result.append(")");
					}
				}
			}
			
			prevDigit = currentDigit;
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numTestCases = Integer.parseInt(scanner.nextLine());
		
		for (int t = 0; t < numTestCases; t++) {
			String input = scanner.nextLine();
			System.out.println("Case #" + (t + 1) + ": " + processToughSet(input));
		}
		
		scanner.close();
	}
}