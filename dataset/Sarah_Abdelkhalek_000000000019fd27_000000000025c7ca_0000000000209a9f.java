
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int Case = 1;
		while (t-- > 0) {
			StringBuilder sb = new StringBuilder();
			char arr[] = sc.nextLine().toCharArray();
			int n = arr.length;
			int open = 0;
			for (int i = 0; i < n; i++) {
				int j = i;
				int need = arr[i] - '0';
				for (int k = 0; k < open - need; k++) {
					sb.append(")");
				}
				for (int k = 0; k < need - open; k++) {
					sb.append("(");
				}

				for (; j < n; j++) {
					if(arr[i]==arr[j])sb.append(""+need);
					else break;
				}
				open =need;
				i=j-1;
			}
			while(open-->0) {
				sb.append(")");
			}
			System.out.printf("Case #%d: %s\n", Case++, sb.toString());
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