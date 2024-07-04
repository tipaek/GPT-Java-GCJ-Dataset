import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            StringBuilder result = new StringBuilder();
            int jumpCount = 1;
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int minDistance = Math.abs(X) + Math.abs(Y);
            int minJumpCount = calculateMinJumpCount(minDistance);
            int currentX = 0, currentY = 0;
            int failCount = 0;

            while (true) {
                int length = (int) Math.pow(2, jumpCount - 1);
                Random random = new Random();
                int direction = random.nextInt(4) + 1;

                switch (direction) {
                    case 1:
                        result.append("N");
                        currentY += length;
                        break;
                    case 2:
                        result.append("E");
                        currentX += length;
                        break;
                    case 3:
                        result.append("S");
                        currentY -= length;
                        break;
                    case 4:
                        result.append("W");
                        currentX -= length;
                        break;
                }

                if (currentX == X && currentY == Y) {
                    break;
                }

                if (Math.abs(currentX) + Math.abs(currentY) > minDistance) {
                    resetState(result);
                    currentX = 0;
                    currentY = 0;
                    jumpCount = 0;
                    failCount++;
                }

                if ((X < 0 && currentX < X) || (X >= 0 && currentX > X) || 
                    (Y < 0 && currentY < Y) || (Y >= 0 && currentY > Y)) {
                    resetState(result);
                    currentX = 0;
                    currentY = 0;
                    jumpCount = 0;
                    failCount++;
                }

                if (failCount == 10000000) {
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

    private static void resetState(StringBuilder result) {
        result.setLength(0);
    }
}