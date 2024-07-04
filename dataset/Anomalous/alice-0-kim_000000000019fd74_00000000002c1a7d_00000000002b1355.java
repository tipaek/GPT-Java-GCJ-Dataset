import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] floor = new int[rows][cols];
            int totalSum = 0;
            List<int[]> toEliminate;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }
            
            do {
                toEliminate = new ArrayList<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (floor[i][j] != -1) {
                            totalSum += floor[i][j];
                            int north = i - 1, south = i + 1, west = j - 1, east = j + 1;
                            int count = 0;
                            double average = 0;
                            
                            while (north >= 0 && floor[north][j] == -1) north--;
                            while (south < rows && floor[south][j] == -1) south++;
                            while (west >= 0 && floor[i][west] == -1) west--;
                            while (east < cols && floor[i][east] == -1) east++;
                            
                            if (north >= 0 && floor[north][j] != -1) { average += floor[north][j]; count++; }
                            if (south < rows && floor[south][j] != -1) { average += floor[south][j]; count++; }
                            if (west >= 0 && floor[i][west] != -1) { average += floor[i][west]; count++; }
                            if (east < cols && floor[i][east] != -1) { average += floor[i][east]; count++; }
                            
                            if (count > 0) {
                                average /= count;
                                if (average > floor[i][j]) {
                                    toEliminate.add(new int[]{i, j});
                                }
                            }
                        }
                    }
                }
                
                for (int[] cell : toEliminate) {
                    floor[cell[0]][cell[1]] = -1;
                }
            } while (!toEliminate.isEmpty());
            
            System.out.printf("Case #%d: %d\n", t, totalSum);
        }
    }
}