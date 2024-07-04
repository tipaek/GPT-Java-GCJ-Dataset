import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Sparsh Sanchorawala
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int n = s.nextInt();
            Time[] time = new Time[2 * n];
            for (int i = 0; i < n; i++) {
                time[2 * i] = new Time(i, 1, s.nextInt());
                time[2 * i + 1] = new Time(i, -1, s.nextInt());
            }
            Arrays.sort(time, new Comparator<Time>() {

                public int compare(Time o1, Time o2) {
                    if (o1.time < o2.time)
                        return -1;
                    if (o1.time > o2.time)
                        return 1;
                    if (o1.d < o2.d)
                        return -1;
                    if (o1.d > o2.d)
                        return 1;
                    return 0;
                }
            });
            boolean pos = true;
            int[] free = new int[2];
            int[] res = new int[n];
            for (Time t : time) {
                if (t.d == 1) {
                    if (free[0] == 1 && free[1] == 1) {
                        pos = false;
                        break;
                    }
                    if (free[0] == 0) {
                        res[t.i] = 0;
                        free[0] = 1;
                    } else {
                        res[t.i] = 1;
                        free[1] = 1;
                    }
                } else {
                    free[res[t.i]] = 0;
                }
            }
            w.print("Case #" + testNumber + ": ");
            if (pos) {
                for (int i = 0; i < n; i++) {
                    if (res[i] == 0)
                        w.print("C");
                    else
                        w.print("J");
                }
                w.println();
            } else
                w.println("IMPOSSIBLE");

        }

        class Time {
            int i;
            int d;
            int time;

            Time(int i, int d, int time) {
                this.i = i;
                this.d = d;
                this.time = time;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

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

        public int nextInt() {
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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

