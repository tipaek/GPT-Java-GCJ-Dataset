import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	int sum;
	int[][] mat;
	ArrayList<Pair> rem;
	public class Pair {
		int x,y;
		public Pair(int a, int b) {
			x=a; y=b;
		}
	}
	public boolean trav() {
		int counter = 0;
		for (int i = 0; i<mat.length; i++ ) {
			for (int j = 0; j<mat[i].length; j++) {
				int sum1=0, count=0;
				if (mat[i][j]!=0) {
					for (int a = i-1; a>=0; a--) {
						if (mat[a][j]!=0) {
							sum1+=mat[a][j];
							count++;
							break;
						}
					}
					for (int a = i+1; a<mat.length; a++) {
						if (mat[a][j]!=0) {
							sum1+=mat[a][j];
							count++;
							break;
						}
					}
					for (int a = j-1; a>=0; a--) {
						if (mat[i][a]!=0) {
							sum1+=mat[i][a];
							count++;
							break;
						}
					}
					for (int a = j+1; a<mat[i].length; a++) {
						if (mat[i][a]!=0) {
							sum1+=mat[i][a];
							count++;
							break;
						}
					}
					if ((double)sum1/(double)count > mat[i][j]) {
						counter++;
						rem.add(new Pair(i,j));
					}
				}
			}
		}
		if (counter == 0) return false;
		return true;
	}
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int t = sc.nextInt();
		for (int q = 0; q<t; q++ ) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			sum = 0;
			System.out.print("Case #" + (q+1) + ": ");
			mat = new int[r][c];
			rem = new ArrayList<Pair>();
			for (int a = 0; a<r; a++ ) {
				for (int b = 0; b<c; b++) {
					mat[a][b] = sc.nextInt();
				}
			}
			for (int i = 0; i<r*c; i++) {
				for (int a = 0; a<r; a++ ) {
					for (int b = 0; b<c; b++) {
						sum+=mat[a][b];
				//		System.out.print(mat[a][b] + " ");
					}
					//System.out.println();
				}
				if (!trav()) break;
				else {
					for (int j= 0; j<rem.size(); j++ ) {
						mat[rem.get(j).x][rem.get(j).y] = 0;
					}
				}
			}
			System.out.print("Case #" + (q+1) + ": "+sum);
		}
	}
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
	public static void main (String[] args) throws Exception {
		new Solution().run();
	}
}