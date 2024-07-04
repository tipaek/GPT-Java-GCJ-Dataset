import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] argv) {
		Scanner in = new Scanner(System.in);
		String numCasesStr = in.nextLine();
		int numCases = Integer.parseInt(numCasesStr);
		for (int i = 0; i < numCases; i++) {
			String input = in.nextLine();
			String nestingDepthString = computeNestingDepthString(input);
			System.out.println(String.format("Case #%d: %s", i + 1, nestingDepthString));
		}
	}

	private static String computeNestingDepthString(String input) {
		StringBuffer result = new StringBuffer();
		List<Integer> ints = input.chars().map(i -> Character.getNumericValue(i)).boxed().collect(Collectors.toList());
		result.append(repeatString("(", ints.get(0)));
		result.append(ints.get(0));
		for (int i = 1; i < input.length(); i++) {
			if (ints.get(i) == ints.get(i - 1)) {
				result.append(ints.get(i));
			} else if (ints.get(i) > ints.get(i - 1)) {
				closeParentheses(result);
				result.append(repeatString("(", ints.get(i)));
				result.append(ints.get(i));
			} else if (ints.get(i) < ints.get(i - 1)) {
				if (result.charAt(result.length() - 1) == ')') {
					result.insert(result.length() - ints.get(i), ints.get(i));
				} else {
					result.append(repeatString(")", ints.get(i - 1) - ints.get(i)));
					result.append(ints.get(i));
				}
			}
		}
		closeParentheses(result);
		return result.toString();
	}

	private static String repeatString(String toRepeat, int timesToRepeat) {
		return String.join("", Collections.nCopies(timesToRepeat, toRepeat));
	}

	private static void closeParentheses(StringBuffer stringBuffer) {
		int openParentheses = (int) stringBuffer.chars().filter(ch -> ch == '(').count();
		int closedParentheses = (int) stringBuffer.chars().filter(ch -> ch == ')').count();
		stringBuffer.append(repeatString(")", openParentheses - closedParentheses));
	}
}