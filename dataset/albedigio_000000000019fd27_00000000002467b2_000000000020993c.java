
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int test = in.readInt();
        for (int i = 0; i < test; i++) {
            int n = in.readInt();
            HashMap<Integer, HashSet<Integer>> rowsUniqueMap = new HashMap<>(n);
            HashMap<Integer, HashSet<Integer>> colsUniqueMap = new HashMap<>(n);
            int trace = 0;
            for (int j = 0; j < n; j++) {
                rowsUniqueMap.put(j, new HashSet<>(n));
                for (int k = 0; k < n; k++) {
                    int value = in.readInt();
                    if (j == 0) {
                        colsUniqueMap.put(k, new HashSet<>(n));
                    }
                    rowsUniqueMap.get(j).add(value);
                    colsUniqueMap.get(k).add(value);
                    if (k == j) {
                        trace+=value;
                    }
                }
            }
            int rows = 0;
            int cols = 0;
            for (int j = 0; j < n; j++) {
                if (rowsUniqueMap.get(j).size() != n) {
                    rows++;
                }
                if (colsUniqueMap.get(j).size() != n) {
                    cols++;
                }
            }

            sb.append("Case #").append(i+1).append(": ").append(trace).append(" ").append(rows).append(" ").append(cols).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
