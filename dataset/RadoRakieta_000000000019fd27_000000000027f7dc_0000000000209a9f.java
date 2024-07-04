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
				}
				if (input[j] == '1') {
					if(j == 0) {
						answer.append('(');
					}
					else if((j - 1) >= 0 && (input[(j - 1)] == '0')) {
						answer.append('(');
					}
					answer.append('1');
					if((j + 1) >= input.length) {
						answer.append(')');
					}
					else if((j + 1) < input.length && (input[(j + 1)] == '0')) {
						answer.append(')');
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