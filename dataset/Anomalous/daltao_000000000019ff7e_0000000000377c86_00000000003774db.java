import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskRunner(), "", 1 << 27);
        thread.start();
        thread.join();
    }

    static class TaskRunner implements Runnable {
        @Override
        public void run() {
            try (FastInput in = new FastInput(System.in);
                 FastOutput out = new FastOutput(System.out)) {
                NamingCompromise solver = new NamingCompromise();
                int testCount = Integer.parseInt(in.next());
                for (int i = 1; i <= testCount; i++) {
                    solver.solve(i, in, out);
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    static class NamingCompromise {
        private char[] a;
        private char[] b;
        private int[][] dp;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            if (!in.hasMore()) {
                throw new UnknownError();
            }
            out.printf("Case #%d: ", testNumber);
            String aStr = in.readString();
            String bStr = in.readString();
            int dist = editDistance(aStr, bStr);
            StringBuilder result = new StringBuilder(aStr.length() + bStr.length());
            backtrace(aStr.length() - 1, bStr.length() - 1, result, dist / 2);
            result.reverse();
            out.println(result);
        }

        private void backtrace(int i, int j, StringBuilder builder, int remainingEdits) {
            if (remainingEdits == 0) {
                for (int k = i; k >= 0; k--) {
                    builder.append(a[k]);
                }
                return;
            }
            if (dp(i, j) == dp(i, j - 1) + 1) {
                builder.append(b[j]);
                backtrace(i, j - 1, builder, remainingEdits - 1);
            } else if (dp(i, j) == dp(i - 1, j) + 1) {
                backtrace(i - 1, j, builder, remainingEdits - 1);
            } else if (dp(i, j) == dp(i - 1, j - 1) + 1) {
                builder.append(b[j]);
                backtrace(i - 1, j - 1, builder, remainingEdits - 1);
            } else {
                builder.append(a[i]);
                backtrace(i - 1, j - 1, builder, remainingEdits);
            }
        }

        private int editDistance(String aStr, String bStr) {
            this.a = aStr.toCharArray();
            this.b = bStr.toCharArray();
            dp = new int[a.length][b.length];
            SequenceUtils.deepFill(dp, -1);
            return dp(a.length - 1, b.length - 1);
        }

        private int dp(int i, int j) {
            if (i < 0 || j < 0) {
                return Math.max(i, j) + 1;
            }
            if (dp[i][j] == -1) {
                dp[i][j] = Math.min(dp(i, j - 1) + 1, dp(i - 1, j) + 1);
                dp[i][j] = Math.min(dp[i][j], dp(i - 1, j - 1) + 1);
                if (a[i] == b[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp(i - 1, j - 1));
                }
            }
            return dp[i][j];
        }
    }

    static class FastInput implements Closeable {
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

        public boolean hasMore() {
            skipBlank();
            return next != -1;
        }

        @Override
        public void close() throws IOException {
            is.close();
        }
    }

    static class SequenceUtils {
        public static void deepFill(Object array, int val) {
            if (!array.getClass().isArray()) {
                throw new IllegalArgumentException();
            }
            if (array instanceof int[]) {
                Arrays.fill((int[]) array, val);
            } else {
                for (Object obj : (Object[]) array) {
                    deepFill(obj, val);
                }
            }
        }
    }

    static class FastOutput implements AutoCloseable, Appendable {
        private final StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        @Override
        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        @Override
        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        @Override
        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(Object obj) {
            cache.append(obj);
            return this;
        }

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
            return this;
        }

        public FastOutput println(Object obj) {
            return append(obj).println();
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

        @Override
        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        @Override
        public String toString() {
            return cache.toString();
        }
    }
}