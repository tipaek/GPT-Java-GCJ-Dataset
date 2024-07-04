

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
				String s = in.next();
				StringBuffer sb = new StringBuffer(s);
				sb.insert(0, "0");
				sb.insert(sb.length(), "0");
//				out.print(sb);
				String str = "";
				for (int i = 1; i < sb.length() - 1; i++) {
					int x = sb.charAt(i) - sb.charAt(i - 1);
					int y = sb.charAt(i) - '0';

					if (x == 0) {
						str += y;
					} else if (x == 1) {
						str += "(" + y;
					} else if (x == 2) {
						str += "((" + y;
					} else if (x == 3) {
						str += "(((" + y;
					} else if (x == 4) {
						str += "((((" + y;
					} else if (x == 5) {
						str += "(((((" + y;
					} else if (x == 6) {
						str += "((((((" + y;
					} else if (x == 7) {
						str += "(((((((" + y;
					} else if (x == 8) {
						str += "((((((((" + y;
					} else if (x == 9) {
						str += "(((((((((" + y;
					} else if (x == -1) {
						str += ")" + y;
					} else if (x == -2) {
						str += "))" + y;
					} else if (x == -3) {
						str += ")))" + y;
					} else if (x == -4) {
						str += "))))" + y;
					} else if (x == -5) {
						str += ")))))" + y;
					} else if (x == -6) {
						str += "))))))" + y;
					} else if (x == -7) {
						str += ")))))))" + y;
					} else if (x == -8) {
						str += "))))))))" + y;
					} else if (x == -9) {

						str += ")))))))))" + y;
					}

				}
				int n = sb.length();
				int z = sb.charAt(n - 1) - sb.charAt(n - 2);
				if (z == -1) {
					str += ")";
				} else if (z == -2) {
					str += "))";
				} else if (z == -3) {
					str += ")))";
				} else if (z == -4) {
					str += "))))";
				} else if (z == -5) {
					str += ")))))";
				} else if (z == -6) {
					str += "))))))";
				} else if (z == -7) {
					str += ")))))))";
				} else if (z == -8) {
					str += "))))))))";
				} else if (z == -9) {
					str += ")))))))))";
				}

				out.println(str);

			}
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
