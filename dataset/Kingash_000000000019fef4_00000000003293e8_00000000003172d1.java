import java.io.*;
import java.util.*;

public class Solution {

	static long m = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = scn.nextInt(), tcs = 0;
		C: while (tcs++ < T) {
			sb.append("Case #" + tcs + ": ");
			int n = scn.nextInt(), d = scn.nextInt();
			HashMap<Long, Integer> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long x = scn.nextLong();
				hm.put(x, hm.getOrDefault(x, 0) + 1);
			}
			if (n == 1) {
				sb.append((d - 1) + "\n");
				continue C;
			}
			boolean mt = false;
			long mint = Long.MAX_VALUE;
			for (long v : hm.keySet()) {
				if (hm.get(v) >= d) {
					sb.append("0\n");
					continue C;
				}
				if (hm.get(v) == 2) {
					mt = true;
					mint = Math.min(mint, v);
				}
			}
			if (d == 2) {
				sb.append((mt ? 0 : 1) + "\n");
				continue C;
			}
			if (mt)
				for (long v : hm.keySet()) {
					if (v > mint) {
						sb.append("1\n");
						continue C;
					}
				}
			for (long v : hm.keySet()) {
				if (hm.get(v) == 3) {
					sb.append("0\n");
					continue C;
				}
			}
			for (long x : hm.keySet()) {
				for (long y : hm.keySet()) {
					if (x < y) {
						if (x == y - x || hm.get(x) >= 2 || hm.getOrDefault(y - x, 0) >= 2) {
							sb.append("1\n");
							continue C;
						}
					}
				}
			}
			if (d == 3) {
				sb.append("2\n");
				continue C;
			}
			int minc = d - 1;
			D: for (long x : hm.keySet()) {
				int v = hm.get(x), c = 0;
				for (long y : hm.keySet()) {
					if (x < y) {
						c++;
						if (x == y - x) {
							v += 2;
						} else {
							v++;
						}
						if (v >= d) {
							minc = Math.min(minc, c);
							continue D;
						}
					}
				}
			}
			sb.append(minc + "\n");
		}
		System.out.print(sb);
	}

	static class Scanner {

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
	}
}