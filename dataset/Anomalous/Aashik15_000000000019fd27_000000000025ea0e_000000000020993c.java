import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            // Reading matrix and calculating trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            // Checking for duplicate rows
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            
            // Checking for duplicate columns
            for (int j = 0; j < matrixSize; j++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (seen[matrix[i][j]]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
            testCases--;
        }
        
        scanner.close();
    }
}