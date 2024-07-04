import java.util.HashMap;
import java.util.Scanner;

public class JustAClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int badRowsCount = 0;
            int badColsCount = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Integer> rowElements = new HashMap<>();
                boolean hasDuplicateInRow = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    if (rowElements.put(matrix[i][j], 1) != null) {
                        hasDuplicateInRow = true;
                    }
                }
                
                if (hasDuplicateInRow) {
                    badRowsCount++;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                HashMap<Integer, Integer> colElements = new HashMap<>();
                boolean hasDuplicateInCol = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    if (colElements.put(matrix[i][j], 1) != null) {
                        hasDuplicateInCol = true;
                    }
                }
                
                if (hasDuplicateInCol) {
                    badColsCount++;
                }
            }
            
            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + badRowsCount + " " + badColsCount);
        }
        
        scanner.close();
    }
}