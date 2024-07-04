import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "khokharnikunj8", 1 << 27);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            Expogo solver = new Expogo();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class Expogo {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.append("Case #" + testNumber + ": ");
            int xx = in.readInt();
            int yy = in.readInt();
            long x = Math.abs(xx);
            long y = Math.abs(yy);
            if (isPossible(x, y)) {
                out.println(findAnswer(0, x, y, xx < 0, yy < 0));
            } else if (lowerset(x) > 0 && isPossible((x + 1) | 1, y)) {
                out.println((xx < 0 ? "E" : "W") + findAnswer(1, x + 1, y, xx < 0, yy < 0));
            } else if (lowerset(y) > 0 && isPossible(x, (y + 1) | 1)) {
                out.println((yy < 0 ? "N" : "S") + findAnswer(1, x, y + 1, xx < 0, yy < 0));
            } else {
                out.println("IMPOSSIBLE");
            }
        }

        public String findAnswer(int start, long x, long y, boolean xNeg, boolean yNeg) {
            StringBuilder out = new StringBuilder();
            for (int i = start; x > 0 || y > 0; i++) {
                if (Bits.bitAt(x, i) == 1) {
                    out.append(xNeg ? "W" : "E");
                } else {
                    out.append(yNeg ? "S" : "N");
                }
                x = Bits.setBit(x, i, false);
                y = Bits.setBit(y, i, false);
            }
            return out.toString();
        }

        public long lowerset(long temp) {
            long res = 0;
            for (int i = 0; i < 60; i++) {
                if (Bits.bitAt(temp, i) == 1) {
                    res = Bits.setBit(res, i, true);
                } else break;
            }
            return res;
        }

        public boolean isPossible(long x, long y) {
            for (int i = 0; x > 0 || y > 0; i++) {
                if (Bits.bitAt(x, i) == Bits.bitAt(y, i)) return false;
                x = Bits.setBit(x, i, false);
                y = Bits.setBit(y, i, false);
            }
            return true;
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(1 << 20);
        private final Writer os;

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(String c) {
            return append(c).println();
        }

        public FastOutput println() {
            cache.append(System.lineSeparator());
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
        }

    }

    static class Bits {
        private Bits() {
        }

        public static int bitAt(long x, int i) {
            return (int) ((x >>> i) & 1);
        }

        public static long setBit(long x, int i, boolean v) {
            if (v) {
                x |= 1L << i;
            } else {
                x &= ~(1L << i);
            }
            return x;
        }

    }

    static class FastInput {
        private final InputStream is;
        private StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private byte[] buf = new byte[1 << 20];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public String next() {
            return readString();
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

        public String readString(StringBuilder builder) {
            skipBlank();

            while (next > 32) {
                builder.append((char) next);
                next = read();
            }

            return builder.toString();
        }

        public String readString() {
            defaultStringBuf.setLength(0);
            return readString(defaultStringBuf);
        }

    }
}

