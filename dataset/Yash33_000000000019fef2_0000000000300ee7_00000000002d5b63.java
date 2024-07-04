import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
public class Solution implements Runnable {
    
    static int a=0,b=0;
    
    static int incirx = 0 , inciry = 0;
    
    static int xxx = 1000000000;
    
    static InputReader sc = null;
    static PrintWriter out = null; 
    static String s = "";
    
    static int getmid(int ll,int rr)
    {
		return ll+(rr-ll)/2;
	}
    
    static void solve(int testcase)
    {
		int x1=-xxx;
		int x2=xxx;
		int y1=-xxx;
		int y2=xxx;
		int x3=0,y3=0;
		
		int cnt = 300;
		
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(x1,y1,x2,y2));
		
		while(cnt--!=0 && q.size()>0)
		{
			Pair tmp = q.remove();
			x1=tmp.a;
			y1=tmp.b;
			x2=tmp.c;
			y2=tmp.d;
			
			x3 = getmid(x1,x2);
			y3 = getmid(y1,y2);
			
			out.println(x3+" "+y3);
			out.flush();
			
			s = sc.next();
			
			if(s.equals("CENTER"))
			{
				return;
			}
			else if(s.equals("HIT"))
			{
				break;
			}
			else if(s.equals("WRONG"))
			{
				return;
			}
			
			q.add(new Pair(x1,y1,x3,y3));
			q.add(new Pair(x3,y3,x2,y2));
			q.add(new Pair(x1,y3,x3,y2));
			q.add(new Pair(x3,y1,x2,y3));
			
		}
		
		int x4 = x3-1;
		int x5 = x3+1;
		
		while(x4>=(-xxx))
		{
			out.println(x4+" "+y3);
			out.flush();
			
			s = sc.next();
			
			if(s.equals("CENTER"))
			{
				return;
			}
			else if(s.equals("MISS"))
			{
				break;
			}
			else if(s.equals("WRONG"))
			{
				return;
			}
			x4--;
		}
		
		while(x5<=xxx)
		{
			out.println(x5+" "+y3);
			out.flush();
			
			s = sc.next();
			
			if(s.equals("CENTER"))
			{
				return;
			}
			else if(s.equals("MISS"))
			{
				break;
			}
			else if(s.equals("WRONG"))
			{
				return;
			}
			x5++;
		}
		
		int y4 = y3-1;
		int y5 = y3+1;
		
		while(y4>=(-xxx))
		{
			out.println(x3+" "+y4);
			out.flush();
			
			s = sc.next();
			
			if(s.equals("CENTER"))
			{
				return;
			}
			else if(s.equals("MISS"))
			{
				break;
			}
			else if(s.equals("WRONG"))
			{
				return;
			}
			y4--;
		}
		
		while(y5<=xxx)
		{
			out.println(x3+" "+y5);
			out.flush();
			
			s = sc.next();
			
			if(s.equals("CENTER"))
			{
				return;
			}
			else if(s.equals("MISS"))
			{
				break;
			}
			else if(s.equals("WRONG"))
			{
				return;
			}
			y5++;
		}
		
		int midx = x4 + (x5-x4)/2;
		int midy = y4 + (y5-y4)/2;
		
		out.println(midx+" "+midy);
		out.flush();
		s = sc.next();
		if(s.equals("CENTER"))
		{
			return;
		}
		out.println((xxx+5)+" "+1);
	}

    public void run() {
       
         sc = new InputReader(System.in);
         out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			solve(i);
			if(s.equals("WRONG"))
			return;		 
		}
		
        out.close();
    }
    
//======================================================================    
    
    static class Pair
    {
		int a,b,c,d;
		Pair(int aa, int bb, int cc, int dd)
		{
			a = aa;
			b = bb;
			c = cc;
			d = dd;
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
