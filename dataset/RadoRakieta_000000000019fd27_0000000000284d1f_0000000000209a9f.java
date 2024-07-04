import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;

	static void solve() throws Exception {
		int tests = scanInt();
		for (int test = 1; test <= tests; test++) {
			String S = scanString();
			char[] input = S.toCharArray();
			StringBuilder answer = new StringBuilder();
			for (int j = 0; j < input.length; j++) {
				if (input[j] == '0') {
					answer.append('0');
				} else {
					int value = Character.getNumericValue(input[j]);
					if (j == 0) {
						for (int i = 0; i < value; i++) {
							answer.append('(');
						}
					} else if ((j - 1) >= 0) {
						int beforeValue = Character.getNumericValue(input[j - 1]);
						int diff = value - beforeValue;
						for (int i = 0; i < diff; i++) {
							answer.append('(');
						}
					}
					answer.append(input[j]);
					if ((j + 1) >= input.length) {
						for (int i = 0; i < value; i++) {
							answer.append(')');
						}
					} else if ((j + 1) < input.length) {
						int afterValue = Character.getNumericValue(input[j + 1]);
						int diff = value - afterValue;
						for (int i = 0; i < diff; i++) {
							answer.append(')');
						}
					}
				}
			}
			out.println("Case #" + test + ": " + answer);
		}
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}