import java.util.*;
import java.io.*;
public class Solution {
	static int r, k;
	static PrintWriter out;
	static long[][] pasTri;
	static long[][] cum;
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		out = new PrintWriter(System.out);
		pasTri = new long[501][501];
		pasTri(500,500);
		
		cum = new long[500][6];
		
		for (int i = 0 ; i < cum.length ; i++) {
			for (int j = 0 ; j < cum[0].length ; j++) {
				cum[i][j] = pasTri[i][j];
			}
		}
		
		for (int i = 0 ; i < cum.length ; i++) {
			for (int j = 1 ; j < cum[0].length ; j++) {
				cum[i][j] += cum[i][j-1];
			}
		}
		/*
		for (int i = 0 ; i < cum.length ; i++) {
			for (int j = 0 ; j < cum[0].length ; j++) {
				out.print(cum[i][j] + " ");
			}
			out.println();
		}
		*/
		
		int T = sc.nextInt();
		for (int ca = 1 ; ca <= T ; ca++) {
			long n = sc.nextInt();
			
			long sum = 1;
			out.printf("Case #%d:\n", ca);
			r=0;k=0;
			print(r,k);
			
			
			if (n== 2) {
				print(r+1,k+1);
				continue;
			}
			
			if (n <= 1000) {
				r++;
				k++;
				while (n >= sum+pasTri[r][k]+1) {
					sum += pasTri[r][k];
					print(r,k);
					r++;
				}
				r--;
				k--;
				
				while(n > sum) {
					sum += pasTri[r][k];
					print(r,k);
					r++;
				}
				
				continue;
			}
			

			while (r < 5) {
				r++;
				k++;
				sum += pasTri[r][k];
				print(r,k);
			}
			r++;
			
			while (sum < n) {
				if (n >= cum[r][k]+sum) {
					sum += pasTri[r][k];
					print(r,k);
					r++;
				} else {
					r--;
					k--;
				}
			}
		}
		out.close();
	}

	static void print(int r, int k) {
		out.println((r+1) + " " + (k+1));
	}
	
	static long pasTri(int n, int k) {
		for (int i = 0 ; i <= n ; i++) {
			pasTri[i][0] = 1;
			pasTri[i][i] = 1;
		}
		
		for (int i = 2 ; i <= n ; i++) {
			for (int j = 1 ; j < i ; j++) {
				pasTri[i][j] = pasTri[i-1][j-1] + pasTri[i-1][j];
			}
		}
		/*
		for (int i = 0 ; i < 20 ; i++) {
			for (int j = 0 ; j < 20 ; j++) {
				System.out.print(pasTri[i][j] + "\t");
			}
			
			System.out.println();
		}*/
		
		return pasTri[n][k];
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