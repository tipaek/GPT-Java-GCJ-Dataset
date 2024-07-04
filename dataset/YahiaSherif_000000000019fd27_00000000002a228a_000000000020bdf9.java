import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][3];
			for (int i = 0; i < arr.length; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = i;
			}
			Arrays.sort(arr, (a, b) -> a[0] - b[0]);
			
			int[] taken = new int[n];
			for (int i = 0; i < n;) {
				taken[i] = 1;
				int s = i;
				while (i < n && arr[i][0] < arr[s][1])
					i++;
			}
			for (int i = 0; i < n;) {
				if (taken[i] == 0) {
					taken[i] = 2;
					int s = i;
					while (i < n && arr[i][0] < arr[s][1])
						i++;
				} else
					i++;
			}
//			pw.println(Arrays.toString(taken));
			boolean v = true;
			char[] ans = new char[n];

			for (int i = 0; v && i < taken.length; i++) {
				if (taken[i] == 0)
					v = false;
				ans[arr[i][2]] = taken[i] == 1 ? 'C' : 'J';
			}
			pw.printf("Case #%d: ", tc);
			if (!v) {
				pw.println("IMPOSSIBLE");
			} else {
				for (int i = 0; i < n; i++) {
					pw.print(ans[i]);
				}
				pw.println();
			}
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
