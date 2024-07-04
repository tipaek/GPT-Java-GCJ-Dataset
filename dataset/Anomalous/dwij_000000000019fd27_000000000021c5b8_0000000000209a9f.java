import java.io.*;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            char[] inputChars = in.nextString().toCharArray();
            int[] digits = new int[inputChars.length];
            for (int i = 0; i < inputChars.length; i++) {
                digits[i] = inputChars[i] - '0';
            }

            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < digits[0]; i++) {
                result.append("(");
                openBrackets++;
            }
            result.append(digits[0]);

            for (int i = 1; i < digits.length; i++) {
                int diff = digits[i] - digits[i - 1];
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append("(");
                        openBrackets++;
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append(")");
                        openBrackets--;
                    }
                }
                result.append(digits[i]);
            }

            for (int i = 0; i < openBrackets; i++) {
                result.append(")");
            }

            out.println(String.format("Case #%d: %s", testNumber, result.toString()));
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String next() {
            return nextString();
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
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