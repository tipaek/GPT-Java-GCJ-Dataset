import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution implements Runnable {
	
	
	private void solve() throws IOException {
		int t = nextInt();
		while (t-- > 0) {
			int n = nextInt();
			int[] freqR = new int[n + 1];
			int[] freqC = new int[n + 1];
			int[][] arr = new int[n][n];
			int trace = 0, r = 0, c = 0;
			boolean cont = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = nextInt();
					
					if (i == j) trace += arr[i][j];
					
					freqR[arr[i][j]]++;
					if (freqR[arr[i][j]] > 1 && cont) {
						r++;
						cont = false;
					}
				}
				freqR = new int[n + 1];
				cont = true;
			}
			
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {					
					freqC[arr[i][j]]++;
					if (freqC[arr[i][j]] > 1) {
						c++;
						break;
					}
				}
				freqC = new int[n + 1];
			}
			pf();
			pl(trace, r, c);
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
			writer = new PrintWriter(System.out);
			tokenizer = null;
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	BigInteger nextBigInteger() throws IOException {
		return new BigInteger(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	void p(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	void pl(Object... objects) {
		p(objects);
		writer.println();
	}

	int cc;

	void pf() {
		writer.printf("Case #%d: ", ++cc);
	}

}