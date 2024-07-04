import java.util.*;
import java.math.*;
import java.io.*;
public class Solution{
    static InputReader sc;
    static PrintWriter wc; 
    public static void main(String[] args) {
        sc = new InputReader(System.in);
        wc = new PrintWriter(System.out);   
        int T = sc.nextInt(),t;
        int a = sc.nextInt(),b = sc.nextInt(),i,j;
        String reply;
        outer:
        for(t=1;t<=T;t++) {
            if(a == (int)1e9-50) {
                for(i = -5;i<=5;i++) {
                    for(j = -5;j<=5;j++) {
                        System.out.println(i+" "+j);
                        String reply = sc.next();
                        if(reply.equals("CENTER")){
                            continue outer;
                        }
                    }
                }
            }
            for(i=-50;i<=50;i++) {
                System.out.println(49+" "+i);
                reply = sc.next();
                if(reply.equals("CENTER")){
                    continue outer;
                }
                else {
                    System.out.println("50 "+i);
                    reply = sc.next();
                    if(reply.equals("HIT")){
                        break;
                    }
                    else if(reply.equals("CENTER")){
                        continue outer;
                    }
                }
            }
            for(j=-50;j<=50;j++){
                System.out.println(j+" "+i);
                reply = sc.next();
                if(reply.equals("CENTER")){
                    continue outer;
                }
            }
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