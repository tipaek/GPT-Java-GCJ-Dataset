import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
public class Solution implements Runnable {
    
    static void solve(InputReader sc, PrintWriter out, int testcase)
    {
		int n = sc.nextInt();
		
		String s[] = new String[n];
		
		Pair[] p= new Pair[n];
		
		String start = "";String end = "";
		boolean flag = false;
		for(int i=0;i<n;i++)
		{
			s[i]=sc.next();
			if(flag)continue;
			int x = s[i].indexOf("*");
			p[i]=new Pair(s[i].substring(0,x),s[i].substring(x+1,s[i].length()));
			
			if(p[i].al!=0 && start.length()==0)
			{
				start=p[i].a;
			}
			else if(p[i].al!=0)
			{
				if(start.length()<p[i].al)
				{
					String tmp = start;
					start = p[i].a;
					p[i].a = tmp;
					p[i].al=p[i].a.length();
					
				}
				
				if(start.indexOf(p[i].a)!=0)
				{
					out.println("*");
					flag=true;
				}
			}
			if(!flag)
			{
				if(p[i].bl!=0 && end.length()==0)
				{
					end=p[i].b;
				}
				else if(p[i].bl!=0)
				{
					if(end.length()<p[i].bl)
					{
						String tmp = end;
						end = p[i].b;
						p[i].b = tmp;
						p[i].bl=p[i].b.length();
						
					}
					
					if(end.lastIndexOf(p[i].b)==-1 || end.lastIndexOf(p[i].b)+p[i].bl!=end.length())
					{
						out.println("*");
						flag=true;
					}
				}	
			}
			
		}
		if(flag)return;
		out.println(start+end);
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
		String a,b;
		int al,bl;
		Pair(String aa, String bb)
		{
			a = aa;
			b = bb;
			al=aa.length();
			bl=bb.length();
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
