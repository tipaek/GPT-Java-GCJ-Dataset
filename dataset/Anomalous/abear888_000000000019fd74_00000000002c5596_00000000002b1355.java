import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            long[][] matrix = new long[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextLong();
                }
            }
            
            long totalSum = 0;
            boolean isStable = false;
            
            while (!isStable) {
                isStable = true;
                long[][] newMatrix = new long[rows][cols];
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        long sumNeighbors = 0;
                        int neighborCount = 0;
                        
                        // Check left neighbor
                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] != 0) {
                                sumNeighbors += matrix[i][k];
                                neighborCount++;
                                break;
                            }
                        }
                        
                        // Check right neighbor
                        for (int k = j + 1; k < cols; k++) {
                            if (matrix[i][k] != 0) {
                                sumNeighbors += matrix[i][k];
                                neighborCount++;
                                break;
                            }
                        }
                        
                        // Check top neighbor
                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] != 0) {
                                sumNeighbors += matrix[k][j];
                                neighborCount++;
                                break;
                            }
                        }
                        
                        // Check bottom neighbor
                        for (int k = i + 1; k < rows; k++) {
                            if (matrix[k][j] != 0) {
                                sumNeighbors += matrix[k][j];
                                neighborCount++;
                                break;
                            }
                        }
                        
                        if (neighborCount > 0 && (double) sumNeighbors / neighborCount <= matrix[i][j]) {
                            newMatrix[i][j] = matrix[i][j];
                            totalSum += matrix[i][j];
                        } else {
                            isStable = false;
                        }
                    }
                }
                
                matrix = newMatrix;
            }
        }
    }
}