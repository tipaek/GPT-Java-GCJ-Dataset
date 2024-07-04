import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	private static final String LEFT_PARENTHESIS = "(";
	private static final String RIGHT_PARENTHESIS = ")";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String line = in.nextLine();
			StringBuffer output = new StringBuffer();
			int lastNum = -1;
			for (char c : line.toCharArray()) {
				int num = Character.getNumericValue(c);
				if (lastNum < 0) {
					appendLeftParenthesis(output, num);
				}
				else {
					if (lastNum == num) {
					}
					else if (num < lastNum) {
						appendRightParenthesis(output, lastNum - num);
					}
					else {
						appendLeftParenthesis(output, num - lastNum);
					}
				}
				output.append(num);
				lastNum = num;
			}
			
			appendRightParenthesis(output, lastNum);
			System.out.println("Case #" + i + ": " + output.toString());
		}
		in.close();
	}
	
	private static void appendLeftParenthesis(StringBuffer sb, int count) {
		append(sb, LEFT_PARENTHESIS, count);
	}

	private static void appendRightParenthesis(StringBuffer sb, int count) {
		append(sb, RIGHT_PARENTHESIS, count);
	}

	private static void append(StringBuffer sb, String parenthesis, int count) {
		for (int i = 0; i < count; i++) {
			sb.append(parenthesis);
		}
	}

}