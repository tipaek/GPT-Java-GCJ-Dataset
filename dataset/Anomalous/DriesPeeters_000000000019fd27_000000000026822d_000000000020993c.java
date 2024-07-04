package com.dpeeters;

import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class Main {

    private static final String FILE_LOCATION = "src/in/";
    private static final String[] FILE_NAMES = {"test1"};
    private static int currentFileIndex = 0;
    private static Matrix[] matrices;
    private static int testCaseCount;

    public static void main(String[] args) throws Exception {
        startProcessing();
    }

    private static void startProcessing() throws Exception {
        System.err.println("Start solving " + FILE_NAMES[currentFileIndex]);
        long startTime = System.currentTimeMillis();

        readData(false);
        solveMatrices();
    }

    private static void solveMatrices() {
        for (int i = 0; i < testCaseCount; i++) {
            solveMatrix(i);
        }
    }

    private static void solveMatrix(int matrixIndex) {
        Matrix matrix = matrices[matrixIndex];
        int trace = calculateTrace(matrix);
        int incorrectRows = calculateIncorrectRows(matrix);
        int incorrectCols = calculateIncorrectColumns(matrix);

        printResult(matrixIndex + 1, trace, incorrectRows, incorrectCols);
    }

    private static int calculateTrace(Matrix matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.size; i++) {
            trace += matrix.elements[i][i];
        }
        return trace;
    }

    private static int calculateIncorrectRows(Matrix matrix) {
        int incorrectRows = 0;
        for (int i = 0; i < matrix.size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix.size; j++) {
                if (!rowSet.add(matrix.elements[i][j])) {
                    incorrectRows++;
                    break;
                }
            }
        }
        return incorrectRows;
    }

    private static int calculateIncorrectColumns(Matrix matrix) {
        int incorrectCols = 0;
        for (int i = 0; i < matrix.size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix.size; j++) {
                if (!colSet.add(matrix.elements[j][i])) {
                    incorrectCols++;
                    break;
                }
            }
        }
        return incorrectCols;
    }

    private static void printResult(int caseNumber, int trace, int incorrectRows, int incorrectCols) {
        System.out.println("Case #" + caseNumber + ": " + trace + " " + incorrectRows + " " + incorrectCols);
    }

    private static void readData(boolean isLocal) throws Exception {
        InputStream inputStream = isLocal ? new FileInputStream(FILE_LOCATION + FILE_NAMES[currentFileIndex] + ".in") : System.in;
        InputReader inputReader = new InputReader(inputStream);

        testCaseCount = inputReader.readInt();
        matrices = new Matrix[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            int matrixSize = inputReader.readInt();
            Matrix matrix = new Matrix(matrixSize);

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix.putElement(row, col, inputReader.readInt());
                }
            }
            matrices[i] = matrix;
        }
    }

    static class Matrix {
        public int[][] elements;
        public int size;

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

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
                result = result * 10 + c - '0';
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