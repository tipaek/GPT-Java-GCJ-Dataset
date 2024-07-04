import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int diagonalSum = 0;
            int matrixSize = scanner.nextInt();
            
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }
            
            // Check for duplicate elements in each row
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }
            
            // Check for duplicate elements in each column
            for (int i = 0; i < matrixSize; i++) {
                boolean[] colCheck = new boolean[101];
                for (int j = 0; j < matrixSize; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }
            
            System.out.println("Case #" + (testCase + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}