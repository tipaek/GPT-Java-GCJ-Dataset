import java.io.*;
import java.util.*;

public class Solution {

	static char[] ans, best;

	static char[] dir = "SWEN".toCharArray();
	static int INF = (int) 1e9;

	static ArrayList<String> cand;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		cand = new ArrayList();
		for (char c : dir)
			cand.add(c + "");
		for (int len = 2; len <= 6; len++) {
			ArrayList<String> tmp = new ArrayList();
			for (String s : cand)
				if (s.length() == len - 1)
					for (char c : dir)
						tmp.add(s + c);
			for (String s : tmp)
				cand.add(s);
		}
		for (int t = 1; t <= tc; t++) {
			String ans = "IMPOSSIBLE";

			out.printf("Case #%d: ", t);
			int x = sc.nextInt(), y = sc.nextInt();
			for (String s : cand)
				if (solve(s, x, y)) {
					ans = s;
					break;
				}
			out.println(ans);

		}
		out.close();

	}

	private static boolean solve(String s, int x, int y) {
		for (int i = 0; i < s.length(); i++) {
			int val = 1 << i;
			if (s.charAt(i) == 'S')
				y += val;
			else if (s.charAt(i) == 'N')
				y -= val;
			else if (s.charAt(i) == 'E')
				x -= val;
			else if (s.charAt(i) == 'W')
				x += val;

		}
		return x == 0 && y == 0;
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