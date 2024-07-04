

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskA {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t = in.nextInt();
			while (t-- > 0) {
				int n = in.nextInt();
				int arr[][] = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						arr[i][j] = in.nextInt();
					}
				}
				int dg = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (i == j) {
							dg += arr[i][j];
						}
					}
				}
				int m[][] = copyarray(arr);
				int c[][] = copyarray(arr);
				int row[][] = sortRowWise(m);
				int col[][] = sortbyColumn(c);
				int cr = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - 1; j++) {
						if (row[i][j] == row[i][j + 1]) {
							cr++;
							break;
						}
					}
				}
				int cc = 0;
				for (int j = 0; j < n; j++) {
					for (int i = 0; i < n - 1; i++) {
						if (col[i][j] == col[i + 1][j]) {
							cc++;
							break;
						}
					}
				}
				out.println(dg + " " + cr + " " + cc);
			}
		}

		public int[][] sortRowWise(int m[][]) {
			for (int i = 0; i < m.length; i++) {
				Arrays.sort(m[i]);
			}
			return m;
		}

		public int[][] sortbyColumn(int t[][]) {
			int n = t.length;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n - 1 - j; k++) {
						if (t[k][i] > t[k + 1][i]) {
							int temp = t[k][i];
							t[k][i] = t[k + 1][i];
							t[k + 1][i] = temp;
						}
					}
				}
			}
			return t;
		}

		public int[][] copyarray(int arr[][]) {
			int temp[][] = new int[arr.length][arr[0].length];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			return temp;
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String nextLine() {
			// TODO Auto-generated method stub
			return null;
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

	}
}
