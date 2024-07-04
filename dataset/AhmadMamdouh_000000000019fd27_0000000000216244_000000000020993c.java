import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int test = 1;
		while (T-- > 0) {
			int n = r.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = r.nextInt();
				}
			}
			int trace = 0;
			for (int i = 0; i < arr.length; i++) {
				trace += arr[i][i];
			}
			int row = 0, col = 0;
			for (int i = 0; i < arr.length; i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				HashSet<Integer> set2 = new HashSet<Integer>();
				for (int j = 0; j < arr.length; j++) {
					set.add(arr[i][j]);
					set2.add(arr[j][i]);
				}
				if (set.size() != n)
					row++;
				if (set2.size() != n)
					col++;
			}
			System.out.printf("Case #%d: %d %d %d\n", test++, trace, row, col);
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
