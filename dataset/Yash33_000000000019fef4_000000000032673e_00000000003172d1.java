import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
public class Solution implements Runnable {
    
    static void solve(InputReader sc, PrintWriter out, int testcase)
    {
		HashMap<Long,Long> fq = new HashMap<>();
		int n=sc.nextInt(),d=sc.nextInt();

		long a[]=new long[n];
		long max = 0;
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextLong();
			fq.put(a[i],fq.getOrDefault(a[i],(long)0)+1);
			max = Math.max(fq.get(a[i]),max);
		}

		if(max>=d)
		{
			out.println(0);
			return;
		}

		if(d==2)
		{
			out.println(1);
			return;
		}

		int two=-1,three=-1;
		Arrays.sort(a);

		for(int i=0;i<n;i++)
		{
			if(fq.get(a[i])==2 && a[i]!=a[n-1])
			{
				out.println(1);
					return;
			}
			for(int j=i+1;j<n;j++)
			{
				if(a[i]*2==a[j])
				{
					out.println(1);
					return;
				}
			}	
		}



		out.println(2);
	}
    
    public void run() {
       
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		
		for(int i=1;i<=t;i++)
		{
			out.print("Case #"+i+": "); 
			solve(sc,out,i);		 
		}
		
        out.close();
    }
    
//======================================================================    
    
    static class Pair
    {
		
		int a,b;
		Pair(int aa, int bb)
		{
			a = aa;
			b = bb;
		} 
		
		public String toString()
		{
			return "["+a+","+b+"]";
		}
	}

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
            if (numChars==-1)
                throw new InputMismatchException();
           
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
               
                if(numChars <= 0)              
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
           
            while(isSpaceChar(c))
                c = read();
           
            int sgn = 1;
           
            if (c == '-') {
                sgn = -1;
                c = read();
            }
           
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
           
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
            }
            while (!isSpaceChar(c));
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
            }
            while (!isSpaceChar(c));
           
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
        new Thread(null, new Solution(),"Main",1<<27).start();
    }
}
