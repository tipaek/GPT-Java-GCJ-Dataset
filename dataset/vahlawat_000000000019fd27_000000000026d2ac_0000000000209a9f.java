import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int test = 1; test <= testcases; ++test) {
			String digits = in.nextLine();
			StringBuffer str = new StringBuffer();
			int ctr = 0;
			while(ctr < digits.length()) {
				if (digits.charAt(ctr) == '1') {
					str.append("(1");
					ctr++;
					break;
				}
				str.append("0");
				ctr++;
			}
			for (; ctr < digits.length(); ctr++) {
				if (digits.charAt(ctr) == '0') {
					if (ctr > 0 && digits.charAt(ctr - 1) == '1') {
						str.append(")");
					}
					str.append("0");
				} else {
					if (ctr > 0 && digits.charAt(ctr - 1) == '0') {
						str.append("(");
					}
					str.append("1");
				}
			}
			if (digits.charAt(digits.length() - 1) == '1') {
				str.append(")");
			}
			System.out.println("Case #" + test + ": " + str.toString());
		}
	}
}
