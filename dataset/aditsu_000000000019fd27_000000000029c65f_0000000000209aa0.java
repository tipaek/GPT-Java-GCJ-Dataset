import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Solution {
	public void solve(final Scanner sc, final PrintWriter pw) {
		final int m = sc.nextInt();
		final int k = sc.nextInt();

		if (k == m + 1 || k == m * m - 1) {
			pw.println("IMPOSSIBLE");
			return;
		}

		final boolean[][] rows = new boolean[m][m + 1];
		final boolean[][] cols = new boolean[m][m + 1];

		final BackTrack<Integer> bt = new BackTrack<Integer>(m * m) {
			@Override
			protected boolean partialCheck(final int pos, final Integer x) {
				final int row = pos / m;
				final int col = pos % m;
				if (rows[row][x] || cols[col][x]) {
					return false;
				}
				if (row != col) {
					return true;
				}
				int t = 0;
				int i = 0;
				while (i * m + i <= pos) {
					t += get(i * m + i);
					i++;
				}
				return t + (m - i) <= k && t + m * (m - i) >= k;
			}

			@Override
			protected void add(final int pos, final Integer x) {
				final int row = pos / m;
				final int col = pos % m;
				rows[row][x] = true;
				cols[col][x] = true;
			}

			@Override
			protected void remove(final int pos, final Integer x) {
				final int row = pos / m;
				final int col = pos % m;
				rows[row][x] = false;
				cols[col][x] = false;
			}

			@Override
			protected Integer nextVal(final int pos, final Integer x) {
				return x == m ? null : x + 1;
			}

			@Override
			protected Integer firstVal(final int pos) {
				return 1;
			}
		};

		if (bt.run()) {
			pw.println("POSSIBLE");
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < m; ++j) {
					if (j > 0) {
						pw.print(' ');
					}
					pw.print(bt.get(i * m + j));
				}
				pw.println();
			}
		}
		else {
			pw.println("IMPOSSIBLE");
		}
	}

	public static void main(final String... args) {
		try (final Scanner sc = new Scanner(System.in);
				final PrintWriter pw = new PrintWriter(System.out)) {
			final int t = sc.nextInt();
			sc.nextLine();

			for (int i = 1; i <= t; ++i) {
				pw.print("Case #" + i + ": ");
				new Solution().solve(sc, pw);
				System.gc();
			}
		}
	}

	// library code

	static abstract class BackTrack<T> {
		protected final int n;
		private int pos;
		private final List<T> l;

		public BackTrack(final int n) {
			this.n = n;
			l = new ArrayList<>(Collections.nCopies(n, null));
		}

		public BackTrack(final T[] a) {
			n = a.length;
			l = Arrays.asList(a);
		}

		public void reset() {
			Collections.fill(l, null);
			pos = 0;
		}

		protected abstract T firstVal(int pos);
		protected abstract T nextVal(int pos, T x);

		@SuppressWarnings("unused")
		protected void add(int pos, T x) {}
		@SuppressWarnings("unused")
		protected void remove(int pos, T x) {}

		protected abstract boolean partialCheck(int pos, T x);

		protected boolean finalCheck() {
			return true;
		}

		public boolean run() {
			if (pos == n) { // rerun
				pos--;
				remove(pos, l.get(pos));
			}
			while (true) {
				if (pos == n) {
					if (finalCheck()) {
						return true;
					}
					pos--;
					remove(pos, l.get(pos));
				}
				T x = l.get(pos);
				x = x == null ? firstVal(pos) : nextVal(pos, x);
				l.set(pos, x);
				if (x == null) {
					pos--;
					if (pos < 0) {
						return false;
					}
					remove(pos, l.get(pos));
				}
				else {
					if (partialCheck(pos, x)) {
						add(pos, x);
						pos++;
					}
				}
			}
		}

		public List<T> getList() {
			return l;
		}

		public T get(final int i) {
			return l.get(i);
		}
	}

}
