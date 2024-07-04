import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int q=1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int x[][] = new int[n][n];
			int k = 0;
			int ro = 0;
			int co = 0;
			for (int i = 0; i < n; i++) {
			}

			HashSet<pair> rowsUsed = new HashSet<>();
			HashSet<pair> colUsed = new HashSet<>();
			HashSet<Integer> c = new HashSet<>();
			for (int i = 0; i < n; i++) {
				boolean foundinRow = false;
				for (int j = 0; j < n; j++) {
					x[i][j] = sc.nextInt();
					if (i == j) {
						k += x[i][j];
					}
					if (!rowsUsed.contains(new pair(i + "", x[i][j] + ""))) {
						rowsUsed.add(new pair(i + "", x[i][j] + ""));
					} else {
						if (!foundinRow) {
							ro++;
							foundinRow=true;
						}
					}
					if (!colUsed.contains(new pair(j + "", x[i][j] + ""))) {
						colUsed.add(new pair(j + "", x[i][j] + ""));
					} else {
						if (!c.contains(j)) {
							co++;
							c.add(j);
						}

					}
				}
			}
			System.out.printf("Case #%d: %d %d %d\n",q++,k,ro,co);

		}
	}

	static class pair implements Comparable<pair> {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			pair other = (pair) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			return true;
		}

		String x, y;

		pair(String x, String y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return x.compareTo(o.x) == 0 ? y.compareTo(o.y) : x.compareTo(o.x);
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
