import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];
            
            // Read the grid
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            
            boolean isOngoing = true;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            int totalSum = 0;
            
            while (isOngoing) {
                int roundSum = 0;
                boolean hasChange = false;
                int[][] updatedGrid = new int[rows][cols];
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        updatedGrid[i][j] = grid[i][j];
                        if (grid[i][j] == -1) continue;
                        
                        roundSum += grid[i][j];
                        int neighborCount = 0;
                        int neighborSum = 0;
                        
                        for (int direction = 0; direction < dx.length; direction++) {
                            int x = i + dx[direction];
                            int y = j + dy[direction];
                            
                            while (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == -1) {
                                x += dx[direction];
                                y += dy[direction];
                            }
                            
                            if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == -1) continue;
                            
                            neighborCount++;
                            neighborSum += grid[x][y];
                        }
                        
                        if (neighborCount == 0) continue;
                        
                        double average = ((double) neighborSum) / neighborCount;
                        if (grid[i][j] < average) {
                            updatedGrid[i][j] = -1;
                            hasChange = true;
                        }
                    }
                }
                
                grid = updatedGrid;
                totalSum += roundSum;
                
                if (!hasChange) {
                    System.out.println("Case #" + testCase + ": " + totalSum);
                    break;
                }
            }
        }
        
        scanner.close();
    }
}