import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			int[] nodes = new int[c];
			for(int j=1; j<c; j++) {
				nodes[j] = -sc.nextInt();
			}
			ArrayList<Edge>[] adj = new ArrayList[c];
			for(int j=0; j<c; j++) {
				adj[j] = new ArrayList();
			}
			ArrayList<Edge> ans = new ArrayList();
			for(int j=0; j<d; j++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				Edge e = new Edge(u,v);
				adj[u-1].add(e);
				adj[v-1].add(e);
				ans.add(e);
			}
			int target = 1;
			while(target < c-1) {
				int tmp = bfs(1, adj, new int[c], target, nodes, target);
				target += tmp;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Case #");
			sb.append(i);
			sb.append(": ");

			for(Edge e: ans) {
				if(e.value < 0) {
					sb.append(1000000+" ");
				} else {
					sb.append(e.value+" ");
				}
			}
			System.out.println(sb);
		}
	}
	
	public static int bfs(int start, ArrayList<Edge>[] adj, int[] visit, int target, int[] nodes, int value) {
		visit[start-1] = 1;
		int ans = 0;
		for(Edge e: adj[start-1]) {
			int v = e.get(start);
			if(visit[v-1] == 0 && nodes[v-1] <target) {
				ans += bfs(v, adj, visit, target, nodes, value-e.value);
			}
			if(visit[v-1] == 0 && nodes[v-1] == target) {
				ans += 1;
				e.value = value;
			}
		}
		return ans;
	}
}

class Edge {
	int u;
	int v;
	int value = -1;
	public Edge(int u, int v) {
		this.u = u;
		this.v =v;
	}
	
	public int get(int u) {
		if(this.u == u) {
			return v;
		}
		return u;
	}
}
