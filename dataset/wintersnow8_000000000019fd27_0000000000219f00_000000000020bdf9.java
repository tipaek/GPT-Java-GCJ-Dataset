import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	public class Pair implements Comparable<Pair> {
		int start, end, ind;
		Character val = 'A';
		public Pair(int a, int b, int c) {
			start = a;
			end = b;
			ind = c;
		}
		public void value(char a) {
			val = a;
		}
		public int compareTo(Pair a) {
			if (start == a.start) return end-a.end;
			return start-a.start;
		}
		public String toString() {
			return ind + " " +  start + " " +end + " " + val;
		}
	}
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int t = sc.nextInt();
		for (int q = 1; q<=t; q++ ) {
			int n = sc.nextInt();
			char[] choice = new char[n];
			String ans = "";
			boolean print = false;
			ArrayList<Pair> pairs = new ArrayList<Pair>();
			for (int i = 0; i<n; i++ ) {
				pairs.add(new Pair(sc.nextInt(), sc.nextInt(), i));
			}
			Collections.sort(pairs);
			pairs.get(0).value('C');
			int end = pairs.get(0).end;
			int start = Integer.MAX_VALUE;
			for (int i = 1; i<pairs.size(); i++ ) {
				if (pairs.get(i).start<end) {
					start = Math.min(start, i);
				}
				else {
					end = pairs.get(i).end;
					pairs.get(i).value('C');
				}
			}
			if (start!=Integer.MAX_VALUE) {
				end = pairs.get(start).end;
				pairs.get(start).value('J');
				for (int i = start; i<pairs.size(); i++) {
					if (pairs.get(i).val == 'C') ;
					else if (pairs.get(i).start>=end) {
						end = pairs.get(i).end;
						pairs.get(i).value('J');
					}
				}
			}
		//	System.out.println(pairs);
			for (int i = 0; i<n; i++ ) {
				if (pairs.get(i).val == 'A') {
					ans = "IMPOSSIBLE";
					print = true;
					break;
				}
				choice[pairs.get(i).ind] = pairs.get(i).val;
			}
			if (!print) {
				for (int i = 0; i<n; i++ ) {
					ans+=choice[i];
				}
			}
			System.out.println("Case #" + q + ": " + ans);
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