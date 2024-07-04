import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMatrices = scanner.nextInt();
        
        for (int i = 0; i < numMatrices; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            // Calculate the trace of the matrix
            int trace = 0;
            for (int l = 0; l < n; l++) {
                trace += matrix[l][l];
            }
            
            // Count repeated rows
            int rowCount = 0;
            for (int l = 0; l < n; l++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[l][k])) {
                        rowCount++;
                        break;
                    }
                }
            }
            
            // Count repeated columns
            int colCount = 0;
            for (int l = 0; l < n; l++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(matrix[k][l])) {
                        colCount++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        scanner.close();
    }
}