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
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.readInt();
            Pair[] p = new Pair[N];
            for (int i = 0; i < N; i++) {
                p[i] = new Pair(in.readInt(), in.readInt());
            }
            Arrays.sort(p);
            int NN = N * (N - 1) / 2;
            Pair[] dir = new Pair[NN];
            int nn = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int dx = p[j].x - p[i].x;
                    int dy = p[j].y - p[i].y;
                    int g = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= g;
                    dy /= g;
                    dir[nn++] = new Pair(dx, dy);
                }
            }
            Arrays.sort(dir);
            Pair prev = null;
            int[] dist = new int[N];
            int ans = Math.min(2, N);
            for (int k = 0; k < NN; k++) {
                Pair d = dir[k];
                if (prev != null && d.x == prev.x && d.y == prev.y) {
                    continue;
                }

                for (int i = 0; i < N; i++) {
                    dist[i] = p[i].x * d.y - p[i].y * d.x;
                }
                Arrays.sort(dist);
                int res = 0;
                int cnt = 1;
                for (int i = 1; i < N; i++) {
                    if (dist[i] == dist[i - 1]) {
                        cnt++;
                    } else {
                        if (cnt > 1) {
                            res += cnt;
                        }
                        cnt = 1;
                    }
                }
                if (res % 2 == 1) {
                    res--;
                }

                res = Math.min(res + 2, N);

                ans = Math.max(ans, res);
            }
            out.print("Case #" + testNumber + ": " + ans);
            out.printLine();
        }

        int gcd(int dx, int dy) {
            while (dx > 0 && dy > 0) {
                if (dx > dy) {
                    dx %= dy;
                } else {
                    dy %= dx;
                }
            }
            return dx + dy;
        }

        class Pair implements Comparable<Pair> {
            int x;
            int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int compareTo(Pair o) {
                if (x != o.x)
                    return x - o.x;
                return y - o.y;
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

