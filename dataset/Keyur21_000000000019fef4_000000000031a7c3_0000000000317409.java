import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Palindrome solver = new Palindrome();

        int t = 1;
        t = in.nextInt();

        for (int i = 0; i < t; i++) {
            solver.solve(i + 1, in, out);
        }

        out.close();
    }

    static class Palindrome {
        static long mod = 1000000007;
        static long maxX = (long) 1e18;
        static long mod2 = 998244353;

        void solve(int testNumber, ScanReader in, PrintWriter out) {
            out.print("Case #" + testNumber + ": ");

            int y = in.nextInt(),x = in.nextInt();
            char[] s = in.next().toCharArray();

            int x1 = 0,y1 = 0;

            int n = s.length;

            int ans = -1;
            for(int i = 0;i<n;i++) {
                if(s[i] == 'N'){
                    x++;
                    x1++;
                } else if (s[i] == 'E') {
                    y++;
                    y1++;
                } else if (s[i] == 'S') {

                    if(y==y1) {
                        if(x == x1) {
                            x1--;
                        } else if(x-1 == x1){
                            ans = i+1;
                            break;
                        } else {
                            x1++;
                        }
                        x--;
                    } else {
                        x--;
                        y1++;
                    }
                } else {
                    if(x==x1){

                        if(y==y1) {
                            y1--;
                        } else if (y-1==y1){
                            ans = i + 1;
                            break;
                        } else {
                            y1++;
                        }
                        y--;
                    } else {
                        y--;
                        x1++;
                    }
                }
                if(x==x1 && y == y1) {
                    ans = i + 1;
                    break;
                }
            }

            if(ans == -1) {
                out.println("IMPOSSIBLE");
            } else out.println(ans);
        }
    }

    static class ScanReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public ScanReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
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
}