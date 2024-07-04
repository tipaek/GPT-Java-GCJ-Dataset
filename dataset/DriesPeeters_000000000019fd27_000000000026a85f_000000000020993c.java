import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class Solution {

    private static final String fileLoc = "src/in/";
    private static final String[] fileNames = new String[]{"test1"};

    static class Matrix {
        public int[][] elements;
        public int size;

        public Matrix(int size) {
            this.size = size;
            elements = new int[size][size];
        }

        public void putElement(int row, int column, int value) {
            elements[row][column] = value;
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    b.append(elements[i][j]).append(" ");
                }
                b.append("\n");
            }
            return b.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        curFile = 0; // current file to scan
        start();
    }

    static int curFile = 0;
    static Matrix[] matrices;
    static int T, N, C;

    static void start() throws Exception {
        final long startTime = System.currentTimeMillis();
        // READ
        readData(false);
        solve();
    }

    private static void solve() {
        for (int i = 0; i < T; i++) {
            solveMatrix(i);
        }
    }

    private static void solveMatrix(int matrixId) {
        Matrix matrix = matrices[matrixId];
        int trace = 0;

        for (int i = 0; i < matrix.size; i++) {
            trace += matrix.elements[i][i];
        }

        // calculate rows having repeated elements
        int incorrectRows = 0;
        int incorrectCols = 0;
        for (int i = 0; i < matrix.size; i++) {
            Set<Integer> rowSet = new HashSet<>(matrix.size);
            Set<Integer> colSet = new HashSet<>(matrix.size);
            boolean canSkipRow = false;
            boolean canSkipCol = false;
            for (int j = 0; j < matrix.size; j++) {
                if (!canSkipRow && !rowSet.add(matrix.elements[i][j])) {
                    ++incorrectRows;
                    canSkipRow = true;
                }
                if (!canSkipCol && !colSet.add(matrix.elements[j][i])) {
                    ++incorrectCols;
                    canSkipCol = true;
                }
            }
        }
        printCase(matrixId + 1, trace, incorrectRows, incorrectCols);
    }

    private static void printCase(int caseNr, int trace, int incorrectRows, int incorrectCols) {
        System.out.println("Case #" + caseNr + ": " + trace + " " + incorrectRows + " " + incorrectCols);
    }

    private static void readData(boolean isLocal) throws Exception {
        final InputReader in = new InputReader(isLocal ? (new FileInputStream((fileLoc + fileNames[curFile] + ".in"))) : System.in);
        T = in.readInt(); // number of test cases
        matrices = new Matrix[T];

        for (int s = 0; s < T; s++) {
            N = in.readInt(); // size of the matrix
            Matrix m = new Matrix(N);
            for (int i = 0; i < N; i++) {
                //String line = in.readLine();
                //int maxJ = line.split(" ").length;
                for (int j = 0; j < N; j++) {
                    m.putElement(i, j, in.readInt());
                }
            }
            matrices[s] = m;
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
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public char readChar() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                stream.close();
            } catch (Exception ex) {
                System.err.println("failed to close stream");
            }
        }
    }
}
