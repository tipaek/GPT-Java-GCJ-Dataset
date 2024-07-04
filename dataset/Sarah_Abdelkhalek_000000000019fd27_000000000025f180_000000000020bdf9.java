
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int Case = 1;
		out: while (t-- > 0) {
			int n = sc.nextInt();
			char ans[] = new char[n];
			ArrayList<pair> schedules = new ArrayList<pair>(n);
			ArrayList<pair> C = new ArrayList<pair>(n);
			ArrayList<pair> J = new ArrayList<pair>(n);

			for (int i = 0; i < n; i++) {
				schedules.add(new pair(sc.nextInt(), sc.nextInt(), i));
			}
			Collections.shuffle(schedules);
			Collections.sort(schedules);
			for (int i = 0; i < n; i++) {
				pair lastC = C.size() - 1 == -1 ? null : C.get(C.size() - 1);
				pair lastJ = J.size() - 1 == -1 ? null : J.get(J.size() - 1);
				pair curr = schedules.get(i);
				if (lastC == null || lastC.e <= curr.s) {
					C.add(curr);
				} else if (lastJ == null || lastJ.e <= curr.s) {
					J.add(curr);

				} else {
					System.out.printf("Case #d: IMPOSSIBLE\n", Case++);
					continue out;
				}
			}

			for (pair p : C) {
				ans[p.idx] = 'C';
			}
			for (pair p : J) {
				ans[p.idx] = 'J';
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(""+ans[i]);
			}
			System.out.printf("Case #%d: %s\n", Case++, sb.toString());

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