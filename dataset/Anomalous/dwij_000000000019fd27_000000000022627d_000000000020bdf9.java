import java.io.*;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int jmin = in.nextInt();
            int jmax = in.nextInt();
            int cmin = 24 * 60 + 1;
            int cmax = -1;
            boolean possible = true;
            StringBuilder result = new StringBuilder("J");

            for (int i = 1; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                boolean jFree = end <= jmin || start >= jmax;
                boolean cFree = end <= cmin || start >= cmax;

                if (jFree) {
                    result.append("J");
                    jmin = Math.min(jmin, start);
                    jmax = Math.max(jmax, end);
                } else if (cFree) {
                    result.append("C");
                    cmin = Math.min(cmin, start);
                    cmax = Math.max(cmax, end);
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                out.println("Case #" + testNumber + ": " + result.toString());
            } else {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

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
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
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

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void println(String str) {
            writer.println(str);
        }

        public void close() {
            writer.close();
        }
    }
}