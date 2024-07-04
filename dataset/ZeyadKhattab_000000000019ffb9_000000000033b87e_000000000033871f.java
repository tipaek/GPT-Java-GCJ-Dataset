import java.io.*;
import java.util.*;

public class Solution {

	static int INF = (int) 1e6;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			out.printf("Case #%d:", t);
			int n = sc.nextInt(), m = sc.nextInt();
			int[] x = new int[n];
			TreeMap<Integer, Integer> map = new TreeMap();
			for (int i = 1; i < n; i++) {
				x[i] = sc.nextInt();
				map.put(-x[i], 0);
			}
			int[][] edges = new int[m][2];
			for (int i = 0; i < m; i++)
				for (int j = 0; j < 2; j++)
					edges[i][j] = sc.nextInt() - 1;
			int id = 1;
			for (int y : map.keySet())
				map.put(y, id++);
			int[] group = new int[n];
			for (int i = 1; i < n; i++)
				group[i] = map.get(-x[i]);
			int[] ans = new int[m];
			for (int g = 1; g <= map.size(); g++) {
				for (int i = 0; i < n; i++) {
					if (group[i] != g)
						continue;
					boolean found = false;
					for (int j = 0; j < m && !found; j++)
						if (edges[j][0] == i || edges[j][1] == i) {
							int other = edges[j][0] == i ? edges[j][1] : edges[j][0];
							if (group[other] < g) {
								ans[j] = g - group[other];
								found = true;
							}
						}

				}
			}
			for (int y : ans)
				out.printf(" %d", y == 0 ? INF : y);
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