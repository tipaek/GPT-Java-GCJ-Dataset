import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i);
        }
    }

    public static void processTestCase(int testCaseNumber) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = readMatrix(matrixSize, matrixSize);

        int trace = calculateTrace(matrix, matrixSize);
        int rowRepeats = countRowRepeats(matrix, matrixSize);
        int columnRepeats = countColumnRepeats(matrix, matrixSize);

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, rowRepeats, columnRepeats);
    }

    private static int[][] readMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < size) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int columnRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < size) {
                columnRepeats++;
            }
        }
        return columnRepeats;
    }
}