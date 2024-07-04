import java.util.*;
import java.io.*;

public class vestigium {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf= 0; asdf < times; asdf++) {
			int n = file.nextInt();
			int[][] mat = new int[n][n];
			for (int i = 0; i < n ;i++) {
				for (int j =0; j < n ;j++) {
					mat[i][j] = file.nextInt();
				}
			}
			int tot = 0;
			for (int i = 0; i < n; i++) {
				tot += mat[i][i];
			}
			int countSameRow = 0, countSameCol = 0;
			for (int i = 0; i < n ;i++) {
				boolean b = false, c = false;
				HashSet<Integer> x = new HashSet(), y = new HashSet();
				for (int j = 0; j < n; j++) {
					if (x.contains(mat[i][j]) && !b) {
						b = true;
						countSameRow++;
					}
					else x.add(mat[i][j]);
					if (y.contains(mat[j][i]) && !c) {
						c = true;
						countSameCol++;
					}
					else y.add(mat[j][i]);
				}
			}
			System.out.println("Case # " + (asdf + 1) + ": " + tot + " " + countSameRow + " " + countSameCol);
		}
	}

	public static void main(String[] args) throws Exception {
		new vestigium().run();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
