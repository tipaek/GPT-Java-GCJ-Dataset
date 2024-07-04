/*
 * @author Maccimo
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private final Scanner input;
    private final PrintStream output;

    private String solveCase() {
        int N = input.nextInt();

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int trace = 0;
        int rows = 0;
        int columns = 0;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }


        BitSet bits = new BitSet(N + 1);

        for (int i = 0; i < N; i++) {
            bits.clear();
            for (int j = 0; j < N; j++) {
                int value = matrix[i][j];
                if (bits.get(value)) {
                    rows++;
                    break;
                } else {
                    bits.set(value);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bits.clear();
            for (int j = 0; j < N; j++) {
                int value = matrix[j][i];
                if (bits.get(value)) {
                    columns++;
                    break;
                } else {
                    bits.set(value);
                }
            }
        }

        return (trace + " " + rows + " " + columns);
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
