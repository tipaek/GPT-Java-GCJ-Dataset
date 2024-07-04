import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            String result = findPath(0, 0, 1, targetX, targetY, "");
            if (result == null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }

    static String findPath(int currentX, int currentY, int jumpDistance, int targetX, int targetY, String path) {
        if (currentX == targetX && currentY == targetY) {
            return path;
        }

        if (Math.abs(targetX - currentX) + Math.abs(targetY - currentY) < jumpDistance) {
            return null;
        }

        String[] directions = {"W", "E", "S", "N"};
        int[][] moves = {{-jumpDistance, 0}, {jumpDistance, 0}, {0, -jumpDistance}, {0, jumpDistance}};
        
        String shortestPath = null;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < directions.length; i++) {
            int newX = currentX + moves[i][0];
            int newY = currentY + moves[i][1];
            String newPath = findPath(newX, newY, jumpDistance * 2, targetX, targetY, path + directions[i]);
            if (newPath != null && newPath.length() < minLength) {
                minLength = newPath.length();
                shortestPath = newPath;
            }
        }

        return shortestPath;
    }
}