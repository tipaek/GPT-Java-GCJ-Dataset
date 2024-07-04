import java.util.*;

public class Solution {

	public static void main(String[] args) {

		ArrayList<String> toPrint = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for(int i=0; i<testCases; i++) {

			String s = scanner.next();

			toPrint.add(solve(s));
		}

		scanner.close();

		for(int i=0; i<toPrint.size(); i++) {
			System.out.println("Case #"+(i+1)+": "+toPrint.get(i));
		}
	}

	public static String solve(String s) {

		char[] chars = s.toCharArray();

		String solution = "";

		//handle the first digit case
		solution = modifySolution(true, Character.getNumericValue(chars[0]), chars[0], solution);

		int currentDigit;
		int prevDigit;
		int openParenthesisCount = Character.getNumericValue(chars[0]);

		for(int i=1; i<chars.length; i++) {

			currentDigit = Character.getNumericValue(chars[i]);
			prevDigit = Character.getNumericValue(chars[i-1]);

			int diff = Math.abs(currentDigit - prevDigit);

			if(currentDigit>prevDigit) {
				openParenthesisCount += diff;
			}else if(currentDigit < prevDigit) {
				openParenthesisCount -= diff;
			}

			solution = modifySolution(currentDigit >= prevDigit, diff, chars[i], solution);
		}

		//handle the last digit case
		for(int i=0; i< openParenthesisCount; i++) {
			solution += ')';
		}

		return solution;
	}

	/**
	 * True if parenthesis need to be opened, false otherwise
	 * @param p: the number of parenthesis to open or close
	 */
	public static String modifySolution(boolean b, int p, char num, String solution) {

		if(b) {

			for(int i=0; i<p; i++) {
				solution += '(';
			}

			solution += num;

		}else {

			for(int i=0; i<p; i++) {
				solution += ')';
			}

			solution += num;
		}

		return solution;
	}
}
