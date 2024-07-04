import java.util.Scanner;

public class Solution {
    
    static Scanner scanner = new Scanner(System.in);
    
    static String findPath(long targetX, long targetY, int step, long currentX, long currentY, String path) {
        
        long distanceX = Math.abs(targetX - currentX);
        long distanceY = Math.abs(targetY - currentY);
        long jumpDistance = (long) Math.pow(2, step - 1);
        
        if (currentX == targetX && currentY == targetY) {
            return path;
        }
        
        if ((distanceX > Math.abs(targetX) * 10) || (distanceY > Math.abs(targetY) * 10)) {
            return "IMPOSSIBLE";
        }
        
        if (currentX == targetX && jumpDistance > distanceY) {
            return "IMPOSSIBLE";
        }
        
        if (currentY == targetY && jumpDistance > distanceX) {
            return "IMPOSSIBLE";
        }
        
        if (jumpDistance > distanceX || jumpDistance > distanceY) {
            return "IMPOSSIBLE";
        }
        
        String result;
        
        result = findPath(targetX, targetY, step + 1, currentX, currentY + jumpDistance, path + 'N');
        if (!result.equals("IMPOSSIBLE")) {
            return result;
        }
        
        result = findPath(targetX, targetY, step + 1, currentX, currentY - jumpDistance, path + 'S');
        if (!result.equals("IMPOSSIBLE")) {
            return result;
        }
        
        result = findPath(targetX, targetY, step + 1, currentX + jumpDistance, currentY, path + 'E');
        if (!result.equals("IMPOSSIBLE")) {
            return result;
        }
        
        result = findPath(targetX, targetY, step + 1, currentX - jumpDistance, currentY, path + 'W');
        
        return result;
    }
    
    public static void main(String[] args) {
        
        int testCases = scanner.nextInt();
        long targetX, targetY;
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            targetX = scanner.nextLong();
            targetY = scanner.nextLong();
            
            String result = findPath(targetX, targetY, 1, 0, 0, "");
            
            System.out.printf("Case #%d: %s\n", testCase, result);
        }
        
        scanner.close();
    }
}