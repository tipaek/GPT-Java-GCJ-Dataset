
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

            int minJumpCount = minJumpCount(minDistance);

            int currentX = 0, currentY = 0;

            int failCount = 0;

            while (true) {

                int length = (int) Math.pow(2, jumpCount - 1);

                Random random = new Random();

                int ran = random.nextInt(4) + 1;

                switch (ran) {

                    case 1:
                        result.append("N");
                        currentY = currentY + length;
                        break;
                    case 2:
                        result.append("E");
                        currentX = currentX + length;
                        break;
                    case 3:
                        result.append("S");
                        currentY = currentY - length;
                        break;
                    case 4:
                        result.append("W");
                        currentX = currentX - length;
                        break;
                }

                if (currentX == X && currentY == Y) {
                    break;
                }

                if (Math.abs(currentX) + Math.abs(currentY) > minDistance) {
                    result = new StringBuilder();
                    currentX = 0;
                    currentY = 0;
                    jumpCount = 0;
                    failCount++;
                }

                if (X < 0) {

                    if (currentX < X) {
                        result = new StringBuilder();
                        currentX = 0;
                        currentY = 0;
                        jumpCount = 0;
                        failCount++;
                    }
                } else {
                    if (currentX > X) {
                        result = new StringBuilder();
                        currentX = 0;
                        currentY = 0;
                        jumpCount = 0;
                        failCount++;
                    }
                }

                if (Y < 0) {

                    if (currentY < Y) {
                        result = new StringBuilder();
                        currentX = 0;
                        currentY = 0;
                        jumpCount = 0;
                        failCount++;
                    }
                } else {
                    if (currentY > Y) {
                        result = new StringBuilder();
                        currentX = 0;
                        currentY = 0;
                        jumpCount = 0;
                        failCount++;
                    }
                }

                if (failCount == 10000000) {
                    result = new StringBuilder();
                    result.append("IMPOSSIBLE");
                    break;
                }
                jumpCount++;
            }

            System.out.println(String.format("Case #%d: %s", i, result));
        }
    }

    private static int minJumpCount(int minDistance) {

        for (int i = 1; true; i++) {

            if (minDistance <= Math.pow(2, i - 1)) {
                return i;
            }
        }
    }
}
