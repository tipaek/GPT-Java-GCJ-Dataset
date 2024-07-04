
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
            String s = in.readString();
            StringBuilder ans = new StringBuilder();
            if (s.length() == 1) {
                int digit = Character.getNumericValue(s.charAt(0));
                for (int j = 0; j < digit; j++) {
                    ans.append('(');
                }
                ans.append(digit);
                for (int j = 0; j < digit; j++) {
                    ans.append(')');
                }
            } else {
                int currentOpen = 0;
                for (int j = 0; j < s.length()-1; j++) {
                    int k = Character.getNumericValue(s.charAt(j));
                    int p = Character.getNumericValue(s.charAt(j+1));
                    if (j == 0) {
                        for (int l = 0; l < k; l++) {
                            ans.append('(');
                            currentOpen++;
                        }
                    } else {
                        for (int l = 0; l < k-currentOpen; l++) {
                            ans.append('(');
                            currentOpen++;
                        }
                    }
                    ans.append(k);
                    int delta = k - p;
                    while (delta == 0 && j + 2 < s.length()) {
                        ans.append(p);
                        j++;
                        p = Character.getNumericValue(s.charAt(j+1));
                        delta = k - p;
                    }
                    if (delta > 0) {
                        for (int l = 0; l < k-p; l++) {
                            ans.append(')');
                            currentOpen--;
                        }
                    } else {
                        for (int l = 0; l < p-k; l++) {
                            ans.append('(');
                            currentOpen++;
                        }
                    }
                }
                ans.append(s.charAt(s.length()-1));
                for (int j = 0; j < currentOpen; j++) {
                    ans.append(')');
                }
            }

            sb.append("Case #").append(i+1).append(": ").append(ans.toString()).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}

