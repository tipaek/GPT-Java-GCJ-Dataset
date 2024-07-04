import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int x = 1; x <= t; ++x) {
			String s = in.nextLine();
			StringBuilder sb = new StringBuilder();
			int i = 0;
			while  (i < s.length()) {
				char c = s.charAt(i);
				if(c == '0') {
					sb.append(c);
				} else {
					sb.append('(');
					while(i < s.length() && s.charAt(i) == '1') {
						sb.append('1');
						i++;
					}
					sb.append(')');
					i--;
				}
				i++;
			}
			System.out.printf("Case #%d: %s\n",x, sb.toString());
		}
	}
}