import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int B;
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		B = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			int total = B / 2;
			int[] value = new int[total];
			boolean[] same = new boolean[total];
			
			int got = 0, req = 0;
			while (got < total) {
				if (req % 10 == 0 && req > 0) {
					boolean complement = false, both = true, ok = false;
					for (int i = 0; i < got; i++) if (same[i]) {
						if (getBit(i, out, sc) != value[i]) complement = true;
						ok = true;
						break;
					}
					if (!ok) getBit(0, out, sc);
					ok = false;
					for (int i = 0; i < got; i++) if (!same[i]) {
						if (getBit(i, out, sc) != value[i]) both = false;
						ok = true;
						break;
					}
					if (!ok) getBit(0, out, sc);
					if (complement) {
						for (int i = 0; i < got; i++) if (same[i]) {
							value[i] = 1 - value[i];
						}
					}
					if (!both) {
						for (int i = 0; i < got; i++) if (!same[i]) {
							value[i] = 1 - value[i];
						}
					}
					req+=2;
				}
				value[got] = getBit(got, out, sc);
				same[got] = value[got] == getBit(B - 1 - got, out, sc);
				got++;
				req+=2;
			}
			for (int i = 0; i < total; i++) {
				out.print(value[i]);
			}
			for (int i = total - 1; i >= 0; i--) {
				out.print(same[i] ? value[i] : 1 - value[i]);
			}
			out.println();
			out.flush();
			if (sc.next().charAt(0) == 'N') {
				throw new RuntimeException("Wrong Answer");
			}
		}
	}
	
	static int getBit(int pos, PrintWriter out, MyScanner sc) {
		out.println(pos + 1);
		out.flush();
		char ret = sc.next().charAt(0);
		if (ret == 'N') throw new RuntimeException("Returned N");
		return ret - '0';
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
