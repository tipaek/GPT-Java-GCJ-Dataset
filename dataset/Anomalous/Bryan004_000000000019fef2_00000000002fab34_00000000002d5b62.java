import java.util.Scanner;

public class Solution {
    
    private static String path = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            long targetX = scanner.nextLong();
            long targetY = scanner.nextLong();
            findPath(0, 0, targetX, targetY, 1, "", (long) Math.sqrt((targetX * targetX) + (targetY * targetY)));
            
            if (path.isEmpty()) {
                path = "IMPOSSIBLE";
            }
            
            System.out.println("Case #" + (i + 1) + ": " + path);
            path = "";
        }
    }
    
    private static void findPath(long startX, long startY, long goalX, long goalY, long moveLength, String currentPath, long maxDistance) {
        if (startX == goalX && startY == goalY) {
            if (path.isEmpty() || currentPath.length() < path.length()) {
                path = currentPath;
            }
        } else if (moveLength > maxDistance * 1.4 || !path.isEmpty()) {
            return;
        } else {
            findPath(startX, startY + moveLength, goalX, goalY, moveLength * 2, currentPath + "N", maxDistance);
            findPath(startX, startY - moveLength, goalX, goalY, moveLength * 2, currentPath + "S", maxDistance);
            findPath(startX + moveLength, startY, goalX, goalY, moveLength * 2, currentPath + "E", maxDistance);
            findPath(startX - moveLength, startY, goalX, goalY, moveLength * 2, currentPath + "W", maxDistance);
        }
    }
}