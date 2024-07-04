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
 * @author out_of_the_box
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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.nextString();
            String ans = solve(s);
            out.println(String.format("Case #%d: %s", testNumber, ans));
        }

        private String solve(String s) {
            //System.out.println("s = " + s);
            int n = s.length();
            int[] aux = new int[n];
            aux[0] = (s.charAt(0) - '0');
            //System.out.println("aux[0] = " + aux[0]);
            for (int i = 1; i < n; i++) {
                int firstDig = s.charAt(i) - '0';
                int secDig = s.charAt(i - 1) - '0';
                //System.out.println("firstDig = " + firstDig);
                //System.out.println("secDig = " + secDig);
                aux[i] = firstDig - secDig;
            }
            //System.out.println("Aux");
            for (int i = 0; i < n; i++) {
                //System.out.println(String.format("aux[%d] = %d", i, aux[i]));
            }
            //System.out.println();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int rc = aux[i];
                if (rc > 0) {
                    for (int j = 0; j < rc; j++) {
                        ans.append('(');
                    }
                } else if (rc < 0) {
                    rc = Math.abs(rc);
                    for (int j = 0; j < rc; j++) {
                        ans.append(')');
                    }
                }
                ans.append(s.charAt(i));
            }
            int last = s.charAt(n - 1) - '0';
            for (int i = 0; i < last; i++) {
                ans.append(')');
            }
            return ans.toString();
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
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

