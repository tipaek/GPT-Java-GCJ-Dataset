import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.util.function.IntFunction;

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
            SecurityUpdate solver = new SecurityUpdate();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class SecurityUpdate {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);

            int n = in.readInt();
            int m = in.readInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
                nodes[i].id = i;
                if (i != 0) {
                    nodes[i].dist = in.readInt();
                }
            }

            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                Node a = nodes[in.readInt() - 1];
                Node b = nodes[in.readInt() - 1];
                edges[i] = new Edge();
                edges[i].a = a;
                edges[i].b = b;
                a.adj.add(edges[i]);
                b.adj.add(edges[i]);
            }

            List<Node> t1 = new ArrayList<>(n);
            List<Node> t2 = new ArrayList<>(n);
            for (int i = 1; i < n; i++) {
                if (nodes[i].dist < 0) {
                    t2.add(nodes[i]);
                    nodes[i].dist = -nodes[i].dist;
                } else {
                    t1.add(nodes[i]);
                }
            }

            t1.sort((a, b) -> a.dist - b.dist);
            t2.sort((a, b) -> a.dist - b.dist);

            int lastDist = 0;
            int front = 1;
            Range2DequeAdapter<Node> rdq = new Range2DequeAdapter<>(i -> t1.get(i), 0, t1.size() - 1);
            for (int i = 0; i < t2.size(); i++) {
                int r = i;
                while (r + 1 < t2.size() && t2.get(r + 1).dist == t2.get(r).dist) {
                    r++;
                }
                int need = t2.get(i).dist;
                while (front < need) {
                    lastDist = rdq.removeFirst().dist;
                    front++;
                }
                lastDist++;
                front += r - i + 1;
                for (int j = i; j <= r; j++) {
                    t2.get(j).dist = lastDist;
                }
                i = r;
            }

            int inf = (int) 1e6;
            for (Edge e : edges) {
                if (e.a.dist == e.b.dist) {
                    e.w = inf;
                    continue;
                }
                e.w = Math.abs(e.a.dist - e.b.dist);
            }

            //debug.debug("nodes", nodes);
            for (Edge e : edges) {
                out.append(e.w).append(' ');
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

    static class Edge {
        Node a;
        Node b;
        int w;

    }

    static class Node {
        List<Edge> adj = new ArrayList<>();
        int dist;
        int id;

        public String toString() {
            return String.format("%d:%d", id, dist);
        }

    }

    static interface SimplifiedStack<T> extends Iterable<T> {
    }

    static class Range2DequeAdapter<T> implements SimplifiedDeque<T> {
        IntFunction<T> data;
        int l;
        int r;

        public Range2DequeAdapter(IntFunction<T> data, int l, int r) {
            this.data = data;
            this.l = l;
            this.r = r;
        }

        public T removeFirst() {
            return data.apply(l++);
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                int iter = l;


                public boolean hasNext() {
                    return iter <= r;
                }


                public T next() {
                    return data.apply(iter++);
                }
            };
        }

    }

    static interface SimplifiedDeque<T> extends SimplifiedStack<T> {
    }
}

