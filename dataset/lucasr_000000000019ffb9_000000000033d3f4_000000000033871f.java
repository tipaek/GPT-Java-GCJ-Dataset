import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int C, D;
	static List<Edge> adj[];
	static List<OrderPoint> order;
	static List<PositionPoint> position;
	
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			C = sc.nextInt();
			D = sc.nextInt();
			adj = new List[C];
			for (int i = 0; i < C; i++) {
				adj[i] = new ArrayList<>();
			}
			order = new ArrayList<>();
			position = new ArrayList<>();
			for (int i = 1; i < C; i++) {
				int tmp = sc.nextInt();
				if (tmp > 0) {
					position.add(new PositionPoint(i, tmp));
				} else {
					order.add(new OrderPoint(i, -tmp));
				}
			}
			
			for (int i = 0; i < D; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adj[a].add(new Edge(b, i));
				adj[b].add(new Edge(a, i));
			}
			
			Collections.sort(order, (p1, p2) -> Integer.compare(p1.prev, p2.prev));
			Collections.sort(position, (p1, p2) -> Integer.compare(p1.seconds, p2.seconds));
			
			
			int[] dist = new int[C];
			int[] retEdges = new int[D];
			Arrays.fill(dist, -1);
			dist[0] = 0;
			int idxOrder = 0, idxPosition = 0;
			int got = 1, curDist = 0;
			while (got < C) {
				int prevGot = got;
				if (idxOrder < order.size() && order.get(idxOrder).prev == prevGot) {
					curDist++;
					while (idxOrder < order.size() && order.get(idxOrder).prev == prevGot) {
						OrderPoint p = order.get(idxOrder);
						dist[p.id] = curDist;
						for (Edge e : adj[p.id]) {
							if (dist[e.to] != -1) {
								retEdges[e.id] = Math.max(1, curDist - dist[e.to]);
							}
						}
						idxOrder++;
						got++;
					}
				} else {
					PositionPoint p = position.get(idxPosition);
					curDist = p.seconds;
					dist[p.id] = curDist;
					for (Edge e : adj[p.id]) {
						if (dist[e.to] != -1) {
							retEdges[e.id] = Math.max(1, curDist - dist[e.to]);
						}
					}
					idxPosition++;
					got++;
				}
			}
			
			out.print("Case #" + caze + ":");
			for (int i = 0; i < D; i++) {
				out.print(" " + retEdges[i]);
			}
			out.println();
			
			out.flush();
		}
	}
	
	static class Edge {
		int to, id;
		
		public Edge(int to, int id) {
			this.to = to;
			this.id = id;
		}
	}
	
	static class OrderPoint {
		int id, prev;
		
		public OrderPoint(int id, int prev) {
			this.id = id;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return prev + "";
		}
	}
	
	static class PositionPoint {
		int id, seconds;
		
		public PositionPoint(int id, int seconds) {
			this.id = id;
			this.seconds = seconds;
		}
		
		@Override
		public String toString() {
			return seconds + "";
		}
	}
	
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer tokenizer;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
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
	}
}
