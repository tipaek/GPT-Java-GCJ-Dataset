import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		while(t --> 0) {
			int n = nextInt();
			int h = 0;
			int v = 0;
			boolean[] h1 = new boolean[n];
			boolean[] v1 = new boolean[n];
			boolean[][] hori = new boolean[n][n];
			boolean[][] vert = new boolean[n][n];
			int sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int t1 = nextInt() - 1;
					if(j == i)
						sum += t1 + 1;
					if(hori[i][t1] && !h1[i]) { h++; h1[i] = true;}else hori[i][t1] = true;
					if(vert[t1][j] && !v1[j]) {v++; v1[j] = true;}else vert[t1][j] = true;
				}
			}
			System.out.println("case #" + l++ + ": " + sum + " " + h + " " + v);
		}
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
