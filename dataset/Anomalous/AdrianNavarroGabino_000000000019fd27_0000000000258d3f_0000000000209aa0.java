import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int desiredTrace = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[] auxiliaryArray = new int[matrixSize];
            boolean isSolutionFound = false;
            
            for (int i = 0; i < matrixSize; i++) {
                auxiliaryArray[i] = matrixSize - i;
            }
            
            for (int i = 0; i < matrixSize; i++) {
                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = auxiliaryArray[(i + col + row) % matrixSize];
                    }
                }
                
                int currentTrace = 0;
                for (int j = 0; j < matrixSize; j++) {
                    currentTrace += matrix[j][j];
                }
                
                if (currentTrace == desiredTrace) {
                    isSolutionFound = true;
                    break;
                }
            }
            
            if (isSolutionFound) {
                System.out.println("Case #" + caseIndex + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int col = 0; col < matrixSize; col++) {
                        System.out.print(row[col] + (col == matrixSize - 1 ? "\n" : " "));
                    }
                }
            } else {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}