import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
 * @author dwij
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Indicium solver = new Indicium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Indicium {
        public void solve(int T, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k % n != 0) {
                out.println(String.format("Case #%d: IMPOSSIBLE", T));
            } else {
                out.println(String.format("Case #%d: POSSIBLE", T));
                int[] s = new int[n];
                for (int i = 1; i <= n; i++) {
                    s[i - 1] = i;
                }

                while (true) {
                    s = shiftLeft(s, 1);
                    if (s[0] == k / n) break;
                }

                int[][] arr = new int[n][];
                for (int i = 0; i < n; i++) {
                    arr[i] = s;
                    s = shiftLeft(s, 1);
                }


                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(arr[i][j]);
                        if (j != n - 1) out.print(" ");
                    }

                    out.println();
                }

            }
        }

        int[] shiftLeft(int[] arr, int n) {
            int[] res = new int[arr.length];
            System.arraycopy(arr, 0, res, 0, arr.length);
            for (int i = 0; i < n; i++) {
                int temp = res[res.length - 1];
                for (int j = res.length - 2; j >= 0; j--) {
                    res[j + 1] = res[j];
                }
                res[0] = temp;
            }
            return res;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

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

        public int nextInt() {
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

        public String nextString() {
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

        public String next() {
            return nextString();
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
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

        public void println() {
            writer.println();
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void print(int i) {
            writer.print(i);
        }

    }
}

