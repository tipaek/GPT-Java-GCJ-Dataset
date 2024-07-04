import java.io.*;
import java.util.InputMismatchException;


public class Solution implements Runnable
{


    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int N = Integer.parseInt(in.nextLine());
            String[] strs = new String[N];
            for (int j = 0; j < N; j++) {
                strs[j] = in.nextLine().trim();
            }
            getRes(strs, i, w);
        }
        w.flush();
        w.close();
    }

    private static void getRes(String[] strs, int t, PrintWriter w) {
        // System.out.println("start");
        int l = strs.length;
        int[][] index = new int[l][2];

        String prefix = "", suffix = "";
        for (int i = 0; i < l; i++) {
            String s = strs[i];
            int len = s.length(), left = 0, right = len - 1;
            while (left <= right && s.charAt(left) != '*') {
                // System.out.println("left " + left);
                left++;
            }
            while (left <= right && s.charAt(right) != '*') {
                // System.out.println("right " + right);
                right--;
            }

            // System.out.println(len + " left: " + left + " right: " + right);
            if (left <= prefix.length() && prefix.indexOf(s.substring(0, left)) != 0 ||
                    left > prefix.length() && s.substring(0, left).indexOf(prefix) != 0) {
                w.println("Case #" + t + ": " + "*");
                return;
            }
            if (left > prefix.length()) prefix = s.substring(0, left);
            int suffixLen = len - right - 1;
            if (suffixLen <= suffix.length() && suffix.indexOf(s.substring(right + 1)) < 0 ||
                    suffixLen > suffix.length() && s.substring(right + 1).indexOf(suffix) < 0) {
                w.println("Case #" + t + ": " + "*");
                return;
            }
            if (suffixLen > suffix.length()) suffix = s.substring(right + 1);
            // System.out.println("prefix: " + prefix);
            // System.out.println("suffix: " + suffix);
            index[i][0] = left + 1;
            index[i][1] = right - 1;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < l; i++) {
            for (int j = index[i][0]; j <= index[i][1]; j++) {
                if (strs[i].charAt(j) != '*') {
                    sb.append(strs[i].charAt(j));
                }
            }
        }
        sb.append(suffix);
        w.println("Case #" + t + ": " + sb.toString());
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
