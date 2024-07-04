import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution implements Runnable {

	private void solve() throws IOException {
		int t = nextInt();
		
		while (t-- > 0) {
			String s = nextToken();
			StringBuilder ans = new StringBuilder();
			int open = 0;
			for (int i = 0; i < s.length(); i++) {
				int cur = s.charAt(i) - '0';
				if (cur > open) {
					while (cur > open) {
						ans.append("(");
						++open;
					}
					ans.append(s.charAt(i));
				} else if (cur < open) {
					while (cur < open) {
						ans.append(")");
						open--;
					}
					ans.append(s.charAt(i));
				} else {
					ans.append(s.charAt(i));
				}
			}
			while (open > 0) {
				ans.append(")");
				--open;
			}
			pf();
			pl(ans);
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
			writer = new PrintWriter(System.out);
			tokenizer = null;
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	BigInteger nextBigInteger() throws IOException {
		return new BigInteger(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	void p(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	void pl(Object... objects) {
		p(objects);
		writer.println();
	}

	int cc;

	void pf() {
		writer.printf("Case #%d: ", ++cc);
	}

}