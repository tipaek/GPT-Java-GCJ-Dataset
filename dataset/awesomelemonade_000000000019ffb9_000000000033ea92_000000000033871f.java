import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer info = new StringTokenizer(reader.readLine());
			int c = Integer.parseInt(info.nextToken());
			int d = Integer.parseInt(info.nextToken());
			int[] computers = new int[c];
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for (int i = 0; i < c - 1; i++) {
				computers[i + 1] = Integer.parseInt(tokenizer.nextToken());
			}
			Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
			for (int i = 0; i < c; i++) {
				edges.put(i, new HashMap<>());
			}
			for (int i = 0; i < d; i++) {
				StringTokenizer a = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(a.nextToken()) - 1;
				int v = Integer.parseInt(a.nextToken()) - 1;
				edges.get(u).put(v, i);
				edges.get(v).put(u, i);
			}
			int[] edgeLatencies = new int[d];
			int[] vertexLatencies = new int[c];
			Arrays.fill(vertexLatencies, -1);
			Arrays.fill(edgeLatencies, -1);
			vertexLatencies[0] = 0; // source computer

			Set<Integer>[] buckets = new HashSet[c];
			for (int i = 0; i < buckets.length; i++) {
				buckets[i] = new HashSet<>();
			}
			for (int i = 1; i < computers.length; i++) {
				if (computers[i] < 0) {
					buckets[-computers[i]].add(i);
				}
			}

			int currentLatency = 0;
			for (int i = 0; i < buckets.length; i++) {
				if (buckets[i].isEmpty()) {
					continue;
				}
				Map<Integer, Integer> minParents = new HashMap<Integer, Integer>();
				Map<Integer, Integer> minLatencies = new HashMap<Integer, Integer>();
				Map<Integer, Integer> minEdgeIds = new HashMap<Integer, Integer>();
				//writer.println("Processing: " + buckets[i]);
				for (int vertex : buckets[i]) {
					Map<Integer, Integer> map = edges.get(vertex);
					int min = Integer.MAX_VALUE;
					int minParent = -1;
					int minEdgeId = -1;
					for (int neighbor : map.keySet()) {
						if (vertexLatencies[neighbor] == -1) {
							// not visited yet
							continue;
						}
						if (vertexLatencies[neighbor] < min) {
							min = vertexLatencies[neighbor];
							minParent = neighbor;
							minEdgeId = map.get(neighbor);
						}
					}
					minParents.put(vertex, minParent);
					minLatencies.put(vertex, min);
					minEdgeIds.put(vertex, minEdgeId);
				}
				int maxLatency = Integer.MIN_VALUE;
				for (int vertex : minParents.keySet()) {
					maxLatency = Math.max(minLatencies.get(vertex), maxLatency);
				}
				int newLatency = Math.max(maxLatency + 1, currentLatency + 1);
				//writer.println("New Latency: " + newLatency);
				for (int vertex : minParents.keySet()) {
					int edgeId = minEdgeIds.get(vertex);
					int diff = newLatency - minLatencies.get(vertex);
					edgeLatencies[edgeId] = diff;
					vertexLatencies[vertex] = newLatency;
				}
				currentLatency = Math.max(currentLatency, newLatency);
			}

			// Output
			writer.printf("Case #%d: ", tt + 1);
			writer.print(edgeLatencies[0]);
			for (int i = 1; i < edgeLatencies.length; i++) {
				writer.print(' ');
				if (edgeLatencies[i] == -1) {
					edgeLatencies[i] = 1000000; // 1e6
				}
				writer.print(edgeLatencies[i]);
			}
			writer.println();
		}

		reader.close();
		writer.close();
	}
	static class Vertex {
		int id;
		int latency = 0;
		int info = 0;
		Vertex parent;
		int edgeTraversed;
		public Vertex(int id, Vertex parent, int edgeTraversed, int info) {
			this.id = id;
			this.parent = parent;
			this.edgeTraversed = edgeTraversed;
			this.info = info;
		}
		public void setLatency(int latency) {
			this.latency = latency;
		}
		public int getLatency() {
			return latency;
		}
	}
}
