import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
class Solution{
    public static void task(InputReader in){
        //---------------------------------Solve here---------------------------------------------------------------------------------
        int t=in.nextInt();
        for(int test=1;test<=t;test++)
        {
            System.out.print("Case #"+test+": ");
            char a[]=in.nextString().toCharArray();
            int n=a.length;
            String x="";
            for(int i=0;i<n;i++)
            {
                if(i==0)
                {
                    for(int j=0;j<(int)a[i]-48;j++)
                        x+='(';
                    x+=a[i];
                }
                else if(a[i]==a[i-1])
                x+=a[i];
                else if(a[i]>a[i-1])
                {
                    int diff=(int)a[i]-(int)a[i-1];
                    for(int j=0;j<diff;j++)
                        x+='(';
                    x+=a[i];
                }
                else if(a[i]<a[i-1])
                {
                    int diff=(int)a[i-1]-(int)a[i];
                    for(int j=0;j<diff;j++)
                        x+=')';
                    x+=a[i];
                }
            }
            for(int j=0;j<(int)a[n-1]-48;j++)
                x+=')';
            System.out.println(x);
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