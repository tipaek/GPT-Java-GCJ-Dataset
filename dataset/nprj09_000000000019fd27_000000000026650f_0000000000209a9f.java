import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int count = 1; count <= T; count++) {
			String currentString = sc.next();
			StringBuilder currentStringSB = new StringBuilder(currentString);
			currentString = nestedDepthSolve(currentStringSB);
			System.out.println("Case #" + count + ": " + currentString);
		}
	}

	private static String nestedDepthSolve(StringBuilder currentStringSB) {
		StringBuilder result = new StringBuilder(currentStringSB);
		int charsAdded = 0;
		for (int index = 0; index < currentStringSB.length(); index++) {
			int currNum = Integer.parseInt(String.valueOf(currentStringSB.charAt(index)));
			if (currNum != 0) {
				String leftBracket = "", rightBracket = "";
				while (currNum-- > 0) {
					leftBracket += '(';
					rightBracket += ')';
				}
				result.insert(index + charsAdded, leftBracket);
				result.insert(index + leftBracket.length()+1 + charsAdded, rightBracket);
				charsAdded += leftBracket.length() * 2;
			}
		}
		currentStringSB = new StringBuilder(result);
		int charsDeleted = 0;
		for (int index = 0; index < result.length()-1; index++) {
			//String ch1 = String.valueOf(result.charAt(index));
			//String ch2 = String.valueOf(result.charAt(index + 1));
			int ch1 = result.charAt(index);
			int ch2 = result.charAt(index + 1);
			if (ch1 == 41 && ch2 == 40) {
				currentStringSB.delete(index - charsDeleted, index + 2 - charsDeleted);
				charsDeleted += 2;
			}
		}
		return currentStringSB.toString();
	}
}