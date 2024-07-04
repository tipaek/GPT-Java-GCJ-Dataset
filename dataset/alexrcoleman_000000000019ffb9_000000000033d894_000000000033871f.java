import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int inf = 1000000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int C = in.nextInt(), D = in.nextInt();
			int[] cs = new int[C];
			for (int i = 1; i < cs.length; i++) {
				cs[i] = in.nextInt();
			}

			ArrayList<Edge>[] adj = new ArrayList[C];
			for (int i = 0; i < C; i++) {
				adj[i] = new ArrayList<>();
			}

			int[] ans = new int[D];
			Arrays.fill(ans, inf);
			for (int i = 0; i < D; i++) {
				int u = in.nextInt() - 1, v = in.nextInt() - 1;
				adj[u].add(new Edge(v, i));
				adj[v].add(new Edge(u, i));
				ans[i] = Math.max(1, Math.abs(cs[u] - cs[v]));
			}

			System.out.printf("Case #%d:", t);
			for (int i = 0; i < D; i++) {
				System.out.print(" " + ans[i]);
			}
			System.out.println();
		}
	}

	static class Edge {
		int v, i;

		public Edge(int v, int i) {
			this.v = v;
			this.i = i;
		}
	}
}
