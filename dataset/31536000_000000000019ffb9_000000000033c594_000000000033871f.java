public class Solution {

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		FastScanner fs = new FastScanner();
		java.io.PrintWriter out = new java.io.PrintWriter(System.out);
		solve(fs, out);
		out.flush();
	}

	private class Edge {
		int u, v, index;
		int ans = 1000000;
		Edge(int U, int V, int index) {
			u = U;
			v = V;
			this.index = index;
		}
	}

	public void solve(FastScanner fs, java.io.PrintWriter out) {
		int T = fs.nextInt();
		for (int i = 1;i <= T;++ i) {
			int C = fs.nextInt(), D = fs.nextInt();
			int[] X = new int[C];
			for (int j = 1;j < C;++ j) X[j] = fs.nextInt();
			java.util.List<java.util.ArrayList<Edge>> graph = new java.util.ArrayList<>(C);
			for (int j = 0;j < C;++ j) graph.add(new java.util.ArrayList<>());
			for (int j = 0;j < D;++ j) {
				int U = fs.nextInt() - 1, V = fs.nextInt() - 1;
				graph.get(U).add(new Edge(U, V, j));
				graph.get(V).add(new Edge(V, U, j));
			}
			int[] dist = new int[C];
			java.util.Arrays.fill(dist, -1);
			dist[0] = 0;
			{
				java.util.Queue<Integer> bfs = new java.util.ArrayDeque<>();
				bfs.add(0);
				while(!bfs.isEmpty()) {
					int tmp = bfs.poll();
					for (Edge j : graph.get(tmp)) {
						if (dist[j.v] < 0) {
							dist[j.v] = dist[tmp] + 1;
							bfs.add(j.v);
						}
					}
				}
			}
			java.util.PriorityQueue<Integer> positive = new java.util.PriorityQueue<>((l, r) ->
				(X[l] == X[r] ? Integer.compare(dist[l], dist[r]) : Integer.compare(X[l], X[r]))),
			negative = new java.util.PriorityQueue<>((l, r) ->
			(X[l] == X[r] ? Integer.compare(dist[l], dist[r]) : Integer.compare(X[r], X[l])));
			for (int j = 1;j < C;++ j) {
				if (X[j] > 0) positive.add(j);
				else negative.add(j);
			}

			int[] lazy = new int[C];
			java.util.Arrays.fill(lazy, 1000001);
			lazy[0] = 0;
			for (int j = 1, count = 1;j <= 1000000;++ j) {
				int tmpCount = 0;
				while(!negative.isEmpty() && X[negative.peek()] == -count) {
					int tmp = negative.poll();
					Edge min = null;
					for (Edge k : graph.get(tmp)) {
						if (min == null || lazy[k.v] < lazy[min.v]) min = k;
					}
					min.ans = j - lazy[min.v];
					lazy[tmp] = j;
					++ tmpCount;
				}
				while(!positive.isEmpty() && X[positive.peek()] == j) {
					int tmp = positive.poll();
					Edge min = null;
					for (Edge k : graph.get(tmp)) {
						if (min == null || lazy[k.v] < lazy[min.v]) min = k;
					}
					min.ans = j - lazy[min.v];
					lazy[tmp] = j;
					++ tmpCount;
				}
				count += tmpCount;
			}
			int[] ans = new int[D];
			java.util.Arrays.fill(ans, 1000000);
			for (java.util.List<Edge> j : graph) {
				for (Edge k : j) {
					ans[k.index] = Math.min(ans[k.index], k.ans);
				}
			}
			out.print("Case #" + i + ":");
			for (int j : ans) out.print(" " + j);
			out.println();
		}
	}

	static class FastScanner {
		private final java.io.InputStream in = System.in;
		private final byte[] buffer = new byte[1024];
		private int ptr = 0;
		private int buflen = 0;

		private boolean hasNextByte() {
			if (ptr < buflen) return true;
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
			return buflen > 0;
		}

		private byte readByte() {
			return hasNextByte() ? buffer[ptr++ ] : -1;
		}

		private static boolean isPrintableChar(byte c) {
			return 32 < c || c < 0;
		}

		private static boolean isNumber(int c) {
			return '0' <= c && c <= '9';
		}

		public boolean hasNext() {
			while (hasNextByte() && !isPrintableChar(buffer[ptr]))
				ptr++ ;
			return hasNextByte();
		}

		public String next() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			byte b = readByte();
			while (isPrintableChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public final long nextLong() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			long n = 0;
			try {
				byte b = readByte();
				if (b == '-') {
					while(isNumber(b = readByte())) n = n * 10 + '0' - b;
					return n;
				} else if (!isNumber(b)) throw new NumberFormatException();
				do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
				return n;
			} catch (java.util.NoSuchElementException e) {
				return n;
			}
		}

		public final int nextInt() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			int n = 0;
			try {
				byte b = readByte();
				if (b == '-') {
					while(isNumber(b = readByte())) n = n * 10 + '0' - b;
					return n;
				} else if (!isNumber(b)) throw new NumberFormatException();
				do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
				return n;
			} catch (java.util.NoSuchElementException e) {
				return n;
			}
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
