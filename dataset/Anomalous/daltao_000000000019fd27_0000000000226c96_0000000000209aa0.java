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
            Indicium solver = new Indicium();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
            out.close();
        }
    }

    static class Indicium {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.readInt();
            int k = in.readInt();

            k -= n;

            int[][] mat = null;
            for (int d = 0; d < n && mat == null; d++) {
                if (GCDs.gcd(d, n) != 1) {
                    continue;
                }
                mat = solve(n, k, d);
            }

            if (mat == null) {
                out.println("IMPOSSIBLE");
                return;
            }
            out.println("POSSIBLE");
            for (int[] row : mat) {
                for (int cell : row) {
                    out.append(cell + 1).append(' ');
                }
                out.pop(1);
                out.println();
            }
        }

        public int sumOf(int n) {
            return (1 + n) * n / 2;
        }

        public int sumOf(int l, int r) {
            return sumOf(r) - sumOf(l - 1);
        }

        public int[][] solve(int n, int k, int d) {
            int step = DigitUtils.mod(d - 1, n);
            int g = GCDs.gcd(n, step);
            int pick = n / g;
            int mul = n / pick;
            if (k % mul != 0) {
                return null;
            }
            k /= mul;
            if (k < sumOf(0, pick - 1) || k > sumOf(n - pick, n - 1)) {
                return null;
            }

            int[] vals = new int[pick];
            int sum = 0;
            for (int i = 0; i < pick; i++) {
                vals[i] = i;
                sum += vals[i];
            }

            int last = n;
            for (int i = pick - 1; i >= 0; i--) {
                int plus = Math.min(k - sum, last - 1 - vals[i]);
                vals[i] += plus;
                sum += plus;
            }

            boolean[] used = new boolean[n];
            for (int x : vals) {
                used[x] = true;
            }
            IntegerList other = new IntegerList(n);
            IntegerList hit = new IntegerList(n);
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    other.add(i);
                } else {
                    hit.add(i);
                }
            }
            int[] row = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % g == 0) {
                    row[i] = hit.pop();
                } else {
                    row[i] = other.pop();
                }
            }

            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                mat[i] = row.clone();
                SequenceUtils.rotate(mat[i], 0, n - 1, (i * d) % n);
            }

            return mat;
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

        public void pop(int k) {
            cache.setLength(cache.length() - k);
        }

        public String toString() {
            return cache.toString();
        }
    }

    static class SequenceUtils {
        public static void swap(int[] data, int i, int j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        public static void rotate(int[] list, int l, int r, int to) {
            reverse(list, l, r);
            reverse(list, l, to - 1);
            reverse(list, to, r);
        }

        public static void reverse(int[] data, int l, int r) {
            while (l < r) {
                swap(data, l, r);
                l++;
                r--;
            }
        }

        public static boolean equal(int[] a, int al, int ar, int[] b, int bl, int br) {
            if ((ar - al) != (br - bl)) {
                return false;
            }
            for (int i = al, j = bl; i <= ar; i++, j++) {
                if (a[i] != b[j]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class GCDs {
        public static int gcd(int a, int b) {
            return a >= b ? gcd0(a, b) : gcd0(b, a);
        }

        private static int gcd0(int a, int b) {
            return b == 0 ? a : gcd0(b, a % b);
        }
    }

    static class FastInput {
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

    static class DigitUtils {
        public static int mod(int x, int mod) {
            x %= mod;
            if (x < 0) {
                x += mod;
            }
            return x;
        }
    }

    static class IntegerList implements Cloneable {
        private int size;
        private int cap;
        private int[] data;
        private static final int[] EMPTY = new int[0];

        public IntegerList(int cap) {
            this.cap = cap;
            data = cap == 0 ? EMPTY : new int[cap];
        }

        public IntegerList(IntegerList list) {
            this.size = list.size;
            this.cap = list.cap;
            this.data = Arrays.copyOf(list.data, size);
        }

        public IntegerList() {
            this(0);
        }

        public void ensureSpace(int req) {
            if (req > cap) {
                while (cap < req) {
                    cap = Math.max(cap + 10, 2 * cap);
                }
                data = Arrays.copyOf(data, cap);
            }
        }

        public void add(int x) {
            ensureSpace(size + 1);
            data[size++] = x;
        }

        public void addAll(int[] x, int offset, int len) {
            ensureSpace(size + len);
            System.arraycopy(x, offset, data, size, len);
            size += len;
        }

        public void addAll(IntegerList list) {
            addAll(list.data, 0, list.size);
        }

        public int pop() {
            return data[--size];
        }

        public int[] toArray() {
            return Arrays.copyOf(data, size);
        }

        public String toString() {
            return Arrays.toString(toArray());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof IntegerList)) {
                return false;
            }
            IntegerList other = (IntegerList) obj;
            return SequenceUtils.equal(data, 0, size - 1, other.data, 0, other.size - 1);
        }

        public int hashCode() {
            return Arrays.hashCode(Arrays.copyOf(data, size));
        }

        public IntegerList clone() {
            IntegerList ans = new IntegerList();
            ans.addAll(this);
            return ans;
        }
    }
}