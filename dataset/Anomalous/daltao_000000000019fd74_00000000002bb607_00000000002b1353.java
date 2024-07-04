import java.io.*;
import java.util.*;

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
                PascalWalk solver = new PascalWalk();
                int testCount = in.readInt();
                for (int i = 1; i <= testCount; i++) {
                    solver.solve(i, in, out);
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    static class PascalWalk {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            out.printf("Case #%d:", testNumber).println();
            if (n <= 500) {
                for (int i = 0; i < n; i++) {
                    out.append(i + 1).append(' ').append(1).println();
                }
                return;
            }

            List<int[]> seq = new ArrayList<>(500);
            int m = n - 30;
            boolean right = false;
            for (int i = 0; i <= 29; i++) {
                if (Bits.bitAt(m, i) == 0) {
                    seq.add(new int[]{i, right ? i : 0});
                } else {
                    if (right) {
                        for (int j = i; j >= 0; j--) {
                            seq.add(new int[]{i, j});
                        }
                    } else {
                        for (int j = 0; j <= i; j++) {
                            seq.add(new int[]{i, j});
                        }
                    }
                    right = !right;
                }
            }

            for (int i = 1, until = Integer.bitCount(m); i <= until; i++) {
                seq.add(new int[]{29 + i, right ? 29 + i : 0});
            }

            for (int[] s : seq) {
                out.append(s[0] + 1).append(' ').append(s[1] + 1).println();
            }
        }
    }

    static class FastOutput implements AutoCloseable, Appendable {
        private final StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput(OutputStream os) {
            this.os = new OutputStreamWriter(os);
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

        public FastOutput append(int c) {
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

        public String readString() {
            defaultStringBuf.setLength(0);
            skipBlank();
            while (next > 32) {
                defaultStringBuf.append((char) next);
                next = read();
            }
            return defaultStringBuf.toString();
        }

        @Override
        public void close() throws IOException {
            is.close();
        }
    }

    static class Bits {
        private Bits() {
        }

        public static int bitAt(int x, int i) {
            return (x >>> i) & 1;
        }
    }
}