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

                s = shiftLeft(s, k / n);


                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sb.append(s[j]);
                        if (j != n - 1) sb.append(" ");
                    }
                    sb.append("\n");
                    s = shiftLeft(s, 1);
                }

                out.print(sb.toString());


            }
        }

        int[] shiftLeft(int[] arr, int n) {
            int[] res = new int[arr.length];
            for (int i = 0; i < n; i++) {
                int temp = arr[arr.length - 1];
                for (int j = arr.length - 2; j >= 0; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[0] = temp;
            }

            for (int i = 0; i < arr.length; i++) {
                res[i] = arr[i];
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

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

