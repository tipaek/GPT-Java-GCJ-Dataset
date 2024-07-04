import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, InputReader c, OutputWriter w) {
            int x1 = c.readInt(), y1 = c.readInt();
            int x2 = x1, y2 = y1;
            if (x1 < 0) {
                x2 = -x1;
            }
            if (y1 < 0) {
                y2 = -y1;
            }
            if (x2 % 2 == 1 && y2 % 2 == 1) {
                w.printLine("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                boolean[] a1 = new boolean[32], b1 = new boolean[32];
                for (int i = 0; i < 32; i++) {
                    if ((x2 & (1 << i)) > 0) {
                        a1[i] = true;
                    }
                    if ((y2 & (1 << i)) > 0) {
                        b1[i] = true;
                    }
                }
                boolean check = false;
                for (int i = 0; i < 32; i++) {
                    if (a1[i] & b1[i]) {
                        check = true;
                    }
                }
                if (check) {
                    if (a1[0]) {
                        boolean ff = false;
                        int kk = -1;
                        for (int i = 31; i > 0; i--) {
                            if (ff) {
                                a1[i] = !a1[i];
                            } else {
                                if (a1[i]) {
                                    ff = true;
                                    a1[i + 1] = true;
                                    kk = i + 1;
                                    a1[i] = false;
                                }
                            }
                        }
                        if (check_(a1, b1)) {
                            w.print("Case #" + testNumber + ": ");
                            for (int i = 0; i < 32; i++) {
                                if (b1[i]) {
                                    if (y1 > 0) {
                                        w.print("N");
                                    } else {
                                        w.print("S");
                                    }
                                } else {
                                    if (i == kk) {
                                        if (x1 > 0) {
                                            w.print("E");
                                        } else {
                                            w.print("W");
                                        }
                                    } else if (i < kk) {
                                        if (x1 > 0) {
                                            w.print("W");
                                        } else {
                                            w.print("E");
                                        }
                                    }
                                }
                            }
                            w.printLine();
                        } else {
                            w.printLine("Case #" + testNumber + ": IMPOSSIBLE");
                        }
                    } else if (b1[0]) {
                        boolean ff = false;
                        int kk = -1;
//                    w.printLine(Arrays.toString(b1));

                        for (int i = 31; i > 0; i--) {
                            if (ff) {
                                b1[i] = !b1[i];
                            } else {
                                if (b1[i]) {
                                    ff = true;
                                    b1[i + 1] = true;
                                    kk = i + 1;
                                    b1[i] = false;
                                }
                            }
                        }
//                    w.printLine(Arrays.toString(b1));
                        if (check_(a1, b1)) {
                            w.print("Case #" + testNumber + ": ");
                            for (int i = 0; i < 32; i++) {
                                if (a1[i]) {
                                    if (x1 > 0) {
                                        w.print("E");
                                    } else {
                                        w.print("W");
                                    }
                                } else {
                                    if (i == kk) {
                                        if (y1 > 0) {
                                            w.print("N");
                                        } else {
                                            w.print("S");
                                        }
                                    } else if (i < kk) {
                                        if (y1 > 0) {
                                            w.print("S");
                                        } else {
                                            w.print("N");
                                        }
                                    }
                                }
                            }
                            w.printLine();
                        } else {
                            w.printLine("Case #" + testNumber + ": IMPOSSIBLE");
                        }
                    } else {
                        w.printLine("Case #" + testNumber + ": IMPOSSIBLE");
                    }
                } else {
                    if (check_(a1, b1)) {
                        w.print("Case #" + testNumber + ": ");
                        for (int i = 0; i < 32; i++) {
                            if (a1[i]) {
                                if (x1 > 0) {
                                    w.print("E");
                                } else {
                                    w.print("W");
                                }
                            } else if (b1[i]) {
                                if (y1 > 0) {
                                    w.print("N");
                                } else {
                                    w.print("S");
                                }
                            }
                        }
                        w.printLine();
                    } else {
                        w.printLine("Case #" + testNumber + ": IMPOSSIBLE");
                    }
                }

            }
        }

        private boolean check_(boolean[] a1, boolean[] b1) {
            boolean cc = false;
            for (int i = 0; i < 32; i++) {
                if (!a1[i] && !b1[i]) {
                    cc = true;
                } else {
                    if (cc) {
                        return false;
                    }
                }
            }
            return true;
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
}

