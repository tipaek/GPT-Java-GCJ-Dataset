import java.io.*;
import java.util.*;

public class Main{

	public static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public char nextChar() {
			return next().charAt(0);
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			return arr;
		}

		public int[][] next2DIntArr(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = this.nextInt();
				}
			}
			return arr;
		}

		public int[] nextSortedIntArr(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			Arrays.sort(arr);
			return arr;
		}

		public long[] nextLongArr(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextLong();
			}
			return arr;
		}

		public char[] nextCharArr(int n) {
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextChar();
			}
			return arr;
		}
	}

	public static InputReader scn = new InputReader();
	public static PrintWriter out = new PrintWriter(System.out);

	public static ArrayList<Integer>[] gr;
	public static ArrayList<Integer> cyc;
	public static int[] vis;
	public static int trim = 0, size = 0;

	public static void main(String[] args) {
		// InputStream inputStream = System.in; // Useful when taking input other than
		// console eg file handling // check ctor of inputReader
		//System.out.println("GO");

		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt(), m = scn.nextInt(), k = scn.nextInt();
			gr = new ArrayList[n + 1];
			Arrays.setAll(gr, i -> new ArrayList<>());

			while (m-- > 0) {
				int u = scn.nextInt(), v = scn.nextInt();
				gr[u].add(v);
				gr[v].add(u);
			}

			cyc = new ArrayList<>();
			vis = new int[n + 1];
			
			int ans = 0;
			trim = -1;
			if (cycle(1, 0, k)) {
				out.println("CYCLE");
				out.println(size);
				for(int i = trim; i < cyc.size(); i++) {
					out.print(cyc.get(i) + " ");
				}
				out.println();
			} else if ((ans = cut(k)) != 0) {
				out.println("CUT \n1");
				out.println(ans);
			} else {
				out.println("NO ANSWER");
			}
		}

		out.close();
	}

	public static int cut(int k) {
		for (int i = 1; i < gr.length; i++) {
			if (gr[i].size() < k) {
				return i;
			}
		}
		return 0;
	}

	public static boolean cycle(int u, int p, int k) {
		if (vis[u] == 1) {
			for(int i = 0; i < cyc.size(); i++) {
				if(cyc.get(i) == u) {
					trim = i;
					break;
				}
			}
			if (cyc.size() - trim >= k) {
				size = cyc.size() - trim;
				return true;
			} else {
				return false;
			}
		}
		vis[u] = 1;

		cyc.add(u);
		for (Integer v : gr[u]) {
			if (v != p && cycle(v, u, k)) {
				return true;
			}
		}
		cyc.remove(cyc.size() - 1);
		return false;
	}
}
