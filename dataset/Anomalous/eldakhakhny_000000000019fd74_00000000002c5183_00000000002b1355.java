import javafx.util.Pair;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] floor = new int[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }
            
            int totalScore = 0;
            boolean canContinue = true;
            
            while (canContinue) {
                List<Pair<Integer, Integer>> toRemove = new ArrayList<>();
                int roundScore = 0;
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        roundScore += floor[i][j];
                        int north = findNorth(floor, i, j - 1, rows, cols);
                        int south = findSouth(floor, i, j + 1, rows, cols);
                        int east = findEast(floor, i + 1, j, rows, cols);
                        int west = findWest(floor, i - 1, j, rows, cols);
                        
                        double count = ((north > 0) ? 1 : 0) + ((south > 0) ? 1 : 0) + ((east > 0) ? 1 : 0) + ((west > 0) ? 1 : 0);
                        double sum = north + south + east + west;
                        double average = sum / count;
                        
                        if (floor[i][j] < average) {
                            toRemove.add(new Pair<>(i, j));
                        }
                    }
                }
                
                totalScore += roundScore;
                
                for (Pair<Integer, Integer> pair : toRemove) {
                    floor[pair.getKey()][pair.getValue()] = 0;
                }
                
                if (toRemove.isEmpty()) {
                    canContinue = false;
                }
            }
            
            System.out.println("Case #" + t + ": " + totalScore);
        }
    }
    
    static int findNorth(int[][] floor, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) return 0;
        return (floor[row][col] > 0) ? floor[row][col] : findNorth(floor, row, col - 1, maxRow, maxCol);
    }
    
    static int findSouth(int[][] floor, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) return 0;
        return (floor[row][col] > 0) ? floor[row][col] : findSouth(floor, row, col + 1, maxRow, maxCol);
    }
    
    static int findWest(int[][] floor, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) return 0;
        return (floor[row][col] > 0) ? floor[row][col] : findWest(floor, row - 1, col, maxRow, maxCol);
    }
    
    static int findEast(int[][] floor, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) return 0;
        return (floor[row][col] > 0) ? floor[row][col] : findEast(floor, row, col + 1, maxRow, maxCol);
    }
}