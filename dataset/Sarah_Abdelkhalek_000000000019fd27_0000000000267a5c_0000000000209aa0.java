
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int Case = 1;
		out: while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (k % n != 0 || k / n > n) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", Case++);
				continue out;
			}
			int start = k / n - 1;
			int nums[] = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = (start + i) % n + 1;
			}
//			System.out.println(Arrays.toString(nums));
			int ans[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int JIDX = (i + j) % n;
					ans[i][JIDX] = nums[j];
				}
			}
			System.out.printf("Case #%d: POSSIBLE\n", Case++);
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb.append(ans[i][j]+" ");
				}
				System.out.println(sb.toString().trim());
				
			}
		}
	}
}

class pair implements Comparable<pair> {
	public pair(int s, int e, int idx) {
		this.s = s;
		this.e = e;
		this.idx = idx;
	}

	int s, e, idx;

	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return s - o.s == 0 ? e - o.e : s - o.s;
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