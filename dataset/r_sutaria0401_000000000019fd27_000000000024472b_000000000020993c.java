import java.util.*;
import java.math.*;
import java.io.*;
public class Solution{
    static InputReader sc;
    static PrintWriter wc; 
    public static void main(String[] args) {
        sc = new InputReader(System.in);
        wc = new PrintWriter(System.out);   
        int t = sc.nextInt();
        int arr[][] = new int[100][100],input,count[] = new int[100];
        int i,j,trace = 0;
        int n,k;
        int r_count = 0, c_count = 0, all=1;
        for(k=1;k<=t;k++) {
            n = sc.nextInt();
            trace = 0;
            for(i=0;i<n;i++) {
                for(j=0;j<n;j++) {
                    arr[i][j] = sc.nextInt();
                }
                trace += arr[i][i];
            }
            r_count = 0; c_count = 0;
            for(i=0;i<n;i++) {
                for(j=0;j<n;j++) count[j] = 0;
                for(j=0;j<n;j++) count[arr[i][j]-1]++;
                all = 1;
                for(j=0;j<n;j++) all = Math.min(all,count[j]);
                r_count += 1 - all;
            }
            for(i=0;i<n;i++) {
                for(j=0;j<n;j++) count[j] = 0;
                for(j=0;j<n;j++) count[arr[j][i]-1]++;
                all = 1;
                for(j=0;j<n;j++) all = Math.min(all,count[j]);
                c_count += 1 - all;
            }
            wc.println("Case #"+k+": "+trace+" "+r_count+" "+c_count);
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