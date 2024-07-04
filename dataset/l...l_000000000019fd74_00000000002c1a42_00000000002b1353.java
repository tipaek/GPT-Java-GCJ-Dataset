import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

	static int N;
	static long[][] P;
	static long INF = 1_000_000_001L;
	static StringBuffer buf = new StringBuffer();
	static ArrayList<int[]>[] sols = new ArrayList[1001];
	static HashSet<String> rep;
	static int sf = 0;
	static int md = 12;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			buf.append("Case #" + t + ":");
			solve();
		}
		System.out.print(buf);
	}	
	
	static void build_T() {
		P = new long[500][500];
		for (int i = 0; i < P.length; i++)
			Arrays.fill(P[i], INF);
		P[0][0] = 1;
		for (int i = 1; i < P.length; i++) {
			P[i][0] = 1;
			P[i][i] = 1;
			for (int j = 1; j < i; j++) 
				P[i][j] = P[i-1][j-1] + P[i-1][j];
		}
	}
	
	static void solve() {
		if (N<=501) solve_easy();
		else if (N<=1000) solve_med();
	}	
	
	static int[][] path;
	static int lp;
	
	static void solve_med() {
		if (sols[N]!=null) {
			report(sols[N]);
			return;
		}
		if (path==null) path = new int[500][2];
		if (P==null) build_T();
		rep = new HashSet<String>();
		path[0][0] = 0;
		path[0][1] = 0;
		lp = 1;
		rep.add("0$0");
		rec(0, 0, 1, 0);
		report(sols[N]);
	}
	
	static void rec(int r, int c, int sum, int d) {
		if  (d>md) return;
		if (lp>500) return;
		if (sum>1000) return;
		if (sols[sum]==null) {
			sf++;
			sols[sum] = path_list();
		}
		int x, y; 
		//
		if (r>0 && c>0 && !rep.contains((r-1)+"$"+(c-1)) && P[r-1][c-1]<INF) {
			x = r-1;
			y = c-1;
			path[lp][0] = x;
			path[lp][1] = y;
			lp++;
			rep.add((x)+"$"+(y));
			rec(x, y, sum+(int)(P[x][y]), d+1);
			lp--;
			rep.remove((x)+"$"+(y));
		} 
		//
		if (r>0 && c<r && !rep.contains((r-1)+"$"+(c)) && P[r-1][c]<INF) {
			x = r-1;
			y = c;
			path[lp][0] = x;
			path[lp][1] = y;
			lp++;
			rep.add((x)+"$"+(y));
			rec(x, y, sum+(int)(P[x][y]), d+1);
			lp--;
			rep.remove((x)+"$"+(y));
		} 
		//
		if (c>0 && !rep.contains((r)+"$"+(c-1)) && P[r][c-1]<INF) {
			x = r;
			y = c-1;
			path[lp][0] = x;
			path[lp][1] = y;
			lp++;
			rep.add((x)+"$"+(y));
			rec(x, y, sum+(int)(P[x][y]), d+1);
			lp--;
			rep.remove((x)+"$"+(y));
		} 
		//
		if (c<r && !rep.contains((r)+"$"+(c+1)) && P[r][c+1]<INF) {
			x = r;
			y = c+1;
			path[lp][0] = x;
			path[lp][1] = y;
			lp++;
			rep.add((x)+"$"+(y));
			rec(x, y, sum+(int)(P[x][y]), d+1);
			lp--;
			rep.remove((x)+"$"+(y));
		} 
		//
		//
		if (r<499 && !rep.contains((r+1)+"$"+(c)) && P[r+1][c]<INF) {
			x = r+1;
			y = c;
			path[lp][0] = x;
			path[lp][1] = y;
			lp++;
			rep.add((x)+"$"+(y));
			rec(x, y, sum+(int)(P[x][y]), d+1);
			lp--;
			rep.remove((x)+"$"+(y));
		} 
		//
		if (r<499 && !rep.contains((r+1)+"$"+(c+1)) && P[r+1][c+1]<INF) {
			x = r+1;
			y = c+1;
			path[lp][0] = x;
			path[lp][1] = y;
			lp++;
			rep.add((x)+"$"+(y));
			rec(x, y, sum+(int)(P[x][y]), d+1);
			lp--;
			rep.remove((x)+"$"+(y));
		} 
		
	}

	static ArrayList<int[]> path_list() {
		ArrayList<int[]> L = new ArrayList<>();
		for (int i = 0; i < lp; i++) L.add(new int[] {path[i][0]+1, path[i][1]+1});
		return L;
	}
	
	static void solve_easy() {
		ArrayList<int[]> sol = new ArrayList<>();
		int k, r;
		if (N==1) sol.add(new int[] {1,1});
		else if (N==2) {
			sol.add(new int[] {1,1});
			sol.add(new int[] {2,1});
		}
		else if (N==3) {
			sol.add(new int[] {1,1});
			sol.add(new int[] {2,1});
			sol.add(new int[] {3,1});
		}else {
			sol.add(new int[] {1,1});
			sol.add(new int[] {2,1});
			sol.add(new int[] {3,2});
			k = 4;
			r = 3;
			for (; k < N; k++) {
				sol.add(new int[] {r, r});
				r++;
			}
		}
		report(sol);
	}
	
	static void report(ArrayList<int[]> sol) {
		int n = sol.size();
		for (int i = 0; i < n; i++) {
			int[] x = sol.get(i);
			buf.append("\n" + x[0] + " " + x[1]);
		}
		buf.append("\n");
	}
}