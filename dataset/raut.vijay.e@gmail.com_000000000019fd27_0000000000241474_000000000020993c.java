import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class TestCaseInput {
        private final int trace;
        private final int rowRepetitions;
        private final int colRepetitions;

        public TestCaseInput(final int trace, final int rowRepetitions, final int colRepetitions) {
            this.trace = trace;
            this.rowRepetitions = rowRepetitions;
            this.colRepetitions = colRepetitions;
        }
    }

    public static void main(final String[] args) {
        final List<TestCaseInput> testCases = parseInput();
        int testCase = 1;
        for (final TestCaseInput entry : testCases) {
            final String outputMessage =
                String.format("Case #%d: %d %d %d", testCase, entry.trace, entry.rowRepetitions, entry.colRepetitions);
            System.out.println(outputMessage);
            testCase++;
        }
    }

    private static List<TestCaseInput> parseInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            String readLine = scanner.nextLine();
            final int numTestCases = Integer.parseInt(readLine);

            final List<TestCaseInput> testCases = new ArrayList<>(numTestCases);
            for (int index = 0; index < numTestCases && null != (readLine = scanner.nextLine()); index++) {

                final int matrixSize = Integer.parseInt(readLine);

                final int[][] rowRepetition = new int[matrixSize][matrixSize + 1];
                final int[][] colRepetition = new int[matrixSize][matrixSize + 1];

                int trace = 0;
                int maxRowRepetitions = 0;
                int maxColRepetitions = 0;

                for (int row = 0; row < matrixSize; row++) {
                    readLine = scanner.nextLine();
                    final String[] inputs = readLine.split("\\s+");
                    for (int col = 0; col < matrixSize; col++) {
                        final int value = Integer.parseInt(inputs[col]);
                        if (row == col) {
                            trace += value;
                        }

                        rowRepetition[row][value]++;
                        if (maxRowRepetitions < rowRepetition[row][value]) {
                            maxRowRepetitions = rowRepetition[row][value];
                        }

                        colRepetition[col][value]++;
                        if (maxColRepetitions < colRepetition[col][value]) {
                            maxColRepetitions = colRepetition[col][value];
                        }
                    }
                }
                if (maxRowRepetitions == 1) {
                    maxRowRepetitions = 0;
                }
                if (maxColRepetitions == 1) {
                    maxColRepetitions = 0;
                }

                testCases.add(new TestCaseInput(trace, maxRowRepetitions, maxColRepetitions));
            }

            return testCases;
        }
    }
}
