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
            IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class IncrementalHouseOfPancakes {
        public double findItt(double first, double n) {
            return (n * (n + 1l)) / 2 + ((n * (first - 1)));
        }

        public long findIt(long first, long n) {
            if (findItt(first, n) > 1e18) return Long.MAX_VALUE / 2;
            return (n * (n + 1l)) / 2 + ((n * (first - 1)));
        }

        public double findIt11(double first, double n) {
            return (n * (2 * first + (n - 1) * 2)) / 2;
        }

        public long findIt1(long first, long n) {
            if (findIt11(first, n) > 1e18) return Long.MAX_VALUE / 2;
            return (n * (2 * first + (n - 1) * 2)) / 2;
        }

        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.append("Case #" + testNumber + ": ");
            long l = in.readLong();
            long r = in.readLong();
            long index = -1;
            {
                long low = 0;
                long high = 1000000000;
                while (low <= high) {
                    long mid = (low + high) >> 1l;
                    if (r - (mid * (mid + 1l)) / 2 <= l) {
                        index = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            long ans = index;
            r -= (index * (index + 1l)) / 2;
            long index1 = -1;
            {
                long low = 0;
                long high = 1000000000;
                while (low <= high) {
                    long mid = (low + high) >> 1;
                    if (l - findIt(index + 1, mid) >= r) {
                        index1 = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            l -= findIt(index + 1, index1);
            ans += index1;
            long index2 = -1;
            {
                long low = 0;
                long high = 2 * 1000000000l;
                while (low <= high) {
                    long mid = (low + high) >> 1;
                    if (findIt1(ans + 2, mid / 2) <= r) {
                        index2 = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            if (findIt1(ans + 1, (index2) / 2 + 1) <= l) {
                l -= findIt1(ans + 1, (index2) / 2 + 1);
                r -= findIt1(ans + 2, (index2) / 2);
                ans++;
            } else {
                l -= findIt1(ans + 1, (index2 / 2));
                r -= findIt1(ans + 2, index2 / 2);
            }
            out.println((ans + (index2 / 2) * 2) + " " + l + " " + r);

        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private final Writer os;
        private final StringBuilder cache = new StringBuilder(1 << 20);

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
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

    static class FastInput {
        private final InputStream is;
        private final StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private final byte[] buf = new byte[1 << 13];
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

        public long readLong() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            long val = 0;
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

