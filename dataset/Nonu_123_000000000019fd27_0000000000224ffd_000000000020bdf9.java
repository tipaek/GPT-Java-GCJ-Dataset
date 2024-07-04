
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	public static void solve() {
		int t = s.nextInt();
		o: for(int z = 1; z <= t; z++) {
			int n = s.nextInt();
			Pair[] times = new Pair[n];
			for(int i = 0; i < n; i++) {
				times[i] = new Pair(s.nextLong(), s.nextLong(), i);
			}
			Arrays.sort(times);
//			StringBuilder ans = new StringBuilder();
			char[] ans = new char[n];
			long C = 0, J = 0;
			for(int i = 0; i < n; i++) {
				if(times[i].x >=  C) {
					ans[times[i].pos] = 'C'; 
					C = times[i].y;
				}else if( times[i].x >= J) {
					ans[times[i].pos] = 'J';
					J = times[i].y;
				}else {
					out.println("Case #"+z+": IMPOSSIBLE");
					continue o;
				}
			}
			out.print("Case #"+z+": ");
			for(int i = 0; i < n; i++) {
				out.print(ans[i]);
			}
			out.println();
		}
	}
	
	public static class Pair implements Comparable<Pair> {
		long x;
		long y;
		int pos;

		public Pair(long x, long y, int pos) {
			this.x = x;
			this.y = y;
			this.pos = pos;
		}

		public int compareTo(Pair x) {
			//ascending order
			if (this.x == x.x) {
				return Long.compare(this.y, x.y);
			} else {
				return Long.compare(this.x, x.x);
			}
			//descending order
			//		if(this.x==x.x) {
			//			return Long.compare(x.y, this.y);
			//		}else {
			//			return Long.compare(x.x, this.x);
			//		}
		}

		//Use it rarely because it has about 0.115% collision rate which is quite 
		//and hence it will constantly keep go into equal function and hence slow
		public int hashCode() {
			return Long.hashCode(x) ^ Long.hashCode(y);
		}

		public boolean equals(Object o) {
			if (!(o instanceof Pair)) {
				return false;
			}
			Pair x = (Pair) o;
			if (x.x == this.x && x.y == this.y) {
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
