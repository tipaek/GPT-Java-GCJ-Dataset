import java.io.*;
import java.util.*;

public class Solution {

	static long m = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = scn.nextInt(), tcs = 0;
		B: while (tcs++ < T) {
			sb.append("Case #" + tcs + ": ");
			int fg = scn.nextInt();
			HashMap<Character, ArrayList<Long>> map = new HashMap<>();
			for (int i = 0; i < 10000; i++) {
				long m = (scn.nextLong());
				char[] c = scn.next().toCharArray();
				for (char g : c) {
					ArrayList<Long> gf = new ArrayList<>();
					if (map.containsKey(g))
						gf = map.get(g);
					gf.add(m);
					map.put(g, gf);
				}
			}
			int klj = 0;
			TreeSet<Integer> ts = new TreeSet<Integer>();
			for (int i = 1; i * i <= 1000; i += 1) {
				if (100 % i == 0) {
					ts.add(i);
					ts.add(100 / i);
				}
			}
			pair[] pas = new pair[10];
			for (Character fas : map.keySet()) {
				ArrayList<Long> a1 = map.get(fas);
				Collections.sort(a1);
				map.put(fas, a1);
				long temp = a1.get(0) % 10;
				pas[klj] = new pair(fas, temp);
				klj++;
			}
			Arrays.sort(pas);
			for (int i = 0; i < pas.length; i++)
				sb.append(pas[i].c);
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static class pair implements Comparable<pair> {
		char c;
		long ci;

		pair(char c, long idx) {
			this.c = c;
			this.ci = idx;
		}

		public int compareTo(pair o) {
			if (this.ci > o.ci)
				return 1;
			else
				return -1;
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
	}
}