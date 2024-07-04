import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        
        while (numberOfTestCases-- > 0) {
            solveTestCase();
        }
    }
    
    private static void solveTestCase() {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        
        int diagonalSum = 0;
        
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }
        
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);
        
        System.out.println("Case #" + (testCaseNumber++) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
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