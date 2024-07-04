import java.io.*;

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
            try (FastInput in = new FastInput(System.in);
                 FastOutput out = new FastOutput(System.out)) {
                NestingDepth solver = new NestingDepth();
                int testCount = Integer.parseInt(in.next());
                for (int i = 1; i <= testCount; i++) {
                    solver.solve(i, in, out);
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    static class NestingDepth {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);
            char[] s = in.readString().toCharArray();
            add(out, '(', s[0] - '0');
            out.append(s[0]);
            for (int i = 1; i < s.length; i++) {
                if (s[i] >= s[i - 1]) {
                    add(out, '(', s[i] - s[i - 1]);
                } else {
                    add(out, ')', s[i - 1] - s[i]);
                }
                out.append(s[i]);
            }
            add(out, ')', s[s.length - 1] - '0');
            out.println();
        }

        private void add(FastOutput out, char c, int n) {
            for (int i = 0; i < n; i++) {
                out.append(c);
            }
        }
    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
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

        @Override
        public void close() throws IOException {
            flush();
            os.close();
        }

        @Override
        public String toString() {
            return cache.toString();
        }
    }

    static class FastInput implements Closeable {
        private final InputStream is;
        private final StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private final byte[] buf = new byte[1 << 20];
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

        private void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public String next() {
            return readString();
        }

        public String readString() {
            defaultStringBuf.setLength(0);
            return readString(defaultStringBuf);
        }

        private String readString(StringBuilder builder) {
            skipBlank();
            while (next > 32) {
                builder.append((char) next);
                next = read();
            }
            return builder.toString();
        }

        @Override
        public void close() throws IOException {
            is.close();
        }
    }
}