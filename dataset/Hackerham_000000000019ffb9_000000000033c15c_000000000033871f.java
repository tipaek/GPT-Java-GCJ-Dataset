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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int C = in.readInt();
            int D = in.readInt();

            int[] place = new int[C];
            int[] lat = new int[C];

            for (int i = 1; i < C; i++) {
                int x = in.readInt();
                if (x < 0) {
                    place[i] = -x;
                    lat[i] = -1;
                } else {
                    place[i] = -1;
                    lat[i] = x;
                }
            }

            int[] u = new int[D];
            int[] v = new int[D];
            int[][] grid = new int[C][C];
            for (int i = 0; i < D; i++) {
                u[i] = in.readInt();
                v[i] = in.readInt();
                u[i]--;
                v[i]--;
                grid[u[i]][v[i]] = 1;
                grid[v[i]][u[i]] = 1;
            }


            int[][] comps = new int[C][C];
            int[] cnt = new int[C];
            cnt[0] = 1;
            comps[0][0] = 1;

            for (int i = 1; i < C; i++) {
                if (place[i] >= 0) {
                    comps[place[i]][cnt[place[i]]++] = i;
                }
            }

            int[] srt = new int[C - 1];
            int cc = 0;
            for (int i = 1; i < C; i++) {
                if (lat[i] >= 0) {
                    srt[cc++] = lat[i] * C + i;
                }
            }
            Arrays.sort(srt, 0, cc);

            int curtime = 0;
            int m = 0;
            int a = 1;
            for (int p = 1; p < C; p++) {
                if (cnt[p] > 0) {
                    curtime++;
                    int missing = p - a;
                    for (int i = 0; i < missing; i++) {
                        int ind = srt[m] % C;
                        m++;
                        curtime = Math.max(curtime, lat[ind] + 1);
                    }

                    for (int i = 0; i < cnt[p]; i++) {
                        int s = comps[p][i];
                        lat[s] = curtime;
                    }
                    a = p + cnt[p];
                }
            }

            out.print("Case #" + testNumber + ":");
            for (int i = 0; i < D; i++) {
                int d = lat[u[i]] - lat[v[i]];
                d = Math.max(1, Math.abs(d));
                grid[u[i]][v[i]] = grid[v[i]][u[i]] = d;
                out.print(" " + d);
            }
            out.printLine();

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

