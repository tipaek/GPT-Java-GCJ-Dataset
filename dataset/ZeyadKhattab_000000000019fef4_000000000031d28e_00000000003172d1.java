import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			out.printf("Case #%d: ", t);
			int n = sc.nextInt(), d = sc.nextInt();
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextLong();
			sort(a);
			int ans = d - 1;
			for (int i = 0; i < n;) {

				int j = i;
				while (j < n && a[j] == a[i])
					j++;
				int cntSame = j - i;
				if (cntSame >= d) {
					ans = 0;
					break;
				}
				int curr = 0;
				int needed = d - cntSame;
				for (int k = j; k < n && needed > 0; k++)
					if (a[k] % a[i] == 0) {
						long div = a[k] / a[i];
						if (needed < div) {
							curr += needed;
							needed = 0;
						} else {
							curr += div - 1;
							needed -= div;
						}

					}
				for (int k = j; k < n && needed > 0; k++)
					if (a[k] % a[i] != 0) {
						long div = a[k] / a[i];
						div = Math.min(div, needed);
						curr += div;
						needed -= div;
					}
				if (needed == 0) {
					ans = Math.min(ans, curr);
				}
				i = j;

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

	static void sort(long[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(long[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			long tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}