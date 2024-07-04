import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.next();

			String result = "";
			int open = 0;
			for (int j = 0; j < s.length(); ++j) {
				int num = (int) (s.charAt(j) - '0');
				while (num > open) {
					result += "(";
					open++;
				}
				while (num < open) {
					result += ")";
					open--;
				}
				result += s.charAt(j);

			}
			
			while (open > 0) {
				result += ")";
				open--;
			}

			System.out.println("Case #" + i + ": " + result);
		}
	}
}