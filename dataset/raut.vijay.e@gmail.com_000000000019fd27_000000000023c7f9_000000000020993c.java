import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vestigium {

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

    public static void main(final String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("No input provided.");
            return;
        }

        final String fileName = args[0];
        final File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Failed to find the file by name: " + fileName);
            return;
        }

        final List<TestCaseInput> testCases = parseInput(file);
        int testCase = 1;
        for (final TestCaseInput entry : testCases) {
            final String outputMessage = String.format("Case #%d: %d %d %d%n", testCase, entry.trace,
                entry.rowRepetitions, entry.colRepetitions);
            System.out.print(outputMessage);
            testCase++;
        }
    }

    private static List<TestCaseInput> parseInput(final File file) throws IOException {
        try (final BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String readLine = fileReader.readLine();
            final int numTestCases = Integer.parseInt(readLine);

            final List<TestCaseInput> testCases = new ArrayList<>(numTestCases);
            for (int index = 0; index < numTestCases && null != (readLine = fileReader.readLine()); index++) {

                final int matrixSize = Integer.parseInt(readLine);

                final int[][] rowRepetition = new int[matrixSize][matrixSize + 1];
                final int[][] colRepetition = new int[matrixSize][matrixSize + 1];

                int trace = 0;
                int maxRowRepetitions = 0;
                int maxColRepetitions = 0;

                for (int row = 0; row < matrixSize; row++) {
                    readLine = fileReader.readLine();
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
