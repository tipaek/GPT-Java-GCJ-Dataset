import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNum = 1;

		while (t-- > 0) {
			int n = sc.nextInt();
			String arr[] = new String[n];
			String middle[] = new String[n];

			String longestPref = "";
			String longestSuff = "";
			boolean ansBool = true;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLine();

				int preIdx = arr[i].indexOf('*');
				int suffIdx = arr[i].lastIndexOf('*');
				String prefix = "";
				String suffex = "";
//				System.out.println(suffIdx + " " + preIdx);
				if (preIdx > 0)
					prefix = arr[i].substring(0, preIdx);
				if (suffIdx < arr[i].length() - 1)
					suffex = arr[i].substring(suffIdx + 1, arr[i].length());

				if (!checkEqPre(longestPref, prefix) || !checkEqSuff(longestSuff, suffex)) {
//					System.out.println(longestPref + " " + prefix);
//					System.out.println(longestSuff + " " + suffex);
					ansBool = false;
				} else {
					if (longestPref.length() < prefix.length())
						longestPref = prefix;
					if (longestSuff.length() < suffex.length())
						longestSuff = suffex;

				}
				if (preIdx != -1)
					middle[i] = arr[i].substring(preIdx, suffIdx + 1).replace("*", "");
				else
					middle[i] = "";

			}
			if (!ansBool) {
				System.out.printf("Case #%d: *\n", caseNum++);
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(longestPref);
				for (int i = 0; i < middle.length; i++) {
					sb.append(middle[i]);
				}
				sb.append(longestSuff);
				System.out.printf("Case #%d: %s\n", caseNum++, sb.toString());

			}

		}
	}

	public static boolean checkEqPre(String s, String q) {
		for (int i = 0; i < Math.min(s.length(), q.length()); i++) {
			if (s.charAt(i) != q.charAt(i))
				return false;
		}
		return true;
	}

	public static boolean checkEqSuff(String s, String q) {
		String s1 = new StringBuilder(s).reverse().toString();
		String s2 = new StringBuilder(q).reverse().toString();
		return checkEqPre(s1, s2);

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