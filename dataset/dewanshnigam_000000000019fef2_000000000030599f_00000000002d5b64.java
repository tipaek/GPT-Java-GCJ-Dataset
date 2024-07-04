/**
 *  The author of the following code is -  Dewansh Nigam
 *  Username  - dewanshnigam
 *  Unstoppable Now.
 */

import java.util.*;
import java.io.*;
public class Solution
{
    static InputReader in=new InputReader(System.in);
    static OutputWriter out=new OutputWriter(System.out);    
    static StringBuilder sb=new StringBuilder();
    static long MOD = (long)(1e9+7);
    // Main Class Starts Here        
    public static void main(String args[])throws IOException
    {
    	// Write your code.
    	int t = in();
    	int cases=1;
    	while(t-->0) {
    		int r=in();
    		int s=in();
    		int count = (s-1) * (r-1) ;
    		StringBuilder str = new StringBuilder();    	
    		int fir = (s-1) * r;
    		while(r>0) {
        		for(int i=1;i<s;i++) {
        			if((r-1) == 0)
        				break;
        			str.append(fir+" "+(r-1)+"\n");
        			fir--;
        		}
        		r--;    	    	
    		}
    		
    		app("Case #"+cases+": "+count+"\n");
    		app(str);
    		cases++;
    	}    	
    	out.printLine(sb);
    	out.close();
    }
           
    public static long rev(long n) {
    	if(n<10L)
    		return n;
    	long rev = 0L;
    	while(n != 0L) {
    		long a = n % 10L;
    		rev = a + rev*10L;
    		n /= 10L;
    	}
    	return rev;
    }
    
    public static long pow(long a,long b) {
    	if(b==0)
    		return 1L;
    	if(b==1)
    		return a % MOD;
    	long f = a * a;
    	if(f > MOD)
    		f %= MOD;
    	long val = pow(f, b/2);
    	if(b % 2 == 0)
    		return val;
    	else {
    		long temp = val * a;
    		if(temp > MOD)
    			temp = temp % MOD;
    		return temp;
    	}
    }
    
    public static int gcd(int a,int b) {
    	if(b==0)
    		return a;
    	return gcd(b, a%b);
    }
    
    public static int[] an(int n) {
    	int ar[]=new int[n];
    	for(int i=0;i<n;i++)
    		ar[i]=in();
    	return ar;
    }
    
    public static int in() {
    	return in.readInt();
    }
    
    public static long lin() {
    	return in.readLong();
    }
    
    public static String sn() {
    	return in.readString();
    }          
    
    public static HashMap<Integer,Integer> hm(int a[]){
    	HashMap<Integer,Integer> map=new HashMap<>();
    	for(int i=0; i < a.length;i++) {
    		int keep = (int)map.getOrDefault(a[i],0);
    		map.put(a[i],++keep);
    	}
    	return map;
    }
    
    public static void app(Object o) {
    	sb.append(o);
    }
    
    public static long calcManhattanDist(int x1,int y1,int x2,int y2) {
    	long xa = Math.abs(x1-x2);
    	long ya = Math.abs(y1-y2);
    	return (xa+ya);
    }
    
    static class Point
    {
    	int x;
    	int y;
    	String dir;
    	public Point(int x,int y,String dir) {
    		this.x=x;
    		this.y=y;
    		this.dir=dir;
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

        public void print(Object...objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object...objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }
    } 
}

