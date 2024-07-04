import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int test = 1;
		while (T-- > 0) {
			int n = r.nextInt();
			int m = r.nextInt();
			int res = 0;
			int[][] arr = new int[n][m];
			int interest = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = r.nextInt();
					interest += arr[i][j];
				}
			}

			while (true) {
				res += interest;
				LinkedList<Point> el = new LinkedList<Point>();
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						if (arr[i][j] > 0) {
							int comp = 0;
							int row = i - 1;
							int cnt = 0;
							while (row >= 0 && arr[row][j] == 0)
								row--;
							if (row >= 0) {
								comp += arr[row][j];
								cnt++;
							}

							row = i + 1;
							while (row < n && arr[row][j] == 0)
								row++;
							if (row < n) {
								comp += arr[row][j];
								cnt++;
							}

							int col = j - 1;
							while (col >= 0 && arr[i][col] == 0)
								col--;
							if (col >= 0) {
								comp += arr[i][col];
								cnt++;
							}

							col = j + 1;
							while (col < m && arr[i][col] == 0)
								col++;
							if (col < m) {
								comp += arr[i][col];
								cnt++;
							}
							if (cnt > 0) {
								double av = 1.0 * comp / cnt;
								if (arr[i][j] < av) {
									el.add(new Point(i, j));
								}
							}

						}
					}
				}
				if (el.size() > 0) {
					for (Point p : el){
						interest-=arr[p.x][p.y];
						arr[p.x][p.y] = 0;
					}
					
				} else
					break;
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
