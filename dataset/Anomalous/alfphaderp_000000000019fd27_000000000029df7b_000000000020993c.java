import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCases;
    private static int matrixSize;
    private static int[][] matrix;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            readInput();
            String result = calculateTrace() + " " + countRepeatedRows() + " " + countRepeatedColumns();
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }

    private static void readInput() {
        matrixSize = scanner.nextInt();
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows() {
        int repeatedRowCount = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < matrixSize) {
                repeatedRowCount++;
            }
        }
        return repeatedRowCount;
    }

    private static int countRepeatedColumns() {
        int repeatedColumnCount = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < matrixSize) {
                repeatedColumnCount++;
            }
        }
        return repeatedColumnCount;
    }
}