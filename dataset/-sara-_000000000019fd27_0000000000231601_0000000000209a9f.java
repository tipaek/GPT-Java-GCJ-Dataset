import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		in.nextLine(); // advance to the second line to begin reading the input strings
		for (int i = 1; i <= t; ++i) {
			String input = in.nextLine();
			int[] inputNumbers = new int[input.length()];
			String solution = "";
			for (int j = 0; j < input.length(); j++) {
				inputNumbers[j] = Character.getNumericValue(input.charAt(j));
			}
			int nestingDepth = 0;
			for(int j = 0; j < input.length(); j++) {
				if (inputNumbers[j] > nestingDepth) {
					solution = solution + 
							openingParenthesis(inputNumbers[j] - nestingDepth) +
							inputNumbers[j];
				} else if (inputNumbers[j] == nestingDepth) {
					solution = solution + inputNumbers[j];
				} else {
					solution = solution + 
							closingParenthesis(nestingDepth - inputNumbers[j]) +
							inputNumbers[j];
				}
				nestingDepth = inputNumbers[j];
			}
			if (nestingDepth > 0) {
				solution = solution + 
						closingParenthesis(nestingDepth);
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
	
	private static String openingParenthesis(int repetitions) {
		String parentheses = "";
		for (int j = 0; j < repetitions; j++) {
			parentheses = parentheses + "(";
		}
		return parentheses;
	}
	
	private static String closingParenthesis(int repetitions) {
		String parentheses = "";
		for (int j = 0; j < repetitions; j++) {
			parentheses = parentheses + ")";
		}
		return parentheses;
	}
}
