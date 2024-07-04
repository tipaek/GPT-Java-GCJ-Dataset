import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		String t = in.nextLine(); // Scanner has functions to read ints, longs, strings, chars, etc.

		String s = "";
		String y = "";

		for (int x = 1; x <= Integer.valueOf(t); ++x) {
			s = in.nextLine();
			y = "";
			String sub = "";
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					if (!sub.isEmpty()) {
						y= sub + ")" + ch;
						sub = "";
					} else {
						y = y + ch;
					}
				} else {
					if (sub.isEmpty()) {
						sub = "(" + ch;
					} else {
						sub = sub + ch;
					}
				}

			}
			if (!sub.isEmpty() && !sub.contains(")")) {
				y = y + sub + ")";
			}
			System.out.println("Case #" + x + ": " + y);
		}

		in.close();
	}
}