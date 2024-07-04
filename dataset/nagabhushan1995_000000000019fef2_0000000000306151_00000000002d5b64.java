

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private static int n, x, y;
	private static ArrayList<int[]> list;

	public static void main(String[] args) {
		int t = ini();
		
		for(int z=1; z<=t; z++) {
			x = ini();
			y = ini();
			list = new ArrayList<>();
			
			for(int j=1; j<=y; j++) {
				for(int i=1; i<=x; i++) {
					list.add(new int[] {i, j});
				}
			}
			
			for(int[] xx: list) {
//				println(xx[0]+" "+xx[1]);
			}
			
//			HashSet<ArrayList<int[]>> mark = new HashSet<>();
			Queue<ArrayList<int[]>> queue = new LinkedList<>();
			
			HashMap<ArrayList<int[]>, Integer> mark = new HashMap<>();
			queue.add(list);
			mark.put(list, 0);
			int ans = 0;
			
			HashMap<ArrayList<int[]>, int[]> map1 = new HashMap<>();
			HashMap<ArrayList<int[]>, ArrayList<int[]>> map2 = new HashMap<>();
			
			while(!queue.isEmpty()) {
				ArrayList<int[]> track = queue.poll();
//				println(track);
				
				if (poss(track)) {
					ans = mark.get(track);

					println("Case #"+z+": "+ans);
					ArrayList<int[]> go = track;
//					println("HI");
					while(map2.containsKey(go)) {
						int[] zz = map1.get(go);
						println(zz[0]+ " "+zz[1]);
						go = map2.get(go);
					}
					break;
				}
//				println(track.size());
				int m = track.size();
				ArrayList<int[]> newList = new ArrayList<>(track);
				for(int i=0; i<m; i++) {
					for(int j=i+1; j<m; j++) {
						int[] u = list.get(j);
						newList.remove(j);
						newList.add(j-i-1, u);
						if (!mark.containsKey(newList)) {
							ArrayList<int[]> ll = new ArrayList<>(newList);
							queue.add(ll);
							mark.put(ll, mark.get(track)+1);
							map1.put(ll, new int[] {i+1, j-i});
							map2.put(ll, new ArrayList<>(track));
						}
					}
					newList = new ArrayList<>(track);
				}
			}
			
			
//			
//			println("Case #"+z+": "+ans);
		}

		out.flush();
		out.close();

	}
	
//	private static int solve(ArrayList<int[]> track) {
//		boolean done = poss(track);
//		
//		int ans = (int)1e9;
//		
//		int m = list.size();
//		ArrayList<int[]> newList = new ArrayList<>(track);
//		for(int i=0; i<m; i++) {
//			for(int j=i+1; j<m; j++) {
//				int[] u = list.get(j);
//				newList.remove(j);
//				newList.add(j-i-1, u);
//				ans = Math.min(ans, 1+solve(newList));
//			}
//			newList = new ArrayList<>(track);
//		}
//		return ans;
//	}
	
	
	private static boolean poss(ArrayList<int[]> track) {
		
		for(int i=1; i<track.size(); i++) {
			if (track.get(i)[0]<track.get(i-1)[0]) {
				return false;
			}
		}
		return true;
		
	}


	//CONSTANTS
	private static final int MOD = (int)1e9+7;

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
			u=a;
			v=b;
			w=c;
		}
		
		public int other(int x) {
			return (x==u?v:u);
		}
		
		public int compareTo(Edge edge) {
			return Long.compare(w, edge.w);
		}
	}
	
	private static class Pair {
		private int u, v;
		
		public Pair(int a, int b) {
			u=a;
			v=b;
		}
		
		public int hashCode() {
			return u+v+u*v;
		}
		
		public boolean equals(Object object) {
			Pair pair = (Pair)object;
			return u==pair.u && v==pair.v;
		}
	}
	
	private static class Node implements Comparable<Node> {
		private int u;
		private long dist;
		
		public Node(int a, long b) {
			u=a;
			dist=b;
		}
		
		public int compareTo(Node node) {
			return Long.compare(dist, node.dist);
		}
	}
	
	//MATHS AND NUMBER THEORY SHORTCUTS
	
	private static int gcd(int a, int b) {
		//O(log(min(a,b)))
		if (b==0) return a;
		
		return gcd(b, a%b);
	}
	
	private static long modExp(long a, long b) {
		if (b==0) return 1;
		
		a%=MOD;
		
		long exp = modExp(a, b/2);
		
		if (b%2==0) {
			return (exp*exp)%MOD;
		} else {
			return (a*((exp*exp)%MOD))%MOD;
		}
	}
}
