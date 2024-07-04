import java.util.*;
import java.io.*;

public class Solution {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			int n = file.nextInt();
			ArrayList<Pair> c = new ArrayList(), j = new ArrayList();
			ArrayList<Pair> sorted = new ArrayList(), unsorted = new ArrayList();
			for (int i = 0; i < n; i++) {
				unsorted.add(new Pair(file.nextInt(), file.nextInt()));
			}
			for (int i = 0; i < n; i++)
				sorted.add(unsorted.get(i));

			Collections.sort(sorted);
			boolean works = true;
			int count = 0;
			for (Pair p : sorted) {
				if (count == 0) {
					c.add(p);
				}
				else {
					if (p.x >= c.get(c.size() - 1).x && p.x < c.get(c.size() - 1).y || p.y <= c.get(c.size() - 1).y && p.y > c.get(c.size() - 1).x) {
						if (j.size() == 0) j.add(p);
						else if (p.x >= j.get(j.size() - 1).x && p.x < j.get(j.size() - 1).y || p.y > j.get(j.size() - 1).x && p.y <= j.get(j.size() - 1).y) {
							works = false;
							break;
						}
						else j.add(p);
					}
					else {
						c.add(p);
					}
				}
				count++;
			}
			if (!works) System.out.println("Case #" + (asdf + 1) + ": IMPOSSIBLE");
			else {
				char[] chars = new char[n];
				for (int i = 0; i < n; i++) {
					if (c.indexOf(unsorted.get(i)) < 0) {
						chars[i] = 'J';
					}
					else chars[i] = 'C';
				}
				String res = "";
				for (char w : chars) res += "" + w;
				System.out.println("Case #" + (asdf + 1) + ": " + res);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair other) {
			if (other.x == x)
				return y - other.y;
			return x - other.x;
		}

		public boolean equals(Pair other) {
			if (x == other.x && y == other.y)
				return true;
			return false;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
