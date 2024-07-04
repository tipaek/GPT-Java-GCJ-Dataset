import java.util.Scanner;

public class Solution {
    private static String result = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases-- > 0) {
            result = "IMPOSSIBLE";
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            findPath(x, y, 0, 0, 1, "");
            System.out.println(result);
        }
    }

    private static void findPath(int targetX, int targetY, int currentX, int currentY, int move, String path) {
        if (currentX == targetX && currentY == targetY) {
            if (path.length() < result.length() || result.equals("IMPOSSIBLE")) {
                result = path;
            }
            return;
        }

        if (Math.abs(currentX) > 4 || Math.abs(currentY) > 4) {
            return;
        }

        char[] directions = {'E', 'N', 'W', 'S'};
        int[][] moves = {
            {1, 0}, // East
            {0, 1}, // North
            {-1, 0}, // West
            {0, -1} // South
        };

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + moves[i][0] * (int) Math.pow(2, move - 1);
            int nextY = currentY + moves[i][1] * (int) Math.pow(2, move - 1);
            findPath(targetX, targetY, nextX, nextY, move + 1, path + directions[i]);
        }
    }
}