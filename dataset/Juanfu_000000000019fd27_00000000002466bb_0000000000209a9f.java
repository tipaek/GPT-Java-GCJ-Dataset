import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static final String OPEN = "(";
	private static final String CLOSE = ")";

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// one line with a number of test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		// boucle for testCases #x = i
		for (int i = 1; i <= t; ++i) {
			String stBase = in.next();

			String stOutput = new String();

			char[] arr = stBase.toCharArray();

			int oldvalue = 0;
			for (char c : arr) {
				// CAST to int
				int value = Character.getNumericValue(c);

				String close = repeat(CLOSE, oldvalue - value);
				String open = repeat(OPEN, value - oldvalue);

				stOutput = concatenate(stOutput, close, open, Character.toString(c));
				oldvalue = value;
			}
			stOutput = concatenate(stOutput, repeat(CLOSE, oldvalue));

			System.out.println("Case #" + i + ": " + stOutput);

		}
	}

	private static String repeat(String string, int times) {
		String result = "";
		if (times > 0) {
			result = new String(new char[times]).replace("\0", string);
		}
		return result;
	}

	public static String concatenate(String... s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++)
			sb = sb.append(s[i]);

		return sb.toString();
	}

}
