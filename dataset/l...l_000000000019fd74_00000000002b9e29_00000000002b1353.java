import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] P;
	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		build_T();
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			buf.append("Case #" + t + ":");
			solve();
		}
		System.out.print(buf);
	}	
	
	static void build_T() {
//		P = new int[501][501];
		
	} 
	
	static void solve() {
		if (N<=501) solve_easy();
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