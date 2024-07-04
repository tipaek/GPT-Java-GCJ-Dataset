import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int q = 1;
		while (t-- > 0) {
			StringBuilder sol = new StringBuilder();
			person c = new person();
			person j = new person();
			
			boolean stop = false;
			int n = sc.nextInt();
			person[] events = new person[n];
			HashMap<Integer,person> hm = new HashMap<>();
			for(int i=0;i<n;i++) {
				events[i]= new person(sc.nextInt(),sc.nextInt());
				hm.put(i, events[i]);
			}
			Arrays.sort(events);
			for (int i = 0; i < n; i++) {
				int s =events[i].start;
				int e = events[i].end;
				if ((c.start == null || s >= c.end) && !stop) {
					c.start = s;
					c.end = e;
					events[i].giveTask("C");
				} else {
					if ((j.start == null || s >= j.end) && !stop) {
						j.start = s;
						j.end = e;
						events[i].giveTask("J");
					} else {
						if(!stop) {
						events[i].giveTask("IMPOSSIBLE");
						stop = true;
						}
					}

				}
			}
			if(stop) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", q++);
				continue;

			}
			for(int i=0;i<n;i++) {
				sol.append(hm.get(i).doer);
			}
			System.out.printf("Case #%d: %s\n", q++, sol.toString());

		}
	}
	

	public static StringBuilder fillwitho(StringBuilder sb, int c) {
		while (c-- > 0) {
			sb.append('(');
		}
		return sb;
	}

	public static StringBuilder fillwithc(StringBuilder sb, int c) {
		while (c-- > 0) {
			sb.append(')');
		}
		return sb;
	}

	static class person implements Comparable<person> {
		Integer start;
		Integer end;
		String doer;

		public person() {
		}
		public person(int s,int e) {
			start=s;
			end=e;
		}

		public void giveTask(String S) {
			doer=S;
			
		}

		@Override
		public int compareTo(person o) {
			return  this.start!=o.start?this.start-o.start:this.end-o.end;
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
