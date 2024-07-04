import java.math.*;
import java.io.*;
import java.util.*;

public class Solution {

    public static String findPath(long x, long y, String path, long currentX, long currentY, long step) {
        if (path.length() >= 20) {
            return path;
        }
        if (x == currentX && y == currentY) {
            return path;
        }
        if (currentX + step == x) {
            return findPath(x, y, path + 'E', x, currentY, step * 2);
        }
        if (currentX - step == x) {
            return findPath(x, y, path + 'W', x, currentY, step * 2);
        }
        if (currentY - step == y) {
            return findPath(x, y, path + 'S', currentX, y, step * 2);
        }
        if (currentY + step == y) {
            return findPath(x, y, path + 'N', currentX, y, step * 2);
        }
        
        String path1 = findPath(x, y, path + 'E', currentX + step, currentY, step * 2);
        String path2 = findPath(x, y, path + 'W', currentX - step, currentY, step * 2);
        String path3 = findPath(x, y, path + 'N', currentX, currentY + step, step * 2);
        String path4 = findPath(x, y, path + 'S', currentX, currentY - step, step * 2);
        
        int length1 = path1.length();
        int length2 = path2.length();
        int length3 = path3.length();
        int length4 = path4.length();
        
        int minLength = Math.min(length1, Math.min(length2, Math.min(length3, length4)));
        
        if (minLength == length1) {
            return path1;
        } else if (minLength == length2) {
            return path2;
        } else if (minLength == length3) {
            return path3;
        } else {
            return path4;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            
            if ((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1)) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }
            
            String result = findPath(x, y, "", 0L, 0L, 1L);
            System.out.println("Case #" + test + ": " + result);
        }
    }
}