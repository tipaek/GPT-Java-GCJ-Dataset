import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static class P {
		int x;
		int y;

		int cost;
		String path;

		public P(int xx, int yy, int cc, String p) {
			x = xx;
			y = yy;
			cost = cc;
			path = p;
		}
	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		LinkedList<P> q = new LinkedList<P>();
		q.add(new P(0, 0, 0, ""));
		String[][] can = new String[250][250];
		int cnt = 0;
		int delta = 110;
		while (!q.isEmpty()) {
			cnt++;
			if (cnt > 100000)
				break;
			P p = q.removeFirst();
			if (p.x + delta >= can.length || p.y + delta >= can.length
					|| p.x + delta < 0 || p.y + delta < 0) {
			} else {
				if (can[p.x + delta][p.y + delta] != null)
					continue;
				can[p.x + delta][p.y + delta] = p.path;
			}
			int step = 1 << (p.cost);
			q.add(new P(p.x + step, p.y, p.cost + 1, p.path + "E"));
			q.add(new P(p.x - step, p.y, p.cost + 1, p.path + "W"));
			q.add(new P(p.x, p.y + step, p.cost + 1, p.path + "N"));
			q.add(new P(p.x, p.y - step, p.cost + 1, p.path + "S"));
		}
		int T = r.nextInt();
		int test = 1;
		while (T-- > 0) {
			int x = r.nextInt();
			int y = r.nextInt();
			String res = can[x + delta][y + delta];
			System.out.printf("Case #%d: %s\n", test++,
					res == null ? "IMPOSSIBLE" : res);
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
