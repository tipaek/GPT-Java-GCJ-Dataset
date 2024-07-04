import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);
/*
Initially have all edges 1 second.
Start with largest guy of "Takes X seconds to reach me"
Make all his outgoing edges such that each path takes X seconds to reach him
Recalc distances
Do it again for the next guy.

Now some distances may be too large.
Go through and fix them by updating edges from large to small

Now need to handle queries of ("K got it before me)


1
6 9
-1 -2 -5 -3 -4
1 2
1 3
2 3
2 4
2 5
3 5
3 6
4 5
5 6
 */
	
	static final int INF = 2_000_000_000;
	
	static int N,M;
	static ArrayList<Edge> adj[];
	static int ROOT = 0;
	static int qs[];
	static Edge es[];
	
	static final boolean debug = true;
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			N = in.nextInt();
			M = in.nextInt();
			qs = new int[N];
			for(int i = 1; i < N; i++) qs[i] = in.nextInt();
			adj = new ArrayList[N];
			for(int i = 0; i < N; i++) adj[i] = new ArrayList<Edge>();
			es = new Edge[M];
			for(int i = 0; i < M; i++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				Edge e = new Edge(a,b);
				es[i] = e;
				adj[a].add(e);
				adj[b].add(e);
			}
			// Now do second kind
			secondUpdate();
			
			out.print("Case #"+runs+": ");
			for(Edge e : es) out.print(e.d+" ");
			out.println();
		}
	
		out.close();
	}
	
	static int[] distsFromRoot() {
		PriorityQueue<State> pq = new PriorityQueue<State>();
		int dist[] = new int[N];
		Arrays.fill(dist, INF);
		dist[ROOT] = 0;
		pq.add(new State(ROOT, 0));
		while(!pq.isEmpty()) {
			State v = pq.poll();
			if(dist[v.n] != v.d) continue;
			for(Edge e : adj[v.n]) {
				int to = e.to(v.n);
				int nd = v.d + e.d;
				if(dist[to] <= nd) continue;
				dist[to] = nd;
				pq.add(new State(to, nd));
			}
		}
		return dist;
	}

	static void secondUpdate() {
		Integer ord[] = new Integer[N];
		for(int i = 0; i < N; i++) ord[i] = i;
		Arrays.sort(ord,(a,b) -> qs[b] - qs[a]);
		
		int l = 1, r = 1;
		int prevD = 0;
		while(l < N) {
			while(r+1 < N && qs[ord[r+1]] == qs[ord[l]]) r++;
			// handle [l, r]
			
			int dFromRoot[] = distsFromRoot();
			int nextD = prevD+1;
			for(int i = l; i <= r; i++) nextD = Math.max(nextD, dFromRoot[ord[i]]);
						
			for(int i = l; i <= r; i++) {
				int id = ord[i];
				for(Edge e : adj[id]) {
					int cur = dFromRoot[e.to(id)] + e.d;
					if(cur < nextD) e.d += (nextD-cur);
				}
			}
			prevD = nextD;
			
			l = r+1;
			r = l;
		}
	}
	
	static class Edge {
		int a, b, d;
		public Edge(int aa, int bb) {
			a=aa;
			b=bb;
			d=1;
		}
		public int to(int x) { return a^b^x;}
		@Override
		public String toString() {
			return "["+a+"-"+b+" d="+d+"]";
		}
	}
	
	static class State implements Comparable<State> {
		int n, d;
		public State(int nn, int dd) {
			n=nn;
			d=dd;
		}
		@Override
		public int compareTo(State o) {
			return d-o.d;
		}
	}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	
}
