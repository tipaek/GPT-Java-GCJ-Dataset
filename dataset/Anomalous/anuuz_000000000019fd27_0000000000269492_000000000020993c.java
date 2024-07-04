import java.util.Scanner;
import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][][] matrices = new int[t][][];
        
        // Read input matrices
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            matrices[k] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrices[k][i][j] = sc.nextInt();
                }
            }
        }
        
        // Process each matrix
        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ":");
            int trace = calculateTrace(matrices[i]);
            System.out.print(" " + trace);
            
            int[][] transposedMatrix = transpose(matrices[i]);
            int rowDuplicates = countDuplicateRows(matrices[i]);
            int colDuplicates = countDuplicateRows(transposedMatrix);
            
            System.out.print(" " + rowDuplicates);
            System.out.println(" " + colDuplicates);
        }
    }
    
    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }
    
    public static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < row.length - 1; j++) {
                if (row[j] == row[j + 1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}