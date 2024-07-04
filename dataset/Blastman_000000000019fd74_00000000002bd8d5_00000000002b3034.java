
import java.util.*;
import java.io.*;

public class Solution {

	static final boolean stdin = true;
	static final String filename = "";
	static FastScanner br;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {

		if (stdin) {
			br = new FastScanner();
			pw = new PrintWriter(new OutputStreamWriter(System.out));
		} else {
			br = new FastScanner(filename + ".in");
			pw = new PrintWriter(new FileWriter(filename + ".out"));
		}

		Solver solver = new Solver();
		int T = br.ni();
		for (int i = 1; i <= T; i++) {
			pw.print("Case #" + i + ": ");
			solver.solve(br, pw);
		}
		pw.close();
	}

	static class Solver {
		static long mod = (long) (1e9) + 7;

		public void solve(FastScanner br, PrintWriter pw) throws IOException {
			int n = br.ni();
			ArrayList<String> right = new ArrayList<>();
			ArrayList<String> left = new ArrayList<>();
			ArrayList<String> mid = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String s = br.nt();
				boolean r = s.charAt(0) == '*', l = s.charAt(s.length() - 1) == '*';
				if (r) {
					s = s.substring(1);
					right.add(s);
				} else if (l) {
					s = s.substring(0, s.length() - 1);
					left.add(s);
				} else {
					mid.add(s);
				}
			}
			Collections.sort(right, new MyComparator(""));
			Collections.sort(left, new MyComparator(""));
			// right ends at right
			String outR = "";
			if (!right.isEmpty()) {
				String rr = right.get(0);
				for (String s : right) {
					if (!s.equals(rr.substring(rr.length() - s.length()))) {
						outR = "*";
						break;
					}
				}
				if (!outR.equals("*"))
					outR = rr;
			}
			String outL = "";
			if (!left.isEmpty()) {
				String ll = left.get(0);
				// left ends at left
				for (String s : left) {
					if (!s.equals(ll.substring(0, s.length()))) {
						outL = "*";
						break;
					}
				}
				if (!outL.equals("*"))
					outL = ll;
			}
			if (outR.equals("*") || outL.equals("*")) {
				pw.println("*");
			} else {
				if (mid.size() == 0) {
					pw.println(outL + outR);
				} else if (mid.size() == 1) {
					String ss = mid.get(0);
					for (int i = 0; i < ss.length(); i++) {
						if (ss.charAt(i) == '*') {
							boolean fail = false;
							String lll = ss.substring(0, i);
							String rrr = ss.substring(i + 1);

							int minl = Math.min(lll.length(), outL.length());
							if (!lll.substring(0, minl).equals(outL.substring(0, minl))) {
								fail = true;
							}
							String resl = "";
							if (lll.length() > outL.length()) {
								resl = lll.substring(outL.length());
							}

							int minr = Math.min(rrr.length(), outR.length());
							if (!rrr.substring(rrr.length() - minr, rrr.length())
									.equals(outR.substring(outR.length() - minr, outR.length()))) {
								fail = true;
							}
							String resr = "";
							if (rrr.length() > outR.length()) {
								resr = rrr.substring(0, rrr.length() - outR.length());
							}

							if (fail) {
								pw.println("*");
							} else {
								pw.println(outL + resl + resr + outR);
							}
						}
					}
				} else {
					pw.println("*");
				}
			}
		}

		public class MyComparator implements java.util.Comparator<String> {

			private int referenceLength;

			public MyComparator(String reference) {
				super();
				this.referenceLength = reference.length();
			}

			public int compare(String s1, String s2) {
				int dist1 = Math.abs(s1.length() - referenceLength);
				int dist2 = Math.abs(s2.length() - referenceLength);

				return -dist1 + dist2;
			}
		}

		static long gcd(long a, long b) {
			if (a > b)
				return gcd(b, a);
			if (a == 0)
				return b;
			return gcd(b % a, a);
		}

		static long lcm(long a, long b) {
			return a * (b / gcd(a, b));
		}

		static long pow(long a, long b) {
			if (b == 0)
				return 1L;
			long val = pow(a, b / 2);
			if (b % 2 == 0)
				return val * val % mod;
			else
				return val * val % mod * a % mod;
		}

	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}

		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point other = (Point) obj;
				return x == other.x && x == other.x;
			}
			return false;
		}

		public int hashCode() {
			return 65536 * x + y + 4733 * 0;
		}

	}

	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		ArrayList<Integer>[] ng(int n, int e) {
			ArrayList<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < e; i++) {
				int a = ni() - 1;
				int b = ni() - 1;
				adj[a].add(b);
				adj[b].add(a);
			}
			return adj;
		}

		Integer[] nIa(int n) {
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = ni();
			}
			return arr;
		}

		int[] nia(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = ni();
			}
			return arr;
		}

		Long[] nLa(int n) {
			Long[] arr = new Long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nl();
			}
			return arr;
		}

		long[] nla(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nl();
			}
			return arr;
		}

		String[] nsa(int n) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nt();
			}
			return arr;
		}

		String nt() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int ni() {
			return Integer.parseInt(nt());
		}

		long nl() {
			return Long.parseLong(nt());
		}

		double nd() {
			return Double.parseDouble(nt());
		}

	}
}