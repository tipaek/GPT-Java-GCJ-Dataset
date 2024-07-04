import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		public int nextInt() {
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

		public long nextLong() {
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

		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
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

	public static void main(String args[]) throws Exception {
		new Thread(null, new Solution(), "Main", 1 << 27).start();
	}

	static class Pair {
		int x, y,i;

		Pair(int x, int y,int i) {
			this.x = x;
			this.y = y;
			this.i=i;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x * 7 + (y * 3 + 5 * (y - x));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Pair other = (Pair) obj;
			if (x != other.x && y != other.y) {
				return false;
			}
			return true;
		}
	}

	static void sieveOfEratosthenes(int n) {
		//Prints prime nos till n 
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				System.out.print(i + " ");
		}
	}
	
	public void run() {
		InputReader in = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		int t=in.nextInt();
		for(int z=0;z<t;z++)
		{
			int n=in.nextInt();
			Pair P[]=new Pair[n];
			for(int i=0;i<n;i++)
				P[i]=new Pair(in.nextInt(),in.nextInt(),i);
			Arrays.sort(P, new Comparator<Pair>()
			{
				@Override public int compare(Pair x,Pair y)
				{
					if(x.x==y.x)
						return x.y-y.y;
					return x.x-y.x;
				}
			});
			char c[]=new char[n];
			int cs=P[0].x,ce=P[0].y,js=0,je=0;
			boolean f=false;
			c[0]='C';
			for(int i=1;i<n;i++)
			{
				if(P[i].x>=ce)
				{
					cs=P[i].x;
					ce=P[i].y;
					c[i]='C';
				}
				else if(P[i].x<ce && P[i].x>=je)
				{
					c[i]='J';
					js=P[i].x;
					je=P[i].y;
				}
				else if(P[i].x<ce && P[i].x<je)
				{
					w.print("Case #"+(z+1)+": ");
					w.println("IMPOSSIBLE");
					f=true;
					break;
				}
			}
			if(!f)
			{
				w.print("Case #"+(z+1)+": ");
				for(int i=0;i<n;i++)
					w.print(c[P[i].i]);
				w.println();
			}
		}
		w.flush();
		w.close();
	}
}
