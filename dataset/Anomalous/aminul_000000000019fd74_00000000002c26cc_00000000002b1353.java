import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            long n = in.nextInt();
            List<int[]> results = solve(n);
            pw.println("Case #" + t + ":");
            for (int[] coordinates : results) {
                pw.println(coordinates[0] + " " + coordinates[1]);
            }
        }
        pw.close();
    }

    static List<int[]> solve(long n) {
        List<int[]> results = new ArrayList<>();
        long sum = 1;
        int length = 1;
        int row = 1, col = 1, direction = 1;
        while (n > 0) {
            if (n >= sum) {
                for (int i = 1; i <= length; i++) {
                    results.add(new int[]{row, col});
                    col += direction;
                }
                if (col <= 0) col = 1;
                row++;
                n -= sum;
                direction *= -1;
                sum *= 2;
                length++;
            } else {
                while (n > 0) {
                    results.add(new int[]{row++, col});
                    n--;
                    if (direction == -1) col++;
                }
            }
        }
        return results;
    }

    static class FastReader {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int bufferLen = 0, bufferPtr = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        private int readByte() {
            if (bufferLen == -1) throw new InputMismatchException();
            if (bufferPtr >= bufferLen) {
                bufferPtr = 0;
                try {
                    bufferLen = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLen <= 0) return -1;
            }
            return buffer[bufferPtr++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}