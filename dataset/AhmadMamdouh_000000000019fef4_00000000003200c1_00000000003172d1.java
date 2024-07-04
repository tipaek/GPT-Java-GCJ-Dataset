import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int t = r.nextInt();
		int test = 1;
		while (t-- > 0) {
			int n = r.nextInt();
			int d = r.nextInt();
			long[] arr = new long[n];
			HashSet<Long> set = new HashSet<Long>();
			HashMap<Long, Integer> count = new HashMap<Long, Integer>();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = r.nextLong();
				if (!count.containsKey(arr[i]))
					count.put(arr[i], 0);
				count.put(arr[i], count.get(arr[i]) + 1);
				set.add(arr[i]);
			}

			Arrays.sort(arr);

			int res = 2;
			if (n == 1) {
				if (d == 2) {
					res = 1;
				} else {
					res = 2;
				}
			} else if (n == 2) {
				if (d == 2) {
					if (set.size() == 1) {
						res = 0;
					} else {
						res = 1;
					}
				} else {
					if (set.size() == 1) {
						res = 2;
					} else {
						if (arr[1] == 2 * arr[0]) {
							res = 1;
						} else {
							res = 2;
						}
					}
				}
			} else {
				if (d == 2) {
					if (set.size() < arr.length) {
						res = 0;
					} else {
						res = 1;
					}
				} else {
					if (set.size() < arr.length - 1) {
						// TEST limit
						res = 0;
					} else if (set.size() < arr.length) {
						loop: for (int i = 0; i < arr.length; i++) {
							if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
								res = 1;
								break loop;
							}
							if (count.get(arr[i]) >= 2) {

								for (int j = 0; j < arr.length; j++) {
									if (arr[j] > arr[i]) {
										res = 1;
										break loop;
									}
								}
							}
						}
					} else {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
								res = 1;
							}
						}
					}
				}
			}
			System.out.printf("Case #%d: %d\n", test++, res);
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
