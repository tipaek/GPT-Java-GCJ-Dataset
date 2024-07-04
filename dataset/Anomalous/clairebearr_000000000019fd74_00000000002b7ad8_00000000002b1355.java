import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            boolean continueProcess = true;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            int totalSum = 0;
            
            while (continueProcess) {
                int roundSum = 0;
                boolean changed = false;
                int[][] updatedMatrix = new int[rows][cols];
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] == -1) continue;
                        
                        roundSum += matrix[i][j];
                        int neighborCount = 0;
                        int neighborSum = 0;
                        
                        for (int direction = 0; direction < dx.length; direction++) {
                            int neighborX = i + dx[direction];
                            int neighborY = j + dy[direction];
                            
                            if (neighborX < 0 || neighborY < 0 || neighborX >= rows || neighborY >= cols || matrix[neighborX][neighborY] == -1) {
                                continue;
                            }
                            
                            neighborCount++;
                            neighborSum += matrix[neighborX][neighborY];
                        }
                        
                        updatedMatrix[i][j] = matrix[i][j];
                        
                        if (neighborCount > 0) {
                            double average = (double) neighborSum / neighborCount;
                            if (matrix[i][j] < average) {
                                updatedMatrix[i][j] = -1;
                                changed = true;
                            }
                        }
                    }
                }
                
                matrix = updatedMatrix;
                totalSum += roundSum;
                
                if (!changed) {
                    System.out.println("Case #" + testCase + ": " + totalSum);
                    break;
                }
            }
        }
    }
}