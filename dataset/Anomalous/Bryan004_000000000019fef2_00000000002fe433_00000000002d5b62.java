import java.util.Scanner;

public class Solution {
    
    private static String path = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            long x = scan.nextLong();
            long y = scan.nextLong();
            
            findPath(0, 0, x, y, 1, "", (long) Math.sqrt((x * x) + (y * y)));
            
            if (path.isEmpty()) {
                path = "IMPOSSIBLE";
            }
            
            System.out.println("Case #" + (i + 1) + ": " + path);
            path = "";
        }
        
        scan.close();
    }

    private static void findPath(long startX, long startY, long goalX, long goalY, long moveLength, String currentPath, long maxDistance) {
        if (startX == goalX && startY == goalY) {
            if (path.isEmpty() || currentPath.length() < path.length()) {
                path = currentPath;
            }
        } else if (moveLength > maxDistance * 1.4 || !path.isEmpty() || (goalX < 0 && goalY > 0) || (goalX > 0 && goalY < 0)) {
            return;
        } else {
            findPath(startX, startY + moveLength, goalX, goalY, moveLength * 2, currentPath + "N", maxDistance);
            findPath(startX, startY - moveLength, goalX, goalY, moveLength * 2, currentPath + "S", maxDistance);
            findPath(startX + moveLength, startY, goalX, goalY, moveLength * 2, currentPath + "E", maxDistance);
            findPath(startX - moveLength, startY, goalX, goalY, moveLength * 2, currentPath + "W", maxDistance);
        }
    }
}