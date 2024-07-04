import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class Solution {
	FastScanner file;
	
	StringBuilder res;
	String[] p;
	
	public boolean cmp(String a, String b) {
		int idx_a = a.indexOf('*');
		int idx_b = b.indexOf('*');
		
		int ia = a.lastIndexOf('*');
		int ib = b.lastIndexOf('*');
		
		for (int i = 0; i < Math.min(idx_a, idx_b); i++) {
			if (a.charAt(i) != b.charAt(i)) return false;
		}
		for (int i = Math.max(ia, ib) + 1; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) return false;
		}
		
		return true;
	}
	
	public String solve() throws Exception {
		
		int N = file.nextInt();
		
		p = new String[N];
		int[] spot = new int[N];
		int max_length = -1;
		res = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			p[i] = new String(file.next());
			max_length = Math.max(max_length, p[i].length());
		}
		
		boolean works = false;
		
		for (int i = 0; i < N; i++) {
			int j = p[i].indexOf("*");
			spot[i] = j;
			
			while (p[i].length() < max_length) {
				p[i] = p[i].substring(0,j) + "*" + p[i].substring(j);
			}
		}
		
		while (!works) {
			works = true;
			
			if (p[0].length() > 1000) return "*";
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (!cmp(p[i], p[j])) {
						works = false;
					}
					if (!works) break;
				}
				if (!works) break;
			}
			
			if (!works) {
				for (int i = 0; i < N; i++) {
					int j = spot[i];
					p[i] = p[i].substring(0,j) + "*" + p[i].substring(j);
				}
				continue;
			}
			
			for (int i = 0; i < p[0].length(); i++) {
				char c = '*';
				for (int j = 0; j < N; j++) {
					if (p[j].charAt(i) != '*') {
						c = p[j].charAt(i);
					}
				}
				res.append(c);
			}
			
			String ans = res.toString();
			ans=  ans.replace("*","A");
			
			if (ans.length() > 1e4) {
				return "*";
			}
			
			return ans;
		}
		
		return "*";
	}
	
	public void run() throws Exception {
		file = new FastScanner();
		
		int T = file.nextInt();
		
		for (int test = 1; test <= T; test++) {
			System.out.println("Case #" + test + ": " + solve());
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
	
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
}