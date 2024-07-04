import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		FastReader reader = new FastReader();
		PrintWriter writer = new PrintWriter(System.out);
		Task solver = new Task();
		int testCases = reader.nextInt();
		for (int i = 1; i <= testCases; i++) {
			solver.solve(i, reader, writer);
		}
		writer.close();
	}

	static class Task {
		static final int INF = Integer.MAX_VALUE;

		public void solve(int testNumber, FastReader reader, PrintWriter writer) {
			int n = reader.nextInt();
			StringBuilder prefix = new StringBuilder();
			StringBuilder middle = new StringBuilder();
			StringBuilder suffix = new StringBuilder();
			String result = "";

			outerLoop:
			for (int i = 0; i < n; i++) {
				StringBuilder currentPrefix = new StringBuilder();
				StringBuilder currentSuffix = new StringBuilder();
				String line = reader.nextLine();
				int position = 0;

				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) == '*') {
						position = 1;
					} else if (position == 1) {
						middle.append(line.charAt(j));
					} else {
						currentPrefix.append(line.charAt(j));
					}
				}

				String prefixStr = currentPrefix.toString();
				String existingPrefix = prefix.toString();

				for (int j = 0; j < Math.min(prefixStr.length(), existingPrefix.length()); j++) {
					if (prefixStr.charAt(j) != existingPrefix.charAt(j)) {
						result = "*";
						break outerLoop;
					}
				}

				if (prefixStr.length() > existingPrefix.length()) {
					prefix = currentPrefix;
				}

				for (int j = line.length() - 1; j >= 0; j--) {
					if (line.charAt(j) == '*') {
						break;
					}
					currentSuffix.append(line.charAt(j));
				}

				String suffixStr = currentSuffix.toString();
				String existingSuffix = suffix.toString();

				for (int j = 0; j < Math.min(suffixStr.length(), existingSuffix.length()); j++) {
					if (suffixStr.charAt(j) != existingSuffix.charAt(j)) {
						result = "*";
						break outerLoop;
					}
				}

				if (suffixStr.length() > existingSuffix.length()) {
					suffix = currentSuffix;
				}
			}

			if (result.isEmpty()) {
				result = prefix.toString() + middle.toString() + suffix.reverse().toString();
			}

			writer.printf("Case #%d: %s%n", testNumber, result);
		}
	}

	static long binpow(long base, long exp, long mod) {
		base %= mod;
		long result = 1;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = result * base % mod;
			}
			base = base * base % mod;
			exp >>= 1;
		}
		return result;
	}

	static void sort(int[] array) {
		shuffle(array);
		Arrays.sort(array);
	}

	static void sort(long[] array) {
		shuffle(array);
		Arrays.sort(array);
	}

	static class Tuple implements Comparable<Tuple> {
		int a, b;

		Tuple(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Tuple other) {
			return Integer.compare(other.b, this.b);
		}
	}

	static void shuffle(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int randomIndex = random.nextInt(array.length);
			int temp = array[i];
			array[i] = array[randomIndex];
			array[randomIndex] = temp;
		}
	}

	static void shuffle(long[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int randomIndex = random.nextInt(array.length);
			long temp = array[i];
			array[i] = array[randomIndex];
			array[randomIndex] = temp;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(fileName)));
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