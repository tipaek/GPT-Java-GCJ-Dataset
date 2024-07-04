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
            int cmin = Integer.MAX_VALUE;
            int cmax = Integer.MIN_VALUE;
            boolean possible = true;
            StringBuilder schedule = new StringBuilder("J");

            for (int i = 1; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                boolean canJ = end <= jmin || start >= jmax;
                boolean canC = end <= cmin || start >= cmax;

                if (canJ) {
                    schedule.append("J");
                    jmin = Math.min(jmin, start);
                    jmax = Math.max(jmax, end);
                } else if (canC) {
                    schedule.append("C");
                    cmin = Math.min(cmin, start);
                    cmax = Math.max(cmax, end);
                } else {
                    if (possible) {
                        out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                    }
                    possible = false;
                }
            }

            if (possible) {
                out.println(String.format("Case #%d: %s", testNumber, schedule.toString()));
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
            return c < 33 || c > 126;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i > 0) {
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