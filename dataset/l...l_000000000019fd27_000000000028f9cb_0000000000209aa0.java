import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K;
	static int[][] M;
	static boolean[][] r;
	static boolean[][] c;
	static boolean found;
	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			M = new int[N][N];
			r = new boolean[N][N];
			c = new boolean[N][N];
			found = false;
			buf.append("Case #" + t + ": ");
			rec(0, 0);
			if (!found) buf.append("IMPOSSIBLE\n");
		}
		System.out.print(buf);
	}
	
	static void report() {
		buf.append("POSSIBLE\n");
		for (int i = 0; i < N; i++) {
			buf.append(M[i][0]);
			for (int j = 1; j < N; j++) {
				buf.append(" " + M[i][j]);
			}
			buf.append("\n");
		}
	}
	
	static void check() {
		int t = 0;
		for (int i = 0; i < N; i++) t+=M[i][i];
		if (t==K) {
			report();
			found = true;
		}
	}
	
	static void rec(int i, int j) {
		if (found) return;
		if (i==N) {
			check();
			return;
		}
		if (j==N) {
			rec(i+1, 0);
			return;
		}
		for(int k=1;k<=N;k++) {
			if (found) return;
			if (r[i][k-1]) continue;
			if (c[j][k-1]) continue;
			r[i][k-1] = true;
			c[j][k-1] = true;
			M[i][j] = k;
			rec(i,j+1);
			r[i][k-1] = false;
			c[j][k-1] = false;
		}		
	}
}
