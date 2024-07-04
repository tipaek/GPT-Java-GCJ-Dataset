import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
            ESAbATAd solver = new ESAbATAd();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class ESAbATAd {
        Debug debug = new Debug(true);
        FastInput in;
        FastOutput out;
        int[] vals;
        boolean[] know;
        int cnt;
        int differ;
        int same;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int t = in.readInt();
            int n = in.readInt();
            this.in = in;
            this.out = out;
            while (t-- > 0) {
                debug.debug("t", t);
                solve(n);
                out.flush();
                if (in.readChar() != 'Y') {
                    throw new RuntimeException();
                }
            }
        }

        public int ask(int x) {
            out.println(x + 1);
            out.flush();
            cnt++;
            return in.readInt();
        }

        public void prepare() {
            if (cnt % 10 == 0) {
                int sameVal = same != -1 ? vals[same] : -1;
                int differVal = differ != -1 ? vals[differ] : -1;

                if (same != -1) {
                    if (sameVal != ask(same)) {
                        for (int i = 0; i < vals.length; i++) {
                            vals[i] = 1 - vals[i];
                        }
                        differVal = 1 - differVal;
                    }
                }
                if (differ != -1) {
                    if (differVal != ask(differ)) {
                        for (int i = 0; i < vals.length; i++) {
                            int j = mirror(i, vals.length);
                            if (j <= i) {
                                continue;
                            }
                            SequenceUtils.swap(vals, i, j);
                            SequenceUtils.swap(know, i, j);
                        }
                    }
                }
            }
        }

        public int mirror(int i, int n) {
            return n - 1 - i;
        }

        public void solve(int n) {
            vals = new int[n];
            know = new boolean[n];
            cnt = 0;
            differ = -1;
            same = -1;
            while (true) {
                prepare();
                int first = -1;
                int last = -1;
                for (int j = 0; j < n; j++) {
                    if (first == -1 && !know[j]) {
                        first = j;
                    }
                    if (!know[j]) {
                        last = j;
                    }
                }

                if (first == -1) {
                    break;
                }

                int index = first <= (n - 1 - last) ? first : last;
                vals[index] = ask(index);
                know[index] = true;
                int mi = mirror(index, n);
                if (know[mi]) {
                    if (vals[index] == vals[mi]) {
                        same = index;
                    } else {
                        differ = index;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                out.append(vals[i]);
            }
            out.println();
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

        public FastOutput append(int c) {
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

    static class SequenceUtils {
        public static <T> void swap(boolean[] data, int i, int j) {
            boolean tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        public static void swap(int[] data, int i, int j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

    }

    static class Debug {
        private boolean offline;
        private PrintStream out = System.err;

        public Debug(boolean enable) {
            offline = enable && System.getSecurityManager() == null;
        }

        public Debug debug(String name, int x) {
            if (offline) {
                debug(name, "" + x);
            }
            return this;
        }

        public Debug debug(String name, String x) {
            if (offline) {
                out.printf("%s=%s", name, x);
                out.println();
            }
            return this;
        }

    }

    static class FastInput {
        private final InputStream is;
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

        public char readChar() {
            skipBlank();
            char c = (char) next;
            next = read();
            return c;
        }

    }
}

