import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class P implements Comparable<P> {
		int type;
		Point val;
		int index;

		public P(Point v, int t, int i) {
			val = v;
			type = t;
			index = i;
		}

		@Override
		public int compareTo(P arg0) {
			if (val.x == arg0.val.x)
				return type - arg0.type;
			return val.x - arg0.val.x;
		}

	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int test = 1;
		while (T-- > 0) {
			int n = r.nextInt();
			PriorityQueue<P> pq = new PriorityQueue<P>();
			char[] res = new char[n];
			for (int i = 0; i < n; i++) {
				int from = r.nextInt();
				int to = r.nextInt();
				pq.add(new P(new Point(from, to), 1, i));
			}
			boolean c = false, j = false;
			boolean can = true;
			while (!pq.isEmpty()) {
				P front = pq.remove();
				if (front.type == 0) {
					if (front.index == 0)
						c = false;
					else
						j = false;
				} else {
					if (!c) {
						res[front.index] = 'C';
						pq.add(new P(new Point(front.val.y, 0), 0, 0));
						c = true;
					} else if (!j) {
						res[front.index] = 'J';
						pq.add(new P(new Point(front.val.y, 0), 0, 1));
						j = true;
					} else {
						can = false;
						break;
					}
				}
			}
			if (can)
				System.out.printf("Case #%d: %s\n", test++, new String(res));
			else
				System.out.printf("Case #%d: IMPOSSIBLE\n", test++);
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
