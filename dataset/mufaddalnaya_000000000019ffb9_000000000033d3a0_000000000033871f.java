import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.AbstractCollection;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Mufaddal Naya
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, InputReader c, OutputWriter w) {
            int n = c.readInt(), m = c.readInt();
            int l[] = c.readIntArray(n - 1);
            ArrayList<Integer>[] aa = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                aa[i] = new ArrayList<>();
            }

            int input[][] = new int[m][2];
            HashMap<Pair<Integer, Integer>, Integer> hh = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int u = c.readInt() - 1, v = c.readInt() - 1;
                input[i][0] = u;
                input[i][1] = v;
                aa[u].add(v);
                aa[v].add(u);
                hh.put(new Pair<>(u, v), i);
                hh.put(new Pair<>(v, u), i);
            }

            LinkedList<Integer> ll = new LinkedList<>();
            HashMap<Pair<Integer, Integer>, Integer> res = new HashMap<>();

            int ress[] = new int[n];
            Arrays.fill(ress, -1);
            ress[0] = 0;
            LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
            q.add(new Pair<>(0, 0));
            while (!q.isEmpty()) {
                Pair<Integer, Integer> kk = q.poll();
                for (int xx : aa[kk.first]) {
                    if (xx == 0) {
                        continue;
                    }
                    if (ress[xx] == -1 && -l[xx - 1] == kk.second + 1) {
                        ress[xx] = -l[xx - 1];
                        res.put(new Pair<>(xx, kk.first), -l[xx - 1]);
                        res.put(new Pair<>(kk.first, xx), -l[xx - 1]);
                        q.add(new Pair<>(xx, kk.second + 1));
                    }
                }
            }

            w.print("Case #" + testNumber + ":", "");
            for (int i = 0; i < m; i++) {
                if (res.containsKey(new Pair<>(input[i][0], input[i][1]))) {
                    w.print(res.get(new Pair<>(input[i][0], input[i][1])), "");
                } else {
                    w.print(n + 100, "");
                }
            }

            w.printLine();

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

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
        }

        public int read() {
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            return !(first != null ? !first.equals(pair.first) : pair.first != null) &&
                    !(second != null ? !second.equals(pair.second) : pair.second != null);
        }

        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        public String toString() {
            return "(" + first + "," + second + ")";
        }

        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) first).compareTo(o.first);
            if (value != 0) {
                return value;
            }
            return ((Comparable<V>) second).compareTo(o.second);
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

        public void printLine() {
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

