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
			char[] digs = sc.next().toCharArray();
			int[] vals = new int[digs.length];
			for (int i = 0; i < vals.length; i++) {
				vals[i] = digs[i]-'0';
			}
			int got = 0;
			out.print("Case #" + caze + ": ");
			for (int i = 0; i < vals.length; i++) {
				while (got < vals[i]) {
					out.print("(");
					got++;
				}
				while (got > vals[i]) {
					out.print(")");
					got--;
				}
				out.print(vals[i]);
			}
			while (got > 0) {
				out.print(")");
				got--;
			}
			out.println();
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
