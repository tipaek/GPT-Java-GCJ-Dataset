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
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }
            getRes(arr, w, i);
        }
        w.flush();
        w.close();
    }

    private static void getRes(int[][] arr, PrintWriter w, int t) {
        char[] ch = new char[arr.length];
        Map<String, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i][0] + " " + arr[i][1];
            map.putIfAbsent(s, new LinkedList<>());
            map.get(s).offer(i);
        }

        Arrays.sort(arr, (a1, a2) -> a1[1] - a2[1]);
        int J = 0, C = 0;

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int index = map.get(arr[i][0] + " " + arr[i][1]).poll();
            if (J <= start && C <= start) {
                if (J > C) {
                    ch[index] = 'J';
                    J = arr[i][1];
                }
                else {
                    ch[index] = 'C';
                    C = arr[i][1];
                }
                continue;
            }
            if (J <= start) {
                ch[index] = 'J';
                J = arr[i][1];
                continue;
            }
            if (C <= start) {
                ch[index] = 'C';
                C = arr[i][1];
                continue;
            }
            w.println("Case #" + t + ": " + "IMPOSSIBLE");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }


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
