import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
	static class Edge {
		int from, to, cost;

		public Edge(int f, int t) {
			from = f;
			to = t;
			cost = -1;
		}
	}

	static boolean[][] vis;
	static int[][] res;
	static int[] dist;
	static ArrayList<Integer>[] adj;

	static void solve(ArrayList<Integer> val, ArrayList<Edge> edges,
			int currCost) {
		ArrayList<Edge> newEdges = new ArrayList<Edge>();
		for (int node : val) {
			for (Edge ed : edges) {
				if (ed.cost != -1)
					continue;
				if (ed.from == node || ed.to == node) {
					int other = ed.from + ed.to - node;
					int coco = currCost - dist[other];
					ed.cost = coco;
					dist[node] = currCost;
					res[other][node] = coco;
					res[node][other] = coco;
					for (int x : adj[node]) {
						if (!vis[x][node]) {
							newEdges.add(new Edge(x, node));
							vis[x][node] = true;
							vis[node][x] = true;
						}
					}
					break;
				}
			}
		}
		currCost = currCost + 1;
		for (Edge ed : newEdges)
			edges.add(0, ed);
	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int t = r.nextInt();
		int test = 1;
		while (t-- > 0) {
			int n = r.nextInt();
			int m = r.nextInt();
			int[] arr = new int[n - 1];
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
			TreeMap<Integer, Integer> m2 = new TreeMap<Integer, Integer>();
			for (int i = 0; i < arr.length; i++) {
				int x = r.nextInt();
				if (x < 0) {
					arr[i] = -1 * x;

					if (!map.containsKey(arr[i]))
						map.put(arr[i], new ArrayList<Integer>());
					ArrayList<Integer> curr = map.get(arr[i]);
					curr.add(i + 1);
					map.put(arr[i], curr);
				} else {
					m2.put(x, i + 1);
				}
			}
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			ArrayList<Edge> sol = new ArrayList<Edge>();
			for (int i = 0; i < m; i++) {
				int from = r.nextInt() - 1;
				int to = r.nextInt() - 1;
				adj[from].add(to);
				adj[to].add(from);
				sol.add(new Edge(from, to));
			}
			res = new int[n][n];
			for (int[] x : res)
				Arrays.fill(x, 1000000);
			ArrayList<Edge> edges = new ArrayList<Edge>();
			vis = new boolean[n][n];
			for (int x : adj[0]) {
				edges.add(new Edge(0, x));
				vis[0][x] = true;
				vis[x][0] = true;
			}
			int currCost = 1;
			dist = new int[n];
			int processed = 1;
			for (Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
				int key = e.getKey();
				ArrayList<Integer> val = e.getValue();
				while (processed < key) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					Entry<Integer, Integer> e2 = m2.pollFirstEntry();
					l.add(e2.getValue());
					int cost = e2.getKey();
					while (true) {
						Entry<Integer, Integer> e3 = m2.firstEntry();
						if (e3 != null && e3.getKey() == cost) {
							e3 = m2.pollFirstEntry();
							l.add(e3.getValue());
						} else {
							break;
						}
					}
					if (processed + l.size() <= key) {
						solve(l, edges, cost);
						currCost = cost + 1;
						processed += l.size();
					} else {
						val.addAll(l);
						currCost = cost;
						break;
					}
				}
				solve(val, edges, currCost);
				processed += val.size();
				currCost++;
			}
			// for (Edge ed : edges) {
			// System.out.println(ed.from + 1 + " " + (ed.to + 1) + " "
			// + ed.cost);
			// }
//			for (Edge ed : sol) {
//				System.out.println(res[ed.from][ed.to]);
//			}
			// System.out.println("------");
			// int res = 0;
			System.out.printf("Case #%d:", test++);
			for (Edge ed : sol) {
				System.out.print(" " + res[ed.from][ed.to]);
			}
			System.out.println();
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
