import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        String[] results = new String[numberOfTests];
        
        for (int test = 0; test < numberOfTests; test++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            scanner.nextLine();
            
            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
            
            int traceValue = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);
            results[test] = String.format("Case %d: %d %d %d", test + 1, traceValue, duplicateRows, duplicateColumns);
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        int matrixSize = matrix.length;
        
        for (int col = 0; col < matrixSize; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrixSize; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
    }
}