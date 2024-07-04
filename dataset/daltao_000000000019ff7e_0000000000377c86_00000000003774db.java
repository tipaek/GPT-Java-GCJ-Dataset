import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
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
            NamingCompromise solver = new NamingCompromise();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class NamingCompromise {
        char[] a;
        char[] b;
        int[][] dp;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            if (!in.hasMore()) {
                throw new UnknownError();
            }
            out.printf("Case #%d: ", testNumber);
            String a = in.readString();
            String b = in.readString();
            int dist = editDistance(a, b);
            StringBuilder ans = new StringBuilder(a.length() + b.length());
            backtrace(a.length() - 1, b.length() - 1, ans, dist / 2);
            ans.reverse();
            out.println(ans);

//        debug.debug("dist", dist);
//        debug.debug("ans->a", editDistance(a, ans.toString()));
//        debug.debug("ans->b", editDistance(b, ans.toString()));
        }

        public void backtrace(int i, int j, StringBuilder builder, int more) {
            if (more == 0) {
                for (int k = i; k >= 0; k--) {
                    builder.append(a[k]);
                }
                return;
            }
            if (dp(i, j) == dp(i, j - 1) + 1) {
                builder.append(b[j]);
                backtrace(i, j - 1, builder, more - 1);
                return;
            }
            if (dp(i, j) == dp(i - 1, j) + 1) {
                //builder.append(a[i]);
                backtrace(i - 1, j, builder, more - 1);
                return;
            }
            if (dp(i, j) == dp(i - 1, j - 1) + 1) {
                builder.append(b[j]);
                backtrace(i - 1, j - 1, builder, more - 1);
                return;
            }
            builder.append(a[i]);
            backtrace(i - 1, j - 1, builder, more);
        }

        public int editDistance(String a, String b) {
            this.a = a.toCharArray();
            this.b = b.toCharArray();
            dp = new int[this.a.length][this.b.length];
            SequenceUtils.deepFill(dp, -1);
            return dp(a.length() - 1, b.length() - 1);
        }

        public int dp(int i, int j) {
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

    }

    static class SequenceUtils {
        public static void deepFill(Object array, int val) {
            if (!array.getClass().isArray()) {
                throw new IllegalArgumentException();
            }
            if (array instanceof int[]) {
                int[] intArray = (int[]) array;
                Arrays.fill(intArray, val);
            } else {
                Object[] objArray = (Object[]) array;
                for (Object obj : objArray) {
                    deepFill(obj, val);
                }
            }
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

        public FastOutput append(Object c) {
            cache.append(c);
            return this;
        }

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
            return this;
        }

        public FastOutput println(Object c) {
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
}

