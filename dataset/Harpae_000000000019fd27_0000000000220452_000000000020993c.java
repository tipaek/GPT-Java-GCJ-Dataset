import java.util.*;
import java.io.*;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			int N = in.nextInt();
			int v[][] = new int[N][N];
			for(int i = 0 ;i < N; i++)
				for(int j = 0; j < N; j++)
					v[i][j] = in.nextInt();
			
			int sum = 0;
			int rows = 0;
			int cols = 0;
			for(int i = 0; i < N; i++) sum += v[i][i];
			
			for(int r = 0; r < N; r++) {
				boolean h[] = new boolean[N+1];
				for(int c = 0; c < N; c++) {
					if(h[v[r][c]]) { rows++; break;}
					else h[v[r][c]] = true;
				}
			}
			for(int c = 0; c < N; c++) {
				boolean h[] = new boolean[N+1];
				for(int r = 0; r < N; r++) {
					if(h[v[r][c]]) {cols++; break;}
					else h[v[r][c]] = true;
				}
			}
			
			
			out.println("Case #"+runs+": "+sum+" "+rows+" "+cols);
		}
		
		
		out.close();
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
