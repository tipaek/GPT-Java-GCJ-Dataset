import java.io.*;
import java.util.*;

public class Solution {

	static ArrayList<Integer>[] adj;
	static int[] col;

	static boolean dfs(int u, int c) {
		col[u] = c;
		for (int v : adj[u]) {
			if (col[v] == col[u])
				return false;
			if (col[v] == -1 && !dfs(v, c ^ 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			out.printf("Case #%d: ", t);
			int n = sc.nextInt();
			int[] l = new int[n], r = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}
			col = new int[n];
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList();
				col[i] = -1;
				for (int j = 0; j < n; j++) {
					if (i == j || r[i] <= l[j] || r[j] <= l[i])
						continue;
					adj[i].add(j);

				}
			}
			boolean ok = true;
			for (int i = 0; i < n; i++)
				if (col[i] == -1 && !dfs(i, 0))
					ok = false;
			if (!ok)
				out.print("IMPOSSIBLE");
			else {
				for (int i = 0; i < n; i++)
					out.print(col[i] == 0 ? 'C' : 'J');
			}
			out.println();
		}
		out.close();

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