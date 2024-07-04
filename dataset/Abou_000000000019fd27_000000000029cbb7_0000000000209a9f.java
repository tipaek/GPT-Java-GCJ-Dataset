import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.

		in.nextLine();
		
		for (int tc = 1; tc <= t; ++tc) {
			int depth = 0;
			String s = in.nextLine();
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < s.length(); i++) {
				int d = Integer.valueOf("" + s.charAt(i));
				while (d < depth) {
					result.append(')');
					depth--;
				}
				while (d > depth) {
					result.append('(');
					depth++;
				}
				result.append(d);
			}
			while (0 < depth) {
				result.append(')');
				depth--;
			}

			
			System.out.println("Case #" + tc + ": " + result);
		}
	}
}
