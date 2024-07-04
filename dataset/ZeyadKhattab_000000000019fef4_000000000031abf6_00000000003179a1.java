import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		int N = (int) 1e4;
		for (int t = 1; t <= tc; t++) {
			
			int u = sc.nextInt();
			if (u != 2)
				continue;
			out.printf("Case #%d: ", t);
			ArrayList<String>[] adj = new ArrayList[100];
			for (int i = 1; i <= 99; i++)
				adj[i] = new ArrayList();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				String s = sc.next();
				adj[x].add(s);
			}
			boolean[] seen = new boolean[26];
			char[] ans = new char[10];
			for (int d = 1; d <= 9; d++)
				for (String s : adj[d])
					if (!seen[s.charAt(0) - 'A']) {
						seen[s.charAt(0) - 'A'] = true;
						ans[d] = s.charAt(0);
					}
			out: for (int d = 10; d < 100; d++)
				for (String s : adj[d])
					for (char c : s.toCharArray())
						if (!seen[c - 'A']) {
							ans[0] = c;
							break out;
						}
			out.println(ans);

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