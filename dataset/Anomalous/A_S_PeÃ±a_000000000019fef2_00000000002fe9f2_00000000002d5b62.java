import java.util.Scanner;

public class Solution {
    
    private static final Scanner SCNR = new Scanner(System.in);
    
    private static String findPath(long targetX, long targetY, int step, long currentX, long currentY, String path) {
        
        long distX = Math.abs(targetX - currentX);
        long distY = Math.abs(targetY - currentY);
        long jump = 1L << (step - 1); // Equivalent to (long)Math.pow(2, step - 1)

        if (currentX == targetX && currentY == targetY) {
            return path;
        }
        
        if (distX > Math.abs(targetX) * 13 || distY > Math.abs(targetY) * 13) {
            return "IMPOSSIBLE";
        }
        
        if (currentX == targetX && jump > distY) {
            return "IMPOSSIBLE";  
        }
        
        if (currentY == targetY && jump > distX) {
            return "IMPOSSIBLE";
        }
        
        if (jump > distX || jump > distY) {
            return "IMPOSSIBLE";
        }

        String result = "IMPOSSIBLE";
        int minLength = Integer.MAX_VALUE;

        String[] directions = {"N", "S", "E", "W"};
        long[][] moves = {{0, jump}, {0, -jump}, {jump, 0}, {-jump, 0}};
        
        for (int i = 0; i < directions.length; i++) {
            String temp = findPath(targetX, targetY, step + 1, currentX + moves[i][0], currentY + moves[i][1], path + directions[i]);
            if (!temp.equals("IMPOSSIBLE") && temp.length() < minLength) {
                minLength = temp.length();
                result = temp;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int testCases = SCNR.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            long targetX = SCNR.nextLong();
            long targetY = SCNR.nextLong();
            
            String result = findPath(targetX, targetY, 1, 0, 0, "");
            
            System.out.printf("Case #%d: %s%n", i, result);
        }
        
        SCNR.close();
    }
}