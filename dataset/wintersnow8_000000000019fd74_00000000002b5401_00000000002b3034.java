import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int test = sc.nextInt();
		for (int q = 0; q<test; q++) {
			int n = sc.nextInt();
			String fro = "";
			String back = "";
			boolean ok = true;
			for (int i = 0; i<n; i++ ) {
				String s = sc.next();
				String sf = s.substring(0,s.indexOf('*'));
				String sb = s.substring(s.indexOf('*')+1);
				if (sf.length()>=fro.length() && sf.substring(sf.length()-fro.length()).equals(fro)) {
					fro = sf;
				}
				else if (fro.length()>=sf.length() && fro.substring(fro.length()-sf.length()).equals(sf)) {
					;
				}
				else ok = false;
				if (sb.length()>=back.length() && sb.substring(sb.length()-back.length()).equals(back)) {
					back = sb;
				}
				else if (back.length()>=sb.length() && back.substring(back.length()-sb.length()).equals(sb)) {
					;
				}
				else ok = false;
			}
			if (!ok) System.out.println("Case #" + (q+1)+": *");
			else {
				//System.out.println("Case #" + (q+1) + ": " + fro + back );
				int bstart = -1;
				boolean ok1 = false;
				for (int i = fro.length()-1; i>=0; i-- ) {
					if (fro.charAt(i) == back.charAt(0)) {
						if (back.substring(0,fro.length()-i).equals(fro.substring(i))) {
							bstart = i;
							ok1 = true;
							break;
						}
					}
				}
				if (!ok1) 	System.out.println("Case #" + (q+1) + ": " + fro + back );
				else System.out.println("Case #" + (q+1) + ": " + fro.substring(0,bstart) + back );
				
			}
		}
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
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
	public static void main (String[] args) throws Exception {
		new Solution().run();
	}
}