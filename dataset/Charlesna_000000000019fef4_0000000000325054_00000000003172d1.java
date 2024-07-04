import java.io.*;
import java.util.*;


public class Solution implements Runnable
{


    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = (int) in.nextLong();
        // System.out.println(t);
        for (int i = 1; i <= t; i++) {
            int N = (int) in.nextLong();
            int D = (int) in.nextLong();
            long[] arr = new long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextLong();
            }
            getRes(N, D, arr, i, w);
        }
        w.flush();
        w.close();
    }


    private static void getRes(int N, int D, long[] arr, int t, PrintWriter w) {
        Map<Long, List<Long>> map = new HashMap<>();
        for (long num : arr) {
            boolean p = true;
            for (long i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    p = false;
                    map.putIfAbsent(i, new ArrayList<>());
                    map.get(i).add(num);
                }
            }
            if (p) {
                map.putIfAbsent(num, new ArrayList<>());
                map.get(num).add(num);
            }
        }
        int res = D - 1;
        for (long key : map.keySet()) {
            res = Math.min(res, helper(key, map.get(key), D));
        }
        w.println("Case #" + t + ": " + res);
    }

    private static int helper(long p, List<Long> list, int d) {
        long[] arr = new long[list.size()];
        int res = d - 1;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i) / p;
            sum += arr[i];
        }

        if (sum < d) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * (d / sum + 1);
            }
        }

        int[] dp = new int[d + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > d) continue;
            for (int j = d; j >= arr[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - (int)arr[i]] + 1);
            }
        }
        for (int k = d; k >= 1; k--) {
            res = Math.min(res, d - dp[k] + (d - k));
        }

        for (long num : list) {
            res = Math.min(res, cal(num, list, d));
        }
        // System.out.println("res is: " + res);
        return res;
    }

    private static int cal(long num, List<Long> list, int d) {
        List<Long> arr = new ArrayList<>();
        long sum = 0;
        for (long l : list) {
            sum += l / num;
            if (l < num || l % num != 0) continue;
            arr.add(l / num);
        }

        if (sum < d) {
            for (int i = 0; i < arr.size(); i++) {
                arr.set(i, (d / sum + 1) * arr.get(i));
            }
        }

        int res = d - 1;
        int[] dp = new int[d + 1];
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > d) continue;
            for (int j = d; j >= arr.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[(int) (j - (arr.get(i)))] + 1);
            }
        }
        for (int k = d; k >= 1; k--) {
            res = Math.min(res, d - dp[k] + (d - k));
        }
        return res;
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
