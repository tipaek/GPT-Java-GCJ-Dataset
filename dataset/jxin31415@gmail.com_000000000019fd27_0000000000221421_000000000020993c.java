import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Solution {
	static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
    public static void main (String [] args) throws IOException {
	    int T = Integer.parseInt(f.readLine());
	    for(int t = 1; t <= T; t++) {
	    	out.println("Case #" + t + ": " + solve());
	    }
	    
	    out.close();
	    f.close();
	}
	
	public static String solve() throws IOException {
		int N = Integer.parseInt(f.readLine());
		
		int[][] mat = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = 0;
		for(int i = 0; i < N; i++) {
			boolean[] taken = new boolean[N+1];
			for(int j = 0; j < N; j++) {
				if(taken[mat[i][j]]) {
					r++;
					break;
				}
				taken[mat[i][j]] = true;
			}
		}
		int c = 0;
		for(int i = 0; i < N; i++) {
			boolean[] taken = new boolean[N+1];
			for(int j = 0; j < N; j++) {
				if(taken[mat[j][i]]) {
					c++;
					break;
				}
				taken[mat[j][i]] = true;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += mat[i][i];
		}
		return sum + " " + r + " " + c;
	}
}