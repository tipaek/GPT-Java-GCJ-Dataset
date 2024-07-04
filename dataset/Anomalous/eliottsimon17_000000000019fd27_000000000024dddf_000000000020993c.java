import java.io.*;
import java.util.InputMismatchException;

public class JAM {
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
            
            int trace = calculateTrace(matrix);
            int r = countDuplicateRows(matrix);
            int c = countDuplicateColumns(matrix);
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + r + " " + c);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int counter = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                counter++;
            }
        }
        return counter;
    }

    private static int countDuplicateColumns(int[][] matrix) {
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }
}