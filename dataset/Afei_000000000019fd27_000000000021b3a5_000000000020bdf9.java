import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] a = getIntArr(in, n, 2);
			String r = solve(n, a);
			System.out.println("Case #" + i + ": " + (r == null ? "IMPOSSIBLE" : r));
		}
		in.close();
	}

	private static String solve(int n, int[][] a) {
		Event[] e = new Event[2 * n];
		int[] assignment = new int[n];
		for (int i = 0; i < n; i++) {
			e[i] = new Event(i, a[i][0], 1);
			e[n + i] = new Event(i, a[i][1], -1);
		}
		Arrays.sort(e, (x, y) -> Integer.compare(x.time, y.time) != 0 ? Integer.compare(x.time, y.time)
				: Integer.compare(x.type, y.type));
		Set<Integer> pending = new HashSet<>();
		for (int i = 0; i < e.length; i++) {
			if (e[i].type == -1) {
				pending.remove(e[i].id);
			} else {
				if (pending.size() <= 1) {
					assignment[e[i].id] = 0;
					if (pending.size() == 1) {
						assignment[e[i].id] = 1 - assignment[pending.iterator().next()];
					}
					pending.add(e[i].id);
				} else {
					return null;
				}
			}
		}
		StringBuilder ret = new StringBuilder();
		for (int x : assignment) {
			ret.append(x == 0 ? "C" : "J");
		}
		return ret.toString();
	}

	static class Event {
		int time;
		int type;
		int id;

		public Event(int id, int time, int type) {
			this.id = id;
			this.time = time;
			this.type = type;
		}
	}

	private static void addParentheses(StringBuilder sb, int diff) {
		int cnt = Math.abs(diff);
		for (int i = 0; i < cnt; i++) {
			sb.append(diff > 0 ? "(" : ")");
		}
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
