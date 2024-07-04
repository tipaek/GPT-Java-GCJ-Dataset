import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Solution {

    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        initialize();
        int testCases = in.readInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(testCase);
        }
        close();
    }

    private static void initialize() throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
//        in = new InputReader(new FileInputStream("grant.in"));
//        out = new PrintWriter("grant.out");
    }

    private static void processTestCase(int testCaseNumber) {
        int n = in.readInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.readInt();
            }
        }

        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) rowRepeats++;
            if (hasDuplicates(getColumn(matrix, i))) colRepeats++;
        }

        out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, rowRepeats, colRepeats);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) return true;
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    private static void close() throws IOException {
        out.flush();
        out.close();
        System.exit(0);
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}