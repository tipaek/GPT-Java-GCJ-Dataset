import java.io.*;
import java.util.*;


public class Solution implements Runnable
{


    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            getRes(x, y, w, i);
        }
        w.flush();
        w.close();
    }


    private static void getRes(int x, int y, PrintWriter p, int t) {
        boolean EW = x < 0, NS = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);
        if ((x ^ y & 1) == 0) {
            p.println("Case #" + t + ": " + "IMPOSSIBLE");
            return;
        }


        StringBuilder sb = new StringBuilder();

        int w = 0, s = 0;
        for (int i = 1; i < 31 && (1 << i) <= x && (1 << i) <= y; i++) {
            int m = x >> i & 1;
            int n = y >> i & 1;
            if (m == 0 && n == 0) {
                if ((w >> i & 1) == 1 || (s >> i & 1) == 1) continue;
                for (int j = i - 1; j >= 0; j--) {
                    if ((x >> j & 1) == 1 || ((w >> j & 1) == 1)) {
                        x += (1 << j);
                        w += (1 << j);
                        i = j;
                        break;
                    }
                    else if ((y >> j & 1) == 1 || ((s >> j & 1) == 1)) {
                        y += (1 << j);
                        s += (1 << j);
                        i = j;
                        break;
                    }
                }
            }
            else if (m == 1 && n == 1) {
                int j = i - 1;
                if ((x >> (i - 1) & 1) == 0) {
                    while ((y >> j & 1) == 1) {
                        j--;
                    }
                    j++;
                    y += (1 << j);
                    s += (1 << j);
                }
                else {
                    while ((x >> j & 1) == 1) {
                        j--;
                    }
                    j++;
                    x += (1 << j);
                    w += (1 << j);
                }
                i = j;
            }
        }

        for (int i = 0; i < 31; i++) {
            if ((w >> i & 1) == 1) {
                sb.append(EW ? "E" : "W");
            }
            else if ((s >> i & 1) == 1) {
                sb.append(NS ? "N" : "S");
            }
            else if ((x >> i & 1) == 1) {
                sb.append(EW ? "W" : "E");
            }
            else if ((y >> i & 1) == 1) {
                sb.append(NS ? "S" : "N");
            }
            else {
                break;
            }
        }

        p.println("Case #" + t + ": " + sb.toString());
    }



    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    public static void main(String args[]) throws Exception
    {
        new Thread(null, new Solution(),"Main",1<<27).start();
    }

}
