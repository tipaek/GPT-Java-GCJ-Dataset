import java.io.*;
import java.util.InputMismatchException;

public class JAM {
    private static int matrixDimension;
    private static int[][] matrix;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        int testCount = Integer.parseInt(in.next());

        for (int i = 0; i < testCount; i++) {
            if (i == 0) {
                in.next();
            }
            matrixDimension = Integer.parseInt(in.next());
            in.next();

            matrix = new int[matrixDimension][matrixDimension];
            for (int j = 0; j < matrixDimension; j++) {
                for (int k = 0; k < matrixDimension; k++) {
                    matrix[j][k] = Integer.parseInt(in.next());
                }
                in.next();
            }

            int trace = getTrace(matrix);
            int r = getR(matrix);
            int c = getC(matrix);
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }

    public static int getTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int getR(int[][] matrix) {
        int counter = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                counter++;
            }
        }
        return counter;
    }

    public static int getC(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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
                res.appendCodePoint(c);
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
            boolean isSpaceChar(int ch);
        }
    }
}