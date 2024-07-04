import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        processInput(inputStream);

        // Uncomment the following block to read input from a file
        /*
        try (InputStream fileStream = getFileInputStream()) {
            processInput(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private static void processInput(InputStream inputStream) {
        scanner = new Scanner(inputStream);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfTestCases; i++) {
            handleTestCase(i);
        }
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void handleTestCase(int testCaseNumber) {
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        }

        int trace = calculateTrace(matrix);
        int duplicateRows = 0;
        int duplicateColumns = 0;

        boolean[] rowCheck = new boolean[matrixSize];
        boolean[] columnCheck = new boolean[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            boolean rowHasDuplicates = false;
            boolean columnHasDuplicates = false;

            Arrays.fill(rowCheck, false);
            Arrays.fill(columnCheck, false);

            for (int j = 0; j < matrixSize; j++) {
                if (rowCheck[matrix[i][j] - 1]) {
                    rowHasDuplicates = true;
                }
                rowCheck[matrix[i][j] - 1] = true;

                if (columnCheck[matrix[j][i] - 1]) {
                    columnHasDuplicates = true;
                }
                columnCheck[matrix[j][i] - 1] = true;
            }

            if (rowHasDuplicates) {
                duplicateRows++;
            }
            if (columnHasDuplicates) {
                duplicateColumns++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, duplicateRows, duplicateColumns);
    }

    private static InputStream getFileInputStream() throws IOException {
        File inputFile = new File("src/input.txt");
        return new FileInputStream(inputFile);
    }
}