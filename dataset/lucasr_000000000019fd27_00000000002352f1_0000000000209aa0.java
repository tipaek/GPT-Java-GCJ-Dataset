import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K;
	
	static int[][] getEquals(int N) {
		int[][] ret = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret[i][j] = (N - i + j) % N;
			}
		}
		
		return ret;
	}
	
	static int[][] getAllButTwo(int N) {
		if (N < 4) return null;
		int[][] ret = new int[N][N];
		
		for (int i = 0; i < N - 3; i++) {
			for (int j = 0; j < N; j++) {
				ret[i][j] = (N - i + j) % N;
			}
		}
		ret[N-3][0] = 1;
		ret[N-2][0] = 2;
		ret[N-1][0] = 3;
		for (int i = 1; i < N - 3; i++) {
			ret[N-3][i] = i + 2;
			ret[N-2][i] = (i & 1) == 1 ? i + 3 : i + 1;
			ret[N-1][i] = ret[N-1][i-1] + ((i & 1) == 1 ? -1 : 3);
		}
		ret[N-2][N-2] = ret[N-1][N-1] = 1;
		ret[N-3][N-2] = N-1;
		ret[N-3][N-1] = 2;
		ret[N-2][N-3] = (N & 1) == 1 ? N-2 : N-1;
		ret[N-1][N-3] = (N & 1) == 1 ? N-1 : N-2;
		
		return ret;
	}
	
	static int[][] getAllButOneOne(int N) {
		int[][] ret = getEquals(N);
		
		for (int i = 0; i < N; i++) {
			int tmp = ret[i][N-2];
			ret[i][N-2] = ret[i][N-1];
			ret[i][N-1] = tmp;
		}
		swap(ret, N-1, 2);
		
		return ret;
	}
	
	static void swap(int[][] mat, int a, int b) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == a) mat[i][j] = b;
				else if (mat[i][j] == b) mat[i][j] = a;
			}
		}
	}
	
	static int[][] inc(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j]++;
			}
		}
		return mat;
	}
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			int[][] ans = null;
			if (K % N == 0) {
				ans = inc(getEquals(N));
				int div = K / N;
				if (div != 1) {
					swap(ans, 1, div);
				}
			} else if (N >= 4) {
				boolean found = false;
				for (int i = 1; i <= N && !found; i++) {
					for (int j = 1; j <= N && !found; j++) if (i != j) {
						if ((N - 2) * i + 2 * j == K) {
							found = true;
							ans = inc(getAllButTwo(N));
							int two = 2;
							if (i != 1) {
								swap(ans, 1, i);
								if (i == two) two = 1;
							}
							if (j != two) {
								swap(ans, two, j);
							}
						}
						for (int k = 1; k <= N && !found; k++) if (i != k && j != k) {
							if ((N - 2) * i + j + k == K ) {
								found = true;
								ans = inc(getAllButOneOne(N));
								int two = 2, three = 3;
								if (i != 1) {
									swap(ans, 1, i);
									if (i == two) two = 1;
									if (i == three) three = 1;
								}
								if (j != two) {
									swap(ans, two, j);
									if (j == three) three = two;
								}
								if (k != three) {
									swap(ans, three, k);
								}
							}
						}
					}
				}
				
			}
			
			out.println("Case #" + caze + ": " + (ans == null ? "IMPOSSIBLE": "POSSIBLE") );
			if (ans != null) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						out.print(ans[i][j] + " ");
					}
					out.println();
				}
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
