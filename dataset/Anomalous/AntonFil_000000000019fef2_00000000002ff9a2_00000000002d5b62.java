import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            scanner.nextLine();
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            System.out.println("Case #" + testCase + ": " + findPathToTarget(0, 0, targetX, targetY, 1, ""));
        }
        scanner.close();
    }

    private static String findPathToTarget(long currentX, long currentY, long targetX, long targetY, long step, String path) {
        if (step > 2_000_000_000 || (currentX != targetX && calculateDistance(currentX, targetX) < step) || (currentY != targetY && calculateDistance(currentY, targetY) < step)) {
            return IMPOSSIBLE;
        }
        if (currentX == targetX && currentY == targetY) {
            return path;
        }
        
        String pathEast = findPathToTarget(currentX + step, currentY, targetX, targetY, step * 2, path + "E");
        String pathWest = findPathToTarget(currentX - step, currentY, targetX, targetY, step * 2, path + "W");
        String pathNorth = findPathToTarget(currentX, currentY + step, targetX, targetY, step * 2, path + "N");
        String pathSouth = findPathToTarget(currentX, currentY - step, targetX, targetY, step * 2, path + "S");
        
        return getShortestValidPath(pathEast, pathWest, pathNorth, pathSouth);
    }

    private static String getShortestValidPath(String... paths) {
        int shortestLength = Integer.MAX_VALUE;
        String shortestPath = IMPOSSIBLE;
        for (String path : paths) {
            if (!path.equals(IMPOSSIBLE) && path.length() < shortestLength) {
                shortestLength = path.length();
                shortestPath = path;
            }
        }
        return shortestPath;
    }

    private static long calculateDistance(long point1, long point2) {
        return Math.abs(point1 - point2);
    }
}