import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sh = (long) (Math.floor(a * 2 / 1.5) / 2);
        long s = sh * 2;
        long f = 1_000_000_000;

        for (int curT = 1; curT <= t; curT++) {
            long hitX = Long.MIN_VALUE;
            long hitY = Long.MIN_VALUE;

            outerLoop:
            for (long x = -f; x <= f; x += s) {
                for (long y = -f; y <= f; y += s) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if (response.equals("CENTER")) {
                        break outerLoop;
                    } else if (response.equals("HIT")) {
                        hitX = x;
                        hitY = y;
                        break;
                    }
                }
            }

            long centerX = findCoordinate(hitX, hitY, b, scanner, true);
            long centerY = findCoordinate(hitX, hitY, b, scanner, false);

            System.out.println(centerX + " " + centerY);
            scanner.next();
            System.exit(0);
        }
    }

    private static long findCoordinate(long hitX, long hitY, long b, Scanner scanner, boolean isHorizontal) {
        long lowPos = 0;
        long highPos = b;
        while (lowPos < highPos) {
            long mid = (lowPos + highPos + 1) / 2;
            if (isHorizontal) {
                System.out.println((hitX + mid) + " " + hitY);
            } else {
                System.out.println(hitX + " " + (hitY + mid));
            }
            String response = scanner.next();
            if (response.equals("CENTER")) {
                System.exit(0);
            } else if (response.equals("HIT")) {
                lowPos = mid;
            } else if (response.equals("MISS")) {
                highPos = mid - 1;
            } else if (response.equals("WRONG")) {
                System.exit(0);
            }
        }

        long lowNeg = 0;
        long highNeg = b;
        while (lowNeg < highNeg) {
            long mid = (lowNeg + highNeg + 1) / 2;
            if (isHorizontal) {
                System.out.println((hitX - mid) + " " + hitY);
            } else {
                System.out.println(hitX + " " + (hitY - mid));
            }
            String response = scanner.next();
            if (response.equals("CENTER")) {
                System.exit(0);
            } else if (response.equals("HIT")) {
                lowNeg = mid;
            } else if (response.equals("MISS")) {
                highNeg = mid - 1;
            } else if (response.equals("WRONG")) {
                System.exit(0);
            }
        }

        return (lowPos - lowNeg) / 2 + (isHorizontal ? hitX : hitY);
    }
}