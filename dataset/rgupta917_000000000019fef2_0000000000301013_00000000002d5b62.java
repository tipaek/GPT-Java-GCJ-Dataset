import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
public class Solution{
public static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;
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
     
    public static void main(String[] args) 
    { 
       InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
       int t=sc.nextInt();
       int c=0;
       while(t-->0)
       {
           c++;
       long x=sc.nextLong();
       long y=sc.nextLong();
       long crrx=0;
       long crry=0;
       String ans="";
       if((x+y)%2==0)
       w.println("Case #"+c+": "+"IMPOSSIBLE");
       else if(Math.log(Math.abs(x-y)+1)/Math.log(2)!=Math.ceil(Math.log(Math.abs(x-y)+1)/Math.log(2)))
       w.println("Case #"+c+": "+"IMPOSSIBLE");
       else
       {
           if(x%2!=0)
           {
               if(x>0)
               {crrx=-1;
               ans+="E";
               x--;
               }
               else
               {crrx=1;
               ans+="W";
               x++;
               }
               
           }
           else if(y%2!=0)
           {
               if(y>0)
               {
               crry=-1;
               ans+="S";
               y++;
               }
               else
               {
               crry=1;
               ans+="N";
               y--;
               }
               
           }
           int l=(int)Math.abs(x)+(int)Math.abs(y);
           
          for(int i=2;i<=l;i=i*2)
               {
                   if(i==Math.abs(y))
                   {
                       if(y<0)
                       ans+="S";
                       else
                       ans+="N";
                       y=0;
                   }
                   else
                   {
                       if(x<0)
                       {
                           ans+="W";
                           x+=i;
                       }
                       else
                       {
                           ans+="E";
                           x-=i;
                       }
                       
                   }
                  // w.print(ans+" 1");
               }
               w.println("Case #"+c+": "+ans); 
           
       }
        
     
      }
	w.close();
	}
 } 