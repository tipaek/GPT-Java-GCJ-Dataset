import java.io.*;
import java.util.*;

public class Solution {

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
					sl = lsf;
				}
				for (int j = i - 1; j >= 0; --j) {
					String ss = sa[j];
					int idxq = ss.indexOf('*');
					String spf = ss.substring(0, idxq);
					String ssf = ss.substring(idxq + 1);

					if (spf.length() > pl.length()) {
						pl = spf;
					}
					if (ssf.length() > sl.length()) {
						sl = ssf;
					}
					if (!pfb(lpf, spf)) {
						ash.append("*\n");
						continue A;
					}
					if (!sfb(lsf, ssf)) {
						ash.append("*\n");
						continue A;
					}
				}
			}
			ash.append(pl + sl + "\n");
		}
		System.out.print(ash);
	}

	static public boolean pfb(String s1, String s2) {
		boolean b = true;
		if (s1.length() > s2.length()) {
			for (int i = 0; i < s2.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i))
					return false;
			}
		} else {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i))
					return false;
			}
		}
		return b;
	}

	static public boolean sfb(String s1, String s2) {
		boolean b = true;
		if (s1.length() > s2.length()) {
			int i = s1.length() - 1, j = s2.length() - 1;
			while (j >= 0) {
				if (s1.charAt(i--) != s2.charAt(j--))
					return false;
			}
		} else {
			int i = s1.length() - 1, j = s2.length() - 1;
			while (i >= 0) {
				if (s1.charAt(i--) != s2.charAt(j--))
					return false;
			}
		}
		return b;
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