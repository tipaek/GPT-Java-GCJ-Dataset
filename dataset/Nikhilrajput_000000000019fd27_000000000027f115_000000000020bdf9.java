import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
public class Solution implements Runnable {
   
    
  
   
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
    
    static void fill(int a[],int i,int n)
    {
        for(;i<=n;i++)a[i]=1;
    }
   
    
    static void solve(InputReader sc, PrintWriter out, int testcase)
    {
        int a[] = new int[1442];
        int b[] = new int[1442];
       
        int n = sc.nextInt();
       
        Pair[] p = new Pair[n];
       
        for(int i=0;i<n;i++)
        {
            int s = sc.nextInt(), e =sc.nextInt();
            p[i] = new Pair(s,e,i);
        }
       
        char ans[] = new char[n];
        Arrays.sort(p,new SortPair());
           
        for(int j=0;j<n;j++)
        {
            int s = p[j].a;
            int e = p[j].b;
            int in = p[j].in;
           
           
            if(a[s]!=1)
            {
                fill(a,s,e-1);
                ans[p[j].in]='C';
            }
            else if(b[s]!=1)
            {
                fill(b,s,e-1);     
                ans[p[j].in]='J';
            }
            else
            {
                out.println("Case #"+testcase+": IMPOSSIBLE");
                return;
            }
        }
 
        out.println("Case #"+testcase+": "+new String(ans));
    }
   
    public void run() {
       
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
       
        int t = sc.nextInt();
       
        for(int i=1;i<=t;i++)
        {
            solve(sc,out,i);         
        }
       
        out.close();
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