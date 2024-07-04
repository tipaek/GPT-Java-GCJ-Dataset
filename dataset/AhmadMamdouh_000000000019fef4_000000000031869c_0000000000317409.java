import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int t = r.nextInt();
		int test = 1;
		while (t-- > 0) {
			int x = r.nextInt();
			int y = r.nextInt();
			char[] arr = r.next().toCharArray();
			int res = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'N') {
					y++;
				} else if (arr[i] == 'S') {
					y--;
				} else if (arr[i] == 'E') {
					x++;
				} else {
					x--;
				}
				int dist = Math.abs(x) + Math.abs(y);
				int time = i + 1;
				if (dist <= time) {
					res = time;
					break;
				}
			}
			if (res == -1) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", test++);
			} else {
				System.out.printf("Case #%d: %d\n", test++, res);
			}
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
