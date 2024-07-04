
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
        for (int t = 0; t < test; t++) {
            StringBuilder ans = new StringBuilder();
            int n = in.readInt();
            int d = in.readInt();
            double angles[] = new double[n];
            HashMap<Double, Integer> howMany = new HashMap<>();
            for (int i = 0; i < n; i++) {
                angles[i] = in.readDouble();
                if (howMany.containsKey(angles[i])) {
                    int ho = howMany.get(angles[i]);
                    howMany.put(angles[i], ho+1);
                } else {
                    howMany.put(angles[i], 1);
                }
            }
            if (d == 2) {
                for (Map.Entry<Double, Integer> entry : howMany.entrySet()) {
                    if (entry.getValue() == 2) {
                        ans.append(0);
                        break;
                    }
                }
                if (ans.length() == 0) {
                    ans.append(1);
                }
            } else if (d == 3) {
                for (Map.Entry<Double, Integer> entry : howMany.entrySet()) {
                    if (entry.getValue() == 3) {
                        ans.append(0);
                        break;
                    }
                }
                boolean isBreak = false;
                for (Map.Entry<Double, Integer> entry1 : howMany.entrySet()) {
                    for (Map.Entry<Double, Integer> entry2 : howMany.entrySet()) {
                        if (entry1.getValue()/2 == entry2.getValue()) {
                            ans.append(1);
                            isBreak = true;
                            break;
                        }
                        if (isBreak) {
                            break;
                        }
                    }
                }
                if (ans.length() == 0) {
                    ans.append(2);
                }
            }

            sb.append("Case #").append(t+1).append(": ").append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
