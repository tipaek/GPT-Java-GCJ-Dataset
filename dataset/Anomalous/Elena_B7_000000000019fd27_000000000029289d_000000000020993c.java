import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        InputStream inputSource = System.in;
        // Uncomment the following lines to read input from a file
        /*
        try (InputStream inputSource = getInputFromFile()) {
            processInput(inputSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private static void processInput(InputStream inputSource) {
        scanner = new Scanner(inputSource);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfTestCases; i++) {
            processTestCase(i);
        }
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void processTestCase(int testCaseId) {
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int traceValue = calculateTrace(matrix);

        int duplicateRows = 0;
        int duplicateColumns = 0;

        boolean[] rowCheck = new boolean[matrixSize];
        boolean[] columnCheck = new boolean[matrixSize];
        boolean hasDuplicateRow = false;
        boolean hasDuplicateColumn = false;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (rowCheck[matrix[i][j] - 1]) {
                    hasDuplicateRow = true;
                }
                rowCheck[matrix[i][j] - 1] = true;

                if (columnCheck[matrix[j][i] - 1]) {
                    hasDuplicateColumn = true;
                }
                columnCheck[matrix[j][i] - 1] = true;
            }
            if (hasDuplicateRow) duplicateRows++;
            if (hasDuplicateColumn) duplicateColumns++;

            Arrays.fill(rowCheck, false);
            Arrays.fill(columnCheck, false);
            hasDuplicateRow = false;
            hasDuplicateColumn = false;
        }

        System.out.printf("Case #%d: %d %d %d\n", testCaseId, traceValue, duplicateRows, duplicateColumns);
    }

    private static InputStream getInputFromFile() throws IOException {
        File inputFile = new File("src/input.txt");
        return new FileInputStream(inputFile);
    }
}