import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for (int ca = 1 ; ca <= T ; ca++) {
			String str = sc.next();
			StringBuilder sb = new StringBuilder();
			int depth = 0;
			
			for (int i = 0 ; i < str.length() ; i++) {
				while (depth < str.charAt(i) - '0') {
					sb.append('(');
					depth++;
				}
				
				while (depth > str.charAt(i) - '0') {
					sb.append(')');
					depth--;
				}
				
				sb.append(str.charAt(i));
			}
			
			while (depth > 0) {
				sb.append(')');
				depth--;
			}
			
			out.printf("Case #%d: %s\n", ca, sb.toString());
		}
		out.close();
	}

/*
1
052492234	
 */
	
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
