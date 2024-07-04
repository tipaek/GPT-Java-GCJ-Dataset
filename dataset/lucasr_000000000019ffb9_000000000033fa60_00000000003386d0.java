import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			int n = sc.nextInt();
			long[] x = new long[n], y = new long[n];
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextLong();
				y[i] = sc.nextLong();
			}
			int ans = 1;
			if (n > 1) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < i; j++) {
						long a = y[j] - y[i];
						long b = x[i] - x[j];
						Map<Long, Integer> counter = new HashMap<>();
						for (int k = 0; k < n; k++) {
							long val = x[k] * a + y[k] * b;
							counter.put(val, counter.getOrDefault(val, 0) + 1);
						}
						boolean start = false, end = false, gotImpar = false;
						int tot = 0;
						for (int cc : counter.values()) {
							if (cc == 1) {
								if (!start) {
									start = true;
									tot++;
								} else if (!end) {
									end = true;
									tot++;
								}
							} else if (cc % 2 == 0) {
								tot += cc;
							} else {
								if (!gotImpar) {
									tot += cc - 1;
									gotImpar = true;
								} else {
									tot += cc + 1;
									gotImpar = false;
								}
							}
						}
						ans = Math.max(ans, tot);
					}
				}
			
			}
			out.println("Case #" + caze + ": " + ans);
			
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
