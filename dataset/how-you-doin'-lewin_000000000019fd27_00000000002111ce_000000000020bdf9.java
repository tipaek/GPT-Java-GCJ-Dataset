import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author lewin
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            ParentingPartneringReturns.Item[] its = new ParentingPartneringReturns.Item[n];
            for (int i = 0; i < n; i++) {
                its[i] = new ParentingPartneringReturns.Item(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(its, Comparator.comparingInt(x -> x.end));
            int end1 = -1, end2 = -1;
            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                if (end1 >= end2) {
                    if (its[i].start >= end1) {
                        end1 = its[i].end;
                        res[its[i].idx] = 'C';
                    } else if (its[i].start >= end2) {
                        end2 = its[i].end;
                        res[its[i].idx] = 'J';
                    } else {
                        out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
                        return;
                    }

                } else {
                    if (its[i].start >= end2) {
                        end2 = its[i].end;
                        res[its[i].idx] = 'J';
                    } else if (its[i].start >= end1) {
                        end1 = its[i].end;
                        res[its[i].idx] = 'C';
                    } else {
                        out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
                        return;
                    }
                }
            }
            out.printf("Case #%d: %s\n", testNumber, new String(res, 0, n));
        }

        static class Item {
            public int start;
            public int end;
            public int idx;

            public Item(int start, int end, int idx) {
                this.start = start;
                this.end = end;
                this.idx = idx;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }
}

