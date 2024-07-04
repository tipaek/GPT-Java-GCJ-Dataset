import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				String input = scan.next();
				System.out.println("Case #" + i + ": " + solve(input));
			}
		}
	}

	private static String solve(String digits) {
		StringBuilder response = new StringBuilder();
		int prev = -1;
		int numOfOpenParenthesis = 0;
		for (char c : digits.toCharArray()) {
			int num = Character.getNumericValue(c);
			// if this is the first number
			if (prev == -1) {
				appendNTimes(response, '(', num);
				numOfOpenParenthesis += num;
			} else if (num > prev) {
				appendNTimes(response, '(', num - prev);
				numOfOpenParenthesis += (num - prev);
			} else if (num < prev) {
				appendNTimes(response, ')', prev - num);
				numOfOpenParenthesis -= (prev - num);
			}
			response.append(num);
			prev = num;
		}
		appendNTimes(response, ')', numOfOpenParenthesis);
		return response.toString();
	}

	private static void appendNTimes(StringBuilder sb, char c, int times) {
		for (int i = 0; i < times; ++i) {
			sb.append(c);
		}
	}
}