import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		solve();
		// System.out.println(solve(1 << 30, 1));
	}

	private static void solve() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String r = solve(x, y);
			System.out.println("Case #" + i + ": " + r);
		}
		in.close();
	}

	private static String solve(int x, int y) {
		Map<Integer, String> m = new HashMap<>();
		if (x >= 0) {
			m.put(1, "E");
			m.put(-1, "W");
		}
		if (x < 0) {
			m.put(-1, "E");
			m.put(1, "W");
		}
		if (y >= 0) {
			m.put(2, "N");
			m.put(-2, "S");
		}
		if (y < 0) {
			m.put(-2, "N");
			m.put(2, "S");
		}
		return solve(Math.abs(x), Math.abs(y), m);
	}

	private static String solve(long x, long y, Map<Integer, String> d) {
		if (x % 2 == y % 2) {
			return "IMPOSSIBLE";
		}
		StringBuilder sb = new StringBuilder();
		long[] n = { x, y };
		int[] assignment = new int[35];
		int last = 0;
		if (y % 2 == 1) {
			last = 1;
		}
		for (int i = 0; (1L << i) <= Math.max(Long.highestOneBit(n[0]), Long.highestOneBit(n[1])); i++) {
			long mask = 1L << i;
			if ((n[0] & mask) != 0 && (n[1] & mask) == 0) {
				last = 0;
				assignment[i] = last + 1;
			} else if ((n[1] & mask) != 0 && (n[0] & mask) == 0) {
				last = 1;
				assignment[i] = last + 1;
			} else if ((n[1] & mask) == 0 && (n[0] & mask) == 0) {
				assignment[i] = last + 1;
				n[last] ^= mask;
				assignment[i - 1] *= -1;
			} else {
				n[last] += mask;
				assignment[i - 1] *= -1;
				last = 1 - last;
				assignment[i] = last + 1;
			}
		}
		for (int i = 0; (1L << i) <= Math.max(Long.highestOneBit(n[0]), Long.highestOneBit(n[1])); i++) {
			sb.append(d.get(assignment[i]));
		}
		return sb.toString();
	}

	private static void test() {
		for (int i = 0; i < 10000; i++) {
			testOnce();
		}
	}

	private static void testOnce() {
		Random r = new Random();
		int n = r.nextInt();
	}

	static long mod = 1000000007;

	static long add(long a, long b) {
		long r = a + b;
		if (r < 0) {
			r += mod;
		}
		return r % mod;
	}

	static long mul(long a, long b) {
		return (a * b) % mod;
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	static String str(int[] a) {
		String[] str = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			str[i] = a[i] + "";
		}
		return String.join(" ", str);
	}

	static int[] getIntArr(Scanner in, int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		return arr;
	}

	static int[][] getIntArr(Scanner in, int row, int col) {
		int[][] arr = new int[row][];
		for (int i = 0; i < row; i++) {
			arr[i] = getIntArr(in, col);
		}
		return arr;
	}

	static char[] getCharArr(Scanner in, int size) {
		char[] arr = in.next().toCharArray();
		return arr;
	}

	static String[] getStringArr(Scanner in, int size) {
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.next();
		}
		return arr;
	}

	static Map<Integer, List<Integer>> getEdges(Scanner in, int size, boolean directed) {
		Map<Integer, List<Integer>> edges = new HashMap<>();
		for (int i = 0; i < size; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			if (!edges.containsKey(from)) {
				edges.put(from, new ArrayList<Integer>());
			}
			edges.get(from).add(to);
			if (!directed) {
				if (!edges.containsKey(to)) {
					edges.put(to, new ArrayList<Integer>());
				}
				edges.get(to).add(from);
			}

		}
		return edges;
	}

	static class FastScanner implements Closeable {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
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

		@Override
		public void close() throws IOException {
			br.close();
		}
	}

}
