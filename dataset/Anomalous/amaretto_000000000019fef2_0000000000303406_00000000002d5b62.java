import java.math.*;
import java.io.*;
import java.util.*;

public class Solution {
    
    public static String findPath(long targetX, long targetY, String path, long currentX, long currentY, long step) {
        if (path.length() >= 12) {
            return path;
        }
        if (targetX == currentX && targetY == currentY) {
            return path;
        }
        
        if (currentX + step == targetX) {
            return findPath(targetX, targetY, path + 'E', targetX, currentY, step * 2);
        }
        if (currentX - step == targetX) {
            return findPath(targetX, targetY, path + 'W', targetX, currentY, step * 2);
        }
        if (currentY + step == targetY) {
            return findPath(targetX, targetY, path + 'N', currentX, targetY, step * 2);
        }
        if (currentY - step == targetY) {
            return findPath(targetX, targetY, path + 'S', currentX, targetY, step * 2);
        }
        
        String pathEast = findPath(targetX, targetY, path + 'E', currentX + step, currentY, step * 2);
        String pathWest = findPath(targetX, targetY, path + 'W', currentX - step, currentY, step * 2);
        String pathNorth = findPath(targetX, targetY, path + 'N', currentX, currentY + step, step * 2);
        String pathSouth = findPath(targetX, targetY, path + 'S', currentX, currentY - step, step * 2);
        
        int lengthEast = pathEast.length();
        int lengthWest = pathWest.length();
        int lengthNorth = pathNorth.length();
        int lengthSouth = pathSouth.length();
        
        int minLength = Math.min(lengthEast, Math.min(lengthWest, Math.min(lengthNorth, lengthSouth)));
        
        if (minLength == lengthEast) {
            return pathEast;
        } else if (minLength == lengthWest) {
            return pathWest;
        } else if (minLength == lengthNorth) {
            return pathNorth;
        } else {
            return pathSouth;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            
            if ((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1)) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                continue;
            }
            
            String result = findPath(x, y, "", 0, 0, 1);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}