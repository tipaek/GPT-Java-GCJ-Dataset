import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String line = in.next();
			System.out.println("Case #" + i + ": " + buildParentheses(line));
		}
	}

	private static String buildParentheses(String line) {
		int openParentheses = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.length();i++) {
			int current = Integer.parseInt(String.valueOf(line.charAt(i)));
			if (i == 0) {
				sb = addOpenParenthesis(current, sb);
				sb.append(current);
				openParentheses = current;
			} else {
				int tempParentheses = calculateOpenParenthesis(openParentheses, current);
				if (tempParentheses > 0 && openParentheses>0) {
					sb = addOpenParenthesis(tempParentheses, sb);
					sb.append(current);
					openParentheses += tempParentheses;
				} else if (tempParentheses < 0 && openParentheses>0) {
					sb = addClosedParenthesis(tempParentheses*(-1), sb);
					sb.append(current);
					openParentheses += tempParentheses;
				} else if (tempParentheses == 0){
					sb.append(current);
				} else {
					sb = addOpenParenthesis(current, sb);
					sb.append(current);
					openParentheses = current;
				}
			}
		}
		sb = addClosedParenthesis(openParentheses, sb);
		return sb.toString();
	}

	private static int calculateOpenParenthesis(int openParentheses, int current) {
		return current - openParentheses;
	}

	private static StringBuilder addOpenParenthesis(int openParentheses, StringBuilder sb) {
		for (int i = 0; i<openParentheses;i++) {
			sb.append("(");
		}
		return sb;
	}

	private static StringBuilder addClosedParenthesis(int openParentheses, StringBuilder sb) {
		for (int i = 0; i<openParentheses;i++) {
			sb.append(")");
		}
		return sb;
	}
}