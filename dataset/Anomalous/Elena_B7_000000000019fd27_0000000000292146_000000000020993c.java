import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task1 {

    private static Scanner scanner;

    public static void main(String[] args) {
        InputStream inputSource = System.in;
        /*
        try (InputStream inputSource = getFileInputStream()) {
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

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void handleTestCase(int testId) {
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        }

        // displayMatrix(matrix);
        int traceValue = calculateTrace(matrix);
        // System.out.println("trace=" + traceValue);

        int rowsWithDuplicates = 0;
        int columnsWithDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            if (hasDuplicates(matrix[i])) {
                rowsWithDuplicates++;
            }

            int[] column = new int[matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                columnsWithDuplicates++;
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", testId, traceValue, rowsWithDuplicates, columnsWithDuplicates);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }

    private static InputStream getFileInputStream() throws IOException {
        File inputFile = new File("src/input.txt");
        return new FileInputStream(inputFile);
    }
}