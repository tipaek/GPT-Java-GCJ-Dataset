import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, OutputWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                int[][] activities = new int[n][2];
                for (int j = 0; j < n; j++) {
                    activities[j][0] = in.nextInt();
                    activities[j][1] = in.nextInt();
                }

                Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

                StringBuilder result = new StringBuilder();
                int cEnd = 0, jEnd = 0;
                boolean impossible = false;

                for (int[] activity : activities) {
                    int start = activity[0];
                    int end = activity[1];
                    if (start >= cEnd) {
                        cEnd = end;
                        result.append('C');
                    } else if (start >= jEnd) {
                        jEnd = end;
                        result.append('J');
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }

                out.printf("Case #%d: %s\n", i, result.toString());
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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
            result.appendCodePoint(c);
            while (!isSpaceChar(c = read())) {
                result.appendCodePoint(c);
            }
            return result.toString();
        }

        private static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void printf(String format, Object... args) {
            writer.printf(format, args);
        }

        public void close() {
            writer.close();
        }
    }
}