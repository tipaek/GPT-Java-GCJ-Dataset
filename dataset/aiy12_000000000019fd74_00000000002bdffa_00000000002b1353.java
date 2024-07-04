import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class Solution {
	FastScanner file;
	
	public void run() throws Exception {
		file = new FastScanner();
		
		int T = file.nextInt();
		
		for (int test = 1; test <= T; test++) {
			System.out.println("Case #" + test + ": ");
			
			int N = file.nextInt();
			
			if (N == 1) {
				System.out.println(1 + " " + 1);
				continue;
			}
			
			if (N == 2) {
				System.out.println(1 + " " + 1);
				System.out.println(2 + " " + 2);
				continue;
			}
			
			if (N == 3) {
				System.out.println(1 + " " + 1);
				System.out.println(2 + " " + 1);
				System.out.println(2 + " " + 2);
				continue;
			}
			
			System.out.println(1 + " " + 1);
			System.out.println(2 + " " + 2);
			
			int steps = 2;
			int val = 2;
			ArrayList<Step> list = new ArrayList<>();
			
			int r = 3; int k = 2;
			while (val <= N) {
				val += steps++;
				list.add(new Step(r, k));
				r++; k++;
			}
			list.remove(list.size()-1);
			r-=2; k-=1;
			val -= --steps;
			
			while (val < N) {
				list.add(new Step(r++,k++)); val++;
			}
			
			for (Step s : list) {
				System.out.println(s.r + " " +s.k);
			}
		}
	}
	
	class Step {
		int r, k;
		public Step(int r, int k) {
			this.r = r;
			this.k = k;
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