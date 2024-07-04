import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {

	static char[] arr;
	static int[] open, close;

	public static void solve(int idx, int o) {
		if (idx == arr.length)
			return;
		if (o < arr[idx] - '0') {
			open[idx] = arr[idx] - '0' - o;
		} else
			close[idx] = -arr[idx] + '0' + o;
		solve(idx + 1, arr[idx] - '0');
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		int tc = 1;
		while (t-- > 0) {
			arr = sc.next().toCharArray();
			open = new int[arr.length];
			close = new int[arr.length];
			int o = 0;
			solve(0, 0);
			pw.printf("Case #%d: ", tc++);
			for (int i = 0; i < arr.length; i++) {
				while (open[i]-- > 0) {
					pw.print('(');
					o++;
				}
				while (close[i]-- > 0) {
					pw.print(')');
					o--;
				}
				pw.print(arr[i]);
			}
			while (o-- > 0)
				pw.print(')');
			pw.println();
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
