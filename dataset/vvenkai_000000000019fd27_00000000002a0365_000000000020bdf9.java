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
			List<Triple> list = new ArrayList<Triple>();
			for (int i = 0; i < n; i++) {
				int x = nextInt();
				int y = nextInt();
				list.add(new Triple(x, y, i));
			}
			
			list.sort(new Comparator<Triple>() {
				public int compare(Triple o1, Triple o2) {
					return o1.x - o2.x;
				}
			});

			int c = 0;
			int j = 0;
			char[] a = new char[n]; 
			boolean b = true;
			
			for (Triple p : list) {
				if (p.x < c && p.x < j) {
					b = false;
					break;
				}
				if (c <= j) {
					c = p.y;
					a[p.z] = 'C';
				}
				else {
					j = p.y;
					a[p.z] = 'J'; 
				}
			}
			
			System.out.println("Case #" + tt + ": " + (b ? String.valueOf(a) : "IMPOSSIBLE"));
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
	
	static class Triple {
		int x;
		int y;
		int z;
		public Triple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}