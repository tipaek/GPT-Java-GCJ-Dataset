import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int duplicateRows = calculateDuplicateRows(matrix, matrixSize);
            int duplicateColumns = calculateDuplicateColumns(matrix, matrixSize);
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int calculateDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}