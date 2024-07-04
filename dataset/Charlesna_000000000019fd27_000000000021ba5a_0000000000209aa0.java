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
            int N = in.nextInt();
            int K = in.nextInt();
            getRes(N, K, w, i);
        }
        w.flush();
        w.close();
    }

    static boolean have;
    private static void getRes(int N, int K, PrintWriter w, int t) {
        have = false;
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, 0, N, K, new boolean[N + 1]);
        if (!have) {
            w.println("Case #" + t + ": " + "IMPOSSIBLE");
            return;
        }

        w.println("Case #" + t + ": " + "POSSIBLE");
        for (List<Integer> list : res) {
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num + " ");
            }
            w.println(sb.toString());
        }
    }

    private static void helper(List<List<Integer>> res, List<Integer> temp, int row, int col, int N, int K, boolean[] used) {
        if (have) return;
        if (row == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += res.get(i).get(i);
            }
            if (sum == K) {
                have = true;
            }
            return;
        }
        if (col == N) {
            res.add(temp);
            helper(res, new ArrayList<>(), row + 1, 0, N, K, new boolean[N + 1]);
            if (!have) {
                res.remove(res.size() - 1);
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;
            boolean valid = true;
            for (List<Integer> list : res) {
                if (list.get(col) == i) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;
            used[i] = true;
            temp.add(i);
            helper(res, temp, row, col + 1, N, K, used);
            if (!have) {
                temp.remove(temp.size() - 1);
                used[i] = false;
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
