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
            Set<Integer> uniqueValues = new HashSet<>(matrixSize);
            int[][] array = new int[matrixSize][matrixSize];
            
            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            
            // Calculate the sum of the diagonal
            for (int i = 0; i < matrixSize; i++) {
                sum += array[i][i];
            }
            
            int rowDuplicates = 0; 
            // Check for duplicate values in each row
            for (int i = 0; i < matrixSize; i++) {   
                for (int j = 0; j < matrixSize; j++) { 
                    if (!uniqueValues.add(array[i][j])) {
                        rowDuplicates++;
                        uniqueValues.clear();
                        break;
                    }
                }
                uniqueValues.clear();
            }
            
            int columnDuplicates = 0; 
            // Check for duplicate values in each column
            for (int i = 0; i < matrixSize; i++) {   
                for (int j = 0; j < matrixSize; j++) { 
                    if (!uniqueValues.add(array[j][i])) {
                        columnDuplicates++;
                        uniqueValues.clear();
                        break;
                    }
                }
                uniqueValues.clear();
            }
            
            System.out.println("Case #" + (p + 1) + ": " + sum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}