import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class Solution {

    private static final String FILE_LOCATION = "src/in/";
    private static final String[] FILE_NAMES = {"test1"};
    private static int currentFile = 0;
    private static Matrix[] matrices;
    private static int testCases, matrixSize;

    static class Matrix {
        private final int[][] elements;
        private final int size;

        public Matrix(int size) {
            this.size = size;
            this.elements = new int[size][size];
        }

        public void putElement(int row, int column, int value) {
            elements[row][column] = value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int[] row : elements) {
                for (int element : row) {
                    builder.append(element).append(" ");
                }
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        start();
    }

    private static void start() throws Exception {
        long startTime = System.currentTimeMillis();
        readData(false);
        solve();
    }

    private static void solve() {
        for (int i = 0; i < testCases; i++) {
            solveMatrix(i);
        }
    }

    private static void solveMatrix(int matrixId) {
        Matrix matrix = matrices[matrixId];
        int trace = 0;

        for (int i = 0; i < matrix.size; i++) {
            trace += matrix.elements[i][i];
        }

        int incorrectRows = 0;
        int incorrectCols = 0;
        for (int i = 0; i < matrix.size; i++) {
            Set<Integer> rowSet = new HashSet<>(matrix.size);
            Set<Integer> colSet = new HashSet<>(matrix.size);
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;
            for (int j = 0; j < matrix.size; j++) {
                if (!rowHasDuplicate && !rowSet.add(matrix.elements[i][j])) {
                    incorrectRows++;
                    rowHasDuplicate = true;
                }
                if (!colHasDuplicate && !colSet.add(matrix.elements[j][i])) {
                    incorrectCols++;
                    colHasDuplicate = true;
                }
            }
        }
        printCase(matrixId + 1, trace, incorrectRows, incorrectCols);
    }

    private static void printCase(int caseNumber, int trace, int incorrectRows, int incorrectCols) {
        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, incorrectRows, incorrectCols);
    }

    private static void readData(boolean isLocal) throws Exception {
        InputReader inputReader = new InputReader(isLocal ? new FileInputStream(FILE_LOCATION + FILE_NAMES[currentFile] + ".in") : System.in);
        testCases = inputReader.readInt();
        matrices = new Matrix[testCases];

        for (int s = 0; s < testCases; s++) {
            matrixSize = inputReader.readInt();
            Matrix matrix = new Matrix(matrixSize);
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix.putElement(i, j, inputReader.readInt());
                }
            }
            matrices[s] = matrix;
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

        public int readInt() {
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public void close() {
            try {
                stream.close();
            } catch (IOException e) {
                System.err.println("Failed to close stream");
            }
        }
    }
}