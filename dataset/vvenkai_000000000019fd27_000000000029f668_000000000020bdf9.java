import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = nextInt();
		for (int tt = 1; tt <= t; tt++) {
			int n = nextInt();
			List<Pair> list = new ArrayList<Pair>();
			for (int i = 0; i < n; i++) {
				int x = nextInt();
				int y = nextInt();
				list.add(new Pair(x, y));
			}
			
			list.sort(new Comparator<Pair>() {
				public int compare(Pair p1, Pair p2) {
					return p1.x - p2.x;
				}
			});

			int c = 0;
			int j = 0;
			boolean b = true;
			String s = "";
			
			for (Pair p : list) {
				if (p.x < c && p.x < j) {
					b = false;
					break;
				}
				if (c <= j) {
					c = p.y;
					s += "C";
				}
				else {
					j = p.y;
					s += "J";
				}
			}
			
			System.out.println("Case #" + tt + ": " + (b ? s : "IMPOSSIBLE"));
		}
	}
	
	public static String f(char c, int k) {
		String f = "";
		for (int i = 0; i < k; i++)
			f += c;
		return f;
	}

	public static String nextLine() throws IOException {
		return in.readLine();
	}

	public static String nextString() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(nextString());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(nextString());
	}

	public static int[] intArray(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public static int[][] intArray(int n, int m) throws IOException {
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = nextInt();
		return a;
	}

	public static long[] longArray(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
	
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}