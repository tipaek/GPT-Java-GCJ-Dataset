import java.util.*;
import java.math.*;
import java.io.*;
public class Solution{
    static InputReader sc;
    static PrintWriter wc; 
    public static void main(String[] args) {
        sc = new InputReader(System.in);
        wc = new PrintWriter(System.out);   
        int T = sc.nextInt();
        int t,i,j;
        int a,b,bits,t1,t2;
        outer:
        for(t=1;t<=T;t++) {
            wc.print("Case #"+t+": ");
            a = sc.nextInt();
            b = sc.nextInt();
            bits = 0;
            j = 1;
            i = Math.abs(a) + Math.abs(b);
            while(j<i) {
                j = j << 1;
                bits++; 
            }
            StringBuilder sb = new StringBuilder();
            while(bits>0) {
                j = 1 << (bits-1);
                bits--;
                t1 = Math.abs(a);
                t2 = Math.abs(b);
                // wc.println(j);
                if(t1>t2) {
                    if(a>0) {
                        a -= j;
                        sb.append('E');
                    }
                    else {
                        a += j;
                        sb.append('W');
                    }
                }
                else if(t2>t1) {
                    if(b>0) {
                        b -= j;
                        sb.append('N');
                    }
                    else {
                        b += j;
                        sb.append('S');
                    }

                }
                else {
                    // System.out.println("Got here");
                    wc.println("IMPOSSIBLE");
                    continue outer; 
                }
            }
            wc.println(sb.reverse());
        }
        wc.close();
    }
    static class InputReader {
        
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }
        
        public int read(){
            if (numChars==-1) 
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try 
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                
                if(numChars <= 0)               
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine()
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt()
        {
            int c = read();
            
            while(isSpaceChar(c)) 
                c = read();
            
            int sgn = 1;
            
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            
            int res = 0;
            do 
            {
                if(c<'0'||c>'9') 
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c)); 
            
            return res * sgn;
        }
        
        public long nextLong() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            long res = 0;
            
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
        
        public double nextDouble() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') 
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') 
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) 
                {
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
        
        public String readString() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = read();
            } 
            while (!isSpaceChar(c));
            
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) 
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next() 
        {
            return readString();
        }
        
        public interface SpaceCharFilter 
        {
            public boolean isSpaceChar(int ch);
        }
    }   
}