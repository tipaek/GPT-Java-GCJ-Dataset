import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int test = 1;
		while (T-- > 0) {
			char[] a = r.next().toCharArray();
			int[] arr = new int[a.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = a[i]-'0';
			}
			String out = "";
			int open = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == open) {
					out += arr[i];
				}
				else if (arr[i] < open) {
					open--;
					out += ")";
					i--;
				} else {
					open++;
					out += "(";
					i--;
				}
			}
			while(open>0){
				open--;
				out += ")";
			}
			System.out.printf("Case #%d: %s\n", test++, out);
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
