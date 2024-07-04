import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Solution {

	static class JavaArray {
		final int[] array;
		final int hashCode;

		public JavaArray(int[] array) {
			this.array = array;
			this.hashCode = Arrays.hashCode(array);
		}

		@Override
		public int hashCode() {
			return hashCode;
		}

		@Override
		public String toString() {
			return Arrays.toString(array);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			JavaArray other = (JavaArray) obj;
			if (hashCode != other.hashCode)
				return false;
			if (!Arrays.equals(array, other.array))
				return false;
			return true;
		}

	}

	static class Move implements Comparable<Move> {
		final int len;
		final JavaArray from;
		final String string;

		public Move(int len, JavaArray from, String string) {
			this.len = len;
			this.from = from;
			this.string = string;
		}

		@Override
		public int compareTo(Move p) {
			return Integer.compare(len, p.len);
		}

		@Override
		public String toString() {
			return len + " " + from + " " + string;
		}
	}

	List<String> solve(int r, int s) {
		int n = r * s;

		Map<JavaArray, Move> map = new HashMap<>(1_000_000);
		Queue<JavaArray> queue = new ArrayDeque<JavaArray>(1_000_000);

		{
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = i / s;
			}
			JavaArray javaArray = new JavaArray(array);
			Move move = new Move(0, null, "");
			map.put(javaArray, move);
			queue.add(javaArray);
		}

		while (!queue.isEmpty()) {
			JavaArray from = queue.poll();

			int len = map.get(from).len + 1;

			int[] array = from.array;

			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					if (a + b > n) {
						continue;
					}
					int[] copy = array.clone();
					System.arraycopy(array, 0, copy, b, a);
					System.arraycopy(array, a, copy, 0, b);

					JavaArray to = new JavaArray(copy);
					if (map.containsKey(to)) {
						continue;
					}
					map.put(to, new Move(len, from, b + " " + a));
					queue.add(to);
				}
			}
		}

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i % r;
		}
		JavaArray cur = new JavaArray(array);

		List<String> list = new ArrayList<String>();

//		for (Entry<JavaArray, Move> row : map.entrySet()) {
//			System.err.println(row);
//		}

		while (true) {
			// System.err.println(cur);
			Move move = map.get(cur);
			String string = move.string;
			if (string.isEmpty()) {
				break;
			}
			list.add(string);
			cur = move.from;
		}

		return list;
	}

	void run(Interactor interactor) {

		int tests = interactor.nextInt();

		for (int test = 1; test <= tests; test++) {
			int r = interactor.nextInt();
			int s = interactor.nextInt();

			List<String> ans = solve(r, s);

			interactor.printf(Locale.ENGLISH, "Case #%d: %d%n", test, ans.size());
			for (String line : ans) {
				interactor.println(line);
			}

		}

	}

	static class Interactor extends PrintWriter {

		final BufferedReader reader;

		StringTokenizer tokenizer = new StringTokenizer("");

		public Interactor(InputStream inputStream, OutputStream outputStream) {
			super(outputStream);
			this.reader = new BufferedReader(new InputStreamReader(inputStream));
		}

		@Override
		public void close() {
			super.close();
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		boolean hasNext() {
			while (!tokenizer.hasMoreTokens()) {
				String line = nextLine();
				if (line == null) {
					return false;
				}
				tokenizer = new StringTokenizer(line);
			}
			return true;
		}

		String next() {
			while (!tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(nextLine());
			return tokenizer.nextToken();
		}

		int[] nextArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}
			return array;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException err) {
				return null;
			}
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		int[][] nextMatrix(int n, int m) {
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					matrix[i][j] = nextInt();
			return matrix;
		}

		boolean skip() {
			while (hasNext()) {
				next();
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		try (Interactor interactor = new Interactor(System.in, System.out)) {
			new Solution().run(interactor);
		}
	}

}