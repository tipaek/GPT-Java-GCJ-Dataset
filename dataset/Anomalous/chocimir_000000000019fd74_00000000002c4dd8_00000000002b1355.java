import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private long solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];
        int[][] eliminationGrid = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
                eliminationGrid[i][j] = 1;
            }
        }
        
        long totalSum = 0;
        boolean continueElimination = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (continueElimination) {
            continueElimination = false;
            long roundSum = 0;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    roundSum += grid[i][j];
                    if (grid[i][j] == 0) continue;
                    
                    double neighborSum = 0;
                    int neighborCount = 0;
                    
                    for (int[] dir : directions) {
                        int y = i, x = j;
                        
                        while (y >= 0 && y < rows && x >= 0 && x < cols) {
                            if ((x != j || y != i) && grid[y][x] > 0) {
                                neighborCount++;
                                neighborSum += grid[y][x];
                                break;
                            }
                            x += dir[0];
                            y += dir[1];
                        }
                    }
                    
                    if (neighborCount > 0) {
                        double average = neighborSum / neighborCount;
                        if (average > grid[i][j]) {
                            eliminationGrid[i][j] = 0;
                            continueElimination = true;
                        }
                    }
                }
            }
            
            totalSum += roundSum;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] *= eliminationGrid[i][j];
                }
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}