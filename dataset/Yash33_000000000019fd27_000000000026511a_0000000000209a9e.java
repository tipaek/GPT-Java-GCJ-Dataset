import java.io.*;
import java.util.*;
 
public class Solution implements Runnable {
   
	static int b;	
    static void solve(InputReader sc, PrintWriter out, int testcase)
    {
		
		int i = b/2-1;
		//System.out.println(i);
		int s = -1 , d = -1;
		int a[] = new int[b];
		
		for(int j=0;i>=0 && j<5;j++)
			{
				a[i] = get(i,sc,out); a[b-i-1] = get(b-i-1,sc,out);
				if(s==-1 && a[i]==a[b-i-1])
					s = j;
				if(d==-1 && a[i]!=a[b-i-1])
					d = j;
				i--;
			}
			boolean comp = false, rev = false;
			int curs=-1,curd=-1;
			
			if(i!=-1)
			{
			if(s!=-1)
				curs = get(s,sc,out);
			if(d!=-1)
				curd = get(d,sc,out);
			
			if(curs!=-1 && curs!=a[s])
			{
				comp=true;
			} 
			// rev and comp has same effect on diff, so if dif is same then both
			if(curd!=-1 && curd==a[d])
				rev = true;  
			else
				rev = false;
			if(rev)
			{
				for(int k=0;k<a.length;k++)
				{
					int tmp = a[k];
					a[k] = a[b-k-1];
					a[b-k-1] = tmp;
				}
			}
		}
			if(comp)
			{
				for(int k=0;k<a.length;k++)
					a[k]=a[k]==0?1:0;
			}
		
		while(i>=0)
		{
			// scan all 10 then array will or will not be modified
			for(int j=0;i>=0 && j<4;j++)
			{
				a[i] = get(i,sc,out); a[b-i-1] = get(b-i-1,sc,out);
				if(s==-1 && a[i]==a[b-i-1])
					s = j;
				if(d==-1 && a[i]!=a[b-i-1])
					d = j;
				i--;
			}
			if(i==-1)
				break;
			curs=curd=-1;
			if(s!=-1)
				curs = get(s,sc,out);
			if(d!=-1)
				curd = get(d,sc,out);
			
			comp = rev = false;
			
			//               same   dif
			//  original	 0 0	0 1
			//  comp    	 1 1	1 0
			//  rev      	 0 0 	1 0
			//  both		 1 1	0 1
			
			// coz prevs and curs are same
			if(curs!=-1 && curs!=a[s])
			{
				comp=true;
			} 
			// rev and comp has same effect on diff, so if dif is same then both
			if(curd!=-1 && curd==a[d])
				rev = true;  
			else
				rev = false;
			if(rev)
			{
				for(int k=0;k<a.length;k++)
				{
					int tmp = a[k];
					a[k] = a[b-k-1];
					a[b-k-1] = tmp;
				}
			}
			
			if(comp)
			{
				for(int k=0;k<a.length;k++)
					a[k]=a[k]==0?1:0;
			}
		}
		
		for(int xx:a)
		out.print(xx);
		out.println();
		out.flush();
		
		String verd = sc.next();
		if(verd.charAt(0)=='N')
		System.exit(0);
		
    }
    
    static int get(int pos,InputReader sc,PrintWriter out)
    {
		out.println(pos+1);
		out.flush();
		return sc.nextInt();
	}
   
    public void run() {
       
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
       
        int t = sc.nextInt();
		b = sc.nextInt();
        
        for(int i=1;i<=t;i++)
        {	
            solve(sc,out,i);         
        }
        
        out.close();
    }
   
//======================================================================    
   
    static class SortPair implements Comparator<Pair>
    {
        public int compare(Pair a, Pair b)
        {
            if(a.a != b.a)
                return a.a - b.a;
            return a.b - b.b;
        }
    }
   
    static class Pair
    {
        int a,b,in;
        Pair(int aa, int bb,int ii)
        {
            a = aa;
            b = bb;
            in=ii;
        }
        public String toString()
        {
            return "["+a+" "+b+"]";
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
