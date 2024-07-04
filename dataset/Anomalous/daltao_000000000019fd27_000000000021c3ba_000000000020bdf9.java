import java.io.*;
import java.util.Arrays;

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
            ParentingPartneringReturns solver = new ParentingPartneringReturns();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
            out.close();
        }
    }

    static class ParentingPartneringReturns {
        Debug debug = new Debug(false);

        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.readInt();
            int[][] times = new int[n][2];
            for (int i = 0; i < n; i++) {
                times[i][0] = in.readInt();
                times[i][1] = in.readInt();
            }
            TwoSatBeta ts = new TwoSatBeta(n, n * n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (collide(times[i], times[j])) {
                        ts.xor(i, j);
                        debug.debug("i", i);
                        debug.debug("j", j);
                    }
                }
            }
            if (!ts.solve(true)) {
                out.println("IMPOSSIBLE");
                return;
            }

            for (int i = 0; i < n; i++) {
                out.append(ts.valueOf(i) ? 'C' : 'J');
            }
            out.println();
        }

        private boolean collide(int[] a, int[] b) {
            if (a[0] > b[0]) {
                int[] tmp = a;
                a = b;
                b = tmp;
            }
            return a[1] > b[0];
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
                out.printf("%s=%s%n", name, x);
            }
            return this;
        }
    }

    static class IntegerMultiWayStack {
        private int[] values;
        private int[] next;
        private int[] heads;
        private int alloc;
        private int stackNum;

        public IntegerMultiWayStack(int qNum, int totalCapacity) {
            values = new int[totalCapacity + 1];
            next = new int[totalCapacity + 1];
            heads = new int[qNum];
            stackNum = qNum;
        }

        public IntegerIterator iterator(final int queue) {
            return new IntegerIterator() {
                int ele = heads[queue];

                public boolean hasNext() {
                    return ele != 0;
                }

                public int next() {
                    int ans = values[ele];
                    ele = next[ele];
                    return ans;
                }
            };
        }

        private void doubleCapacity() {
            int newSize = Math.max(next.length + 10, next.length * 2);
            next = Arrays.copyOf(next, newSize);
            values = Arrays.copyOf(values, newSize);
        }

        private void alloc() {
            alloc++;
            if (alloc >= next.length) {
                doubleCapacity();
            }
            next[alloc] = 0;
        }

        public void addLast(int qId, int x) {
            alloc();
            values[alloc] = x;
            next[alloc] = heads[qId];
            heads[qId] = alloc;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < stackNum; i++) {
                builder.append(i).append(": ");
                for (IntegerIterator iterator = iterator(i); iterator.hasNext(); ) {
                    builder.append(iterator.next()).append(",");
                }
                if (builder.charAt(builder.length() - 1) == ',') {
                    builder.setLength(builder.length() - 1);
                }
                builder.append('\n');
            }
            return builder.toString();
        }
    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

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

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
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

    interface IntegerDeque extends IntegerStack {
    }

    interface IntegerStack {
    }

    static class TwoSatBeta {
        private IntegerMultiWayStack edges;
        private boolean[] values;
        private int[] sets;
        private int[] dfns;
        private int[] lows;
        private boolean[] instk;
        private IntegerDequeImpl deque;
        private int n;
        private int dfn = 0;

        public TwoSatBeta(int n, int m) {
            values = new boolean[n * 2];
            sets = new int[n * 2];
            edges = new IntegerMultiWayStack(n * 2, m * 2);
            dfns = new int[n * 2];
            lows = new int[n * 2];
            instk = new boolean[n * 2];
            deque = new IntegerDequeImpl(n * 2);
            this.n = n;
        }

        public boolean valueOf(int x) {
            return values[sets[elementId(x)]];
        }

        public boolean solve(boolean fetchValue) {
            Arrays.fill(values, false);
            Arrays.fill(dfns, 0);
            deque.clear();
            dfn = 0;

            for (int i = 0; i < sets.length; i++) {
                tarjan(i);
            }
            for (int i = 0; i < n; i++) {
                if (sets[elementId(i)] == sets[negateElementId(i)]) {
                    return false;
                }
            }

            if (!fetchValue) {
                return true;
            }

            Arrays.fill(dfns, 0);
            for (int i = 0; i < sets.length; i++) {
                assign(i);
            }
            return true;
        }

        private void assign(int root) {
            if (dfns[root] > 0) {
                return;
            }
            dfns[root] = 1;
            for (IntegerIterator iterator = edges.iterator(root); iterator.hasNext(); ) {
                int node = iterator.next();
                assign(node);
            }
            if (sets[root] == root) {
                values[root] = !values[sets[negate(root)]];
            }
        }

        private void tarjan(int root) {
            if (dfns[root] > 0) {
                return;
            }
            lows[root] = dfns[root] = ++dfn;
            instk[root] = true;
            deque.addLast(root);
            for (IntegerIterator iterator = edges.iterator(root); iterator.hasNext(); ) {
                int node = iterator.next();
                tarjan(node);
                if (instk[node] && lows[node] < lows[root]) {
                    lows[root] = lows[node];
                }
            }
            if (lows[root] == dfns[root]) {
                int last;
                do {
                    last = deque.removeLast();
                    sets[last] = root;
                    instk[last] = false;
                } while (last != root);
            }
        }

        public int elementId(int x) {
            return x << 1;
        }

        public int negateElementId(int x) {
            return (x << 1) | 1;
        }

        private int negate(int x) {
            return x ^ 1;
        }

        public void same(int a, int b) {
            edges.addLast(a, b);
            edges.addLast(b, a);
        }

        public void xor(int a, int b) {
            same(a, negate(b));
        }
    }

    static class IntegerDequeImpl implements IntegerDeque {
        private int[] data;
        private int bpos;
        private int epos;
        private static final int[] EMPTY = new int[0];
        private int n;

        public IntegerDequeImpl(int cap) {
            data = (cap == 0) ? EMPTY : new int[cap];
            bpos = 0;
            epos = 0;
            n = cap;
        }

        private void expandSpace(int len) {
            while (n < len) {
                n = Math.max(n + 10, n * 2);
            }
            int[] newData = new int[n];
            if (bpos <= epos) {
                if (bpos < epos) {
                    System.arraycopy(data, bpos, newData, 0, epos - bpos);
                }
            } else {
                System.arraycopy(data, bpos, newData, 0, data.length - bpos);
                System.arraycopy(data, 0, newData, data.length - bpos, epos);
            }
            epos = size();
            bpos = 0;
            data = newData;
        }

        public IntegerIterator iterator() {
            return new IntegerIterator() {
                int index = bpos;

                public boolean hasNext() {
                    return index != epos;
                }

                public int next() {
                    int ans = data[index];
                    index = IntegerDequeImpl.this.next(index);
                    return ans;
                }
            };
        }

        public int removeLast() {
            int ans = data[last(epos)];
            epos = last(epos);
            return ans;
        }

        public void addLast(int x) {
            ensureMore();
            data[epos] = x;
            epos = next(epos);
        }

        public void clear() {
            bpos = epos = 0;
        }

        private int last(int x) {
            return (x == 0 ? n : x) - 1;
        }

        private int next(int x) {
            return x + 1 >= n ? 0 : x + 1;
        }

        private void ensureMore() {
            if (next(epos) == bpos) {
                expandSpace(n + 1);
            }
        }

        public int size() {
            int ans = epos - bpos;
            if (ans < 0) {
                ans += data.length;
            }
            return ans;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (IntegerIterator iterator = iterator(); iterator.hasNext(); ) {
                builder.append(iterator.next()).append(' ');
            }
            return builder.toString();
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

    interface IntegerIterator {
        boolean hasNext();
        int next();
    }
}