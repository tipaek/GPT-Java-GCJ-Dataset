import java.io.*;
import java.util.*;
 
 
public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        Output out = new Output(System.out);
        int t=in.readInt();
        for(int x=0;x<t;x++)
        {
            String s = in.readString();
            int l  = s.length();
            int[] ar = new int[l];
            for(int i=0;i<l;i++)
            {
                ar[i] = Integer.parseInt(""+s.charAt(i));
            }
            int[] arr = new int[l+1];
            arr[0] = ar[0];
            for(int i=1;i<l;i++)
            {
                arr[i] = arr[i-1] + ar[i]-ar[i-1];   
            }
            arr[l]=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr[0];i++)
            {
                sb.append("(");
            }
            sb.append(ar[0]);
            for(int i=1;i<l;i++)
            {
                int diff = arr[i] - arr[i-1];
                if(diff<0)
                {
                    for(int j=diff;j<0;j++)
                    {
                        sb.append(")");
                    }
                }
                else
                {
                    for(int j=0;j<diff;j++)
                    {
                        sb.append("(");
                    }
                }
                sb.append(ar[i]);
            }
            int di = arr[l] - arr[l-1];
            for(int i=di;i<0;i++)
            {
                sb.append(")");
            }
            String print = sb.toString();
            out.printLine("Case #"+(x+1)+": "+print);
        }
    }

	private static class Reader {
		private InputStream str;
		private byte[] buf = new byte[1024];
		private int curCh;
		private int noCh;
		private SpaceCharFilter fltr;
 
		public Reader(InputStream strim) {
			this.str = strim;
		}
 
		public int read() {
			if (noCh == -1) {
				throw new InputMismatchException();
			}
			if (curCh >= noCh) {
				curCh = 0;
				try {
					noCh = str.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (noCh <= 0) {
					return -1;
				}
			}
			return buf[curCh++];
		}
 
		public int readInt() {
			int c = read();
			while (isspsch(c)) {
				c = read();
			}
			int sin = 1;
			if (c == '-') {
				sin = -1;
				c = read();
			}
			int result = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				result *= 10;
				result += c - '0';
				c = read();
			} while (!isspsch(c));
			return result * sin;
		}
 
		public String readString() {
			int c = read();
			while (isspsch(c)) {
				c = read();
			}
			StringBuilder result = new StringBuilder();
			do {
				result.appendCodePoint(c);
				c = read();
			} while (!isspsch(c));
			return result.toString();
		}
 
		public double readDouble() {
			int c = read();
			while (isspsch(c)) {
				c = read();
			}
			int sin = 1;
			if (c == '-') {
				sin = -1;
				c = read();
			}
			double result = 0;
			while (!isspsch(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return result * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				result *= 10;
				result += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isspsch(c)) {
					if (c == 'e' || c == 'E') {
						return result * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					result += (c - '0') * m;
					c = read();
				}
			}
			return result * sin;
		}
 
		public long readLong() {
			int c = read();
			while (isspsch(c)) {
				c = read();
			}
			int sin = 1;
			if (c == '-') {
				sin = -1;
				c = read();
			}
			long result = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				result *= 10;
				result += c - '0';
				c = read();
			} while (!isspsch(c));
			return result * sin;
		}
 
		public boolean isspsch(int c) {
			if (fltr != null) {
				return fltr.isspsch(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public String next() {
			return readString();
		}
 
		public interface SpaceCharFilter {
			public boolean isspsch(int ch);
		}
	}
 
	private static class Output {
		private final PrintWriter wtr;
 
		public Output(OutputStream outputStream) {
			wtr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
 
		public Output(Writer wtr) {
			this.wtr = new PrintWriter(wtr);
		}
 
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					wtr.print(' ');
				}
				wtr.print(objects[i]);
			}
			wtr.flush();
		}
 
		public void printLine(Object... objects) {
			print(objects);
			wtr.println();
			wtr.flush();
		}
 
		public void close() {
			wtr.close();
		}
 
		public void flush() {
			wtr.flush();
		}
	}
}