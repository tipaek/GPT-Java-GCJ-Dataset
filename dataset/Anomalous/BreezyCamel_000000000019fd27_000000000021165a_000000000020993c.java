import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, OutputWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                int[][] matrix = new int[n][n];
                
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = in.nextInt();
                    }
                }
                
                int trace = 0;
                for (int j = 0; j < n; j++) {
                    trace += matrix[j][j];
                }

                int rowDuplicates = 0;
                for (int row = 0; row < n; row++) {
                    if (hasDuplicates(matrix[row])) {
                        rowDuplicates++;
                    }
                }

                int colDuplicates = 0;
                for (int col = 0; col < n; col++) {
                    if (hasDuplicates(getColumn(matrix, col))) {
                        colDuplicates++;
                    }
                }

                out.printf("Case #%d: %d %d %d\n", i, trace, rowDuplicates, colDuplicates);
            }
        }

        private boolean hasDuplicates(int[] array) {
            Set<Integer> set = new HashSet<>();
            for (int value : array) {
                if (!set.add(value)) {
                    return true;
                }
            }
            return false;
        }

        private int[] getColumn(int[][] matrix, int col) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            return column;
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1 << 16];
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
            result.appendCodePoint(c);
            while (!isSpaceChar(c = read())) {
                result.appendCodePoint(c);
            }
            return result.toString();
        }

        private static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void printf(String format, Object... args) {
            writer.printf(format, args);
        }

        public void close() {
            writer.close();
        }
    }
}