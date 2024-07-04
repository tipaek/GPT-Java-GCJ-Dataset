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
		    System.out.println("Case #"+lp+": ");
		    if(n<=1000){
		        if(n<=500){
		            for (int i=1;i<=n ;i++ ) System.out.println(i+" 1"); 
		        }
		        else{
		            if(n%2==0){
		                System.out.println("1 1");
		                System.out.println("2 1");
		                System.out.println("3 1");
		                System.out.println("4 1");
		                System.out.println("5 1");
		                System.out.println("6 2");
		                int p = (n-4)/2;
		                for(int i=6;i<=p;i++) System.out.println(i+" 1");
		                System.out.println(p+" 2");
		            }
		            else{
		                System.out.println("1 1");
		                System.out.println("2 1");
		                System.out.println("3 1");
		                System.out.println("4 1");
		                System.out.println("5 2");
		                int p = (n-3)/2;
		                for(int i=5;i<=p;i++) System.out.println(i+" 1");
		                System.out.println((p)+" 2");
		            }
		        }
		    }
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