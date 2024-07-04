import java.util.Scanner;

public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static String findPath(long targetX, long targetY, int step, long currentX, long currentY, String path) {
        long distanceX = Math.abs(targetX - currentX);
        long distanceY = Math.abs(targetY - currentY);
        long jumpDistance = (long) Math.pow(2, step - 1);

        if (currentX == targetX && currentY == targetY) {
            return path;
        }

        if (distanceX > Math.abs(targetX) * 15 || distanceY > Math.abs(targetY) * 15) {
            return "IMPOSSIBLE";
        }

        if ((currentX == targetX && jumpDistance > distanceY) || (currentY == targetY && jumpDistance > distanceX)) {
            return "IMPOSSIBLE";
        }

        if (jumpDistance > distanceX || jumpDistance > distanceY) {
            return "IMPOSSIBLE";
        }

        String[] directions = {"N", "S", "E", "W"};
        long[][] moves = {{0, jumpDistance}, {0, -jumpDistance}, {jumpDistance, 0}, {-jumpDistance, 0}};
        String result = "IMPOSSIBLE";
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < directions.length; i++) {
            String tempResult = findPath(targetX, targetY, step + 1, currentX + moves[i][0], currentY + moves[i][1], path + directions[i]);
            if (!tempResult.equals("IMPOSSIBLE") && tempResult.length() < minLength) {
                minLength = tempResult.length();
                result = tempResult;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int i = 1; i <= testCases; i++) {
            long targetX = SCANNER.nextLong();
            long targetY = SCANNER.nextLong();
            String result = findPath(targetX, targetY, 1, 0, 0, "");
            System.out.printf("Case #%d: %s\n", i, result);
        }

        SCANNER.close();
    }
}