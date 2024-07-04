import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		StringBuilder ash = new StringBuilder();
		A: for (int t = 1; t <= T; t++) {
			ash.append("Case #" + t + ": ");
			int n = scn.nextInt();
			String sa[] = new String[n];
			for (int i = 0; i < n; i++) {
				sa[i] = scn.next();
			}
			String pl = "", sl = "";
			for (int i = n - 1; i > 0; --i) {
				String ls = sa[i];
				int idx = ls.indexOf('*');
				String lpf = ls.substring(0, idx);
				String lsf = ls.substring(idx + 1);
				if (lpf.length() > pl.length()) {
					pl = lpf;
				}
				if (lsf.length() > sl.length()) {
					pl = lsf;
				}
				for (int j = i - 1; j >= 0; --j) {
					String ss = sa[j];
					int idxq = ss.indexOf('*');
					String spf = ss.substring(0, idxq);
					String ssf = ss.substring(idxq + 1);

					if (spf.length() > pl.length()) {
						pl = spf;
					}
					if (ssf.length() > pl.length()) {
						pl = ssf;
					}
					if (!lpf.contains(spf) && !spf.contains(lpf)) {
						ash.append("*\n");
						continue A;
					}
					if (!lsf.contains(ssf) && !ssf.contains(lsf)) {
						ash.append("*\n");
						continue A;
					}
				}
			}
			ash.append(pl + sl + "\n");
		}
		System.out.print(ash);
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