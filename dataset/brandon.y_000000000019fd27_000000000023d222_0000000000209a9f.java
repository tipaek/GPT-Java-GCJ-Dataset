import java.util.*;
import java.io.*;
import java.lang.Math;

// java Solution < input.txt > output.txt
// java Solution < input.txt > output.txt; cat output.txt
// https://code.google.com/codejam/resources/quickstart-guide
// https://code.google.com/codejam/resources/faq
// https://github.com/ellengz/CodeJam/tree/master/src/y2018/qualification/A

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String tString = in.nextLine();	// Scanner has functions to read ints, longs, strings, chars, etc.
		int t = Integer.parseInt(tString);
		for (int i = 1; i <= t; ++i) {
			String string = in.nextLine();
			char[] cArr = string.toCharArray();
			int currentStack = 0;
			String answer = "";

			// Iterate through each integer in "111000"
			for (char currentChar: cArr) {
				int currentInt = Character.getNumericValue(currentChar);
				// System.out.println(Integer.toString(currentInt));
				if (currentInt > currentStack) {
					answer += "(";
					answer += Integer.toString(currentInt);
					currentStack++;
				} else if (currentInt == currentStack) {
					answer += currentInt;
				} else if (currentInt < currentStack) {
					answer += ")";
					answer += Integer.toString(currentInt);
					currentStack--;
				}
			}
			if (currentStack > 0) {
				answer += ")";
				currentStack--;
			}
			if (debug) {
				System.out.println("Case #" + i + ": " + Arrays.toString(cArr));
				System.out.println(answer);
			}
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
