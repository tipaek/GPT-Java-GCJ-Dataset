import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(matrixSize, scanner);
            int trace = calculateTrace(matrix, matrixSize);
            int rowRepeats = countRowRepeats(matrix, matrixSize);
            int columnRepeats = countColumnRepeats(matrix, matrixSize);
            printResult(testCase, trace, rowRepeats, columnRepeats);
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        int repeats = 0;
        Set<Integer> expectedNumbers = createNumberSet(size);

        for (int i = 0; i < size; i++) {
            Set<Integer> rowNumbers = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowNumbers.add(matrix[i][j]);
            }
            if (!rowNumbers.equals(expectedNumbers)) {
                repeats++;
            }
        }
        return repeats;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int repeats = 0;
        Set<Integer> expectedNumbers = createNumberSet(size);

        for (int i = 0; i < size; i++) {
            Set<Integer> columnNumbers = new HashSet<>();
            for (int j = 0; j < size; j++) {
                columnNumbers.add(matrix[j][i]);
            }
            if (!columnNumbers.equals(expectedNumbers)) {
                repeats++;
            }
        }
        return repeats;
    }

    private static Set<Integer> createNumberSet(int size) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static void printResult(int testCase, int trace, int rowRepeats, int columnRepeats) {
        System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
    }
}