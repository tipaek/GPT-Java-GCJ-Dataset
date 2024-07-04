import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            execute(scanner);
        }
    }

    private static void execute(Scanner scanner) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            new Solution(scanner).processCase(caseNumber);
        }
    }

    private Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    private void processCase(int caseNumber) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0, rowRepeats = 0, columnRepeats = 0;

        for (int i = 0; i < matrixSize; i++) {
            boolean[] rowChecker = new boolean[matrixSize + 1];
            boolean rowIsValid = true;
            for (int j = 0; j < matrixSize; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                if (i == j) {
                    trace += value;
                }
                if (rowChecker[value]) {
                    rowIsValid = false;
                }
                rowChecker[value] = true;
            }
            if (!rowIsValid) {
                rowRepeats++;
            }
        }

        for (int j = 0; j < matrixSize; j++) {
            boolean[] columnChecker = new boolean[matrixSize + 1];
            boolean columnIsValid = true;
            for (int i = 0; i < matrixSize; i++) {
                int value = matrix[i][j];
                if (columnChecker[value]) {
                    columnIsValid = false;
                }
                columnChecker[value] = true;
            }
            if (!columnIsValid) {
                columnRepeats++;
            }
        }

        printResult(String.format("Case #%d: %d %d %d", caseNumber, trace, rowRepeats, columnRepeats));
    }

    private static void printResult(String result) {
        System.out.println(result);
        System.out.flush();
    }
}