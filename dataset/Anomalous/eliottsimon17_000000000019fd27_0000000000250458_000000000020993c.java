import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    private static int matrixDimension;
    private static int[][] matrix;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
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
            int r = getRowDuplicates(matrix);
            int c = getColumnDuplicates(matrix);
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + r + " " + c);
        }
    }

    public static int getTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int getRowDuplicates(int[][] matrix) {
        int counter = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                counter++;
            }
        }
        return counter;
    }

    public static int getColumnDuplicates(int[][] matrix) {
        int counter = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
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

    private static class InputReader {
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