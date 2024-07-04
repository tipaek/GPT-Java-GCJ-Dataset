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
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 27);
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
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);
            long l = in.readLong();
            long r = in.readLong();
            long delta = Math.abs(l - r);

            LongBinarySearch lbs = new LongBinarySearch() {

                public boolean check(long mid) {
                    return take(mid) > delta;
                }
            };
            long n = lbs.binarySearch(1, (long) 2e9) - 1;
            if (l > r) {
                l -= take(n);
            } else {
                r -= take(n);
            }

            while (l < r && r >= n + 1) {
                r -= n + 1;
                n++;
            }

            long round = n;
            long finalL = l;
            LongBinarySearch left = new LongBinarySearch() {

                public boolean check(long mid) {
                    return finalLeft(mid, round, finalL) < 0;
                }
            };

            long finalR = r;
            LongBinarySearch right = new LongBinarySearch() {

                public boolean check(long mid) {
                    return finalRight(mid, round, finalR) < 0;
                }
            };

            long lend = left.binarySearch(round, (long) 2e9) - 1;
            long rend = right.binarySearch(round, (long) 2e9) - 1;

            n = Math.min(lend, rend);
            l = finalLeft(n, round, finalL);
            r = finalRight(n, round, finalR);

            out.append(n).append(' ').append(l).append(' ').append(r).println();
        }

        public long finalLeft(long mid, long round, long l) {
            if (mid - round - 1 < 0) {
                return l;
            }
            long time = (mid - round - 1) / 2;
            long req = (time + 1) * (round + 1) + 2 * take(time);
            return l - req;
        }

        public long finalRight(long mid, long round, long r) {
            if (mid - round - 2 < 0) {
                return r;
            }
            long time = (mid - round - 2) / 2;
            long req = (time + 1) * (round + 2) + 2 * take(time);
            return r - req;
        }

        public long take(long n) {
            return (n + 1) * n / 2;
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(10 << 20);
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

        public FastOutput append(long c) {
            cache.append(c);
            return this;
        }

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
            return this;
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
        private StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private byte[] buf = new byte[1 << 13];
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

    static class DigitUtils {
        private DigitUtils() {
        }

        public static long average(long a, long b) {
            long ans = (a / 2) + (b / 2);
            switch ((int) (a % 2 + b % 2)) {
                case 2:
                    ans++;
                    break;
                case -1:
                case -2:
                    ans--;
                    break;
            }
            return ans;
        }

    }

    static abstract class LongBinarySearch {
        public abstract boolean check(long mid);

        public long binarySearch(long l, long r) {
            if (l > r) {
                throw new IllegalArgumentException();
            }
            while (l < r) {
                long mid = DigitUtils.average(l, r);
                if (check(mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

    }
}

