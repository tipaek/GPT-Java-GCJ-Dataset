import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		int t = sc.nextInt();
		int lp = 0;
		while (t-->0) {
		    lp++;
		    int n = sc.nextInt();
		    int[][] a = new int[n][n];
		    int trace = 0;
		    int row = 0;
		    for (int i=0;i<n ;i++ ){
		        boolean[] ok = new boolean[n+1];
		        boolean taken = false;
		        for (int j=0;j<n ;j++ ){
		            int p = sc.nextInt();
		            a[i][j] = p;
		            if(i==j) trace+=p;
		            if(ok[p] && !taken){
		                taken = true;
		                row++;
		            }
		            ok[p] = true;
		        } 
		    }
		    int col = 0;
		    for (int i=0;i<n ;i++ ) {
		        boolean[] ok = new boolean[n+1];
		        for (int j=0;j<n ;j++ ){
		            int p = a[j][i];
		            if(ok[p]){
		                col++;
		                break;
		            }
		            ok[p] = true;
		        } 
		    }
		    System.out.println("Case #"+lp+": "+trace+" "+row+" "+col);
		}
	}
	static int gcd(int a, int b){
	    if(b==0) return a;
	    return gcd(b,a%b);
	}
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int c, int d){
			a = c;
			b = d;
		}
		public int compareTo(Pair p){
		    return a-p.a;
		}
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}
		String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				return null;
			}
		}
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}