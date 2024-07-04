import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x % 2 == 1 && y % 2 == 1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + i + ": ");
                findPath(x, y, 0, 0, 0, "");
            }
        }
    }

    private static void findPath(int targetX, int targetY, int currentX, int currentY, int step, String path) {
        if (currentX == targetX && currentY == targetY) {
            System.out.println(path);
        } else if (Math.abs(currentX) <= Math.abs(targetX) && Math.abs(currentY) <= Math.abs(targetY)) {
            int moveDistance = (int) Math.pow(2, step);
            findPath(targetX, targetY, currentX + moveDistance, currentY, step + 1, path + "E");
            findPath(targetX, targetY, currentX - moveDistance, currentY, step + 1, path + "W");
            findPath(targetX, targetY, currentX, currentY + moveDistance, step + 1, path + "N");
            findPath(targetX, targetY, currentX, currentY - moveDistance, step + 1, path + "S");
        }
    }
}