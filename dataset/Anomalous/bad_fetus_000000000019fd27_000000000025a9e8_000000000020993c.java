import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer> uniqueElements = new HashSet<>();
            
            // Read matrix and calculate trace and row duplicates
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                uniqueElements.clear();
                String[] rowValues = scanner.nextLine().split("\\s+");
                boolean hasRowDuplicate = false;
                
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    int value = Integer.parseInt(rowValues[colIndex]);
                    matrix[rowIndex][colIndex] = value;
                    
                    if (!uniqueElements.add(value)) {
                        hasRowDuplicate = true;
                    }
                    
                    if (rowIndex == colIndex) {
                        trace += value;
                    }
                }
                
                if (hasRowDuplicate) {
                    rowDuplicates++;
                }
            }
            
            // Calculate column duplicates
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                uniqueElements.clear();
                
                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    if (!uniqueElements.add(matrix[rowIndex][colIndex])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (testIndex + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}