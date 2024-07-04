import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.UncheckedIOException;
import java.util.Map;
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
            Expogo solver = new Expogo();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class Expogo {
        Map<Character, Character> comp = new HashMap<>();
        StringBuilder ans;

        private boolean findIt(int index, StringBuilder ans, int x, int y, int xx, int yy) {
            if (index == 0) {
                if (x == xx && y == yy) {
                    this.ans = ans;
                    return true;
                } else return false;
            } else {
                if (findIt(index >> 1, ans.append("W"), x, y, xx - index, yy)) return true;
                else ans.deleteCharAt(ans.length() - 1);
                if (findIt(index >> 1, ans.append("E"), x, y, xx + index, yy)) return true;
                else ans.deleteCharAt(ans.length() - 1);
                if (findIt(index >> 1, ans.append("S"), x, y, xx, yy - index)) return true;
                else ans.deleteCharAt(ans.length() - 1);
                if (findIt(index >> 1, ans.append("N"), x, y, xx, yy + index)) return true;
                else ans.deleteCharAt(ans.length() - 1);
                return false;
            }
        }

        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.append("Case #" + testNumber + ": ");
            comp.put('E', 'W');
            comp.put('W', 'E');
            comp.put('S', 'N');
            comp.put('N', 'S');
            int xx = in.readInt();
            int yy = in.readInt();
            int x = Math.abs(xx);
            int y = Math.abs(yy);
            int temp = x + y;
            int highest = Bits.highestBit(temp);
            ans = new StringBuilder();
            findIt(highest, new StringBuilder(), x, y, 0, 0);
            if (ans.length() == 0) {
                out.println("IMPOSSIBLE");
                return;
            }
            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == 'E' || ans.charAt(i) == 'W') {
                    if (xx < 0) ans.setCharAt(i, comp.get(ans.charAt(i)));
                } else {
                    if (yy < 0) ans.setCharAt(i, comp.get(ans.charAt(i)));
                }
            }
            out.println(ans.reverse());
        }

    }

    static class CachedLog2 {
        private static final int BITS = 16;
        private static final int LIMIT = 1 << BITS;
        private static final byte[] CACHE = new byte[LIMIT];

        static {
            int b = 0;
            for (int i = 0; i < LIMIT; i++) {
                while ((1 << (b + 1)) <= i) {
                    b++;
                }
                CACHE[i] = (byte) b;
            }
        }

        public static int floorLog(int x) {
            return x < LIMIT ? CACHE[x] : (BITS + CACHE[x >>> BITS]);
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

        public FastOutput append(String c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(Object c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(String c) {
            return append(c).println();
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

    static class Bits {
        private Bits() {
        }

        public static int highestBit(int x) {
            return 1 << CachedLog2.floorLog(x);
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
}

