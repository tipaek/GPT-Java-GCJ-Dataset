import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
            OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class OversizedPancakeChoppers {
        int[] primes = sieveEratosthenes(10000);

        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.append("Case #" + testNumber + ": ");
            int n = in.readInt();
            int d = in.readInt();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) ar[i] = in.readLong();
            int ans = d - 1;
            HashSet<Long> st = new HashSet<>();
            for (long l : ar) st.add(l);
            ExtGCD extGCD = new ExtGCD();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    st.add(extGCD.extgcd(ar[i], ar[j]));
                }
            }
            for (int i = 0; i < 300; i++) st.add((long) primes[i]);
            for (long val : st) {
                ArrayList<long[]> tl = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    if (ar[j] / val > 0) {
                        if (ar[j] % val == 0) {
                            tl.add(new long[]{ar[j] / val, -1});
                        } else {
                            tl.add(new long[]{ar[j] / val, 0});
                        }
                    }
                int[] dp = new int[d + 1];
                Arrays.fill(dp, Integer.MAX_VALUE / 2);
                dp[0] = 0;
                for (long[] temp : tl) {
                    for (int j = d; j >= 0; j--) {
                        for (int l = 1; l + j <= d && l <= temp[0]; l++) {
                            dp[j + l] = Math.min(dp[l + j], dp[j] + ((l)) + ((temp[1] == -1 && l == temp[0]) ? -1 : 0));
                        }
                    }
                }
                ans = Math.min(ans, dp[d]);
            }
            out.println(ans);
        }

        public int[] sieveEratosthenes(int n) {
            if (n <= 32) {
                int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
                for (int i = 0; i < primes.length; i++) {
                    if (n < primes[i]) {
                        return Arrays.copyOf(primes, i);
                    }
                }
                return primes;
            }

            int u = n + 32;
            double lu = Math.log(u);
            int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
            ret[0] = 2;
            int pos = 1;

            int[] isp = new int[(n + 1) / 32 / 2 + 1];
            int sup = (n + 1) / 32 / 2 + 1;

            int[] tprimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            for (int tp : tprimes) {
                ret[pos++] = tp;
                int[] ptn = new int[tp];
                for (int i = (tp - 3) / 2; i < tp << 5; i += tp)
                    ptn[i >> 5] |= 1 << (i & 31);
                for (int i = 0; i < tp; i++) {
                    for (int j = i; j < sup; j += tp)
                        isp[j] |= ptn[i];
                }
            }

            // 3,5,7
            // 2x+3=n
            int[] magic = {0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4,
                    13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17, 9, 6, 16, 5, 15, 14};
            int h = n / 2;
            for (int i = 0; i < sup; i++) {
                for (int j = ~isp[i]; j != 0; j &= j - 1) {
                    int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
                    int p = 2 * pp + 3;
                    if (p > n)
                        break;
                    ret[pos++] = p;
                    for (int q = pp; q <= h; q += p)
                        isp[q >> 5] |= 1 << (q & 31);
                }
            }

            return Arrays.copyOf(ret, pos);
        }

    }

    static class ExtGCD {
        private long x;
        private long y;
        private long g;

        public long extgcd(long a, long b) {
            if (a >= b) {
                g = extgcd0(a, b);
            } else {
                g = extgcd0(b, a);
                long tmp = x;
                x = y;
                y = tmp;
            }
            return g;
        }

        private long extgcd0(long a, long b) {
            if (b == 0) {
                x = 1;
                y = 0;
                return a;
            }
            long g = extgcd0(b, a % b);
            long n = x;
            long m = y;
            x = m;
            y = n - m * (a / b);
            return g;
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

        public FastOutput append(int c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(int c) {
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

