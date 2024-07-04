import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            String result = findPath(x, y);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    private static StringBuilder pathBuilder;
    private static long targetX, targetY;
    
    private static String findPath(long x, long y) {
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            return "IMPOSSIBLE";
        }
        
        pathBuilder = new StringBuilder();
        targetX = x;
        targetY = y;
        calculatePath(targetX, targetY);
        
        return pathBuilder.toString();
    }
    
    private static void calculatePath(long x, long y) {
        if (x == 1 && y == 0) {
            pathBuilder.append('E');
            return;
        }
        if (x == 0 && y == 1) {
            pathBuilder.append('N');
            return;
        }
        if (x == -1 && y == 0) {
            pathBuilder.append('W');
            return;
        }
        if (x == 0 && y == -1) {
            pathBuilder.append('S');
            return;
        }
        
        if (x % 2 != 0) {
            long nextXPlus = (x + 1) / 2;
            long nextXMinus = (x - 1) / 2;
            long nextY = y / 2;
            
            if ((nextXPlus % 2 == 0 && nextY % 2 != 0) || (nextXPlus % 2 != 0 && nextY % 2 == 0)) {
                pathBuilder.append('W');
                calculatePath(nextXPlus, nextY);
            }
            if ((nextXMinus % 2 == 0 && nextY % 2 != 0) || (nextXMinus % 2 != 0 && nextY % 2 == 0)) {
                pathBuilder.append('E');
                calculatePath(nextXMinus, nextY);
            }
        } else if (y % 2 != 0) {
            long nextYPlus = (y + 1) / 2;
            long nextYMinus = (y - 1) / 2;
            long nextX = x / 2;
            
            if ((nextYPlus % 2 == 0 && nextX % 2 != 0) || (nextYPlus % 2 != 0 && nextX % 2 == 0)) {
                pathBuilder.append('S');
                calculatePath(nextX, nextYPlus);
            }
            if ((nextX % 2 == 0 && nextYMinus % 2 != 0) || (nextX % 2 != 0 && nextYMinus % 2 == 0)) {
                pathBuilder.append('N');
                calculatePath(nextX, nextYMinus);
            }
        }
    }
}