import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int C = in.nextInt();
			int D = in.nextInt();
			int X[] = new int[C];
			for (int i = 1; i < C; i++) {
				X[i] = in.nextInt();
			}
			Edge[] edges = new Edge[D];
			for (int i = 0; i < D; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				edges[i] = new Edge(u, v);
			}
			EdgeRef[][] edgeLists = new EdgeRef[C][];
			for (int i = 0; i < C; i++) {
				List<EdgeRef> buf = new ArrayList<>();
				for (Edge e : edges) {
					if (e.a == i) {
						buf.add(new EdgeRef(e.b, e));
					} else if (e.b == i) {
						buf.add(new EdgeRef(e.a, e));
					}
				}
				edgeLists[i] = buf.stream().toArray(size -> new EdgeRef[size]);
//				System.err.println(Arrays.toString(edgeLists[i]));
			}
			
			if (Arrays.stream(X).allMatch(x -> x <= 0)) {
				int receivedCount = 1;
				boolean[] received = new boolean[C];
				received[0] = true;
				int[] receivedAt = new int[C];
				Arrays.fill(receivedAt, -1);
				receivedAt[0] = 0;
				for (;;) {
					int nextReceivedBefore = receivedCount;
					int[] nextOnes = IntStream.range(0, C).filter(i -> -X[i] == nextReceivedBefore).toArray();
					if (nextOnes.length == 0) {
						// End
						break;
					}
//					System.err.println("NextOnes: " + Arrays.toString(nextOnes));
					int nextReceivedAt = 0;
					for (int next : nextOnes) {
						// At least 1 neighbours
						EdgeRef[] edgeList = edgeLists[next];
						int maxPrev = Arrays.stream(edgeList).filter(r -> receivedAt[r.other] >= 0).mapToInt(r -> receivedAt[r.other]).max().getAsInt();
						nextReceivedAt = Math.max(nextReceivedAt, maxPrev + 1);
					}
//					System.err.println("nextReceivedAt: " + nextReceivedAt);
					for (int next : nextOnes) {
						receivedAt[next] = nextReceivedAt;
						for (EdgeRef r : edgeLists[next]) {
							Edge e = r.edge;
							int atOther = receivedAt[r.other];
							if (atOther >= 0) {
								int before = e.latency;
								int latency = Math.abs(atOther - nextReceivedAt);
								if (0 == latency) { // Both next & other are hit this time.
									latency = 999999;
								}
								e.latency = latency;
//								System.err.println(e + ".latency " + before + " -> " + e.latency);
							}
						}
					}
					receivedCount += nextOnes.length;
				}
				System.out.println("CASE #" + (t + 1) + ": " + Arrays.stream(edges).map(e -> Integer.toString(e.latency)).collect(Collectors.joining(" ")));
			} else {
				// TODO
			}
		}
	}
	public static class Edge {
		public int a;
		public int b;
		public int latency = 0;
		public Edge(int init) {
			this(init, init);
		}
		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "<" + a + "," + b + ":" + latency + ">";
		}
	}
	public static class EdgeRef {
		public int other;
		public Edge edge;
		public EdgeRef(int o, Edge e) {
			other = o;
			edge = e;
		}
		@Override
		public String toString() {
			return "{" + edge + "," + other + "}";
		}
	}
}
