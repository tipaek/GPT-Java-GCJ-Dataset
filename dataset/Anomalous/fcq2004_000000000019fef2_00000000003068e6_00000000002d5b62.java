import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            if (isOdd(targetX) && isOdd(targetY)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                findPath(targetX, targetY, 0, 0, 0, "");
            }
        }
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private static void findPath(int targetX, int targetY, int currentX, int currentY, int step, String path) {
        if (currentX == targetX && currentY == targetY) {
            System.out.println(path);
            return;
        }

        if (Math.abs(currentX) <= Math.abs(targetX) && Math.abs(currentY) <= Math.abs(targetY)) {
            int moveDistance = (int) Math.pow(2, step);
            findPath(targetX, targetY, currentX + moveDistance, currentY, step + 1, path + "E");
            findPath(targetX, targetY, currentX - moveDistance, currentY, step + 1, path + "W");
            findPath(targetX, targetY, currentX, currentY + moveDistance, step + 1, path + "N");
            findPath(targetX, targetY, currentX, currentY - moveDistance, step + 1, path + "S");
        }
    }
}