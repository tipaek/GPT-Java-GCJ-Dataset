import java.util.*;
import java.io.*;
public class Solution {
	static boolean good;
	static int n;
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for (int ca = 1 ; ca <= T ; ca++) {
			good = true;
			n = sc.nextInt();
			String[] words = new String[n];
			
			for (int i = 0 ; i < n ; i++) {
				words[i] = sc.next();
			}
			

			String beginning = getBeginning(words);
			String end = getEnd(words);
			
			StringBuilder sb = new StringBuilder();
			
			if(!good) {
				beginning = "";
				end = "";
				sb = new StringBuilder();
				sb.append("*");
			} else {
				for (int i = 0 ; i < n ; i++) {
					int lastStar = 0;
					
					for (int j = 0 ; j < words[i].length() ; j++) {
						char c = words[i].charAt(j);
						if (c=='*') lastStar=j;
					}
					int start = words[i].indexOf('*');
					for (int j = start ; j < lastStar ; j++) {
						char c = words[i].charAt(j);
						if (c == '*') continue;
						
						sb.append(words[i].charAt(j));
					}
				}
			}
			out.printf("Case #%d: %s\n", ca, beginning + sb.toString() + end);
		}
		out.close();
	}
	
	static String getBeginning(String[] words) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < words[i].length() ; j++) {
				char c = words[i].charAt(j);
				if (c== '*') break;
				
				if (sb.length() > j) {
					if (c != sb.charAt(j)) {
						good = false;
					}
				} else {
					sb.append(c);
				}
			}
		}
		
		return sb.toString();
	}
	
	static String getEnd(String[] words) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = words[i].length()-1 ; j >= 0; j--) {
				char c = words[i].charAt(j);
				if (c== '*') break;
				
				if (sb.length() > words[i].length()-j-1) {
					if (c != sb.charAt(sb.length()-1 - (words[i].length()-1-j))) {
						good = false;
					}
				} else {
					sb.insert(0,c);
				}
			}
		}
		
		return sb.toString();
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