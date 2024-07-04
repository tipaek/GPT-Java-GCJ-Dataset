import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int test = scan.nextInt();
		for(int t=1;t<=test;t++) {
			String s = scan.next();
			int len = s.length();
			int[] digits = new int[len+2];
			digits[0]=0;
			digits[len+1]=0;
			for(int i=0;i<len;i++) {
				digits[i+1] = s.charAt(i) - '0';
			}
			StringBuilder result = new StringBuilder();
			result.append("Case #").append(t).append(": ");
			for(int i=1;i<=len;i++) {
				int prevDiff = (digits[i]>digits[i-1]) ? (digits[i]-digits[i-1]) : 0;
				int nextDiff = (digits[i]>digits[i+1]) ? (digits[i]-digits[i+1]) : 0;
				for(int j=0;j<prevDiff;j++) {
					result.append("(");
				}
				result.append(digits[i]);
				for(int j=0;j<nextDiff;j++) {
					result.append(")");
				}
			}
			System.out.println(result.toString());
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
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
	}
}
