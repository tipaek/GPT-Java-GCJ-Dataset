import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            processVestigium(matrix, matrixSize, testCase);
        }
    }
    
    public static void processVestigium(int[][] matrix, int size, int testCase) {
        int rowDuplicates = 0;
        int colDuplicates = 0;
        int trace = 0;
        
        // Calculate the trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        
        // Check for row duplicates
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        
        // Check for column duplicates
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    colDuplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        
        System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}