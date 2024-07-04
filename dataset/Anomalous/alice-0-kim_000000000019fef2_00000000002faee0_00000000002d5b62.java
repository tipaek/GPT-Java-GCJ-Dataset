import java.io.*;
import java.util.*;

public class Solution {
    static int targetX, targetY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            TreeSet<String> possiblePaths = new TreeSet<>(Comparator.comparingInt(String::length));
            
            findPath(0, 0, 0, "", possiblePaths);
            
            String result = possiblePaths.isEmpty() ? "IMPOSSIBLE" : possiblePaths.first();
            System.out.printf("Case #%d: %s\n", t, result);
        }
        
        scanner.close();
    }

    private static void findPath(int currentX, int currentY, int step, String path, TreeSet<String> paths) {
        if (!paths.isEmpty() && step > paths.first().length() 
            || Math.abs(currentX) > Math.abs(targetX) 
            || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }
        
        if (currentX == targetX && currentY == targetY) {
            paths.add(path);
        } else {
            int distance = (int) Math.pow(2, step);
            
            findPath(currentX + distance, currentY, step + 1, path + "E", paths);
            findPath(currentX - distance, currentY, step + 1, path + "W", paths);
            findPath(currentX, currentY + distance, step + 1, path + "N", paths);
            findPath(currentX, currentY - distance, step + 1, path + "S", paths);
        }
    }
}