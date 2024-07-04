import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Map;
import java.util.Map.Entry;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class OverexcitedFan {
        public void solve(int testNumber, InputReader c, OutputWriter w) {
            w.print("Case #" + testNumber + ": ");
            int x = c.readInt(), y = c.readInt();
            char ss[] = c.readString().toCharArray();
            if (x == 0 && y == 0) {
                w.printLine(0);
                return;
            }
            HashMap<Pair<Integer, Integer>, TreeSet<Integer>> hh = new HashMap<>();
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] == 'N') {
                    y++;
                } else if (ss[i] == 'S') {
                    y--;
                } else if (ss[i] == 'E') {
                    x++;
                } else {
                    x--;
                }
                if (hh.containsKey(new Pair<>(x, y))) {
                    hh.get(new Pair<>(x, y)).add(i + 1);
                } else {
                    TreeSet<Integer> tt = new TreeSet<>();
                    tt.add(i + 1);
                    hh.put(new Pair<>(x, y), tt);
                }
            }


            int res = Integer.MAX_VALUE;
            // using for-each loop for iteration over Map.entrySet()
            for (Map.Entry<Pair<Integer, Integer>, TreeSet<Integer>> entry : hh.entrySet()) {
                Pair<Integer, Integer> pp = entry.getKey();
                TreeSet<Integer> tt = entry.getValue();

                int ress = Math.abs(pp.second) + Math.abs(pp.first);
                if (tt.ceiling(ress) != null) {
                    res = Math.min(res, tt.ceiling(ress));
                }

            }
            if (res == Integer.MAX_VALUE) {
                w.printLine("IMPOSSIBLE");
            } else {
                w.printLine(res);
            }

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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
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

    static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            return (first == null ? 0 : first.hashCode() * 31) + (second == null ? 0 : second.hashCode());
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<U, V> p = (Pair<U, V>) o;
            return (first == null ? p.first == null : first.equals(p.first)) &&
                    (second == null ? p.second == null : second.equals(p.second));
        }

        public int compareTo(Pair<U, V> b) {
            int cmpU = first.compareTo(b.first);
            return cmpU != 0 ? cmpU : second.compareTo(b.second);
        }

        public String toString() {
            return String.format("(%s, %s)", first.toString(), second.toString());
        }

    }
}

