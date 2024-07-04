/**
 *  The author of the following code is -  Dewansh Nigam
 *  Username  - dewanshnigam
 *  Unstoppable Now.
 */

// DO NOT FORGET TO CHANGE THE CLASS NAME TO SOLUTION

import java.io.*;
import java.util.*;
public class CodeJam2020Round1AQ1 {
	public static long MOD = (long) (1e9 + 7);

	public static String s[];
	public static char str[][];
	
	public static void main(String args[]) throws IOException {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int t = in.readInt();
		StringBuilder sb = new StringBuilder();		
		int cases=1;
		while (t-- > 0) {
			int n = in.readInt();
			s = new String[n];
			for(int i=0;i<n;i++)
				s[i] = in.readString();
			// left most only asterick.

			Arrays.sort(s,new Sort());
			
			str = new char[n][101];
			for(int i=0;i<n;i++)
				Arrays.fill(str[i],'*');
			
			for(int i = 0; i < s.length; i++) {
				int k = 100;
				for(int j = s[i].length() - 1; j >= 0 ;j--) {
					str[i][k--] = s[i].charAt(j);
				}
			}			
			//for(int i=0;i<n;i++)
			//	System.out.println(Arrays.toString(str[i]));
			
			boolean isPoss=true;
			for(int i=100; i >= 1; i--)
			{
				char kth = str[0][i];
				if(kth == '*')
					break;
				int flag=0;
				for(int j=1; j < n; j++)
				{
					if(str[j][i] != '*' && str[j][i]!=kth)
					{
						flag=1;
						break;
					}
				}
				if(flag==1) {
					isPoss = false;
					break;
				}
			}
			if(!isPoss)
				sb.append("Case #"+cases+": "+"*"+"\n");
			else
			{
				Arrays.sort(s,new Sort());
				sb.append("Case #"+cases+": "+s[0].substring(1)+"\n");
			}
			cases++;
		}		
		out.printLine(sb);
		out.close();
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static int pow(int a, int b) {
		// finding a to the power b mod MOD
		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		if(a > MOD)
			a = (int)(a % MOD);
		long aa = (long)a;
		int product = (int)((aa * aa) % MOD);
		int val = pow(product, b / 2);
		if ((b & 1) != 0) {
			long val1 = (long)val;
			val = (int) ( (val1 * aa) % MOD );
		}
		return val;
	}
	static class Sort implements Comparator<String>
	{
		public int compare(String a,String b)
		{
			return b.length() - a.length();
		}
	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
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

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
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

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
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
				if (i != 0)
					writer.print(' ');
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
}
