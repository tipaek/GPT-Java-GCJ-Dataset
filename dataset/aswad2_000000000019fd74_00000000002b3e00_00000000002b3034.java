import java.util.*;
import java.io.*;

public class Solution {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			int n = file.nextInt();
			ArrayList<String> x = new ArrayList();
			for (int i = 0; i < n; i++) x.add(file.next());
			ArrayList<Integer> ind = new ArrayList();
			ArrayList<Thing> start = new ArrayList(), end = new ArrayList();
			for (int i = 0; i < x.size(); i++) {
				ind.add(x.get(i).indexOf("*"));
				start.add(new Thing(x.get(i).substring(0, ind.get(i))));
				end.add(new Thing(x.get(i).substring(ind.get(i) + 1)));
			}
			boolean b = true;
//			System.out.println(start.size());
			Collections.sort(start); Collections.sort(end);
			for (int i = 0; i < start.size() - 1; i++) {
//				System.out.println(start.get(i + 1).t + " " + start.get(i).t);
				if (!start.get(i + 1).t.substring(0, start.get(i).t.length()).equals(start.get(i).t)) {
					b = false;
					break;
				}
				if (!end.get(i + 1).t.substring(end.get(i + 1).t.length() - end.get(i).t.length()).equals(end.get(i).t)) {
					b = false;  break;
				}
			}
			if (b) {
				System.out.println(start.get(start.size() - 1).t + "A" + end.get(end.size() - 1).t);
			}
			else System.out.println("*");
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	static class Thing implements Comparable<Thing> {
		String t;
		public Thing(String t) {
			this.t = t;
		}
		public int compareTo(Thing other) {
			return t.length() - other.t.length();
		}
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
