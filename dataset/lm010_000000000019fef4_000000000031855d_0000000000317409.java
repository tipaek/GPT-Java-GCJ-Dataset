import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;
public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Check2", 1 << 28).start();// to increse stack size in java
    }
    long mod= (long)(1e9+7);
    public void run() {
        try {
            boolean file = false;
            InputReader in;
            PrintWriter w;
            if (file) {
                in = new InputReader(new FileInputStream("C:\\Users\\Lenovo\\Downloads\\A-large(1).in"));
                w = new PrintWriter("output.txt");
            } else {
                in = new InputReader(System.in);
                w = new PrintWriter(System.out);
            }

            int t = in.nextInt();
            int tc = 1;

            while (t-- > 0){
                int x = in.nextInt();
                int y = in.nextInt();
                char c[] = in.next().toCharArray();
                int currX = x;
                int currY = y;
                int ans = -1;

                for (int i=0;i<c.length;i++){
                    if (c[i] == 'S'){
                        currY--;
                    }
                    else if (c[i] == 'N'){
                        currY++;
                    }
                    else if (c[i] == 'E'){
                        currX++;
                    }
                    else{
                        currX--;
                    }
                    int time = Math.abs(currX) + Math.abs(currY);
                    if (time <= i + 1){
                        ans = i + 1;
                        break;
                    }
                }
                if (ans == -1){
                    w.println("Case #"+tc+": "+"IMPOSSIBLE");
                }
                else{
                    w.println("Case #"+tc+": "+ans);
                }
                tc++;
            }
            w.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
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
            String stock = "";
            try
            {
                stock = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return stock;
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

