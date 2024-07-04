

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
	private static class Pair {
		private long u, v;

		public Pair(long a, long b) {
			u = a;
			v = b;
			long g = gcd(u, v);
			u = u/g;
			v = v/g;
		}

		public int hashCode() {
			return (int)(u + v + u * v);
		}

		public boolean equals(Object object) {
			Pair pair = (Pair) object;
			return u == pair.u && v == pair.v;
		}
	}
	//author: Nagabhushan S Baddi

	private static int n;
	private static long[] a;
	private static int d;
	private static String s;
	private static HashMap<Integer, ArrayList<Integer>> g;
	private static int[][] dp;

	
	public static void main(String[] args) {
		int t = ini();
		next:
		for(int z=1; z<=t; z++) {
			n = ini();
			d = ini();
			a = new long[n];
			for(int i=0; i<n; i++) {
				a[i] = inl();
			}
			HashSet<Pair> cuts = new HashSet<>();

			dp = new int[n+1][d+1];
			for(int i=0; i<n; i++) {
				cuts.add(new Pair(a[i], 1));
				for(int j=1; j<=d; j++) {
					cuts.add(new Pair(a[i], j));
				}
			}
			
			int ans = (int)1e9;
			
			for(Pair pair: cuts) {
				int count = 0;
				int sum = 0;
				for(int i=0; i<n; i++) {
					if (a[i]*pair.v%pair.u==0) {
						count+=a[i]*pair.v/pair.u;
						sum += a[i]*pair.v/pair.u-1;
					}
				}
//				pd(sum);
				if (count==d) {
					ans = Math.min(ans, sum);
//					pd("SUM "+sum);
//					continue next;
				}
			}
			pd("Case #"+z+": "+ans);
			
		}

		out.flush();
		out.close();

	}
	
//	private static long solve(int i, int left, double x) {
//		if (left<0) return (int)1e9;
//		if (left==0) return 0;
//		if (i==n) {
//			if (left!=0) {
//				return (int)1e9;
//			} else {
//				return 0;
//			}
//		}
//		
//		if(dp[i][left]!=-1) return dp[i][left];
//		
//		long ans = solve(i+1, left, x);
////		pd("OUT "+ans);
//		
//		if (Math.abs(x-a[i])<1e-9) {
//			ans = Math.min(ans, solve(i+1, left-1, x));
//		}
//		
//		if (a[i]%x<1e-9) {
////			pd("HELLO");
//			long get = (long)(a[i]/x);
//			if (get>=left) {
////				pd("HELLO2 "+get);
////				pd("ANS "+ans);
//				ans = Math.min(ans, get-1);
////				pd("ANS "+ans);
//			} else if (get<left) {
//				ans = Math.min(ans, get-1+solve(i+1, (int)(left-get), x));
//			} 
//		} else {
//			for(int j=1; j<=50; j++) {
//				ans = Math.min(ans, j+solve(i+1, left-j, x));
//			}
//		}
//		
//		return dp[i][left]=(int)(ans);
//		
//	}

	//CONSTANTS
	private static final int MOD = (int) 1e9 + 7;

	//NONPROBLEM CODE

	private static InputReader in = new InputReader(System.in);
	private static PrintWriter out = new PrintWriter(System.out);

	private static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}

	//SORT SHORTCUTS

	private static void sort(int[] a) {
		int n = a.length;
		Integer[] b = new Integer[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}

		Arrays.sort(b);

		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

	private static void sort(long[] a) {
		int n = a.length;
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}

		Arrays.sort(b);

		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

	//INPUT SHORTCUTS

	private static int[] ina(int n) {
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = in.nextInt();
		}
		return temp;
	}

	private static int ini() {
		return in.nextInt();
	}

	private static long inl() {
		return in.nextLong();
	}

	private static String ins() {
		return in.readString();
	}

	//PRINT SHORTCUTS

	private static void println(Object... o) {
		for (Object x : o) {
			out.write(x + "");
		}
		out.write("\n");
	}

	private static void pd(Object... o) {
		for (Object x : o) {
			out.write(x + "");
		}
		out.flush();
		out.write("\n");
	}

	private static void print(Object... o) {
		for (Object x : o) {
			out.write(x + "");
		}
	}

	//GRAPH SHORTCUTS

	private static HashMap<Integer, ArrayList<Integer>> intree(int n) {

		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
			g.get(v).add(u);
		}

		return g;
	}

	private static HashMap<Integer, ArrayList<Integer>> ingraph(int n, int m) {
		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();

		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
			g.get(v).add(u);
		}

		return g;

	}

	private static HashMap<Integer, ArrayList<Edge>> inweightedgraph(int n, int m) {
		HashMap<Integer, ArrayList<Edge>> g = new HashMap<>();

		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			int w = ini();
			Edge edge = new Edge(u, v, w);
			g.get(u).add(edge);
			g.get(v).add(edge);
		}

		return g;

	}

	private static class Edge implements Comparable<Edge> {
		private int u, v;
		private long w;

		public Edge(int a, int b, long c) {
			u = a;
			v = b;
			w = c;
		}

		public int other(int x) {
			return (x == u ? v : u);
		}

		public int compareTo(Edge edge) {
			return Long.compare(w, edge.w);
		}
	}

	
	private static class Node implements Comparable<Node> {
		private int u;
		private long dist;

		public Node(int a, long b) {
			u = a;
			dist = b;
		}

		public int compareTo(Node node) {
			return Long.compare(dist, node.dist);
		}
	}

	//MATHS AND NUMBER THEORY SHORTCUTS

	private static long gcd(long a, long b) {
		//O(log(min(a,b)))
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	private static long modExp(long a, long b) {
		if (b == 0)
			return 1;

		a %= MOD;

		long exp = modExp(a, b / 2);

		if (b % 2 == 0) {
			return (exp * exp) % MOD;
		} else {
			return (a * ((exp * exp) % MOD)) % MOD;
		}
	}
}
