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
			String beg = "", end = "";
			StringBuilder mid = new StringBuilder();
			int N = sc.nextInt();
			boolean can = true;
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				int pos = tmp.indexOf('*');
				if (pos > 0) {
					beg = combineBeg(beg, tmp.substring(0, pos));
				}
				int lPos = tmp.lastIndexOf('*');
				if (lPos < tmp.length() - 1) {
					end = combineEnd(end, tmp.substring(lPos + 1, tmp.length()));
				}
				for (int j = pos + 1; j < lPos; j++) if (tmp.charAt(j) != '*') {
					mid.append(tmp.charAt(j));
				}
			}
			can &= beg != null && end != null;
			out.println("Case #" + caze + ": " + (can ? beg + mid.toString() + end: "*"));
			
			out.flush();
		}
	}
	
	static String combineBeg(String a, String b) {
		if (a == null || b == null) return null;
		if (a.length() > b.length()) {
			return combineBeg(b, a);
		}
		if (b.startsWith(a)) return b;
		return null;
	}
	
	static String combineEnd(String a, String b) {
		if (a == null || b == null) return null;
		if (a.length() > b.length()) {
			return combineEnd(b, a);
		}
		if (b.endsWith(a)) return b;
		return null;
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
