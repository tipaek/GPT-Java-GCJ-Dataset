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
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            Thermometers solver = new Thermometers();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
            out.close();
        }
    }

    static class Thermometers {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            if (!in.hasMore()) {
                throw new UnknownError();
            }
            out.printf("Case #%d: ", testNumber);
            int k = in.readInt();
            int n = in.readInt();
            int[] x = new int[n];
            int[] t = new int[n];
            in.populate(x);
            in.populate(t);

            if (Arrays.stream(t).distinct().count() == 1) {
                out.println(1);
                return;
            }

            Deque<Loop> dq = new ArrayDeque<>(n);
            for (int i = 0; i < n; i++) {
                Loop loop = new Loop();
                loop.l = x[i];
                loop.r = x[(i + 1) % n];
                loop.t = t[i];
                if (!dq.isEmpty() && dq.peekLast().t == loop.t) {
                    dq.peekLast().r = loop.r;
                } else {
                    dq.addLast(loop);
                }
            }

            dq.peekLast().r += k;
            Loop first = dq.removeFirst();
            Interval head = new Interval(first.l, first.r, null, false, true, false);
            Interval last = head;
            int ans = 1;

            for (Loop lp : dq) {
                int rl = mirror(last.l, lp.l);
                int rr = mirror(last.r, lp.l);
                int fixRl = Math.min(rl, lp.r);
                int fixRr = Math.max(rr, lp.l);
                if (fixRl <= fixRr) {
                    last = new Interval(lp.l, lp.r, null, false, true, false);
                    ans += 2;
                } else {
                    if (!last.rev) {
                        last.p.l += rl - fixRl;
                        last.p.r -= rr - fixRr;
                        if (fixRl == lp.r) {
                            last.p.encloseL = false;
                        }
                    } else {
                        last.p.r -= rl - fixRl;
                        last.p.l += rr - fixRr;
                    }
                    last = new Interval(fixRr, fixRl, last.p, !last.rev, true, true);
                    ans++;
                }
            }

            last.l -= k;
            last.r -= k;
            int rl = mirror(last.l, first.l);
            int rr = mirror(last.r, first.l);
            int fixRl = Math.min(rl, first.r);
            int fixRr = Math.max(rr, first.l);
            if (fixRl <= fixRr) {
                ans++;
            } else if (last.p == head) {
                if (!last.rev) {
                    if ((dist(last.l, first.l) > dist(first.l, head.l) || 
                         (dist(last.l, first.l) == dist(first.l, head.l) && head.encloseL)) &&
                         dist(last.r, first.l) < dist(first.l, head.r)) {
                        // Do nothing
                    } else {
                        ans++;
                    }
                } else {
                    if (dist(last.r, first.l) != dist(first.l, head.l)) {
                        ans++;
                    }
                }
            }

            out.println(ans);
        }

        private int dist(int l, int r) {
            return r - l;
        }

        private int mirror(int l, int center) {
            return 2 * center - l;
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

        public void populate(int[] data) {
            for (int i = 0; i < data.length; i++) {
                data[i] = readInt();
            }
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
            while (next >= '0' && next <= '9') {
                val = val * 10 + next - '0';
                next = read();
            }

            return sign * val;
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

        public boolean hasMore() {
            skipBlank();
            return next != -1;
        }
    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private final StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
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

    static class Loop {
        int l;
        int r;
        int t;
    }

    static class Interval {
        int l;
        int r;
        boolean encloseL;
        boolean encloseR;
        Interval p;
        boolean rev;

        public Interval(int l, int r, Interval p, boolean rev, boolean encloseL, boolean encloseR) {
            this.l = l;
            this.r = r;
            this.rev = rev;
            this.encloseL = encloseL;
            this.encloseR = encloseR;
            this.p = p != null ? p : this;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", l, r);
        }
    }
}