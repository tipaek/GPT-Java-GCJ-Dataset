import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int k = in.nextInt();
			int q = in.nextInt();
			int[] inputs = new int[q];
			int[] outputs = new int[q];
			String str = in.next();
			char[] parans = str.toCharArray();
			int total = 0;
			List<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>(k);
			for (int j = 0; j < k; j++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				if(j > 0) {
					tmp.add(j - 1);
				}
				if(j < k - 1) {
					tmp.add(j + 1);
				}
				edges.add(tmp);
			}
			// Map<Integer, Integer> matchingParans = new HashMap<>();
			for (int j = 0; j < k; j++) {
				in.nextInt();
			}
			for (int j = 0; j < k; j++) {
				in.nextInt();
			}
			for (int j = 0; j < k; j++) {
				in.nextInt();
			}
			for (int j = 0; j < q; j++) {
				inputs[j] = in.nextInt() - 1;
			}
			for (int j = 0; j < q; j++) {
				outputs[j] = in.nextInt() - 1;
			}
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < parans.length; j++) {
				if (parans[j] == '(') {
					stack.push(j);
				} else {
					int val = stack.pop();
					edges.get(j).add(val);
					edges.get(val).add(j);
					// matchingParans.put(j, val);
					// matchingParans.put(val, j);
				}
			}
			for (int j = 0; j < q; j++) {
				total += helper(inputs[j], outputs[j], edges, k);
			}
			System.out.println("Case #" + i + ": " + total);
		}
	}

	public static int helper(int src, int dest, List<ArrayList<Integer>> edges, int v) {
		// predecessor[i] array stores predecessor of
		// i and distance array stores distance of i
		// from s
		int pred[] = new int[v];
		int dist[] = new int[v];
		BFS(edges, src, dest, v, pred, dist);
		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = dest;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}
		// Print distance
		return dist[dest];
	}

	private static void BFS(List<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]) {
		LinkedList<Integer> queue = new LinkedList<Integer>();

		boolean visited[] = new boolean[v];

		for (int i = 0; i < v; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		visited[src] = true;
		dist[src] = 0;
		queue.add(src);
		while (!queue.isEmpty()) {
			int u = queue.remove();
			for (int i = 0; i < adj.get(u).size(); i++) {
				if (visited[adj.get(u).get(i)] == false) {
					visited[adj.get(u).get(i)] = true;
					dist[adj.get(u).get(i)] = dist[u] + 1;
					pred[adj.get(u).get(i)] = u;
					queue.add(adj.get(u).get(i));
					if (adj.get(u).get(i) == dest)
						return;
				}
			}
		}
	}
}