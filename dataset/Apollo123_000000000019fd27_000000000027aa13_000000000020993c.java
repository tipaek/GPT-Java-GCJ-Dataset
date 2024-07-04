import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int checkRow(int[][] mat, int row, int N){
		int[] a = new int[N+1];
		for(int i = 0; i<N; i++){
			if(a[mat[row][i]] != 0){
				return 1;
			}
			a[mat[row][i]] = 1;
		}
		return 0;
	}
	
	
	static int checkCol(int[][] mat, int col, int N){
		int[] a = new int[N+1];
		for(int i = 0; i<N; i++){
			if(a[mat[i][col]] != 0){
				return 1;
			}
			a[mat[i][col]] = 1;
		}
		return 0;
	}
	
	
	
	public static void main(String[] args){
		Kattio scan = new Kattio(System.in);
		int T = scan.getInt();
		for(int t = 1; t<=T; t++){
			int N = scan.getInt();
			int[][] mat = new int[N][N];
			
			for(int i = 0; i<N; i++){
				for(int j = 0; j<N; j++){
					mat[i][j] = scan.getInt();
				}
			}
			
			int row = 0;
			int col = 0;
			int trace = 0;
			
			for(int i = 0; i<N; i++){
				row += checkRow(mat, i, N);
				col += checkCol(mat, i, N);
				trace += mat[i][i];
			}
			System.out.println("Case #" + t+ ": " + trace + " " + row + " " + col );
			
			
			
			
			
		}
		
		
		
	}
	private static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}


}
