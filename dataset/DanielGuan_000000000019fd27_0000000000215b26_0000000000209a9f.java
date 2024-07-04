import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int a = 1; a <= T; a++) {
			System.out.print("Case #" + a + ": ");
			String S = in.readLine();
			int d = 0;
			StringBuilder out = new StringBuilder(S.length() * 10);
			for (int b = 0; b < S.length(); b++) {
				int temp = Integer.parseInt(S.charAt(b) + "");
				if (temp == d) {
					out.append("" + temp);
				} else if (temp > d) {
					for (int c = d + 1; c <= temp; c++)
						out.append("(");
					d = temp;
					out.append("" + temp);
				} else {
					for (int c = d - 1; c >= temp; c--)
						out.append(")");
					d = temp;
					out.append("" + temp);
				}
			}
			if (0 == d) {
			} else if (0 > d) {
				for (int c = d + 1; c <= 0; c++)
					out.append("(");
			} else {
				for (int c = d - 1; c >= 0; c--)
					out.append(")");
			}
			System.out.println(out.toString());
		}
	}
}