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
			long left = r.nextLong();
			long right = r.nextLong();
			int customer = 1;
			while (true) {
				boolean can = false;
				if (left >= right && left >= customer) {
					left -= customer;
					can = true;
				} else if (right > left && right >= customer) {
					right -= customer;
					can = true;
				}
				if (!can)
					break;
				customer++;
			}
			System.out.printf("Case #%d: %d %d %d\n", test++, customer - 1,
					left, right);
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
