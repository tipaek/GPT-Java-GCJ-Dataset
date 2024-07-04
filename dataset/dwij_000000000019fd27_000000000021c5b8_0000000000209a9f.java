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
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int T, InputReader in, OutputWriter out) {
            char[] crr = in.nextString().toCharArray();

            int[] arr = new int[crr.length];
            for (int i = 0; i < crr.length; i++) {
                arr[i] = crr[i] - '0';
            }

            int oc = 0;

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[0]; j++) {
                sb.append("(");
                oc++;
            }
            sb.append(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        sb.append("(");
                        oc++;
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        sb.append(")");
                        oc--;
                    }
                }

                sb.append(arr[i]);
            }

            for (int i = 0; i < oc; i++) {
                sb.append(")");
            }

            out.println(String.format("Case #%d: %s", T, sb.toString()));

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

