import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            // Calculate diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            
            // Check for duplicate rows
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }
            
            // Check for duplicate columns
            for (int j = 0; j < matrixSize; j++) {
                int[] column = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}