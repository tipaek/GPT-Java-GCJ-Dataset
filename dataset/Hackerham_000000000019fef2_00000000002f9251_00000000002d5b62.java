import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.charset.StandardCharsets;
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
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            out.print("Case #" + testNumber + ": ");

            int x = in.readInt();
            int y = in.readInt();

            //1+2+4+8+16+32+64+

            StringBuilder s = new StringBuilder();

            for (int bit = 1; bit <= Math.abs(x) || bit <= Math.abs(y); bit *= 2) {
                int x1 = Math.abs(x);
                int y1 = Math.abs(y);

                int bit2 = bit * 2;
                if ((x1 & bit) != 0 && (y1 & bit) != 0 ||
                        (x1 & bit) == 0 && (y1 & bit) == 0) {
                    out.printLine("IMPOSSIBLE");
                    return;
                }

                if (x == bit && y == 0) {
                    x = 0;
                    s.append('E');
                    break;
                }
                if (x == -bit && y == 0) {
                    x = 0;
                    s.append('W');
                    break;
                }
                if (y == bit && x == 0) {
                    y = 0;
                    s.append('N');
                    break;
                }
                if (y == -bit && x == 0) {
                    y = 0;
                    s.append('S');
                    break;
                }

                if ((x1 & bit) != 0) {
                    int ny = (y1 & bit2) != 0 ? 1 : 0;
                    int nx = (Math.abs(x - bit) & bit2) != 0 ? 1 : 0;

                    if (nx + ny != 1) {
                        x += bit;
                        s.append('W');
                    } else {
                        x -= bit;
                        s.append('E');
                    }
                } else {
                    int nx = (x1 & bit2) != 0 ? 1 : 0;
                    int ny = (Math.abs(y - bit) & bit2) != 0 ? 1 : 0;

                    if (nx + ny != 1) {
                        y += bit;
                        s.append('S');
                    } else {
                        y -= bit;
                        s.append('N');
                    }
                }
            }

            if (x != 0 || y != 0) {
                out.printLine("IMPOSSIBLE");
                return;
            }
            out.printLine(s.toString());
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

