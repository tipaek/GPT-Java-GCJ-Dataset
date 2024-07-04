import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;

public class Solution {

	private static int FOUND = 1;
	private static int LESS = 2;
	private static int MORE = 3;

	private Random random = new Random(1976);

	public static void main(final String[] args) {
		new Solution().start();
	}

	private InputStream in;

	public Solution() {
		in = System.in;
	}

	public Solution(final String fileName) {
		try {
			in = new FileInputStream(fileName);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[] vs = new int[n];
			for (int j = 0; j < n; j++) {
				vs[j] = 1;
			}

			String result = null;

			if (iterate(vs, 0, k, n, 0) == FOUND) {
				result = "POSSIBLE";
			} else {
				result = "IMPOSSIBLE";
			}

			int[][] m = null;
			if (result.equals("POSSIBLE")) {
				int c = n * 3;
				do {
					m = extracted(n, vs);
					salt(vs);
					c--;
				} while ((m == null) && (c > 0));
			}
			if (m == null) {
				result = "IMPOSSIBLE";
			}

			System.out.println("Case #" + (i + 1) + ": " + result);
			if (m != null) {
				System.out.print(show(m));
			}

		}
	}

	private void salt(final int[] vs) {
		int tmp = vs[0];
		int a = random.nextInt(vs.length);
		int b = random.nextInt(vs.length);
		tmp = vs[a];
		vs[a] = vs[b];
		vs[b] = tmp;
	}

	private int[][] extracted(final int n, final int[] vs) {
		int[][] m = new int[n][n];
		for (int j = 0; j < n; j++) {
			m[j][j] = vs[j];
		}
		for (int j = 0; j < n; j++) {
			for (int l = 0; l < n; l++) {
				if (j != l) {
					BitSet bs = new BitSet(n + 1);
					for (int z = 0; z < n; z++) {
						bs.set(m[z][l]);
						bs.set(m[j][z]);
					}
					int v = bs.nextClearBit(1);
					if (v > n) {
						// System.out.println("NULLLLLLLL");
						return null;
					}
					m[j][l] = v;
					// System.out.println(bs);
					// System.out.println(show(m));
				}
			}
		}
		return m;
	}

	private int free(final BitSet bs, final int n) {
		for (int i = n; i > 0; i--) {
			if (!bs.get(i)) {
				return i;
			}
		}
		return -1;
	}

	public int iterate(final int[] vs, final int index, final int k, final int n, final int suma) {
		for (int i = 1; i <= n; i++) {
			vs[index] = i;

			int st = suma + i;

			if ((st) > k) {
				return MORE;
			}
			if (index == (n - 1)) {
				if (st == k) {
					return valid(vs) ? FOUND : MORE;
				}
			} else {
				int r = iterate(vs, index + 1, k, n, st);
				if (r == FOUND) {
					return FOUND;
				}
			}
		}

		return LESS;
	}

	private String show(final int[][] vss) {
		StringBuilder sb = new StringBuilder();
		for (int[] vs : vss) {
			StringBuilder sbl = new StringBuilder();
			for (int v : vs) {
				sbl.append(" ");
				sbl.append(v);
			}
			sb.append(sbl.substring(1));
			sb.append("\n");
		}
		return sb.toString();
	}

	private boolean valid(final int[] vs) {
		int[] as = new int[vs.length];
		for (int v : vs) {
			as[v - 1]++;
		}
		for (int a : as) {
			if (a == (as.length - 1)) {
				return false;
			}
		}
		return true;
	}
}
