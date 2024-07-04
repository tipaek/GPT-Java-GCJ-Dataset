import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader c, OutputWriter w) {
            int n = c.readInt();
            Pair<Integer, Pair<Integer, Integer>>[] pp = new Pair[n];
            for (int i = 0; i < n; i++) {
                pp[i] = new Pair<>(c.readInt(), new Pair<>(c.readInt(), i));
            }

            Arrays.sort(pp);
            int[] res = new int[n];
            int endTimeC = 0, endTimeJ = 0;
            for (int i = 0; i < n; i++) {
                if (endTimeC <= pp[i].first) {
                    res[pp[i].second.second] = 0;
                    endTimeC = pp[i].second.first;
                } else if (endTimeJ <= pp[i].first) {
                    res[pp[i].second.second] = 1;
                    endTimeJ = pp[i].second.first;
                } else {
                    w.printLine("Case #" + testNumber + ": IMPOSSIBLE");
                    return;
                }
            }

            w.print("Case #" + testNumber + ": ");
            for (int i = 0; i < n; i++) {
                if (res[i] == 0) {
                    w.print("C");
                } else {
                    w.print("J");
                }
            }
            w.printLine();
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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
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

