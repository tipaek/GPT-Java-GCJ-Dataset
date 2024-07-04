import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			int N = sc.nextInt();
			out.println("Case #" + caze + ":");
			int r = 1, k = 1;
			if (N > 30) {
				int tmp = N - 30;
				N = 30;
				for (int i = 0; i < 30 && tmp > 0; i++) {
					if ((tmp & (1 << i)) != 0) {
						if (k == 1) {
							for (k = 1; k <= r; k++) {
								out.println(r + " " + k);
							}
							k = r;
						} else {
							if (k != r) throw new RuntimeException();
							for (k = r; k >= 1; k--) {
								out.println(r + " " + k);
							}
							k = 1;
						}
						tmp -= 1 << i;
					} else {
						out.println(r + " " + k);
						N--;
					}
					if (k != 1) k++;
					r++;
				}
			}
			while (N > 0) {
				out.println(r + " " + k);
				if (k != 1) k++;
				r++;
				N--;
			}
			
			out.flush();
		}
	}
	
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer tokenizer;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
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
