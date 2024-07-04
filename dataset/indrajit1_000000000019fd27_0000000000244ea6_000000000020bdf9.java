import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Indrajit Sinha
 */
public class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ParentingPartneringReturns solver = new ParentingPartneringReturns();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class ParentingPartneringReturns {
		PrintWriter out;
		InputReader in;
		int testcase;
		int n;
		final Comparator<Entity> com = new Comparator<Entity>() {
			public int compare(Entity x, Entity y) {
				int xx = Integer.compare(x.a, y.a);
				if (xx == 0) {
					return Integer.compare(x.b, y.b);
				} else {
					return xx;
				}
			}
		};

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t, i, j, tt, k;
			this.testcase = testNumber;
			this.out = out;
			this.in = in;
			pk();
			n = in.nextInt();
			Entity en[] = new Entity[n];
			for (i = 0; i < n; i++) {
				en[i] = new Entity(in.nextInt(), 0, i);
				en[i].b = in.nextInt();
			}
			boolean fl = true;
			Arrays.sort(en, com);
			TreeSet<Integer> ts = new TreeSet<>();
			ArrayList<Integer> ts1 = new ArrayList<>();
			int lasta = 0;
			int lastb = 0;
			ts.add(0);
			lasta = en[0].b;
			for (i = 1; i < n; i++) {
				int l1 = en[i].a;
				int r2 = en[i].b;
				if (l1 >= lasta) {
					lasta = r2;
					ts.add(i);
				} else {
					if (l1 >= lastb) {
						lastb = r2;
						ts1.add(i);
					} else
						fl = false;
				}
			}

			for (i = 0; i < n; i++) {
				if (ts.contains(i))
					continue;
				ts1.add(i);
			}
			if (fl) {
				int b[] = new int[n];
				for (Integer it : ts1) {
					b[en[it].c] = 1;
				}
				for (i = 0; i < n; i++) {
					if (b[i] == 0)
						out.print("C");
					else
						out.print("J");
				}
				pn("");
			} else
				pn("IMPOSSIBLE");
		}

		void pn(String zx) {
			out.println(zx);
		}

		void pk() {
			out.print("Case #" + (testcase) + ": ");
		}

		class Entity {
			int a;
			int b;
			int c;

			Entity(int p, int q, int r) {
				a = p;
				b = q;
				c = r;
			}

		}

	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new UnknownError();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new UnknownError();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuffer res = new StringBuffer();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));

			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}
}

