import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for (int ca = 1 ; ca <= T ; ca++) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int trace = 0;
			for (int i = 0 ; i < n ; i++) {
				trace += board[i][i];
			}
			
			int r = 0;
			int c = 0;
			for (int i = 0 ; i< n ; i++) {
				HashSet<Integer> seen = new HashSet<>();
				for (int j = 0 ; j< n ;j++) {
					seen.add(board[i][j]);
				}
				
				if (seen.size() != n) {
					r++;
				}
			}
			
			for (int i = 0 ; i< n ; i++) {
				HashSet<Integer> seen = new HashSet<>();
				for (int j = 0 ; j< n ;j++) {
					seen.add(board[j][i]);
				}
				
				if (seen.size() != n) {
					c++;
				}
			}
			
			
			out.printf("Case #%d: %d %d %d\n", ca, trace, r, c);
		}
		out.close();
	}

	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	}

}
