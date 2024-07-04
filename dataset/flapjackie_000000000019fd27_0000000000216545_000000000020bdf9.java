import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for (int ca = 1 ; ca <= T ; ca++) {
			int n = sc.nextInt();
			A[] as = new A[n];
			char[] ans = new char[n];
			boolean bad = false;
			for (int i = 0 ;  i < n ;i++) {
				as[i] = new A(sc.nextInt(), sc.nextInt(), i);
			}
			
			Arrays.sort(as);
			int[] done = new int[2];
			
			for (int i = 0 ; i < n ; i++) {
				if (as[i].s >= done[0]) {
					done[0] = as[i].e;
					ans[as[i].n] = 'C';
				} else if (as[i].s >= done[1]) {
					done[1] = as[i].e;
					ans[as[i].n] = 'J';
				} else {
					bad = true;
				}
			}
			
			if (bad) {
				out.printf("Case #%d: IMPOSSIBLE\n", ca);
			} else {
				out.printf("Case #%d: %s\n", ca, new String(ans));
			}
		}
		out.close();
	}
	
	static class A implements Comparable<A>{
		int s, e, n;
		
		public A (int ss, int ee, int nn) {
			s=ss;e=ee;n=nn;
		}

		@Override
		public int compareTo(A o) {
			return s-o.s;
		}
		
		
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
