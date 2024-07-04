import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader in = new Reader();
        new Solution().solve(out, in);
        out.flush();
        out.close();
    }

    static final int MAXN = 5 * (int) 1e5 + 5;
    static final long MOD = (int) 1e9 + 7;
    static int n, t, d;

    void solve(PrintWriter out, Reader in) throws IOException {
        t = in.nextInt();

        for (int itr = 1; itr <= t; itr++) {
            n = in.nextInt();
            d = in.nextInt();

            long[] arr = new long[n];
            long max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                max = Math.max(max, arr[i]);
            }

            long ans = calculateMaxFrequency(arr);

            if (ans >= d) {
                out.println("Case #" + itr + ": 0");
            } else {
                out.println("Case #" + itr + ": " + calculateResult(arr, ans, max));
            }
        }
    }

    long calculateMaxFrequency(long[] arr) {
        long maxFrequency = 0;
        for (int i = 0; i < arr.length; i++) {
            long tmp = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) tmp++;
            }
            maxFrequency = Math.max(maxFrequency, tmp);
        }
        return maxFrequency;
    }

    int calculateResult(long[] arr, long ans, long max) {
        if (d == 2) {
            return 1;
        } else {
            int res = 2;
            if (ans == 2) {
                for (int i = 0; i < arr.length; i++) {
                    long tmp = 1;
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] == arr[j]) tmp++;
                    }
                    if (tmp == 2 && max > arr[i]) {
                        res = 1;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] * 2 == arr[j]) res = 1;
                }
            }
            return res;
        }
    }

    static class Reader {
        private InputStream input;
        private byte[] buffer = new byte[1024];
        private int curChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream input) {
            this.input = input;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = input.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}