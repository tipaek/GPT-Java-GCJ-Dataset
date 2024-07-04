import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int p = 0; p < T; p++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] matrix = new int[rows][cols];
            int sum = 0;
            int maxValue = 0;
            
            // Read matrix values
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            if (rows == 1 && cols == 1) {
                sum += matrix[0][0];
            } else if (rows == 1) {
                for (int k = 1; k <= cols; k++) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            sum += matrix[i][j];
                            if (matrix[i][j] == k) {
                                matrix[i][j] = 0;
                            }
                        }
                    }
                }
            } else {
                // Find the maximum value in the matrix
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (maxValue <= matrix[i][j]) {
                            maxValue = matrix[i][j];
                        }
                    }
                }
                
                // Process the matrix based on the maximum value
                for (int k = 1; k <= maxValue; k++) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            sum += matrix[i][j];
                            if (matrix[i][j] != maxValue) {
                                matrix[i][j] = 0;
                            }
                        }
                    }
                }
                sum += 4;
            }
            
            System.out.println("Case #" + (p + 1) + ": " + sum);
        }
        sc.close();
    }
}