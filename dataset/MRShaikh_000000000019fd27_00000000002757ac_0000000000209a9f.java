import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
//		Scanner infile = new Scanner(new File("inputNesting"));
		 Scanner infile = new Scanner(System.in);
		int T = infile.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String inputStr = infile.next();
			System.out.println("Case #" + (tc + 1) + ": " + calculateMatch(inputStr));
		}
	}

	private static String calculateMatch(String inputStr) {
		int depth = 0;
		StringBuilder output = new StringBuilder();
		for (char charDigit : inputStr.toCharArray()) {
			int digit = Character.getNumericValue(charDigit);
			while ((digit - depth) > 0) {
				output.append("(");
				depth++;
			}
			while (digit < depth) {
				output.append(")");
				depth--;

			}
			output.append(charDigit);
		}
		while (depth > 0) {
			output.append(")");
			depth--;
		}
		return output.toString();
	}
}
