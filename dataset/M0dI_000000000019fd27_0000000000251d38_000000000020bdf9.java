import java.io.*;
import java.util.*;
 
 
public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        Output out = new Output(System.out);
        int t=in.readInt();
        for(int xx=0;xx<t;xx++)
        {
            int n  = in.readInt();
            HashMap<Integer,String> map = new HashMap<Integer,String>();
            ArrayList<int[]> arr = new ArrayList<int[]>();
            int C= 1;
            int J= 1;
            int ci = -1;
            int ji = -1;
            for(int i=0;i<n;i++)
            {
                
                int[] ar = new int[3];
                ar[0] = in.readInt();
                ar[1]= 1;
                ar[2]= i;
                arr.add(ar);
                int[] ar1 = new int[3];
                ar1[0] = in.readInt();
                ar1[1]= 0;
                ar1[2] = i;
                arr.add(ar1);
            }
            Collections.sort(arr,(x,y)->{
                if(x[0]==y[0])
                {
                    return Integer.compare(x[1],y[1]);
                }
                else
                {
                    return Integer.compare(x[0],y[0]);
                }
            });
            int flag = 0 ;
            //StringBuilder sb = new StringBuilder();
            for(int i=0;i<2*n;i++)
            {
                int[] rr = arr.get(i);
                if(rr[1]==1)
                {
                    if(C==1 || J==1)
                    {
                        if(C == 1)
                        {
                            C = 0;
                            ci = rr[2];
                           // sb.append("C");
                            map.put(rr[2],"C");
                        }
                        else
                        {
                            J = 0;
                            ji = rr[2];
                            //sb.append("J");
                            map.put(rr[2],"J");
                        }
                    }
                    else
                    {
                        flag=1;
                        break;
                    }
                }
                else
                {
                    if(rr[2] == ci)
                    {
                        C = 1;
                    }
                    else
                    {
                        J = 1;
                    }
                }
            }
            if(flag==1)
            {
                out.printLine("Case #"+(xx+1)+": "+"IMPOSSIBLE");
            }
            else
            {
                String print = "";
                for(int i=0;i<n;i++)
                {
                    print = print + map.get(i);
                }
                out.printLine("Case #"+(xx+1)+": "+print);
            }
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