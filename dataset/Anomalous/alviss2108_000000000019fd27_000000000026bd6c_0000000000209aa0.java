import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        IndiciumSolver solver = new IndiciumSolver();
        int numCases = Integer.parseInt(in.next());
        for (int i = 1; i <= numCases; i++) {
            solver.solve(i, in);
        }
    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    static class IndiciumSolver {
        public void solve(int caseNumber, InputReader in) {
            int n = in.readInt();
            int k = in.readInt();
            if (k % n == 0 && k / n <= n) {
                printMessage("Case #" + caseNumber + ": POSSIBLE");
                int start = k / n + n;
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    row.setLength(0);
                    for (int j = 0; j < n; j++) {
                        int value = (start + j) % n;
                        if (value == 0) value = n;
                        row.append(value);
                        if (j < n - 1) row.append(" ");
                    }
                    printMessage(row.toString());
                    start -= 1;
                }
            } else {
                printMessage("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public int readInt() {
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
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    result.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}