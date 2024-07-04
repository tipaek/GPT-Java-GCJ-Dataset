import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

	static class Node {
		Node[] nxt;
		int out;

		public Node() {
			nxt = new Node[26];
			out = 0;
		}
	}

	static boolean addFWord(Node root, String word) {
		Node curr = root;
		int i = 0;
		while (i < word.length() && word.charAt(i) != '*') {
			int nxtIndex = word.charAt(i) - 'A';
			if (curr.nxt[nxtIndex] == null) {
				if (curr.out > 0)
					return false;
				curr.out++;
				curr.nxt[nxtIndex] = new Node();
			}

			curr = curr.nxt[nxtIndex];
			i++;
		}

		return true;
	}

	static boolean addBWord(Node root, String word) {
		Node curr = root;
		int i = word.length() - 1;
		while (i >= 0 && word.charAt(i) != '*') {
			int nxtIndex = word.charAt(i) - 'A';
			if (curr.nxt[nxtIndex] == null) {
				if (curr.out > 0)
					return false;
				curr.out++;
				curr.nxt[nxtIndex] = new Node();
			}

			curr = curr.nxt[nxtIndex];
			i--;
		}

		return true;
	}

	static StringBuilder getString(Node r, boolean reverse) {
		Node curr = r;
		StringBuilder ret = new StringBuilder();

		loop: while (true) {
			for (int i = 0; i < curr.nxt.length; i++) {
				if (curr.nxt[i] != null) {
					ret.append((char) ('A' + i));
					curr = curr.nxt[i];
					continue loop;
				}
			}

			break;
		}

		if (reverse)
			return ret.reverse();

		return ret;
	}

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		for (int a = 1; a <= T; a++) {
			int N = in.nextInt();
			String[] arr = new String[N];
			for (int i = 0; i < N; i++)
				arr[i] = in.next();

			Node pre = new Node();
			Node suf = new Node();

			boolean works = true;
			for (String s : arr) {
				works = works && addFWord(pre, s);
				works = works && addBWord(suf, s);
			}

			if (!works) {
				System.out.println("Case #" + a + ": *");
			} else {
				StringBuilder ans = getString(pre, false);

				for (String s : arr) {
					int sIndex = 0;
					while (s.charAt(sIndex) != '*')
						sIndex++;

					int eIndex = s.length() - 1;
					while (s.charAt(eIndex) != '*') {
						eIndex--;
					}

					for (int i = sIndex; i <= eIndex; i++) {
						if (s.charAt(i) != '*')
							ans.append(s.charAt(i));
					}
				}

				ans.append(getString(suf, true));
				System.out.println("Case #" + a + ": " + ans.toString());
			}
		}
	}

	// Matt Fontaine's Fast I/O
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
