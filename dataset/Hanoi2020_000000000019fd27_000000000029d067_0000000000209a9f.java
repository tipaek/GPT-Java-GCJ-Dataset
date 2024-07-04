import java.util.*;
import java.io.*;

//Nesting Depth
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i1 = 1; i1 <= t; ++i1) {
			String S = in.next();

			StringBuilder sb = new StringBuilder();
			int counter = 0;

			for (int i = 0 ; i < S.length(); i++) {
				char c = S.charAt(i);

				if (c == '1' && counter == 0) {
					sb.append('(');
					sb.append(c);
					counter++;
				} else if (c == '1') {
					sb.append(c);
				} else if (c == '0' && counter > 0) {
					sb.append(')'); counter--;
					sb.append(c);
				} else if (c == '0') {
					sb.append(c);
				}

			}

			if (counter > 0) sb.append(')');



			System.out.println("Case #" + i1 + ": " + sb.toString());

		}
		in.close();
	}

}
