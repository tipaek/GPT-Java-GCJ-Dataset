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
            int jMin = in.nextInt();
            int jMax = in.nextInt();
            int cMin = Integer.MAX_VALUE;
            int cMax = Integer.MIN_VALUE;
            boolean possible = true;
            StringBuilder result = new StringBuilder();
            result.append("J");

            for (int i = 1; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                boolean overlapsJ = (jMin < end && jMin >= start) || (jMax > start && jMax <= end) || (jMin <= start && jMax >= end);
                boolean overlapsC = (cMin < end && cMin >= start) || (cMax > start && cMax <= end) || (cMin <= start && cMax >= end);

                if (!overlapsJ) {
                    result.append("J");
                    jMin = Math.min(jMin, start);
                    jMax = Math.max(jMax, end);
                } else if (!overlapsC) {
                    result.append("C");
                    cMin = Math.min(cMin, start);
                    cMax = Math.max(cMax, end);
                } else {
                    out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                    possible = false;
                    break;
                }
            }

            if (possible) {
                out.println(String.format("Case #%d: %s", testNumber, result.toString()));
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

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

        public boolean isSpaceChar(int c) {
            return c <= 32;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}