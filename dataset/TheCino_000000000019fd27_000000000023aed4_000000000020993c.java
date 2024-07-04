import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.InputMismatchException;


public class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		ForegoneSolution solver = new ForegoneSolution();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++) {
			solver.solve(i, in, out);
		}
		out.close();
	}

	static class ForegoneSolution {
		public void solve(int testNumber, InputReader in, OutputWriter out) {
			int N = in.read();
			int i = N;
			int j = N;
			int M[][]=new int[i][j];
			int V[]=new int[N];
			int k=0;
			int r=0;
			int c=0;
			boolean yes=true;
			for(int h=0;h<N;h++) {
				for (int l=0;l<N;l++) {
					V[l]=M[h][l];
				}
				for (int l=0;l<N && yes;l++) {
					for(int p=0;p<l;p++) {
						if(V[l]==V[p])
							yes=false;
					}
					if(yes)
						r++;
					yes=true;

				}
				for (int l=0;l<N;l++) {
					V[l]=M[l][h];
				}
				for (int l=0;l<N && yes;l++) {
					for(int p=0;p<l;p++) {
						if(V[l]==V[p])
							yes=false;
					}
					if(yes)
						c++;
					yes=true;

				}

			}

			for (int h=0;h<N;h++) {
				k=k+M[h][h];
			}
			out.printLine("Case #" + testNumber + ":"+" "+k+" "+r+" "+c);
		}

	}

	static class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}

		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private InputReader.SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				if (Character.isValidCodePoint(c)) {
					res.appendCodePoint(c);
				}
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return isWhitespace(c);
		}

		public static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);

		}

	}
}

