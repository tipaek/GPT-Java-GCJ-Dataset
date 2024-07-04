import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		int t = sc.nextInt();
		long a = sc.nextLong(), b = sc.nextLong();
		int lp = 0;
		while (t-->0) {
			lp++;
			boolean done = false;
			for (int i=-5;i<=5 ;i++ ) {
				for (int j=-5;j<=5 ;j++ ) {
					System.out.println(i+" "+j);
					System.out.flush();
					String s = sc.nextLine();
					if(s.equals("CENTER")){
						done = true;
						break;
					}
				}
				if(done) break;
			}
		}
	}
	static class Pair{
		long  b;
		long a;
		int p;
		char s;
		Pair prev = null;
		public Pair(long c, long d, int p1, char s1, Pair p2){
			a = c;
			b = d;
			p = p1;
			s = s1;
			prev = p2;
		}
		public boolean equals(Pair p){
			return (b==p.b && a==p.a);
		}
	}
	static int gcd(int a, int b){
	    if(b==0) return a;
	    return gcd(b,a%b);
	}
	static long power(long a, long b, long c){
	    if(b==0) return 1L;
	    if(b==1) return a;
	    long temp = power(a, b/2, c);
	    if(b%2==0) return (temp*temp)%c;
	    else return (((temp*temp)%c)*a)%c;
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