import java.io.*;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Indicium solver = new Indicium();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k % n != 0) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + testNumber + ": POSSIBLE");
                int[] s = new int[n];
                for (int i = 0; i < n; i++) {
                    s[i] = i + 1;
                }

                while (true) {
                    s = shiftLeft(s, 1);
                    if (s[0] == k / n) break;
                }

                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    System.arraycopy(s, 0, matrix[i], 0, n);
                    s = shiftLeft(s, 1);
                }

                for (int[] row : matrix) {
                    for (int j = 0; j < n; j++) {
                        out.print(row[j]);
                        if (j < n - 1) out.print(" ");
                    }
                    out.println();
                }
            }
        }

        private int[] shiftLeft(int[] arr, int positions) {
            int[] result = new int[arr.length];
            System.arraycopy(arr, 0, result, 0, arr.length);
            for (int i = 0; i < positions; i++) {
                int temp = result[result.length - 1];
                System.arraycopy(result, 0, result, 1, result.length - 1);
                result[0] = temp;
            }
            return result;
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        private boolean isSpaceChar(int c) {
            return c < 33 || c > 126;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
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