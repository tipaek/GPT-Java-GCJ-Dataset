import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static String findPath(long targetX, long targetY, int step, long currentX, long currentY, String path) {
        long distanceX = Math.abs(targetX - currentX);
        long distanceY = Math.abs(targetY - currentY);
        long jump = (long) Math.pow(2, step - 1);

        if (currentX == targetX && currentY == targetY) {
            return path;
        } else if ((distanceX > Math.abs(targetX) * 20) || (distanceY > Math.abs(targetY) * 20)) {
            return "IMPOSSIBLE";
        } else if ((currentX == targetX && jump > distanceY) || (currentY == targetY && jump > distanceX) || (jump > distanceX || jump > distanceY)) {
            return "IMPOSSIBLE";
        }

        String[] directions = {"N", "S", "E", "W"};
        long[][] moves = {{0, jump}, {0, -jump}, {jump, 0}, {-jump, 0}};
        String result = "IMPOSSIBLE";
        int shortestPathLength = Integer.MAX_VALUE;

        for (int i = 0; i < directions.length; i++) {
            String newPath = findPath(targetX, targetY, step + 1, currentX + moves[i][0], currentY + moves[i][1], path + directions[i]);
            if (!newPath.equals("IMPOSSIBLE") && newPath.length() < shortestPathLength) {
                shortestPathLength = newPath.length();
                result = newPath;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            long targetX = scanner.nextLong();
            long targetY = scanner.nextLong();
            String result = findPath(targetX, targetY, 1, 0, 0, "");
            System.out.printf("Case #%d: %s\n", i, result);
        }

        scanner.close();
    }
}