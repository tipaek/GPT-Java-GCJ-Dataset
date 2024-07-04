import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] solve(int[] a, int[] z, int[] newA) {
		boolean isEqualA = true, isEqualADash = true, isEqualB = true, isEqualBDash;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != newA[i])
				isEqualA = false;
			if (1 - a[i] != newA[i])
				isEqualADash = false;
			if (z[i] != newA[4-i])
				isEqualB = false;
			if (1 - z[i] != newA[4-i])
				isEqualBDash = false;
		}
		int[] res = new int[10];
		if (isEqualA) {
			for (int i = 0; i < a.length; i++)
				res[i] = a[i];
			for (int i = 5; i < res.length; i++)
				res[i] = z[i - 5];
		} else if (isEqualADash) {
			for (int i = 0; i < a.length; i++)
				res[i] = 1 - a[i];
			for (int i = 5; i < res.length; i++)
				res[i] = 1 - z[i - 5];
		} else if (isEqualB) {
			for (int i = 0; i < a.length; i++)
				res[i] = z[4-i];
			for (int i = 5; i < res.length; i++)
				res[i] = a[9-i];
		} else {
			for (int i = 0; i < a.length; i++)
				res[i] = 1 - z[4-i];
			for (int i = 5; i < res.length; i++)
				res[i] = 1 - a[9-i];
		}
		return res;
	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int b = r.nextInt();
		while (T-- > 0) {
			if (b == 10) {
				int[] arr = new int[10];
				for (int i = 0; i < arr.length; i++) {
					System.out.println((i + 1));
					arr[i] = r.nextInt();
				}
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			} else if (b == 20) {
				int[] a = new int[5];
				for (int i = 0; i < a.length; i++) {
					System.out.println((i + 1));
					a[i] = r.nextInt();
				}
				int[] z = new int[5];
				for (int i = 0; i < z.length; i++) {
					System.out.println(i + 16);
					z[i] = r.nextInt();
				}

				int[] c = new int[5];
				for (int i = 0; i < a.length; i++) {
					System.out.println((i + 6));
					c[i] = r.nextInt();
				}
				int[] y = new int[5];
				for (int i = 0; i < z.length; i++) {
					System.out.println(i + 11);
					y[i] = r.nextInt();
				}

				int[] newA = new int[5];
				for (int i = 0; i < a.length; i++) {
					System.out.println((i + 1));
					newA[i] = r.nextInt();
				}

				int[] newC = new int[5];
				for (int i = 0; i < a.length; i++) {
					System.out.println((i + 6));
					newC[i] = r.nextInt();
				}
				int[] first = solve(a, z, newA);
				int[] second = solve(c, y, newC);
				for (int i = 0; i < 5; i++)
					System.out.print(first[i]);
				for (int i = 0; i < second.length; i++) {
					System.out.print(second[i]);
				}
				for (int i = 5; i < first.length; i++) {
					System.out.print(first[i]);
				}
				System.out.println();
			}

			String ret = r.next();
			if (ret.startsWith("N"))
				return;
		}
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
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
	}
}
