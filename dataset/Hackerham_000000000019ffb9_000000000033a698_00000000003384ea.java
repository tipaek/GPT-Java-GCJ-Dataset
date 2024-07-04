import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public long fit(long i, long L, int inc) {
            long kl = 0;
            long kr = L / i + 1;
            while (kl + 1 < kr) {
                long mid = (kl + kr) / 2;
                if (mid * (2 * i + (mid - 1) * inc) <= 2 * L) {
                    kl = mid;
                } else {
                    kr = mid;
                }
            }

            return kl;
        }

        long sum(long i, long k, int inc) {
            return k * (2 * i + (k - 1) * inc) / 2;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            long L = in.readLong(), R = in.readLong();

            int changed = 0;

            if (L < R) {
                changed++;
                long t = L;
                L = R;
                R = t;
            }

            long i = 1;
            long f1 = fit(i, L - R - changed, 1);
            L -= sum(i, f1, 1);
            i += f1;

            long f2 = fit(i, L, 2);
            long f3 = fit(i + 1, R, 2);
            if (f2 > f3 + 1) {
                f2 = f3 + 1;
            }
            if (f3 > f2) {
                f3 = f2;
            }

            L -= sum(i, f2, 2);
            R -= sum(i + 1, f3, 2);
            i += f2 + f3;
            i--;

            if (changed % 2 == 1) {
                long t = L;
                L = R;
                R = t;
            }

            out.print("Case #" + testNumber + ": ");
            out.printLine(i + " " + L + " " + R);
        }

    }

    static class OutputWriter {
        public final Writer out;

        public OutputWriter(OutputStream outputStream) {
            this.out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        }

        public OutputWriter(Writer writer) {
            this.out = writer;
        }

        public void print(Object... objects) {
            try {
                for (int i = 0; i < objects.length; ++i) {
                    if (i != 0) {
                        this.out.write(32);
                    }

                    this.out.write(objects[i].toString());
                }

            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void printLine(Object... objects) {
            this.print(objects);

            try {
                this.out.write(10);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void close() {
            try {
                this.out.close();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }

    }

    static class InputReader extends InputStream {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public String next() {
            return this.readToken();
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

        public long readLong() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
            }

            int sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            long res = 0L;

            while (c >= 48 && c <= 57) {
                res *= 10L;
                res += (long) (c - 48);
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * (long) sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String readToken() {
            int c;
            while (isSpaceChar(c = this.read())) {
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
}

