import java.io.*;
import java.util.*;

public class Solution {

	static Scanner sc;

	static int query(int idx) throws IOException {
		System.out.println(idx + 1);
		return sc.nextInt();
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner();
		int tc = sc.nextInt();
		int n = sc.nextInt();
		boolean[] same = new boolean[n];

		for (int t = 1; t <= tc; t++) {
			int[] ans = new int[n];
			for (int i = 0; i < n / 2; i++) { // n queries
				ans[i] = query(i);
				ans[n - 1 - i] = query(n - 1 - i);
				same[i] = ans[i] == ans[n - 1 - i];
			}
            int queries = n / 2;
			while (queries % 10 != 1) {
				query(0);
				queries++;
			}
			boolean toggle = false;
			for (int i = 0; i < n / 2; i++)
				if (same[i]) {
					if (query(i) != ans[i]) // 1
						toggle = true;
					break;

				}
			for (int i = 0; i < n / 2; i++)
				if (same[i] && toggle)
					ans[i] = ans[n - 1 - i] = ans[i] ^ 1;

			toggle = false;
			for (int i = 0; i < n / 2; i++)
				if (!same[i]) {
					if (query(i) != ans[i]) // 1
						toggle = true;
					break;

				}
			for (int i = 0; i < n / 2; i++)
				if (!same[i] && toggle) {
					ans[i] ^= 1;
					ans[n - 1 - i] ^= 1;

				}

			for (int i = 0; i < n; i++)
				System.out.print(ans[i]);
			System.out.println();
			if (sc.next().equals("N"))
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