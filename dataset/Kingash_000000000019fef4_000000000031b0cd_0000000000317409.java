import java.io.*;
import java.util.*;

public class Solution {

	static long m = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = scn.nextInt(), tcs = 0;
		A: while (tcs++ < T) {
			sb.append("Case #" + tcs + ": ");
			boolean b = false;
			int x = scn.nextInt(), y = scn.nextInt();
			if (x == 0 && y == 0) {
				sb.append(0 + "\n");
				b = true;
			}
			TreeSet<Integer> ts = new TreeSet<Integer>();
			for (int i = 1; i * i <= 1000; i += 1) {
				if (100 % i == 0) {
					ts.add(i);
					ts.add(100 / i);
				}
			}
			char c[] = scn.next().toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (c[i] == 'S')
					y--;
				else if (c[i] == 'N') {
					y++;
				} else if (c[i] == 'W')
					x--;
				else
					x++;
				int temp = Math.abs(x) + Math.abs(y);
				if (temp <= (i + 1)) {
					sb.append(i + 1 + "\n");
					b = true;
					break;
				}
			}
			if (!b)
				sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb);
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