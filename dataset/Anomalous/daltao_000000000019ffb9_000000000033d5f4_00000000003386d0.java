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
            FastInput in = new FastInput(System.in);
            FastOutput out = new FastOutput(System.out);
            WormholeInOne solver = new WormholeInOne();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
            out.close();
        }
    }

    static class WormholeInOne {
        DSU[] dsus = new DSU[10000];

        {
            for (int i = 0; i < 10000; i++) {
                dsus[i] = new DSU(100);
            }
        }

        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);

            int n = in.readInt();
            int[][] pts = new int[n][2];
            for (int i = 0; i < n; i++) {
                pts[i][0] = in.readInt();
                pts[i][1] = in.readInt();
            }

            LongHashMap map = new LongHashMap(n * n, false);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long key = dir(pts[i], pts[j]);
                    int index = (int) map.getOrDefault(key, -1);
                    if (index == -1) {
                        index = map.size();
                        dsus[index].reset();
                        map.put(key, index);
                    }
                    dsus[index].merge(i, j);
                }
            }

            int m = map.size();
            int ans = Math.min(2, n);
            for (int i = 0; i < m; i++) {
                int t1 = 0;
                int oneCnt = 0;
                for (int j = 0; j < n; j++) {
                    if (dsus[i].find(j) != j) {
                        continue;
                    }
                    int size = dsus[i].size[j];
                    if (size == 1) {
                        oneCnt++;
                    } else {
                        t1 += size;
                    }
                }
                t1 += Math.min(oneCnt, 2);
                ans = Math.max(ans, t1);
            }

            out.println(ans);
        }

        public long dir(int[] a, int[] b) {
            int dx = a[0] - b[0];
            int dy = a[1] - b[1];
            if (dy < 0) {
                dy = -dy;
                dx = -dx;
            }
            if (dx < 0 && dy == 0) {
                dx = -dx;
            }
            int g = GCDs.gcd(Math.abs(dx), Math.abs(dy));
            dx /= g;
            dy /= g;
            return DigitUtils.asLong(dx, dy);
        }
    }

    static class DSU {
        protected int[] p;
        protected int[] rank;
        int[] size;

        public DSU(int n) {
            p = new int[n];
            rank = new int[n];
            size = new int[n];
            reset();
        }

        public final void reset() {
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        public final int find(int a) {
            if (p[a] == p[p[a]]) {
                return p[a];
            }
            return p[a] = find(p[a]);
        }

        public final void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return;
            }
            if (rank[a] == rank[b]) {
                rank[a]++;
            }

            if (rank[a] < rank[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            size[a] += size[b];
            p[b] = a;
        }
    }

    static class DigitUtils {
        private static final long LONG_TO_INT_MASK = (1L << 32) - 1;

        private DigitUtils() {
        }

        public static long asLong(int high, int low) {
            return (((long) high) << 32) | (((long) low) & LONG_TO_INT_MASK);
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
            return readString(defaultStringBuf);
        }

        public String readString(StringBuilder builder) {
            skipBlank();

            while (next > 32) {
                builder.append((char) next);
                next = read();
            }

            return builder.toString();
        }
    }

    static class GCDs {
        private GCDs() {
        }

        public static int gcd(int a, int b) {
            return a >= b ? gcd0(a, b) : gcd0(b, a);
        }

        private static int gcd0(int a, int b) {
            return b == 0 ? a : gcd0(b, a % b);
        }
    }

    static class LongHashMap {
        private int[] slot;
        private int[] next;
        private long[] keys;
        private long[] values;
        private int alloc;
        private boolean[] removed;
        private int mask;
        private int size;
        private final boolean rehash;
        private final Hasher hasher = new Hasher();

        public LongHashMap(int cap, boolean rehash) {
            this.mask = (1 << (32 - Integer.numberOfLeadingZeros(cap - 1))) - 1;
            slot = new int[mask + 1];
            next = new int[cap + 1];
            keys = new long[cap + 1];
            values = new long[cap + 1];
            removed = new boolean[cap + 1];
            this.rehash = rehash;
        }

        private void doubleCapacity() {
            int newSize = Math.max(next.length + 10, next.length * 2);
            next = Arrays.copyOf(next, newSize);
            keys = Arrays.copyOf(keys, newSize);
            values = Arrays.copyOf(values, newSize);
            removed = Arrays.copyOf(removed, newSize);
        }

        public void alloc() {
            alloc++;
            if (alloc >= next.length) {
                doubleCapacity();
            }
            next[alloc] = 0;
            removed[alloc] = false;
            size++;
        }

        public void put(long x, long y) {
            put(x, y, true);
        }

        public void put(long x, long y, boolean cover) {
            int h = hasher.hash(x);
            int s = h & mask;
            if (slot[s] == 0) {
                alloc();
                slot[s] = alloc;
                keys[alloc] = x;
                values[alloc] = y;
            } else {
                int index = findIndexOrLastEntry(s, x);
                if (keys[index] != x) {
                    alloc();
                    next[index] = alloc;
                    keys[alloc] = x;
                    values[alloc] = y;
                } else if (cover) {
                    values[index] = y;
                }
            }
            if (rehash && size >= slot.length) {
                rehash();
            }
        }

        public long getOrDefault(long x, long def) {
            int h = hasher.hash(x);
            int s = h & mask;
            if (slot[s] == 0) {
                return def;
            }
            int index = findIndexOrLastEntry(s, x);
            return keys[index] == x ? values[index] : def;
        }

        private int findIndexOrLastEntry(int s, long x) {
            int iter = slot[s];
            while (keys[iter] != x) {
                if (next[iter] != 0) {
                    iter = next[iter];
                } else {
                    return iter;
                }
            }
            return iter;
        }

        public LongEntryIterator iterator() {
            return new LongEntryIterator() {
                int index = 1;
                int readIndex = -1;

                public boolean hasNext() {
                    while (index <= alloc && removed[index]) {
                        index++;
                    }
                    return index <= alloc;
                }

                public long getEntryKey() {
                    return keys[readIndex];
                }

                public long getEntryValue() {
                    return values[readIndex];
                }

                public void next() {
                    if (!hasNext()) {
                        throw new IllegalStateException();
                    }
                    readIndex = index;
                    index++;
                }
            };
        }

        public int size() {
            return size;
        }

        public String toString() {
            LongEntryIterator iterator = iterator();
            StringBuilder builder = new StringBuilder("{");
            while (iterator.hasNext()) {
                iterator.next();
                builder.append(iterator.getEntryKey()).append("->").append(iterator.getEntryValue()).append(',');
            }
            if (builder.charAt(builder.length() - 1) == ',') {
                builder.setLength(builder.length() - 1);
            }
            builder.append('}');
            return builder.toString();
        }
    }

    static class Hasher {
        private final long time = System.nanoTime() + System.currentTimeMillis();

        public int hash(long x) {
            x += time;
            x += 0x9e3779b97f4a7c15L;
            x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
            x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
            return (int) (x ^ (x >>> 31));
        }
    }

    interface LongEntryIterator {
        boolean hasNext();

        void next();

        long getEntryKey();

        long getEntryValue();
    }
}