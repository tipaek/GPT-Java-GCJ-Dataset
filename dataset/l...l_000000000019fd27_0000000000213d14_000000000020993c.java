import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] M;
	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			M = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) 
					M[i][j] = Integer.parseInt(st.nextToken());
			}
			buf.append("Case #" + t + ":");
			solve();
		}
		System.out.print(buf);
	}	
	
	static void solve() {
		int trace = 0, r = 0, c = 0;
		for (int i = 0; i < N; i++) 
			trace += M[i][i];
		for (int i = 0; i < N; i++) 
			if (has_dup(M[i])) r++;
		M = transp(M);
		for (int i = 0; i < N; i++) 
			if (has_dup(M[i])) c++;
		buf.append(" " + trace + " " + r + " " + c +"\n");
	}	
	
	static int[][] transp(int[][] A) {
		int[][] T = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				T[i][j] = A[j][i];
		return T;
	}
	
	static boolean has_dup(int[] A) {
		boolean[] used = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (used[A[i]-1]) return true;
			used[A[i]-1] = true;
		}
		return false;
	}
	
}
