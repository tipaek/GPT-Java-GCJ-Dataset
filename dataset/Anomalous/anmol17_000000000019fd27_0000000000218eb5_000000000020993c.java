import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 1; i <= testCases; i++) {
            solution.processTestCase(i, scanner);
        }
    }

    private void processTestCase(int caseNumber, Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = calculateTrace(matrix, matrixSize);
        int rowRepetitions = countRowsWithRepetitions(matrix, matrixSize);
        int columnRepetitions = countColumnsWithRepetitions(matrix, matrixSize);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepetitions, columnRepetitions);
    }

    private int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRowsWithRepetitions(int[][] matrix, int size) {
        int repetitionCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                repetitionCount++;
            }
        }
        return repetitionCount;
    }

    private int countColumnsWithRepetitions(int[][] matrix, int size) {
        int repetitionCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() != size) {
                repetitionCount++;
            }
        }
        return repetitionCount;
    }
}