import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Solution {   
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int p = 0; p < T; p++) {  
            int sum = 0;
            int matrixSize = sc.nextInt();
            Set<Integer> uniqueElements = new HashSet<>(matrixSize);
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading matrix elements
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculating the sum of the diagonal elements
            for (int i = 0; i < matrixSize; i++) {
                sum += matrix[i][i];
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            // Checking for duplicate elements in rows
            for (int i = 0; i < matrixSize; i++) {   
                for (int j = 0; j < matrixSize; j++) { 
                    if (!uniqueElements.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
                uniqueElements.clear();
            }
            
            // Checking for duplicate elements in columns
            for (int j = 0; j < matrixSize; j++) {   
                for (int i = 0; i < matrixSize; i++) { 
                    if (!uniqueElements.add(matrix[i][j])) {
                        duplicateCols++;
                        break;
                    }
                }
                uniqueElements.clear();
            }
            
            System.out.println("Case #" + (p + 1) + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }
        
        sc.close();
    }
}