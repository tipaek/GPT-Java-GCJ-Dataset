import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution {
	static class Pair {
		int count;
		long max;

		public Pair(int c, long m) {
			count = c;
			max = m;
		}
	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int t = r.nextInt();
		int test = 1;
		while (t-- > 0) {
			int u = r.nextInt();
			long range = (long) Math.pow(10, u);
			HashMap<String, Pair> map = new HashMap<String, Pair>();
			for (int record = 0; record < 10000; record++) {
				long q = r.nextLong();
				String s = r.next();
				if (!map.containsKey(s))
					map.put(s, new Pair(0, range));
				Pair p = map.get(s);
				p.count++;
				p.max = Math.min(q, p.max);
			}
			char[] sol = new char[10];
			boolean[] taken = new boolean[26];
			for (int d = 1; d < 10; d++) {
				for (Entry<String, Pair> e : map.entrySet()) {
					String s = e.getKey();
					Pair p = e.getValue();
					if (p.max == d) {
						if (!taken[s.charAt(0) - 'A']) {
							taken[s.charAt(0) - 'A'] = true;
							sol[d] = s.charAt(0);
						}
					}
				}
			}
			for (Entry<String, Pair> e : map.entrySet()) {
				String s = e.getKey();
				Pair p = e.getValue();
				if (p.max == 10) {
					if (!taken[s.charAt(1) - 'A']) {
						taken[s.charAt(1) - 'A'] = true;
						sol[0] = s.charAt(1);
					}
				}
			}
			System.out.printf("Case #%d: %s\n", test++, new String(sol));
		}

	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
