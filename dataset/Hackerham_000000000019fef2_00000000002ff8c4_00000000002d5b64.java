import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task3 solver = new Task3();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task3 {
        int RS;
        int R;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            out.print("Case #" + testNumber + ": ");

            int R = in.readInt();
            int S = in.readInt();

            this.RS = R * S;
            this.R = R;

            HashSet<Long> hs = new HashSet<Long>();
            ArrayList<Position> q = new ArrayList<Position>();
            Position start = new Position();
            for (int i = 0; i < RS; i++) {
                start.x[i] = i % R;
            }

            // 1 2 1 2 1 2
            // 1 1 2 1 2 2
            // 2 1 1 1 2 2

            q.add(start);
            Position tmp = new Position();
            Position tmp2 = new Position();
            hs.add(tmp.hash());

            for (int qcur = 0; qcur < q.size(); qcur++) {
                tmp.copyFrom(q.get(qcur));
                tmp2.copyFrom(q.get(qcur));
                for (int a = 0; a < RS; a++) {
                    for (int b = a + 1; b < RS; b++) {
                        int k = 0;
                        for (int i = a + 1; i <= b; i++) {
                            tmp.x[k++] = tmp2.x[i];
                        }
                        for (int i = 0; i <= a; i++) {
                            tmp.x[k++] = tmp2.x[i];
                        }
                        for (int i = b + 1; i < RS; i++) {
                            tmp.x[k++] = tmp2.x[i];
                        }

                        long h = tmp.hash();
                        if (hs.contains(h)) {
                            continue;
                        }
                        hs.add(h);

                        Position p = new Position();
                        p.copyFrom(tmp);
                        p.t = tmp.t + 1;
                        p.pa = a + 1;
                        p.pb = b - a;
                        p.prev = q.get(qcur);
                        q.add(p);

                        if (p.isEnd()) {
                            out.printLine(p.t);
                            ArrayList<String> ss = new ArrayList<String>();
                            while (p.pa > 0) {
                                ss.add(p.pa + " " + p.pb);
                                p = p.prev;
                            }
                            for (int i = ss.size() - 1; i >= 0; i--) {
                                out.printLine(ss.get(i));
                            }
                            return;
                        }
                    }
                }
            }

            out.printLine("WHAT?");
        }

        class Position {
            int[] x;
            int t;
            int pa;
            int pb;
            Position prev;

            Position() {
                x = new int[RS];
            }

            void copyFrom(Position p) {
                for (int i = 0; i < RS; i++) {
                    x[i] = p.x[i];
                }
                this.t = p.t;
            }

            boolean isEnd() {
                int d = 0;
                for (int i = 0; i + 1 < RS; i++) {
                    if (x[i] != x[i + 1]) {
                        d++;
                    }
                }
                return d == R - 1;
            }

            long hash() {
                long h = 0;
                for (int i = 0; i < RS; i++) {
                    h = h * 5 + x[i];
                }
                return h;
            }

        }

    }

    static class OutputWriter {
        public final Writer out;

        public OutputWriter(OutputStream outputStream) {
            this.out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        }

        public OutputWriter(Writer writer) {
            this.out = writer;
        }

        public void print(Object... objects) {
            try {
                for (int i = 0; i < objects.length; ++i) {
                    if (i != 0) {
                        this.out.write(32);
                    }

                    this.out.write(objects[i].toString());
                }

            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void printLine(Object... objects) {
            this.print(objects);

            try {
                this.out.write(10);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void close() {
            try {
                this.out.close();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }

    }

    static class InputReader extends InputStream {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public String next() {
            return this.readToken();
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int readInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
            }

            int sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String readToken() {
            int c;
            while (isSpaceChar(c = this.read())) {
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }
}

