import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Solution {

    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        initialize();
        int tests = in.readInt();
        for (int te = 1; te <= tests; te++) {
            processTest(te);
        }
        finalizeIO();
    }

    private static void processTest(int testNumber) {
        char[] line = in.readLine().toCharArray();
        int open = 0;
        StringBuilder res = new StringBuilder();

        for (char c : line) {
            int current = c - '0';
            if (current > open) {
                res.append(repeat('(', current - open));
            } else if (current < open) {
                res.append(repeat(')', open - current));
            }
            open = current;
            res.append(c);
        }
        res.append(repeat(')', open));
        out.println("Case #" + testNumber + ": " + res);
    }

    private static String repeat(char ch, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static void initialize() throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
    }

    private static void finalizeIO() throws IOException {
        out.flush();
        out.close();
        System.exit(0);
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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

        private int peek() {
            if (numChars == -1) return -1;
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
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
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readLine() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }
    }

    private interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}