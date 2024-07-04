import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	private BufferedReader br;
	private StringTokenizer st;
	private PrintWriter out;
	private boolean eof = false;

	private void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	private String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	private int nextInt() {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() {
		return Long.parseLong(nextToken());
	}

	private double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	private static class Edge {
		int x, y, d, n;

		public Edge(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}

	private static class Node implements Comparable<Node> {
		int n, t;

		public Node(int n, int t) {
			this.n = n;
			this.t = t;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.t, other.t);
		}
	}

	private void solve() {
		int testCount = nextInt();
		for (int test = 1; test <= testCount; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			int m = nextInt();
			ArrayList<Edge>[] edges = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				edges[i] = new ArrayList<>();
			}
			Map<Integer, ArrayList<Integer>> orderMap = new HashMap<>();
			List<Node> nodes = new ArrayList<>();
			for (int i = 1; i < n; i++) {
				int order = nextInt();
				if (order < 0) {
					order = -order;
					orderMap.computeIfAbsent(order, k -> new ArrayList<>()).add(i);
				} else {
					nodes.add(new Node(i, order));
				}
			}
			nodes.add(new Node(0, 0));
			Collections.sort(nodes);
			int[] ans = new int[m];
			for (int i = 0; i < m; i++) {
				int x = nextInt() - 1;
				int y = nextInt() - 1;
				edges[x].add(new Edge(x, y, i));
				edges[y].add(new Edge(y, x, i));
			}
			int[] done = new int[n];
			Arrays.fill(done, -1);
			int processedTime = 0;
			int processedAll = 0;
			for (int layer = 1; layer < n; layer++) {
				if (!orderMap.containsKey(layer)) {
					continue;
				}
				while (processedAll < layer) {
					Node next = nodes.get(processedTime++);
					set(next.n, done, edges, next.t, ans);
					processedAll++;
				}
				int time = nodes.get(processedTime - 1).t + 1;
				for (int x : orderMap.get(layer)) {
					set(x, done, edges, time, ans);
					processedAll++;
				}
			}
			for (int value : ans) {
				out.print(value + " ");
			}
			out.println();
			out.flush();
		}
	}

	private void set(int x, int[] done, ArrayList<Edge>[] edges, int time, int[] ans) {
		done[x] = time;
		for (Edge edge : edges[x]) {
			if (done[edge.y] >= 0) {
				ans[edge.n] = Math.max(time - done[edge.y], 1);
			}
		}
	}
}