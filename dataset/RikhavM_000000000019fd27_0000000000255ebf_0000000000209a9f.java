import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= testCases; ++i) {
				String s = in.next();
				List<Integer> intList = stringToIntegerList(s);

				StringBuffer sDash = new StringBuffer();
				addChar(sDash, '(', intList.get(0));

				sDash.append(intList.get(0));
				for (int num = 1; num < intList.size(); num++) {
					int temp = intList.get(num) - intList.get(num - 1);
					if (temp == 0) {
					} else if (temp > 0) {
						addChar(sDash, '(', Math.abs(temp));

					} else {
						addChar(sDash, ')', Math.abs(temp));
					}
					sDash.append(intList.get(num));
				}
				addChar(sDash, ')', intList.get(intList.size() - 1));
				output(i, sDash.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private static void addChar(StringBuffer s, char c, int n) {
		for (int i = 0; i < n; i++) {
			s.append(c);
		}
	}

	private static void output(int caseNumber, String s) {
		System.out.println("Case #" + caseNumber + ": " + s);
	}

	private static List<Integer> stringToIntegerList(String input) {
		char[] split = input.toCharArray();
		List<Integer> out = new ArrayList<Integer>();
		for (char c : split) {
			out.add(Integer.parseInt(Character.toString(c)));
		}
		return out;
	}
}
