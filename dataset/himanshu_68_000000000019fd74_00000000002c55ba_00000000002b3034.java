
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Solution {
	public static void solve() {
		int t = s.nextInt();
		int count = 1;
		loop1: while (t-- > 0) {
			int n = s.nextInt();
			StringBuilder res = new StringBuilder();
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < n; i++) {
				String str = s.next();
				int ind = 0;
				int flag = 0;
				if (str.charAt(0) == '*') {
					if (res.length() > 0) {
						if (res.length() < str.length()) {
							if (res.charAt(res.length() - 1) == str.charAt(str.length() - 1)) {
								for (int j = 1; j < str.length(); j++) {
									if (res.toString().equals(str.substring(j, str.length()))) {
										flag = 1;
										res.replace(0, res.length(), str.substring(1));
										break;
									}
								}

							} else if (res.charAt(0) == str.charAt(1)) {
								for (int j = str.length(); j > 0; j--) {
									System.out.println(str.substring(1, j));
									if (res.toString().equals(str.substring(1, j))) {
										flag = 1;
										res.replace(0, res.length(), str.substring(1,str.length()));
										break;
									}

								}
							}
							if (flag == 0) {
								out.println("Case #" + count + ": *");
								count++;
								continue loop1;
							}
						}else {
							if (str.charAt(str.length() - 1) == res.charAt(res.length() - 1)) {
								for (int j = 0; j < res.length(); j++) {
									if (str.substring(1).equals(res.substring(j, res.length()))) {
										flag = 1;
										break;
									}
								}

							} else if (res.charAt(0) == str.charAt(1)) {
								for (int j = res.length(); j > 0; j--) {
									System.out.println(res.substring(0, j));
									if (str.substring(1).equals(res.substring(0, j))) {
										flag = 1;
										break;
									}

								}
							}
							if (flag == 0) {
								out.println("Case #" + count + ": *");
								count++;
								continue loop1;
							}
						}

					} else {
						res.append(str.substring(1, str.length()));

					}
				}
			}
			out.println("Case #" + count + ": "+res.toString());
			count++;
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		s = new FastReader();
		solve();
		out.close();
	}

	public static FastReader s;
	public static PrintWriter out;

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
