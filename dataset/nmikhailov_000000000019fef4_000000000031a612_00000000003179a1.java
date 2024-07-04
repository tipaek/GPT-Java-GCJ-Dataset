import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map.Entry;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;

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
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = 10000;
            int u = in.readInt();
            String[] values = new String[N];

            HashSet<Character> alphabet = new HashSet<>();
            HashSet<Character> firstSymbols = new HashSet<>();

            HashMap<Character, Integer> firstSymbolFreq = new HashMap();

            for (int i = 0; i < N; i++) {
                in.readInt();
                values[i] = in.readString();

                for (int j = 0; j < values[i].length(); j++) {
                    alphabet.add(values[i].charAt(j));
                }
                char first = values[i].charAt(0);
                firstSymbols.add(first);

                firstSymbolFreq.put(first, firstSymbolFreq.getOrDefault(first, 0) + 1);
            }

            char[] res = new char[10];


            List<IntPt> pts = firstSymbolFreq.entrySet().stream().map(val -> new IntPt(val.getValue(), val.getKey())).collect(Collectors.toList());
            pts.sort(Comparator.reverseOrder());

            for (int i = 0; i < pts.size(); i++) {
                res[i + 1] = (char) pts.get(i).y;

                alphabet.remove((char) pts.get(i).y);
            }

            res[0] = alphabet.iterator().next();


            out.println("Case #" + testNumber + ": " + new String(res));
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

        public void println(Object... objects) {
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
}

