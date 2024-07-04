import java.io.*;
import java.util.*;

public class Solution {

	static int X = 2, Y = 4;
	static int INF = (int) 1e9;
	static int R;

	static Scanner sc = new Scanner();
//
//	static boolean inside(int x, int y) throws IOException {
////		long dx = x - X, dy = y - Y;
////		long d = dx * dx + dy * dy;
////		return d <= R * 1L * R;
//		String ans = query(x, y);
//		return ans.equals("HIT") || ans.equals("CENTER");
//
//	}

	static int getY() throws IOException {
		int x = 0;
		int y = -1;
		int lo = 50, hi = INF;
		while (lo <= hi) {
			int mid = lo + hi >> 1;
			String tmp = query(x, mid);
			if (tmp.equals("CENTER"))
				return -INF;
			if (tmp.equals("HIT")) {
				y = mid;
				lo = mid + 1;
			} else
				hi = mid - 1;

		}
		return y - R + 1;
	}

	static String query(int x, int y) throws IOException {
		System.out.println(x + " " + y);
		return sc.nextLine();
	}

	public static void main(String[] args) throws IOException {
		int tc = sc.nextInt();
		R = sc.nextInt();
		R = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int y = getY();
			if (y == -INF)
				continue;
			boolean ok = false;
			for (int x = -50; x <= 50; x++) {
				if (query(x, y).equals("CENTER")) {
					ok = true;
					break;
				}
			}
			if (!ok)
				break;
		}

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

		int[] nxtArr(int n) throws IOException {
			int[] ans = new int[n];
			for (int i = 0; i < n; i++)
				ans[i] = nextInt();
			return ans;
		}

	}

	static void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			int tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}