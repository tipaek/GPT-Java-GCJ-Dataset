import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int totalInterest = 0;
        int currentInterest = 0;
        int[][] map = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = scanner.nextInt();
                currentInterest += map[i][j];
            }
        }
        
        totalInterest = currentInterest;
        
        while (true) {
            List<Point> toRemove = new ArrayList<>();
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map[i][j] == -1) {
                        continue;
                    }
                    
                    int count = 0;
                    double average = 0;
                    
                    for (int x = i + 1; x < rows; x++) {
                        if (map[x][j] != -1) {
                            average += map[x][j];
                            count++;
                            break;
                        }
                    }
                    
                    for (int x = i - 1; x >= 0; x--) {
                        if (map[x][j] != -1) {
                            average += map[x][j];
                            count++;
                            break;
                        }
                    }
                    
                    for (int y = j + 1; y < cols; y++) {
                        if (map[i][y] != -1) {
                            average += map[i][y];
                            count++;
                            break;
                        }
                    }
                    
                    for (int y = j - 1; y >= 0; y--) {
                        if (map[i][y] != -1) {
                            average += map[i][y];
                            count++;
                            break;
                        }
                    }
                    
                    if (count > 0) {
                        average /= count;
                        if (map[i][j] < average) {
                            toRemove.add(new Point(i, j));
                        }
                    }
                }
            }
            
            if (toRemove.isEmpty()) {
                break;
            }
            
            for (Point point : toRemove) {
                currentInterest -= map[point.x][point.y];
                map[point.x][point.y] = -1;
            }
            
            totalInterest += currentInterest;
        }
        
        System.out.println(totalInterest);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}