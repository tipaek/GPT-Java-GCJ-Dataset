import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static StringBuilder builder;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int testCases = scanner.nextInt();
			for (int t = 1; t <= testCases; t++) {
				String input = scanner.next();
				builder = new StringBuilder();
				int count = 0;
				int prevDigit = -1;
				for (int i = 0; i < input.length(); i++) {
					int currentDigit = Character.getNumericValue(input.charAt(i));
					if (currentDigit > prevDigit) {
						if (prevDigit != -1) {
							appendRepeated(prevDigit, count);
							count = 1;
							appendOpenBrackets(currentDigit - prevDigit);
						} else {
							appendOpenBrackets(currentDigit);
						}
					} else if (currentDigit == prevDigit) {
						count++;
					} else {
						appendRepeated(prevDigit, count);
						appendCloseBrackets(prevDigit - currentDigit);
						count = 1;
					}

					if (prevDigit == -1) {
						count++;
					}
					prevDigit = currentDigit;
				}
				appendRepeated(prevDigit, count);
				appendCloseBrackets(prevDigit);

				System.out.println("Case #" + t + ": " + builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void appendRepeated(int digit, int times) {
		for (int i = 0; i < times; i++) {
			builder.append(digit);
		}
	}

	private static void appendCloseBrackets(int times) {
		for (int i = 0; i < times; i++) {
			builder.append(")");
		}
	}

	private static void appendOpenBrackets(int times) {
		for (int i = 0; i < times; i++) {
			builder.append("(");
		}
	}
}