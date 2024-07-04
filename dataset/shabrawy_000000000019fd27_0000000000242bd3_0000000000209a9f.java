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
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Egor Kulikov (egor@egork.net)
 */
 class Solution2 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ForegoneSolution solver = new ForegoneSolution();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ForegoneSolution {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String n = in.readString();
            int k=n.length();
            int prev = 0;
            int input = 0;
            String sOutput="";
            //////////////////
                 for (int i = 0; i < k; i++) {
                input = Integer.parseInt("" + n.charAt(i));
                if (input < prev) {
                    int loop = prev - input;
                    while (loop > 0) {
                        sOutput += ")";
                        loop--;
                    }
                } else if (input == prev) {

                } else if (input > prev) {
                    int loop = input - prev;
                    while (loop > 0) {
                        sOutput += "(";
                        loop--;
                    }

                }
                sOutput += "" + input;
                prev = input;
            }
            for (int i = 0; i < input; i++) {
                sOutput += ")";
            }
            out.printLine("Case #" + testNumber + ": " + sOutput);
            
            
            
            
            ///////////////////////////////
//            char[] a = new char[n.length()];
//            char[] b = new char[n.length()];
//            for (int i = 0; i < n.length(); i++) {
//                
//                if (n.charAt(i) == '4') {
//                    a[i] = '2';
//                    b[i] = '2';
//                } else {
//                    a[i] = n.charAt(i);
//                    b[i] = '0';
//                }
//            }
//            out.printLine("Case #" + testNumber + ":", new BigInteger(new String(a)), new BigInteger(new String(b)));
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

