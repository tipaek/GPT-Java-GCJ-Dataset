import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static StringBuffer buf = new StringBuffer();
	static int N;
	static int[] S, E;
	static ArrayList<Integer>[] adj;
	static int[] color;
	static boolean ok;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			S = new int[N];
			E = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				S[i] = Integer.parseInt(st.nextToken());
				E[i] = Integer.parseInt(st.nextToken());
			}
			buf.append("Case #" + t + ": ");
			solve();
		}
		System.out.print(buf);
	}
	
	static void solve() {
		make_graph();
		color = new int[N];
		Arrays.fill(color, -1);
		ok = true;
		for (int i = 0; i < N; i++) { 
			if (color[i]==-1) {
				dfs(i, 0);
			}
			if (!ok) break;
		}
		if (!ok) {
			buf.append("IMPOSSIBLE\n");
			return;
		}
		StringBuffer sol = new StringBuffer();
		for (int i = 0; i < N; i++) {
			if (color[i]==0) sol.append('C');
			else sol.append('J');
		}
		buf.append(sol.toString() + '\n');
	}
	
	static void dfs(int u, int col) {
		if (color[u]!=-1) {
			if (color[u]!=col) ok = false;
			return;
		}
		color[u] = col;
		for (int i = 0; i < adj[u].size(); i++) {
			dfs(adj[u].get(i), (col+1)%2);
			if(!ok) return;
		}
	}
	
	static void make_graph() {
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) 
			for (int j = i+1; j < N; j++) 
				if (intersects(S[i], E[i], S[j], E[j])) {
					adj[i].add(j);
					adj[j].add(i);
				}				
	}
	
	static boolean intersects(int a, int b, int c, int d) {
		if (b<=c) return false;
		if (d<=a) return false;
		return true;
	}
}
