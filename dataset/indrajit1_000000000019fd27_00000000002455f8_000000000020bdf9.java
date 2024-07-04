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
			Arrays.sort(en, com);
			TreeSet<Integer> ts = new TreeSet<>();
			ts.add(0);
			int r1 = en[0].b;
			for (i = 1; i < n; i++) {
				int l1 = en[i].a;
				int r2 = en[i].b;
				if (l1 >= r1) {
					r1 = r2;
					ts.add(i);
				}
			}
			ArrayList<Integer> ts1 = new ArrayList<>();
			for (i = 0; i < n; i++) {
				if (ts.contains(i))
					continue;
				ts1.add(i);
			}
			boolean fl = true;
			if (ts1.size() > 0) {
				r1 = en[ts1.get(0)].b;
				for (i = 1; i < ts1.size(); i++) {
					int ii = ts1.get(i);
					int l1 = en[ii].a;
					int r2 = en[ii].b;
					if (l1 >= r1) {
						r1 = r2;
					} else {
						fl = false;
					}
				}
			}
			if (fl) {
				int b[] = new int[n];
				for (Integer it : ts1) {
					b[en[it].c] = 1;
				}
				for (i = 0; i < n; i++) {
					if (b[i] == 0)
						out.print("J");
					else
						out.print("C");
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

