import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
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
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, InputReader c, OutputWriter w) {
            w.print("Case #" + testNumber + ": ");
            int u = c.readInt();
            HashMap<Integer, HashSet<Character>> hh = new HashMap<>();
            HashSet<Character> htr = new HashSet<>();
            long mkl = -1;
            int q = (int) 1e4;
            while (q-- > 0) {
                long m = c.readLong();
                mkl = m;
                String mm = m + "";
                String s = c.readString();
                for (int i = 0; i < s.length(); i++) {
                    htr.add(s.charAt(i));
                }
                if (m != -1) {
                    if (mm.length() == s.length()) {
                        int first = mm.charAt(0) - '0';
                        if (hh.containsKey(first)) {
                            hh.get(first).add(s.charAt(0));
                        } else {
                            HashSet<Character> ht = new HashSet<>();
                            ht.add(s.charAt(0));
                            hh.put(first, ht);
                        }
                    }
                    if (m > 10) {
                        continue;
                    }
                    int mk = (int) m;
                    if (hh.containsKey(mk)) {
                        hh.get(mk).add(s.charAt(0));
                    } else {
                        HashSet<Character> ht = new HashSet<>();
                        ht.add(s.charAt(0));
                        hh.put(mk, ht);
                    }
                }
            }
            if (mkl != -1) {
                char res[] = new char[10];
                HashSet<Character> rr = new HashSet<>();
                for (int i = 1; i <= 9; i++) {
                    HashSet<Character> ss = hh.get(i);
                    for (int j = 1; j < i; j++) {
                        ss.remove(res[j]);
                    }
                    for (char ch : ss) {
                        res[i] = ch;
                    }
                }

                for (int i = 1; i <= 9; i++) {
                    htr.remove(res[i]);
                }
                for (char ch : htr) {
                    res[0] = ch;
                }
                for (int i = 0; i < 10; i++) {
                    w.print(res[i]);
                }
                w.printLine();
            } else {
                char res[] = new char[10];

                int ptr = 0;
                for (char ch : htr) {
                    res[ptr++] = ch;
                }

                for (int i = 0; i < 10; i++) {
                    w.print(res[i]);
                }
                w.printLine();
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

        public void printLine() {
            writer.println();
        }

        public void print(char i) {
            writer.print(i);
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

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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
}

