import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
public class MainClass{
    public static void task(InputReader in){
        //---------------------------------Solve here---------------------------------------------------------------------------------
        
        int t=in.nextInt();
        for(int test=1;test<=t;test++)
        {
            System.out.print("Case #"+test+": ");
            int n=in.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j]=in.nextInt();
            int trace=0;
            int k=0;
            while(k<n)
            {
                trace+=a[k][k];
                k++;
            }
            int rows=0;
            int cols=0;
            for(int i=0;i<n;i++)
            {
                int count[]=new int[n+1];
                for(int j=0;j<n;j++)
                {
                    count[a[i][j]]++;
                }
                for(int j=1;j<=n;j++)
                {
                    if(count[j]!=1)
                    {
                        rows++;
                        break;
                    }
                }
            }
            for(int j=0;j<n;j++)
            {
                int count[]=new int[n+1];
                for(int i=0;i<n;i++)
                {
                    count[a[i][j]]++;
                }
                for(int i=1;i<=n;i++)
                {
                    if(count[i]!=1)
                    {
                        cols++;
                        break;
                    }
                }
            }
            System.out.println(trace+" "+rows+" "+cols);
            
        }
        
          
        //---------------------------------------------------------------------------------------------------------------------------- 
    }
    public static void main(String[] args)throws IOException {
        try{
            InputStream inputStream = System.in;
            InputReader in = new InputReader(inputStream);
            task(in);
            out.close();
        }
        catch(NumberFormatException e){
            System.out.println(e);
        }
    }
    public static class InputReader {
        /*
        String-nextString()
        int   -nextInt()
        double-nextDouble()
        long  -nextLong()
        char  -nextChar()
        line  -nextLine()
        */
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
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
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public String nextString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, nextInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        public char nextChar(){
            return nextString().charAt(0);
        }
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		public String next() {
			return nextString();
		}
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
		private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
	}
}