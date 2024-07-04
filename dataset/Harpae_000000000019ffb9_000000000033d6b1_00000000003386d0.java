import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);

	static int N;
	static Vec vs[];
	static Vec dir[][];
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			N = in.nextInt();
			vs = new Vec[N];
			for(int i = 0; i < N; i++) {
				vs[i] = new Vec(in.nextLong(), in.nextLong());
			}
			
			dir = new Vec[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dir[i][j] = vs[j].sub(vs[i]);
				}
			}
			
			int res = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					res = Math.max(res, solve(dir[i][j]));
				}
			}
			out.println("Case #"+runs+": "+res);
		}
	
		out.close();
	}
	
	static int solve(Vec dir) {
		int to[] = new int[N];
		Arrays.fill(to, -1);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(goesTo(i, j, dir)) to[i] = j;
			}
		}
		
		int res = 0;
		boolean vis[][][] = new boolean[2][N][1<<N];
		ArrayDeque<State> q = new ArrayDeque<State>();
		
		for(int st = 0; st < N; st++) {
			q.add(new State(0, st, 1<<st));
			vis[0][st][1<<st] = true;
		}
		
		while(!q.isEmpty()) {
			State v = q.poll();
			res = Math.max(res, Integer.bitCount(v.mask));
			if(to[v.n] != -1 && (v.mask & (1<<to[v.n])) == 0) {
				int nm = v.mask | (1<<to[v.n]);
				if(!vis[0][to[v.n]][nm]) {
					q.add(new State(0, to[v.n], nm));
					vis[0][to[v.n]][nm] = true;
				}
			}
			
			// branch to something
			if(v.branched == 0) {
				for(int b = 0; b < N; b++) {
					if((v.mask & (1<<b)) > 0) continue;
					
					int nb = 1;
					int nn = b;
					int nm = v.mask | (1<<b);
					if(vis[nb][nn][nm]) continue;
					vis[nb][nn][nm] = true;
					q.add(new State(nb,nn,nm));					
				}
			}
			
		}
		
		
		return res;
	}
	
	static class State {
		int n, mask, branched;
		public State(int bb, int nn, int mm) {
			branched = bb;
			n=nn;
			mask=mm;
		}
	}
	
	static boolean goesTo(int a, int b, Vec d) {
		return dir[a][b].cross(d) == 0 && dir[a][b].q() == d.q();
	}
	
	static class Vec {
		long x, y;
		public Vec(long xx, long yy) {
			x=xx;
			y=yy;
		}
		public Vec add(Vec o) { return new Vec(x+o.x, y+o.y);}
		public Vec sub(Vec o) { return new Vec(x-o.x, y-o.y);}
		public long cross(Vec o) { return x*o.y - y*o.x;}
		
		public int q() {
			if(y >= 0) return x >= 0 ? 0 : 1;
			return x >= 0 ? 3 : 2;
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
