import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static String findPath(long targetX, long targetY, int step, long currentX, long currentY, String path) {
        long distX = Math.abs(targetX - currentX);
        long distY = Math.abs(targetY - currentY);
        long jump = (long) Math.pow(2, step - 1);

        if (currentX == targetX && currentY == targetY) {
            return path;
        }

        if (distX > Math.abs(targetX) * 10 || distY > Math.abs(targetY) * 10) {
            return "IMPOSSIBLE";
        }

        if ((currentX == targetX && jump > distY) || (currentY == targetY && jump > distX) || (jump > distX || jump > distY)) {
            return "IMPOSSIBLE";
        }

        String temp;
        String result = "IMPOSSIBLE";
        int shortestPathLength = Integer.MAX_VALUE;

        temp = findPath(targetX, targetY, step + 1, currentX, currentY + jump, path + 'N');
        if (!temp.equals("IMPOSSIBLE") && temp.length() < shortestPathLength) {
            shortestPathLength = temp.length();
            result = temp;
        }

        temp = findPath(targetX, targetY, step + 1, currentX, currentY - jump, path + 'S');
        if (!temp.equals("IMPOSSIBLE") && temp.length() < shortestPathLength) {
            shortestPathLength = temp.length();
            result = temp;
        }

        temp = findPath(targetX, targetY, step + 1, currentX + jump, currentY, path + 'E');
        if (!temp.equals("IMPOSSIBLE") && temp.length() < shortestPathLength) {
            shortestPathLength = temp.length();
            result = temp;
        }

        temp = findPath(targetX, targetY, step + 1, currentX - jump, currentY, path + 'W');
        if (!temp.equals("IMPOSSIBLE") && temp.length() < shortestPathLength) {
            shortestPathLength = temp.length();
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            long targetX = scanner.nextLong();
            long targetY = scanner.nextLong();

            String result = findPath(targetX, targetY, 1, 0, 0, "");

            System.out.printf("Case #%d: %s\n", i, result);
        }

        scanner.close();
    }
}