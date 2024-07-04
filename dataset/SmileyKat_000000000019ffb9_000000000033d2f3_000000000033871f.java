import java.util.*;

public class Solution {

	private static final Scanner sc = new Scanner(System.in);
	private static final StringBuilder sb = new StringBuilder();

	private static void solve(int testId) {
		int n = sc.nextInt(), m = sc.nextInt();
		int[] a = new int[n];
		int[][] g = new int[n][n];
		Map<Integer, List<Integer>> adjs = new HashMap<>(n);
		int[][] edges = new int[m][2];
		for (int i = 0; i < n - 1; ++i) {
			a[i + 1] = sc.nextInt();
		}
		for (int i = 0; i < m; ++i) {
			int u = sc.nextInt(), v = sc.nextInt();
			--u; --v;
			g[u][v] = g[v][u] = -1;
			adjs.putIfAbsent(u, new ArrayList<>()); adjs.get(u).add(v);
			adjs.putIfAbsent(v, new ArrayList<>()); adjs.get(v).add(u);
			edges[i][0] = u;
			edges[i][1] = v;
		}

		int count = 1;
		int[] visited = new int[n];
		Arrays.fill(visited, -1);
		visited[0] = 0;
		while (count < n) {
			int tmp = 0;
			for (int u = 0; u < n; ++u) {
				if (visited[u] < 0 && a[u] == -count) {
					for (int v : adjs.get(u)) {
						if (visited[v] >= 0 && g[u][v] < 0) {
							int x = count - visited[v];
							g[u][v] = g[v][u] = x;
							visited[u] = count;
							break;
						}
					}
					++tmp;
				}
			}
			count += tmp;
		}

		sb.append("Case #").append(testId).append(":");
		for (int i = 0; i < m; ++i) {
			sb.append(' ');
			int u = edges[i][0], v = edges[i][1];
			if (g[u][v] > 0) sb.append(g[u][v]);
			else sb.append(10000);
		}
		sb.append('\n');
	}

	public static void main(String[] args) {
		int numTest = sc.nextInt();
		for (int i = 1; i <= numTest; ++i) solve(i);
		System.out.print(sb.toString());
	}

}
