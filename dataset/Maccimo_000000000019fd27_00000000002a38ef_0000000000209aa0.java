/*
 * @author Maccimo
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private final Scanner input;
    private final PrintStream output;

    private static final String NEW_LINE = "\n";
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private String solveCase() {
        int size = input.nextInt(); // N
        int desiredTrace = input.nextInt(); // K

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 1 + ((i + j) % size);
            }
        }

        for (int base = 0; base < size; base++) {
            int trace = 0;
            for (int i = 0; i < size; i++) {
                int rebasedColumn = (base + i) % size;

                trace += matrix[i][rebasedColumn];
            }

            if (trace == desiredTrace) {
                return formatPossible(matrix, size, base);
            }
        }

        return IMPOSSIBLE;
    }

    private String formatPossible(int[][] matrix, int size, int base) {
        StringBuilder builder = new StringBuilder();

        builder
            .append(POSSIBLE)
            .append(NEW_LINE);

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int rebasedColumn = (base + column) % size;

                builder.append(matrix[row][rebasedColumn]);

                if (column < size - 1) {
                    builder.append(" ");
                }
            }
            if (row < size - 1) {
                builder.append(NEW_LINE);
            }
        }

        return builder.toString();
    }

    private void invoke() {
        int caseCount = input.nextInt();

        String rest = input.nextLine();

        assert rest.length() == 0 : rest;

        String result;
        for (int caseNumber = 1; caseNumber <= caseCount; caseNumber++) {
            result = solveCase();
            output.printf("Case #%d: %s\n", caseNumber, result);
        }
    }

    private Solution(InputStream input, PrintStream output) {
        this.input = new Scanner(input);
        this.output = output;
    }

    public static void main(String... args) throws FileNotFoundException {

        InputStream inputStream;
        PrintStream outputStream;

        if (args.length > 0) {

            final String inputFileName = args[0];
            final String outputFileName;

            if (inputFileName.endsWith(".in")) {
                outputFileName = inputFileName.substring(0, inputFileName.length() - 3) + ".out";
            } else {
                outputFileName = inputFileName + ".out";
            }

            inputStream = new FileInputStream(inputFileName);
            outputStream = new PrintStream(outputFileName);

        } else {
            inputStream = System.in;
            outputStream = System.out;
        }

        Solution instance = new Solution(inputStream, outputStream);

        instance.invoke();
    }

}
