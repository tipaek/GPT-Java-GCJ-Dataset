import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String input = in.next();
			char[] inpChars = input.toCharArray();
			int noOfIn = input.length();
			String encapsulated = new String();
			for (int j = 0; j < noOfIn; j++) {
				encapsulated += (encapsulate(inpChars[j]));
			}
			while (encapsulated.indexOf(")(") != -1) {
				encapsulated = encapsulated.replaceAll("\\)\\(", "");
			}
			System.out.println("Case #" + i + ": " + encapsulated);
		}
	}

	private static String encapsulate(char sample) {
		int number = Character.getNumericValue(sample);
		String answer = "";
		if (number != 0) {
			answer = String.format("%0" + number + "d", 0).replace("0", "(");
			answer += sample;
			answer += String.format("%0" + number + "d", 0).replace("0", ")");
		} else {
			answer += sample;
		}
		return answer;
	}

}
