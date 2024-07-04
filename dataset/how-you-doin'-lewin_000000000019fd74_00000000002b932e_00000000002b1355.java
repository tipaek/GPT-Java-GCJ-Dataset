import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author lewin
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SquareDance {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int r = in.nextInt(), c = in.nextInt();
            int[][] grid = new int[r][c];
            for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                grid[i][j] = (int)(Math.random()*1000000);
//            }
                grid[i] = in.readIntArray(c);
            }

            SquareDance.Dancer[] ds = new SquareDance.Dancer[r * c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ds[i * c + j] = new SquareDance.Dancer(i, j, grid[i][j], i * c + j);
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                            ds[i * c + j].neighbor[k] = ds[ni * c + nj];
                        }
                    }
                }
            }

            List<Integer> eliminated = new ArrayList<>();
            int[][] time = new int[r][c];
            AUtils.deepFill(time, -1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int m = 0;
                    for (int k = 0; k < 4; k++) {
                        if (ds[i * c + j].neighbor[k] != null) {
                            m += ds[i * c + j].neighbor[k].val - ds[i * c + j].val;
                        }
                    }
                    if (m > 0) {
                        eliminated.add(ds[i * c + j].idx);
                        time[i][j] = 1;
                    }
                }
            }
            int ct = 1;
            while (eliminated.size() > 0) {
                HashSet<Integer> interesting = new HashSet<>();
                for (int d : eliminated) {
                    for (int k = 0; k < 4; k++) {
                        if (ds[d].neighbor[k] != null) {
                            interesting.add(ds[d].neighbor[k].idx);
                            ds[d].neighbor[k].neighbor[k ^ 2] = ds[d].neighbor[k ^ 2];
                        }
                    }
                }
                List<Integer> nelim = new ArrayList<>();
                ct++;
                for (int x : interesting) {
                    if (time[ds[x].x][ds[x].y] != -1) continue;
                    int m = 0;
                    for (int k = 0; k < 4; k++) {
                        if (ds[x].neighbor[k] != null) {
                            m += ds[x].neighbor[k].val - ds[x].val;
                        }
                    }
                    if (m > 0) {
                        nelim.add(ds[x].idx);
                        time[ds[x].x][ds[x].y] = ct;
                    }
                }
                eliminated = nelim;
            }
            long ans = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans += (time[i][j] == -1 ? ct : time[i][j]) * grid[i][j];
                }
            }
            out.printf("Case #%d: %d\n", testNumber, ans);
        }

        static class Dancer {
            public SquareDance.Dancer[] neighbor;
            public int x;
            public int y;
            public int val;
            public int idx;

            public Dancer(int x, int y, int val, int idx) {
                this.x = x;
                this.y = y;
                this.val = val;
                this.idx = idx;
                neighbor = new SquareDance.Dancer[4];
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

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }

    static class AUtils {
        public static void deepFill(int[][] x, int val) {
            for (int[] y : x) deepFill(y, val);
        }

        public static void deepFill(int[] x, int val) {
            Arrays.fill(x, val);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int[] readIntArray(int tokens) {
            int[] ret = new int[tokens];
            for (int i = 0; i < tokens; i++) {
                ret[i] = nextInt();
            }
            return ret;
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

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
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

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
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

