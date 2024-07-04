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
            System.out.println(result);
        }
    }

    private static void findPath(int targetX, int targetY, int currentX, int currentY, int move, String path) {
        if (currentX == targetX && currentY == targetY) {
            if (path.length() < result.length() || result.isEmpty()) {
                result = path;
            }
            return;
        }

        if (Math.abs(currentX) > Math.abs(targetX) || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }

        char[] directions = {'E', 'N', 'W', 'S'};
        int[] deltaX = {1, 0, -1, 0};
        int[] deltaY = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + deltaX[i] * (1 << (move - 1));
            int nextY = currentY + deltaY[i] * (1 << (move - 1));
            findPath(targetX, targetY, nextX, nextY, move + 1, path + directions[i]);
        }

        if (result.isEmpty()) {
            result = "IMPOSSIBLE";
        }
    }
}