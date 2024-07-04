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
			int r = nextInt();
			int s = nextInt();
			ArrayList<Integer> one = new ArrayList<Integer>();
			for (int i = 1; i <= s; ++i) {
				for (int j = 1; j <= r; ++j) {
					one.add(j);
				}
			}
			pf();
			ArrayList<String> ans = new ArrayList<String>();
			boolean cont = true;
			outer: while (cont) {
				int prev = one.get(0);
				for (int i = 1; i < one.size(); ++i) {
					int cur = one.get(i);
					if (prev > cur) {
						cont = true;
						ArrayList<Integer> sw = new ArrayList<Integer>();
						ArrayList<Integer> removed = new ArrayList<Integer>();
						for (int j = i; j < one.size(); ++j) {
							if (one.get(j) < prev) {
								sw.add(one.get(j));
								one.set(j, -1);
								removed.add(-1);
							} else break;
						}
						one.removeAll(removed);
						ans.add(i + " " + sw.size());
						one.addAll(0, sw);
						continue outer;
					}
					prev = cur;
				}
				cont = false;
				
			}
			pl(ans.size());
			for (String e : ans) pl(e);
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