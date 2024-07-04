import java.util.Random;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            StringBuilder result = new StringBuilder();
            int jumpCount = 1;
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            int minDistance = Math.abs(targetX) + Math.abs(targetY);
            int minJumpCount = calculateMinJumpCount(minDistance);

            int currentX = 0, currentY = 0;
            int failCount = 0;

            while (true) {
                int jumpLength = (int) Math.pow(2, jumpCount - 1);
                Random random = new Random();
                int direction = random.nextInt(4) + 1;

                switch (direction) {
                    case 1:
                        result.append("N");
                        currentY += jumpLength;
                        break;
                    case 2:
                        result.append("E");
                        currentX += jumpLength;
                        break;
                    case 3:
                        result.append("S");
                        currentY -= jumpLength;
                        break;
                    case 4:
                        result.append("W");
                        currentX -= jumpLength;
                        break;
                }

                if (currentX == targetX && currentY == targetY) {
                    break;
                }

                if (Math.abs(currentX) + Math.abs(currentY) > minDistance || isInvalidMove(targetX, targetY, currentX, currentY)) {
                    resetState(result);
                    currentX = 0;
                    currentY = 0;
                    jumpCount = 0;
                    failCount++;
                }

                if (failCount == 15000) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                jumpCount++;
            }

            System.out.println(String.format("Case #%d: %s", i, result));
        }
    }

    private static int calculateMinJumpCount(int minDistance) {
        for (int i = 1; ; i++) {
            if (minDistance <= Math.pow(2, i - 1)) {
                return i;
            }
        }
    }

    private static boolean isInvalidMove(int targetX, int targetY, int currentX, int currentY) {
        return (targetX < 0 && currentX < targetX) || (targetX >= 0 && currentX > targetX) ||
               (targetY < 0 && currentY < targetY) || (targetY >= 0 && currentY > targetY);
    }

    private static void resetState(StringBuilder result) {
        result.setLength(0);
    }
}