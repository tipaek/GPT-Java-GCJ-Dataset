import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][][] matrices = new int[testCases][][];
        
        // Read input matrices
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            matrices[t] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrices[t][i][j] = scanner.nextInt();
                }
            }
        }
        
        // Process each matrix
        for (int t = 0; t < testCases; t++) {
            int trace = calculateTrace(matrices[t]);
            int rowDuplicates = countDuplicateRows(matrices[t]);
            int[][] transposedMatrix = transposeMatrix(matrices[t]);
            int columnDuplicates = countDuplicateRows(transposedMatrix);
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
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
    
    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }
    
    private static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
}