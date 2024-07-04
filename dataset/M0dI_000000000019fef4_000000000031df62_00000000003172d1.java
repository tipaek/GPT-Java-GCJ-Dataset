import java.io.*;
import java.util.*;
 
 
public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        Output out = new Output(System.out);
        int t=in.readInt();
        for(int xx=0;xx<t;xx++)
        {
            int ans = -1;
            int n=in.readInt();
 		    int d=in.readInt();
 		    long[] arr = new long[n];
 		    for(int i=0;i<n;i++)
 		    {
 		        arr[i] = in.readLong();
 		    }
 		    if(d==2)
 		    {
 		        Arrays.sort(arr);
 		        int flag=0;
 		        //int ans=0;
 		        for(int i=0;i<n-1;i++)
 		        {
 		            if(arr[i]==arr[i+1])
 		            {
 		                flag=1;
 		            }
 		        }
 		        if(flag==1)
 		        {
 		            out.printLine("Case #"+(xx+1)+": "+0);
 		        }
 		        else
 		        {
 		            out.printLine("Case #"+(xx+1)+": "+1);
 		        }
 		    }
 		    if(d==3)
 		    {
 		        Arrays.sort(arr);
 		        int flag3=0;
 		        int flag2=0;
 		        int flagdiv=0;
 		        int flagdosh=0;
 		        for(int i=0;i<n;i++)
 		        {
 		            int count3=1;
 		            long temp=arr[i];
 		            for(int j=i+1;j<n;j++)
 		            {
 		                if(arr[j]==temp)
 		                {
 		                    count3++;
 		                }
 		            }
 		            if(count3>=3)
 		            {
 		                flag3=1;
 		                break;
 		            }
 		        }
 		       
 		         for(int i=0;i<n-1;i++)
 		        {
 		            int count2=1;
 		            long temp=arr[i];
 		            for(int j=i+1;j<n;j++)
 		            {
 		                if(arr[j]==temp)
 		                {
 		                    count2++;
 		                }
 		            }
 		            if(count2==2)
 		            {
 		                
 		                flag2=1;
 		                break;
 		            }
 		            
 		        }
 		        for(int i=0;i<n-1;i++)
 		        {
 		            
 		            long temp=arr[i];
 		            for(int j=i+1;j<n;j++)
 		            {
 		                if(arr[j]==temp*2)
 		                {
 		                    flagdiv=1;
 		                }
 		            }
 		            
 		            
 		        }
 		        if(flag3==1)
 		        {
 		             out.printLine("Case #"+(xx+1)+": "+0);
 		        }
 		        else if(flag2==1)
 		        {
 		             out.printLine("Case #"+(xx+1)+": "+1);
 		        }
 		        else if(flagdiv==1)
 		        {
 		             out.printLine("Case #"+(xx+1)+": "+1);
 		        }
 		        else
     	        {
     	             out.printLine("Case #"+(xx+1)+": "+2);
     	        }
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