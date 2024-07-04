import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int C, D;
	static StringBuffer buf = new StringBuffer();
	static int[] K, T;
	static ArrayList<Integer>[] adj;
	static final int INF = 1000000000;
	static boolean[] vis;
	static int[] disc;
	static int[] parent;
	static Vertex[] V;
	static String[] edg;
	static StringTokenizer st;
		
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		int X, u, v;
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(in.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			K = new int[C];
			T = new int[C];
			adj = new ArrayList[C];
			edg = new String[D];
			Arrays.fill(K, INF);
			Arrays.fill(T, INF);
			K[0] = 0;
			T[0] = 0;
			vis = new  boolean[C];
			for (int i = 0; i < C; i++) adj[i] = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i < C; i++) {
				X = Integer.parseInt(st.nextToken());
				if (X>0) T[i] = X;
				else K[i] = -X;
			}
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				u = Integer.parseInt(st.nextToken())-1;
				v = Integer.parseInt(st.nextToken())-1;
				adj[u].add(v);
				adj[v].add(u);
				edg[i] = u + " " + v;
			}
			buf.append("Case #" + t + ":");
			solve();
		}
		System.out.print(buf);
	}	
	
	static int time = 0;
	
	static void solve() {
		vis = new  boolean[C];
		disc = new  int[C];
		parent = new  int[C];
		Arrays.fill(disc, INF);
		Arrays.fill(parent, -1);
		//rec(0);
		create();
	}
		
	static void create() {
		V = new Vertex[C];
		for (int i = 0; i < C; i++)
			V[i] = new Vertex(i, K[i], T[i], disc[i]);
		Arrays.sort(V);
		time = 0;
		int added = 1;
		int cur = 1;
		while (cur<C) {
			if (V[cur].k<added) {
				V[cur].t = time;
				added++;
				cur++;
				continue;
			}
			time++;
			V[cur].t = time;
			added++;
			cur++;
		}
		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(edg[i]);
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Math.abs(tD(u)-tD(v));
			if (t==0) t=1;
			buf.append(" " + t);
		}
		buf.append("\n");
	}
	
	static int tD(int id) {
		for (int i = 0; i < C; i++) {
			if (V[i].id == id) return V[i].t;
		}
		return -1;
	}
	
	static int rec(int u) {
		if (vis[u]) return INF + 1;
		vis[u] = true;
		disc[u] = time++;
		int bestK = K[u];
		for (int i = 0; i < adj[u].size(); i++) {
			int v = adj[u].get(i);
			if (vis[v]) continue;
			parent[v] = u;
			bestK = Math.min(bestK, rec(v) - 1);
		}
		if (bestK >= INF/2) {
			K[u] = INF;
			return INF+1;
		}
		else K[u] = bestK;
		return K[u];
	}
	
	static class Vertex implements Comparable<Vertex> {
		int id, k, t, disc; 
		public Vertex(int id, int k, int t, int disc) {
			this.id = id;
			this.k = k;
			this.t = t;
			this.disc = disc;
		}
		public int compareTo(Vertex other) {
			if (this.k < other.k) return -1;
			if (this.k > other.k) return 1;
			if (this.disc < other.disc) return -1;
			if (this.disc > other.disc) return 1;
			return 0;
		}
	}
}