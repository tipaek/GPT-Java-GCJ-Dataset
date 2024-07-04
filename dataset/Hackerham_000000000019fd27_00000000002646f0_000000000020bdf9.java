import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.charset.StandardCharsets;
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
        Task_3 solver = new Task_3();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task_3 {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            out.print("Case #" + testNumber + ": ");
            int N = in.readInt();

            Activity[] all = new Activity[N];
            for (int i = 0; i < N; i++) {
                all[i] = new Activity(i, in.readInt(), in.readInt());
            }

            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < N; i++) {
                ans.append('C');
            }

            Arrays.sort(all);
            int[] end = new int[2];
            end[0] = -1;
            end[1] = -1;
            for (int i = 0; i < N; i++) {
                Activity a = all[i];
                if (a.S >= end[0]) {
                    end[0] = a.E;
                } else if (a.S >= end[1]) {
                    ans.setCharAt(a.num, 'J');
                    end[1] = a.E;
                } else {
                    out.printLine("IMPOSSIBLE");
                    return;
                }
            }
            out.printLine(ans.toString());
        }

        class Activity implements Comparable<Activity> {
            int S;
            int E;
            int num;

            Activity(int num, int S, int E) {
                this.num = num;
                this.S = S;
                this.E = E;
            }

            public int compareTo(Activity o) {
                return this.S - o.S;
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

