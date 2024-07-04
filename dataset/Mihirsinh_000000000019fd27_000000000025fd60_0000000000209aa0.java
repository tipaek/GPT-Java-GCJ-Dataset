import java.io.*;
import java.util.*;
 
public class Solution{
   
    static boolean verify(int a[][],int x,int r,int c,int tra)
    {
        int sum = x;
        
        for(int i=0;i<a.length;i++)
        {
            if(a[i][c] ==x || a[r][i]==x)
                return false;
            else
            {
            	sum+=a[i][i];
            }
        }
        
        if(r==c && r==a.length-1)
        {
            if(sum!=tra)
            {
            	return false;
            }
        }
        if(r==c && sum>tra)
        {
        	return false;
        }
 		else
 		{
 			return true;
 		}
    }
   
    static boolean find(int a[][],int n,int tra)
    {
        boolean fin = true;
        int r,c;
        r=-1;
        c=-1;
        for(int i=0;i<n;i++)
        {
                for(int j=0;j<n;j++)
                {
                    if(a[i][j]==0)
                    {
                        r = i;
                        c = j;
                        fin = false;
                        break;
                    }
                }
                if(!fin)
                {
                	break;
                }
        }
        if(fin)
            return true;
       
        for(int i=1;i<=n;i++)
        {
            if(verify(a,i,r,c,tra))
            {
                a[r][c] = i;
                if(find(a,n,tra))
                {
                    return true;
                }
                a[r][c]=0;
            }
        }
        return false;
    }
    /*static void diag(int a[][],int tra)
    {
        for(int i=0;i<a.length;i++)
        {
            a[i][i]=a.length;
        }
       
        int sum = a.length*a.length;
       
        for(int i = a.length-1;i>=0;i--)
        {
            if(sum==tra)
                break;
            int x = sum-tra;
            if(a[i][i]-1<x)
            {
            	x=a[i][i]-1;
            }
            else
            {
            	x=x;
            }
            a[i][i]-=x;
            sum-=x;
        }
    }*/
    static void solve(InputReader sc, PrintWriter out, int tc)
    {
        int n = sc.nextInt();
        int a[][] = new int[n][n];
       
        int tra = sc.nextInt();
   
        if(find(a,n,tra))
        {
            out.println("Case #"+tc+": POSSIBLE");
            pr_ans(a,out);
        }
        else
        {
            out.println("Case #"+tc+": IMPOSSIBLE");
           
        }
       
    }
   
    static void pr_ans(int a[][],PrintWriter out)
    {
        for(int i[]:a)
        {
            for(int j:i)
                out.print(j+" ");
            out.println();
        }
    }
   
   
//======================================================================
 
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
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
       
        int t = sc.nextInt();
   
        for(int i=1;i<=t;i++)
        {
            solve(sc,out,i);         
        }
        out.close();
    }
}