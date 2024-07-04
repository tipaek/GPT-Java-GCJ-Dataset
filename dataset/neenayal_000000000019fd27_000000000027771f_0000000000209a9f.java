import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = Integer.valueOf(in.nextLine());
		for (int test = 1; test <= tc; ++test) {
			String str = in.nextLine();
			StringBuilder builder = new StringBuilder();

			int openingBracs = 0;
			int len = str.length();
			int next = 0;
			for (int idx = 0; idx < len; idx++) {
				int num = Integer.valueOf(String.valueOf(str.charAt(idx)));

				while (openingBracs < num) {
					builder.append("(");
					openingBracs++;
				}
				builder.append(num);

				if (idx < len - 1) {
					next = Integer.valueOf(String.valueOf(str.charAt(idx + 1)));
					while (next < openingBracs) {
						builder.append(")");
						openingBracs--;
					}
				}
			}

			while (openingBracs > 0) {
				builder.append(")");
				openingBracs--;
			}

			System.out.println("Case #" + test + ": " + builder.toString());
		}
	}
}
