import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.String.format;

public class Solution {

    public static void main(String[] args) {
        Scanner in = newScanner();
        PrintStream out = System.out;

        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            Input input = readTestCase(in, t);
            Output output = solve(input);
            printOutput(out, output);
        }
    }

    private static Output solve(Input input) {
        int trace = calculateTrace(input.getMatrixSize(), input.getMatrix());
        int ambiguousRowCount = calculateAmbiguousRows(input.getMatrixSize(), input.getMatrix());
        int ambiguousColumnCount = calculateAmbiguousColumns(input.getMatrixSize(), input.getMatrix());

        return new Output(input.getTestCase(), trace, ambiguousRowCount, ambiguousColumnCount);
    }

    private static int calculateAmbiguousRows(int matrixSize, int[][] matrix) {
        int result = 0;
        for (int r = 0; r < matrixSize; r++) {
            boolean ambiguous = rowContainsDuplicates(matrix, matrixSize, r);
            if (ambiguous) {
                result++;
            }
        }
        return result;
    }

    private static boolean rowContainsDuplicates(int[][] matrix, int matrixSize, int r) {
        Set<Integer> elements = new HashSet<>();
        for (int c = 0; c < matrixSize; c++) {
            int element = matrix[r][c];
            if (elements.contains(element)) {
                return true;
            }
            elements.add(element);
        }
        return false;
    }

    private static int calculateAmbiguousColumns(int matrixSize, int[][] matrix) {
        int result = 0;
        for (int c = 0; c < matrixSize; c++) {
            boolean ambiguous = columnContainsDuplicates(matrix, matrixSize, c);
            if (ambiguous) {
                result++;
            }
        }
        return result;
    }

    private static boolean columnContainsDuplicates(int[][] matrix, int matrixSize, int c) {
        Set<Integer> elements = new HashSet<>();
        for (int r = 0; r < matrixSize; r++) {
            int element = matrix[r][c];
            if (elements.contains(element)) {
                return true;
            }
            elements.add(element);
        }
        return false;
    }

    private static int calculateTrace(int matrixSize, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }


    private static Scanner newScanner() {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static Input readTestCase(Scanner in, int t) {
        int size = in.nextInt();
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                matrix[row][column] = in.nextInt();
            }
        }
        return new Input(t, size, matrix);
    }

    private static void printOutput(PrintStream out, Output output) {
        String outputString = format("Case #%s: %s %s %s",
                output.getTestCase(),
                output.getTrace(),
                output.getRows(),
                output.getColumns());

        out.println(outputString);
    }

    private static class Input {

        private final int testCase;
        private final int matrixSize;
        private final int[][] matrix;

        private Input(int testCase, int matrixSize, int[][] matrix) {
            this.testCase = testCase;
            this.matrixSize = matrixSize;
            this.matrix = matrix;
        }

        public int getTestCase() {
            return testCase;
        }

        public int getMatrixSize() {
            return matrixSize;
        }

        public int[][] getMatrix() {
            return matrix;
        }
    }

    private static class Output {

        private final int testCase;
        private final int trace;
        private final int rows;
        private final int columns;

        private Output(int testCase, int trace, int rows, int columns) {
            this.testCase = testCase;
            this.trace = trace;
            this.rows = rows;
            this.columns = columns;
        }

        public int getTestCase() {
            return testCase;
        }

        public int getTrace() {
            return trace;
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
    }
}
