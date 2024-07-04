import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.AbstractSet;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
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
            SquareDance solver = new SquareDance();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class SquareDance {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);

            int r = in.readInt();
            int c = in.readInt();

            long sum = 0;
            Dancer[][] dancers = new Dancer[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    dancers[i][j] = new Dancer();
                    dancers[i][j].id = i * c + j;
                    dancers[i][j].skill = in.readInt();
                    sum += dancers[i][j].skill;
                }
            }
            int[][] ds = new int[][]{
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
            };
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < 4; k++) {
                        int[] d = ds[k];
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if (ni < 0 || ni >= r || nj < 0 || nj >= c) {
                            continue;
                        }
                        dancers[i][j].next[k] = dancers[ni][nj];
                    }
                }
            }

            TreeSet<Dancer> set = new TreeSet<>((a, b) -> a.weight() == b.weight() ? a.id - b.id : a.weight() - b.weight());
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    set.add(dancers[i][j]);
                }
            }

            long ans = sum;
            List<Dancer> wait = new ArrayList<>(r * c);
            List<Dancer> insert = new ArrayList<>(r * c * 4);
            while (!set.isEmpty() && set.first().weight() < 0) {
                wait.clear();
                while (!set.isEmpty() && set.first().weight() < 0) {
                    wait.add(set.pollFirst());
                }
                for (Dancer dancer : wait) {
                    for (int i = 0; i < 4; i++) {
                        if (dancer.next[i] != null) {
                            insert.add(dancer.next[i]);
                        }
                    }
                }
                set.removeAll(insert);
                for (Dancer dancer : wait) {
                    dancer.killed = true;
                    sum -= dancer.skill;
                }
                for (Dancer dancer : insert) {
                    if (dancer.killed) {
                        continue;
                    }
                    set.add(dancer);
                }

                ans += sum;
            }

            out.println(ans);
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

        public FastOutput append(long c) {
            cache.append(c);
            return this;
        }

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
            return this;
        }

        public FastOutput println(long c) {
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

    static class Dancer {
        int skill;
        boolean killed;
        Dancer[] next = new Dancer[4];
        int id;

        public int weight() {
            int a = 0;
            int b = 0;
            for (int i = 0; i < 4; i++) {
                while (next[i] != null && next[i].killed) {
                    next[i] = next[i].next[i];
                }
                if (next[i] != null) {
                    a += skill;
                    b += next[i].skill;
                }
            }


            return a - b;
        }

    }
}

