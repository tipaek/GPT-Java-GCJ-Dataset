
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner infile = new Scanner(System.in);
		int T = infile.nextInt();
		int B = infile.nextInt();

		for (int i = 0; i < T; i++) {
			char guessedArry[] = new char[B];
			for (int j = 1; j <= 10; j++) {
				System.out.print(j);
				System.out.flush();
				String nextChar = infile.next();
				guessedArry[j - 1] = nextChar.charAt(0);
			}
			String reversed = reverseMe(guessedArry);
			String compliment = complementMe(guessedArry);
			String revComplimnentStr = revCompliment(guessedArry);
			String doNothinStr = doNothin(guessedArry);
			for (int j = 1; j <= 10; j++) {
				System.out.print(j);
				System.out.flush();
				String nextChar = infile.next();
				guessedArry[j - 1] = nextChar.charAt(0);
			}
			String output = null;
			String guessedStr = new String(guessedArry);
			if (guessedStr.equals(reversed)) {
				output = reversed;
			}

			if (guessedStr.equals(compliment)) {
				output = compliment;
			}

			if (guessedStr.equals(revComplimnentStr)) {
				output = revComplimnentStr;
			}
			if (guessedStr.equals(doNothinStr)) {
				output = doNothinStr;
			}
			System.out.print(output);
			System.out.flush();
			String nextChar = infile.next();
			if (nextChar.charAt(0) == 'Y')
				continue;
			else
				System.exit(1);

		}

	}

	private static String doNothin(char[] guessedArry) {
		return guessedArry.toString();
	}

	private static String revCompliment(char[] guessedArry) {

		for (int i = 0; i < guessedArry.length; i++) {
			if (guessedArry[i] == '1')
				guessedArry[i] = '0';
			else
				guessedArry[i] = '1';
		}
		String string = new String(guessedArry);
		StringBuilder sb = new StringBuilder(string);
		return sb.reverse()
		         .toString();

	}

	private static String complementMe(char[] guessedArry) {
		for (int i = 0; i < guessedArry.length; i++) {
			if (guessedArry[i] == '1')
				guessedArry[i] = '0';
			else
				guessedArry[i] = '1';
		}
		String string = new String(guessedArry);
		return string;
	}

	private static String reverseMe(char[] guessedArry) {
		String string = new String(guessedArry);
		StringBuilder sb = new StringBuilder(string);
		return sb.reverse()
		         .toString();
	}

}
