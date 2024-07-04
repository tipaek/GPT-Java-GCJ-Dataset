import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int x = 1; x <= t; ++x) {
			int size = in.nextInt();
			int[] ans = new int[in.nextInt()];
			int a;
			int c;
			List<int[]> l = new ArrayList<>();
			List<int[]> m = new ArrayList<>();
			for (a = 1; a < size; a++) {
				if ((c = in.nextInt()) < 0) {
					l.add(new int[] { a, -c });
				} else {
					m.add(new int[] { a, c });
				}
			}
			int[][][] graph = new int[size][size][];
			for (a = 0; a < ans.length; a++) {
				int u = in.nextInt() - 1, v = in.nextInt() - 1;
				graph[u][v] = graph[v][u] = new int[] { a, 2 };
			}
			Collections.sort(l, (u, v) -> u[1] - v[1]);
			Collections.sort(m, (u, v) -> u[1] - v[1]);
			List<int[]> n = new ArrayList<>();
			n.add(new int[3]);
			a = 0;
			int b = 0;
			while (a < l.size() && b < m.size()) {
				if (l.get(a)[1] <= n.size()) {
					n.add(new int[3]);
					n.get(n.size() - 1)[0] = l.get(a)[0];
					n.get(n.size() - 1)[1] = n.get(n.size() - 2)[2] == l.get(a)[1] ? n.get(n.size() - 2)[1]
							: n.get(n.size() - 2)[1] + 1;
					n.get(n.size() - 1)[2] = l.get(a)[1];
					a++;
				} else {
					n.add(new int[3]);
					n.get(n.size() - 1)[0] = m.get(b)[0];
					n.get(n.size() - 1)[1] = m.get(b)[1];
					n.get(n.size() - 1)[2] = n.get(n.size() - 2)[1] == m.get(b)[1] ? n.get(n.size() - 2)[2]
							: n.size() - 2;
					b++;
				}
			}
			while (a < l.size()) {
				n.add(new int[3]);
				n.get(n.size() - 1)[0] = l.get(a)[0];
				n.get(n.size() - 1)[1] = n.get(n.size() - 2)[2] == l.get(a)[1] ? n.get(n.size() - 2)[1]
						: n.get(n.size() - 2)[1] + 1;
				n.get(n.size() - 1)[2] = l.get(a)[1];
				a++;
			}
			while (b < m.size()) {
				n.add(new int[3]);
				n.get(n.size() - 1)[0] = m.get(b)[0];
				n.get(n.size() - 1)[1] = m.get(b)[1];
				n.get(n.size() - 1)[2] = n.get(n.size() - 2)[1] == m.get(b)[1] ? n.get(n.size() - 2)[2] : n.size() - 2;
				b++;
			}
			int[] check = new int[size];
			for (int i = 0; i < n.size(); i++) {
				for (a = 0; a < size; a++) {
					if (graph[a][n.get(i)[0]] != null) {
						graph[a][n.get(i)[0]][1]--;
						if (graph[a][n.get(i)[0]][1] == 0) {
							ans[graph[a][n.get(i)[0]][0]] = 1;
							if (n.get(i)[1] - check[a] > ans[graph[a][n.get(i)[0]][0]]) {
								ans[graph[a][n.get(i)[0]][0]] = n.get(i)[1] - check[a];
							}
							check[n.get(i)[0]] = n.get(i)[1];
						}
					}
				}
			}
			System.out.print("Case #" + x + ": ");
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}
}