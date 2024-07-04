import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int test = scan.nextInt();
		for(int t=1;t<=test;t++) {
			int n = scan.nextInt();
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j] = scan.nextInt();
				}
			}
			int trace = 0;
			int noRows = 0;
			int noCols = 0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> rowHash = new HashSet<>();
				for(int j=0;j<n;j++) {
					if(!rowHash.add(matrix[i][j])) {
						noRows++;
						break;
					}
				}
				HashSet<Integer> colHash = new HashSet<>();
				for(int j=0;j<n;j++) {
					if(!colHash.add(matrix[j][i])) {
						noCols++;
						break;
					}
				}
				trace += matrix[i][i];
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(t).append(": ");
			sb.append(trace).append(" ");
			sb.append(noRows).append(" ");
			sb.append(noCols).append(" ");
			System.out.println(sb.toString());
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
