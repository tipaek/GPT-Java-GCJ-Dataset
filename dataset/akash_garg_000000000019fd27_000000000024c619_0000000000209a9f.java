
// you can also use imports, for example:
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		for (int q = 1; q <= test_cases; q++) {
			String str = in.next();
			int c1 = 0;
			StringBuilder output = new StringBuilder("");
			for (int x = 0; x < str.length(); x++) {
				int val = str.charAt(x) - '0';
				int diff = c1 - val;
				c1 = val;
				if (diff < 0) {
					while (diff++ != 0) {
						output.append('(');
					}
				} else {
					while (diff-- != 0) {
						output.append(')');
					}
				}
				output.append(val);
			}
			if (c1 < 0) {
				while (c1++ != 0) {
					output.append('(');
				}
			} else {
				while (c1-- != 0) {
					output.append(')');
				}
			}
			System.out.println("Case #" + q + ": " + output);
		}
	}
}
