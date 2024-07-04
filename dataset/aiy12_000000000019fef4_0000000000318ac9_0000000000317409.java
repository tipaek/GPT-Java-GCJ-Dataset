import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "(" + x + " " + y + ")";
		}
	}
	
	public void run() throws Exception {
		FastScanner file = new FastScanner();
		
		int T = file.nextInt();
		
		for (int test = 1; test <= T; test++) {
			int X = file.nextInt();
			int Y = file.nextInt();
			String M = file.next();
			
			ArrayList<Pair> coords = new ArrayList<Pair>();

			for (int i = 0; i < M.length(); i++) {
				if (M.charAt(i) == 'N') {
					coords.add(new Pair(X, ++Y));
				} else if (M.charAt(i) == 'S') {
					coords.add(new Pair(X, --Y));
				} else if (M.charAt(i) == 'E') {
					coords.add(new Pair(++X, Y));
				} else if (M.charAt(i) == 'W') {
					coords.add(new Pair(--X, Y));
				}
			}
			
//			System.out.println(coords);
			
			int best = Integer.MAX_VALUE;
			
			for (int i = 0; i < coords.size(); i++) {
				int steps = i + 1;
				if (Math.abs(coords.get(i).x) + Math.abs(coords.get(i).y) > steps) continue;
//				if ((Math.abs(coords.get(i).x) + Math.abs(coords.get(i).y) - steps) % 2 != 0) continue;
				best = steps;
				break;
			}
			System.out.print("Case #" + test + ": ");
			System.out.println(best == Integer.MAX_VALUE ? "IMPOSSIBLE" : best);
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