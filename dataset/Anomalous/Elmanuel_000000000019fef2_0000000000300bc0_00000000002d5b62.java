import java.util.Scanner;

public class Solution {
    private static String result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        while (numberOfCases-- > 0) {
            result = "";
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            findPath(targetX, targetY, 0, 0, 1, "");
            System.out.println(result.isEmpty() ? "IMPOSSIBLE" : result);
        }
    }

    private static void findPath(int targetX, int targetY, int currentX, int currentY, int moveNumber, String path) {
        if (currentX == targetX && currentY == targetY) {
            if (path.length() < result.length() || result.isEmpty()) {
                result = path;
            }
            return;
        }

        if (Math.abs(currentX) > 4 || Math.abs(currentY) > 4) {
            return;
        }

        char[] directions = {'E', 'N', 'W', 'S'};
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + dx[i] * (int) Math.pow(2, moveNumber - 1);
            int nextY = currentY + dy[i] * (int) Math.pow(2, moveNumber - 1);
            findPath(targetX, targetY, nextX, nextY, moveNumber + 1, path + directions[i]);
        }
    }
}