import java.io.*;
import java.util.InputMismatchException;


public class Solution implements Runnable
{


    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        build();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int N = in.nextInt();
            getRes(N, i, w);
        }
        w.flush();
        w.close();
    }

    static long[][] tri = new long[501][501];
    static long[][] prefix = new long[501][501];

    private static void build() {
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    prefix[i][j] = 1;
                    tri[i][j] = 1;
                    continue;
                }
                tri[i][j] = tri[i - 1][j] + tri[i - 1][j - 1];
                tri[i][j] = Math.min(tri[i][j], (long)1e10);
                prefix[i][j] = prefix[i][j - 1] + tri[i][j];
            }
        }
    }


    private static void getRes(int N, int t, PrintWriter w) {

//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 50; j++) {
//                System.out.print(prefix[i][j] + " ");
//            }
//            System.out.println();
//        }
        w.println("Case #" + t + ": ");
        int x = 1, y = 1;
        while (N > 0) {
            w.println(x + " " + y);
            N -= tri[x][y];

            if (prefix[x + 1][y] + tri[x + 1][y + 1] <= N) {
                x++;
                y++;
            }
            else if (prefix[x + 1][y - 1] + tri[x + 1][y] <= N) {
                x++;
            }
            else {
                y--;
            }
        }

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
