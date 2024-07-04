import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			sb.append("Case #"+test+": "); test++;
			int n = sc.nextInt();
			String[] ss = new String[n];
			ArrayList<String> starters = new ArrayList<String>();
			ArrayList<String> enders = new ArrayList<String>();
			ArrayList<String> middles = new ArrayList<String>();
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				String[] sp = s.split("\\*");
				for(int j = 0; j < sp.length; j++) {
					if(j == 0) {
						if(s.charAt(0) != '*') {
							starters.add(sp[j]);
						}
						else {
							middles.add(sp[j]);
						}
					}
					if(j == sp.length-1) {
						if(s.charAt(s.length()-1) != '*') {
							enders.add(sp[j]);
						}
						else if(j != 0) {
							middles.add(sp[j]);
						}
					}
					if(j != 0 && j != sp.length-1) {
						middles.add(sp[j]);
					}
				}
			}
			int N = 10000;
			char[] res = new char[N];
			boolean invalid = false;
			int currind = 0;
			for(String s: starters) {
				for(int i = 0; i < s.length(); i++) {
					if(res[i] == 0) {
						res[i] = s.charAt(i);
					}
					else if(res[i] != s.charAt(i)) invalid = true;
				}
				currind = Math.max(currind, s.length());
			}
			int lim = N;
			for(String s: enders) {
				for(int i = s.length()-1; i >= 0; i--) {
					if(res[N - s.length() + i] == 0) {
						res[N - s.length() + i] = s.charAt(i);
					}
					else if(res[N - s.length() + i] != s.charAt(i)) invalid = true;
				}
				lim = Math.min(lim, N - s.length());
			}
			for(String s: middles) {
				for(int i = 0; i < s.length(); i++) {
					res[i + currind] = s.charAt(i); 
				}
				currind += s.length();
			}
			for(int i = currind; i < lim; i++) {
				res[i] = 'A';
			}
			if(invalid) sb.append("*\n");
			else {
				sb.append(res); sb.append("\n");
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
	}
	
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
