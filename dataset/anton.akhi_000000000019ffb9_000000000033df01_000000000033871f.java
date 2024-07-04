import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	String nextToken() {
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

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	class Edge {
		public Edge(int x2, int y2, int i) {
			x = x2;
			y = y2;
			n = i;
		}

		int x, y;
		int d, n;
	}

	private void solve() {
		int testn = nextInt();
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			int m = nextInt();
			ArrayList<Edge>[] edges = new ArrayList[n];
			for (int i = 0; i < edges.length; i++) {
				edges[i] = new ArrayList<>();
			}
			HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
			for (int i = 1; i < edges.length; i++) {
				int order = -nextInt();
				if (!hm.containsKey(order)) {
					hm.put(order, new ArrayList<>());
				}
				hm.get(order).add(i);
			}
			int[] ans = new int[m];
			for (int i = 0; i < m; i++) {
				int x = nextInt() - 1;
				int y = nextInt() - 1;
				Edge e = new Edge(x, y, i);
				edges[x].add(e);
				e = new Edge(y, x, i);
				edges[y].add(e);
			}
			int time = 0;
			int[] done = new int[edges.length];
			Arrays.fill(done, -1);
			done[0] = 0;
			for (int layer = 1; layer < edges.length; layer++) {
				if (!hm.containsKey(layer)) {
					continue;
				}
				time++;
				ArrayList<Integer> nodes = hm.get(layer);
				for (int x : nodes) {
					done[x] = time;
					for (Edge e : edges[x]) {
						if (done[e.y] < 0) {
							continue;
						}
						ans[e.n] = Math.max(time - done[e.y], 1);
					}
				}
			}
			for (int i = 0; i < ans.length; i++) {
				out.print(ans[i] + " ");
			}
			out.println();
		}
	}
}
