import java.util.Scanner;

public class Solution {
    private static String result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            result = "";
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            findPath(targetX, targetY, 0, 0, 1, "");
            System.out.println(result.isEmpty() ? "IMPOSSIBLE" : result);
        }
    }

    private static void findPath(int targetX, int targetY, int currentX, int currentY, int moveCount, String path) {
        if (currentX == targetX && currentY == targetY) {
            if (path.length() < result.length() || result.isEmpty()) {
                result = path;
            }
            return;
        }

        if (Math.abs(currentX) > 4 || Math.abs(currentY) > 4) return;

        char[] directions = {'E', 'N', 'W', 'S'};
        int[] deltaX = {1, 0, -1, 0};
        int[] deltaY = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + deltaX[i] * (int) Math.pow(2, moveCount - 1);
            int nextY = currentY + deltaY[i] * (int) Math.pow(2, moveCount - 1);
            findPath(targetX, targetY, nextX, nextY, moveCount + 1, path + directions[i]);
        }
    }
}