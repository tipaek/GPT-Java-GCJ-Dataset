
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int Case = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			long k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					if (i == j)
						k += arr[i][j];
				}
			}
			int r = 0;
			out: for (int i = 0; i < n; i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				for (int j = 0; j < n; j++) {
					if (set.contains(arr[i][j])) {
						r++;
						continue out;
					}
					set.add(arr[i][j]);
				}
			}
			int c = 0;
			out: for (int i = 0; i < n; i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				for (int j = 0; j < n; j++) {
					if (set.contains(arr[j][i])) {
						c++;
						continue out;
					}
					set.add(arr[j][i]);
				}
			}
			System.out.printf("Case #%d: %d %d %d\n",Case++, k, r, c);

		}
	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public double nextDouble() throws IOException {
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}