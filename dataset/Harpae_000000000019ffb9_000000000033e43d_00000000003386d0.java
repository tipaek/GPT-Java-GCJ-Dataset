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

			answer = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					solve(dir[i][j]);
				}
			}
			
//			int res = 1;
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					if(i == j) continue;
//					res = Math.max(res, solve(dir[i][j]));
//				}
//			}
			out.println("Case #"+runs+": "+answer);
		}
	
		out.close();
	}
	
	static void solve(Vec dir) {
		
		to = new int[N];
		Vec curTo[] = new Vec[N];
		Arrays.fill(to, -1);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(goesTo(i, j, dir)) {
					Vec d = vs[j].sub(vs[i]);
					if(curTo[i] == null || curTo[i].mag2() > d.mag2()) {
						to[i] = j;
						curTo[i] = d;
					}
				}
			}
		}
		
//		System.out.println(dir);
//		System.out.println(Arrays.toString(to));
		warp = new int[N];
		Arrays.fill(warp, -1);
		dfs(0);
		
	}
	
	
	static void go(int cur) {
		boolean vis[] = new boolean[N];
		if(warp[cur] == -1) return;
		
		vis[cur] = true;
		cur = warp[cur];
		
		for(int iter = 0; iter < 3*N + 10; iter++) {
			vis[cur] = true;
			if(to[cur] == -1) break;
			
			vis[to[cur]] = true;
			if(warp[to[cur]] != -1) {
				vis[warp[to[cur]]] = true;
				cur = warp[to[cur]];
			}
			else break;
		}
		
		int res = 0;
		for(boolean bb : vis) if(bb)res++;
		answer = Math.max(answer, res);
	}
	
	static void dfs(int id) {
		if(id >= N) {
			for(int start = 0; start < N; start++) {
				go(start);
			}
		}
		else {
			dfs(id+1); // Already picked or do nothing with this guy
			
			if(warp[id] == -1) {
				// pick something
				for(int i = 0; i < N; i++) {
					if(i == id || warp[i] != -1) continue;
					warp[id] = i;
					warp[i] = id;
					dfs(id+1);
					warp[id] = -1;
					warp[i] = -1;
				}
			}
		}
	}
	
	static int to[];
	static int answer = 0;
	static int warp[];
	
	
	
	
	
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
		public long mag2() {
			return x*x + y*y;
		}
		public int q() {
			if(y >= 0) return x >= 0 ? 0 : 1;
			return x >= 0 ? 3 : 2;
		}
		@Override
		public String toString() {
			return "("+x+", "+y+")";
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
