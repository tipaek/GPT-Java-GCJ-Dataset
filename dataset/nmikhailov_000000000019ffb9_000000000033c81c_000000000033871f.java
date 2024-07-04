import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;
import java.util.function.IntFunction;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int m = in.readInt();

            ArrayList<IntPt> numBefore = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                numBefore.add(new IntPt(-in.readInt(), i + 1));
            }

            numBefore.sort(Comparator.naturalOrder());

            Graph graph = new Graph(n);

            ArrayList<IntPt> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int from = in.readInt() - 1;
                int to = in.readInt() - 1;
                graph.addEdgeBi(from, to, (long) 1e6);
                edges.add(new IntPt(from, to));
            }


            ArrayList<Integer> visited = new ArrayList<>();
            visited.add(0);
            for (int i = 0; i < numBefore.size(); i++) {
                int curId = numBefore.get(i).y;
                int curBefore = numBefore.get(i).x;

                for (int prevNode : visited) {
                    if (graph.getWeight(prevNode, curId) != null) {
                        graph.setWeight(prevNode, curId, 1);
                        break;
                    }
                }

                visited.add(curId);
            }

            long[] res = new long[m];
            for (int i = 0; i < m; i++) {
                res[i] = graph.getWeight(edges.get(i).x, edges.get(i).y);
            }

            out.print("Case #" + testNumber + ": ");
            out.println(res);

        }

    }

    static class Graph {
        protected int n;
        public HashSet<Integer>[] node2node;
        public HashMap<IntPt, Long> edgeWeights;

        public Graph(int n) {
            this.n = n;
            this.node2node = Utils.makeArray(n, HashSet::new);
            this.edgeWeights = new HashMap<>();
        }

        public void addEdge(int from, int to, long weight) {
            this.node2node[from].add(to);
            edgeWeights.put(new IntPt(from, to), weight);
        }

        public void addEdgeBi(int from, int to, long weight) {
            this.addEdge(from, to, weight);
            this.addEdge(to, from, weight);
        }

        public Long getWeight(int from, int to) {
            if (node2node[from].contains(to)) {
                return this.edgeWeights.get(new IntPt(from, to));
            }
            return null;
        }

        public void setWeight(int from, int to, long w) {
            this.edgeWeights.put(new IntPt(from, to), w);
        }

    }

    static class IntPt implements Comparable<IntPt>, IPt<Integer, Integer> {
        public final int x;
        public final int y;

        public IntPt(int k, int v) {
            x = k;
            y = v;
        }

        public IntPt(IntPt entry) {
            this(entry.getX(), entry.getY());
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof IntPt)) {
                return false;
            } else {
                return x == ((IntPt) o).x && y == ((IntPt) o).y;
            }
        }

        public int hashCode() {
            int result = Integer.hashCode(x);

            final int h = Integer.hashCode(y);
            result = 37 * result + h ^ (h >>> 16);

            return result;
        }

        public String toString() {
            return "[" + getX() + ", " + getY() + "]";
        }

        public int compareTo(IntPt o) {
            if (x == o.x) {
                return Integer.compare(y, o.y);
            }
            return Integer.compare(x, o.x);
        }

    }

    static interface IPt<A, B> {
    }

    static final class Utils {
        private Utils() {
        }

        public static <T> T[] makeArrayInd(int n, IntFunction<T> creator) {
            if (n > 0) {
                T first = creator.apply(0);
                T[] res = (T[]) Array.newInstance(first.getClass(), n);
                res[0] = first;

                for (int i = 1; i < n; i++) {
                    res[i] = creator.apply(i);
                }

                return res;
            } else {
                return null;
            }
        }

        public static <T> T[] makeArray(int n, Supplier<T> creator) {
            return makeArrayInd(n, value -> creator.get());
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

