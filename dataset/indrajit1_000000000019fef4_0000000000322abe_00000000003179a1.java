import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Comparator;
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
		Overrandomized solver = new Overrandomized();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class Overrandomized {
		PrintWriter out;
		InputReader in;
		int testcase;
		final Comparator<Entity> com = new Comparator<Entity>() {
			public int compare(Entity x, Entity y) {
				int xx = Integer.compare(x.b, y.b);
				if (xx == 0) {
					return Character.compare(x.a, y.a);
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
			int u = in.nextInt();
			TreeMap<Character, Integer> tm = new TreeMap<>();
			TreeSet<Character> ts = new TreeSet<>();
			for (i = 0; i < 10000; i++) {
				String x = in.next();
				String y = in.next();
				if (x.length() == y.length()) {
					for (j = 0; j < 1; j++) {
						int ch = x.charAt(j) - '0';
						if (ch == 0)
							continue;
						char op = y.charAt(j);
						if (tm.containsKey(op)) {
							tm.put(op, Math.min(tm.get(op), ch));
						} else
							tm.put(op, ch);
					}
				}
				for (j = 0; j < y.length(); j++) {
					ts.add(y.charAt(j));
				}
			}
			Entity en[] = new Entity[tm.size()];
			int cc = 0;
			for (Character ch : tm.keySet()) {
				en[cc] = new Entity(ch, tm.get(ch));
				cc++;
			}
			Arrays.sort(en, com);
			pk();
			char od[] = new char[10];
			Arrays.fill(od, '#');
			for (i = 0; i < en.length; i++) {
				od[en[i].b] = en[i].a;
				ts.remove(en[i].a);
			}
			for (i = 0; i < 10; i++) {
				if (od[i] == '#') {
					od[i] = ts.pollFirst();
				}
			}
			for (i = 0; i < 10; i++) {
				out.print(od[i]);
			}
			out.println();
		}

		void pk() {
			out.print("Case #" + (testcase) + ": ");
		}

		class Entity {
			char a;
			int b;

			Entity(char p, int q) {
				a = p;
				b = q;
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

