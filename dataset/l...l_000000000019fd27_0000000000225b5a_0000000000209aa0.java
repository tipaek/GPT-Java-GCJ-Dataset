import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] M;
	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			buf.append("Case #" + t + ": ");
			solve();
		}
		System.out.print(buf);
	}
	
	static void solve() {
		if (K%N!=0) {
			buf.append("IMPOSSIBLE\n");
			return;
		}
		buf.append("POSSIBLE\n");
		if (K >= N*N/2) build_M2();
		else build_M();
		if (K >= N*N/2) {
			int p = K-N*N/2;
			p /= N;
			rotate(p);
		}else {
			int p = K-N;
			p /= N;
			rotate(p);
		}
		report();
	}

	static void report() {
		for (int i = 0; i < N; i++) {
			buf.append(M[i][0]);
			for (int j = 1; j < N; j++) {
				buf.append(" " + M[i][j]);
			}
			buf.append("\n");
		}
	}
	
	static void rotate(int p){
		for (int i = 0; i < p; i++) {
			int[] X = M[i];
			M[i] = M[N-i-1];
			M[N-i-1] = X;
		}
	}
	
	static void build_M2() {
		M = new int[N][N];
		for (int i = 0; i < N; i++) {
			int k = i;
			for (int j = 0; j < N; j++) {
				M[i][j] = (k+j)%N+1;
			}
		}
	}
	
	static void build_M() {
		M = new int[N][N];
		int k = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				M[i][j] = (k+j)%N+1;
			}
			if (k==0) k=N-1;
			else k--;
		}
	}
}