import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + i + ": " + findPath(x, y));
        }
    }

    private static String findPath(int targetX, int targetY) {
        int currentX = 0;
        int currentY = 0;
        StringBuilder path = new StringBuilder();
        int maxSteps = 30;
        int stepCount = 1;
        int jumpLength = 1;

        while (stepCount <= maxSteps) {
            if (currentX == targetX && currentY == targetY) {
                break;
            }

            if (canJump(currentX - jumpLength, targetX)) {
                path.append("W");
                currentX -= jumpLength;
            } else if (canJump(currentX + jumpLength, targetX)) {
                path.append("E");
                currentX += jumpLength;
            } else if (canJump(currentY - jumpLength, targetY)) {
                path.append("S");
                currentY -= jumpLength;
            } else if (canJump(currentY + jumpLength, targetY)) {
                path.append("N");
                currentY += jumpLength;
            } else if (canJump(targetX - jumpLength, 0)) {
                path.append("W");
                currentX -= jumpLength;
            } else if (canJump(targetX + jumpLength, 0)) {
                path.append("E");
                currentX += jumpLength;
            } else if (canJump(targetY - jumpLength, 0)) {
                path.append("S");
                currentY -= jumpLength;
            } else if (canJump(targetY + jumpLength, 0)) {
                path.append("N");
                currentY += jumpLength;
            } else if (canJump(-targetX - jumpLength, 0)) {
                path.append("E");
                currentX += jumpLength;
            } else if (canJump(-targetX + jumpLength, 0)) {
                path.append("W");
                currentX -= jumpLength;
            } else if (canJump(-targetY - jumpLength, 0)) {
                path.append("N");
                currentY += jumpLength;
            } else if (canJump(-targetY + jumpLength, 0)) {
                path.append("S");
                currentY -= jumpLength;
            }

            if (currentX == targetX && currentY == targetY) {
                break;
            }

            jumpLength <<= 1;
            stepCount++;
        }

        return (currentX == targetX && currentY == targetY) ? path.toString() : "IMPOSSIBLE";
    }

    private static boolean canJump(int position, int target) {
        return position == target || (target >= 0 && (target - position) % 2 == 0);
    }
}