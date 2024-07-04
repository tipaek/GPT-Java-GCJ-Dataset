import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {

	
	static StringBuilder sb;
	
	static ArrayList<Character> path;
	static int mind;

	public static void solve(int idx, int x, int y, int d) {
		if (x == 0 && y == 0) {
			if (d >= mind)
				return;
			mind = d;
			sb = new StringBuilder();
			for (char c : path) {
				sb.append(c);
			}
			return;
		}
		if (idx == 32 || (1 << idx > Math.abs(x) && x != 0) || (1 << idx > Math.abs(y) && y != 0))
			return;
		if ((Math.abs(x) & (1 << idx)) != 0 && (Math.abs(y) & (1 << idx)) != 0)
			return;
		if ((Math.abs(x) & (1 << idx)) == 0 && (Math.abs(y) & (1 << idx)) == 0)
			return;
		if ((Math.abs(x) & (1 << idx)) != 0) {
			path.add('E');
			solve(idx + 1, x + (1 << idx), y, d + 1);
			path.remove(path.size() - 1);
			path.add('W');
			solve(idx + 1, x - (1 << idx), y, d + 1);
			path.remove(path.size() - 1);

		} else {
			path.add('N');
			solve(idx + 1, x, y + (1 << idx), d + 1);
			path.remove(path.size() - 1);
			path.add('S');
			solve(idx + 1, x, y - (1 << idx), d + 1);
			path.remove(path.size() - 1);

		}
	}

	static class Triple {
		int x, y, z;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		int tc = 1;
		loop: while (t-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
//			int yn = y < 0 ? -1 : 1;
//			int xn = x < 0 ? -1 : 1;
//			x = Math.abs(x);
//			y = Math.abs(y);
//			int lim = Math.max(lmb(x), lmb(y));
			mind = (int) 1e9;
			sb = new StringBuilder();
			path = new ArrayList<Character>();
			solve(0, x, y, 0);
			if (mind == (int) 1e9) {
				pw.printf("Case #%d: %s%n", tc++, "Impossible");
			} else {
				pw.printf("Case #%d: %s%n", tc++, sb);
			}
		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
