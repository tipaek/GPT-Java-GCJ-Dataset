import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int testCasesNumber = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= testCasesNumber; i++) {
			String stringToModify = in.next();

			printModifiedString(stringToModify, i);
		}
	}

	private static void printModifiedString(String stringToModify, int i) {
		String modifiedString = modifyString(stringToModify);
		System.out.println("Case #" + i + ": " + modifiedString);

	}

	private static String modifyString(String stringToModify) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] charArray = stringToModify.toCharArray();

		int currentlyOpened = 0;

		for (int i = 0; i < charArray.length; i++) {
			int currentNumber = Character.getNumericValue(charArray[i]);

			if (currentlyOpened - currentNumber == 0) {
				stringBuilder.append(charArray[i]);
			} else if (currentlyOpened - currentNumber > 0) {
				appendCloseParentheses(Math.abs(currentlyOpened - currentNumber), stringBuilder);
				stringBuilder.append(charArray[i]);
				currentlyOpened = currentlyOpened - Math.abs(currentlyOpened - currentNumber);
			} else {
				appendOpenParentheses(Math.abs(currentlyOpened - currentNumber), stringBuilder);
				stringBuilder.append(charArray[i]);
				currentlyOpened = currentlyOpened + Math.abs(currentlyOpened - currentNumber);
			}
		}
		//close in the end
		appendCloseParentheses(currentlyOpened, stringBuilder);
		return stringBuilder.toString();
	}

	private static void appendOpenParentheses(int number, StringBuilder stringBuilder) {
		for (int i = 1; i <= number; i++) {
			stringBuilder.append('(');
		}
	}

	private static void appendCloseParentheses(int number, StringBuilder stringBuilder) {
		for (int i = 1; i <= number; i++) {
			stringBuilder.append(')');
		}
	}

}
