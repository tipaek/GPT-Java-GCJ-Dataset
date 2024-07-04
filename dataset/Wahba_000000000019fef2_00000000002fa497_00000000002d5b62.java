import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution implements Runnable {
	
	static class State {
		long x, y;
		String path;
		
		public State(long xx, long yy, String p) {
			x = xx;
			y = yy;
			path = p;
		}
		
		
	}
	
	private void solve() throws IOException {
		int t = nextInt();
		outer: while (t-- > 0) {
			long x = nextInt();
			long y = nextInt();
			pf();
			Queue<State> q = new LinkedList<State>();
			HashSet<String> vis = new HashSet<String>();
			q.add(new State(0, 0, ""));
			vis.add(0 + " " + 0);
			while (!q.isEmpty()) {
				State cur = q.poll();
				//pl(cur.path + " " + cur.x + " " + cur.y);
				if (cur.x == x && cur.y == y) {
					pl(cur.path);
					continue outer;
				}
				if (Math.hypot(cur.x - x, cur.y - y) > 5000) {
					pl("IMPOSSIBLE");
					continue outer;
				}
				if (cur.path.length() == 20) {
					pl("IMPOSSIBLE");
					continue outer;
				}
				if (!vis.contains(cur.x + " " + (cur.y - (1L << cur.path.length())))) {
					q.add(new State(cur.x, cur.y - (1L << cur.path.length()), cur.path + "S"));
					vis.add(cur.x + " " + (cur.y - (1L << cur.path.length())));
				}
				if (!vis.contains(cur.x + " " + (cur.y + (1L << cur.path.length())))) {
					q.add(new State(cur.x, cur.y + (1L << cur.path.length()), cur.path + "N"));
					vis.add(cur.x + " " + (cur.y + (1L << cur.path.length())));
				}
				if (!vis.contains((cur.x - (1L << cur.path.length())) + " " + cur.y)) {
					q.add(new State(cur.x - (1L << cur.path.length()), cur.y, cur.path + "W"));
					vis.add((cur.x - (1L << cur.path.length())) + " " + cur.y);
				}
				if (!vis.contains((cur.x + (1L << cur.path.length())) + " " + cur.y)) {
					q.add(new State(cur.x + (1L << cur.path.length()), cur.y, cur.path + "E"));
					vis.add((cur.x + (1L << cur.path.length())) + " " + cur.y);
				}
			}
			pl("IMPOSSIBLE");
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