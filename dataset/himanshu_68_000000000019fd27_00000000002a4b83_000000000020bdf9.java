
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void solve() {
		int t = s.nextInt();
		int count=1;
		while(t-->0) {
			int n = s.nextInt();
			Pair[] p = new Pair[n];
			for (int i = 0; i < n; i++) {
				long first=s.nextLong();
				long second=s.nextLong();
				p[i] = new Pair(first, second, i);
			}
			char[] res = new char[n];
			int flag=0;
			Arrays.sort(p);
			long c_end = 0, j_end = 0;
			for (int i = 0; i < n; i++) {
				if (p[i].start >= c_end) {
					res[p[i].index] = 'C';
					c_end = p[i].end;
				} else if (p[i].start >= j_end) {
					res[p[i].index] = 'J';
					j_end = p[i].end;
				} else {
					flag=1;
					break;
				}
			}
			if(flag==1) {
				out.println("Case #" + count + ": IMPOSSIBLE");
			}else {
				String str=new String(res);
				out.print("Case #" + count + ": "+str);
				out.println();
			}
			
			count++;
		}
	}

	public static class Pair implements Comparable<Pair> {
		long start;
		long end;
		int index;

		public Pair(long x, long y, int index) {
			this.start = x;
			this.end = y;
			this.index = index;
		}

		public int compareTo(Pair x) {
			if (this.start == x.start) {
				return Long.compare(this.end, x.end);
			} else {
				return Long.compare(this.start, x.start);
			}
		}

		public int hashCode() {
			return Long.hashCode(start) ^ Long.hashCode(end);
		}

		public boolean equals(Object o) {
			if (!(o instanceof Pair)) {
				return false;
			}
			Pair x = (Pair) o;
			if (x.start == this.start && x.end == this.end) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		s = new FastReader();
		solve();
		out.close();
	}

	public static FastReader s;
	public static PrintWriter out;

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}