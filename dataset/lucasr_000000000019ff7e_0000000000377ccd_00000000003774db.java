
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			char[] C = sc.next().toCharArray();
			char[] J = sc.next().toCharArray();
			int[][] table = new int[C.length + 1][J.length + 1];
			for (int i = C.length; i >= 0; i--) {
				for (int j = J.length; j >= 0; j--) {
					if (i == C.length) {
						table[i][j] = J.length - j;
					} else if (j == J.length) {
						table[i][j] = C.length - i;
					} else {
						if (C[i] == J[j]) {
							table[i][j] = table[i+1][j+1];
						} else {
							table[i][j] = 1 + table[i+1][j+1];
							table[i][j] = Math.min(table[i][j], 1 + table[i+1][j]);
							table[i][j] = Math.min(table[i][j], 1 + table[i][j+1]);
						}
					}
				}
			}
			int need = (table[0][0] + 1) / 2;
			int i, other = 0;
			for (i = 0; i <= C.length; i++) {
				if (table[i][other] == need) {
					break;
				} else {
					if (other < J.length && table[i][other] == table[i+1][other+1]) {
						other++;
					} else if (other < J.length && table[i][other] == 1 + table[i+1][other + 1]) {
						other++;
					} else if (other < J.length && table[i][other] == 1 + table[i][other + 1]) {
						i--;
						other++;
					} else if (table[i][other] == 1 + table[i+1][other]) {
						// nothing
					}
				}
			}
			String ret = new String(Arrays.copyOfRange(C, 0, i)) + new String(Arrays.copyOfRange(J, other, J.length));
			
			out.println("Case #" + caze + ": " + ret);
			
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
