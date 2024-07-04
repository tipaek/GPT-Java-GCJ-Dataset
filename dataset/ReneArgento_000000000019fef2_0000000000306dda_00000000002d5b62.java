import java.util.Scanner;

/**
 * Created by Rene Argento on 03/04/20.
 */
// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fef2/00000000002d5b62
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 1; t <= tests; t++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            String moves = getMoves(targetX, targetY);
            System.out.println("Case #" + t + ": " + moves);
        }

//        for (int i = -4; i <= 4; i++) {
//            for (int j = -4; j <= 4; j++) {
//                System.out.println(i + ", " + j + ": " + getMoves(i, j));
//            }
//        }
    }

    private static String getMoves(int targetX, int targetY) {
        long nearestPowerOf2X = getNearestPowerOf2(Math.abs(targetX));
        long nearestPowerOf2Y = getNearestPowerOf2(Math.abs(targetY));
        long differenceX = (long) Math.abs(Math.pow(2, nearestPowerOf2X) - Math.abs(targetX));
        long differenceY = (long) Math.abs(Math.pow(2, nearestPowerOf2Y) - Math.abs(targetY));

        // Edge cases
        if (targetX == 0 && targetY == 0) {
            return "";
        }

        if (targetX == 1) {
            return getPath(targetX, targetY, 1, 0, 1,  "E");
        } else if (targetX == -1) {
            return getPath(targetX, targetY, -1, 0, 1,  "W");
        } else if (targetY == 1) {
            return getPath(targetX, targetY, 0, 1, 1,  "N");
        } else if (targetY == -1) {
            return getPath(targetX, targetY, 0, -1, 1,  "E");
        }

        if ((differenceX == 1 && Math.abs(targetX) < Math.abs(targetY))
                || (differenceY == 1 && Math.abs(targetY) < Math.abs(targetX))) {
            return getPath(targetX, targetY, 0, 0, 0,  "");
        } else {
            String prefix = "";
            int currentX = 0;
            int currentY = 0;
            if (differenceX == 0) {
                if (targetY > 0) {
                    prefix = "S";
                    currentY = -1;
                } else {
                    prefix = "N";
                    currentY = 1;
                }
            } else {
                if (targetX > 0) {
                    prefix = "W";
                    currentX = -1;
                } else {
                    prefix = "E";
                    currentX = 1;
                }
            }
            return getPath(targetX, targetY, currentX, currentY, 1, prefix);
        }
    }

    private static String getPath(int targetX, int targetY, long currentX, long currentY, int power, String prefix) {
        StringBuilder result = new StringBuilder(prefix);
        boolean xDirection = currentX < targetX;
        boolean yDirection = currentY < targetY;

        if (Math.abs(targetX) < Math.abs(targetY)) {
            while (Math.abs(currentX) < Math.abs(targetX)) {
                long nextPower = (long) Math.pow(2, power);
                if (xDirection) {
                    currentX += nextPower;
                    result.append("E");
                } else {
                    currentX -= nextPower;
                    result.append("W");
                }
                power++;
            }
            while (Math.abs(currentY) < Math.abs(targetY)) {
                long nextPower = (long) Math.pow(2, power);
                if (yDirection) {
                    currentY += nextPower;
                    result.append("N");
                } else {
                    currentY -= nextPower;
                    result.append("S");
                }
                power++;
            }
        } else {
            while (Math.abs(currentY) < Math.abs(targetY)) {
                long nextPower = (long) Math.pow(2, power);
                if (yDirection) {
                    currentY += nextPower;
                    result.append("N");
                } else {
                    currentY -= nextPower;
                    result.append("S");
                }
                power++;
            }
            while (Math.abs(currentX) < Math.abs(targetX)) {
                long nextPower = (long) Math.pow(2, power);
                if (xDirection) {
                    currentX += nextPower;
                    result.append("E");
                } else {
                    currentX -= nextPower;
                    result.append("W");
                }
                power++;
            }
        }

        if (Math.abs(currentX) != Math.abs(targetX) || Math.abs(currentY) != Math.abs(targetY)) {
            return "IMPOSSIBLE";
        }
        return result.toString();
    }

    private static long getNearestPowerOf2(long targetNumber) {
        long value = 1;
        int power = 0;

        while (value < targetNumber) {
            value <<= 1;
            power++;
        }
        return power;
    }


}
