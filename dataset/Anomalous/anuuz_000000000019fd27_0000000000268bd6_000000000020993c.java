import java.util.Scanner;
import java.util.Arrays;

public class MatrixTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][][] matrices = new int[testCases][][];
        
        // Read input matrices
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            matrices[t] = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrices[t][i][j] = scanner.nextInt();
                }
            }
        }
        
        // Process each matrix
        for (int t = 0; t < testCases; t++) {
            int trace = calculateTrace(matrices[t]);
            int rowDuplicates = countDuplicatesInRows(matrices[t]);
            int colDuplicates = countDuplicatesInRows(transposeMatrix(matrices[t]));
            
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, rowDuplicates, colDuplicates);
        }
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int[][] transposeMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] transposed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
    
    private static int countDuplicatesInRows(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < row.length - 1; j++) {
                if (row[j] == row[j + 1]) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }
}