import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int test = 1; test <= testcases; ++test) {
			String digits = in.nextLine();
			StringBuffer str = new StringBuffer();
			for (int ctr = 0; ctr < digits.length(); ctr++) {
				int parenLen = Integer.parseInt(digits.charAt(ctr) + "");
				for (int parenCtr = 0; parenCtr < parenLen; parenCtr++) {
					str.append("(");
				}
				str.append(digits.charAt(ctr));
				for (int parenCtr = 0; parenCtr < parenLen; parenCtr++) {
					str.append(")");
				}
			}

			for(int i=0; i < str.length() - 1; i++) {
				if (str.charAt(i) == ')' && str.charAt(i+1) == '(') {
					str = str.deleteCharAt(i);
					str = str.deleteCharAt(i);
					i = i - 2;
				}
			}
			System.out.println("Case #" + test + ": " + str.toString());
		}
	}
}