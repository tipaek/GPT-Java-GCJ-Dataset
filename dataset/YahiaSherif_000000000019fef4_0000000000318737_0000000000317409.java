import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		int tc = 1;
		while (t-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.next();
			int[] xx = new int[s.length() + 1];
			int[] yy = new int[s.length() + 1];
			xx[0] = x;
			yy[0] = y;
			for (int i = 0; i < xx.length - 1; i++) {
				xx[i + 1] = xx[i];
				yy[i + 1] = yy[i];
				if (s.charAt(i) == 'N') {
					yy[i + 1]++;
				}
				if (s.charAt(i) == 'S') {
					yy[i + 1]--;
				}
				if (s.charAt(i) == 'E') {
					xx[i + 1]++;
				}
				if (s.charAt(i) == 'W') {
					xx[i + 1]--;
				}
			}
			int ans = -1;
			for (int i = 0; i < xx.length; i++) {
				if ((Math.abs(xx[i]) + Math.abs(yy[i])) <= i) {
					ans = i;
					break;
				}
			}
			pw.printf("Case #%d: %s%n", tc++, ans == -1 ? "Impossible" : ans);
		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
