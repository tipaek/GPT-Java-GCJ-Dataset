import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int n, k;
	static Integer[][] sol;
	static boolean found;

	static void go(Integer[][] arr, int row, int col) {
		if (found)
			return;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][i] != null)
				sum += arr[i][i];
		}
		if (sum > k)
			return;
		int c1 = 0, c2 = 0;
		for (int i = 0; i < arr.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			HashSet<Integer> set2 = new HashSet<Integer>();
			int rr = 0, cc = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != null) {
					set.add(arr[i][j]);
					rr++;
				}
				if (arr[j][i] != null) {
					cc++;
					set2.add(arr[j][i]);
				}
			}
			if (set.size() != rr)
				c1++;
			if (set2.size() != cc)
				c2++;
		}
		if (c1 > 0 || c2 > 0)
			return;

		if (row == n) {
			if (sum == k && c1 == 0 && c2 == 0) {
				found = true;
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						sol[i][j] = arr[i][j];
					}
				}
			}
			return;
		}
		for (int i = 1; i <= n; i++) {
			arr[row][col] = i;
			if (col + 1 == n)
				go(arr, row + 1, 0);
			else
				go(arr, row, col + 1);
			arr[row][col] = null;
		}

	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int test = 1;
		while (T-- > 0) {
			n = r.nextInt();
			k = r.nextInt();
			Integer[][] arr = new Integer[n][n];
			sol = new Integer[n][n];
			found = false;
			go(arr, 0, 0);
			if (found) {
				System.out.printf("Case #%d: POSSIBLE\n", test++);
				for (Integer[] a : sol) {
					for (int i = 0; i < n; i++) {
						System.out.print(a[i]);
						if (i != n - 1)
							System.out.print(" ");
					}
					System.out.println();
				}
			} else
				System.out.printf("Case #%d: IMPOSSIBLE\n", test++);
		}
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
