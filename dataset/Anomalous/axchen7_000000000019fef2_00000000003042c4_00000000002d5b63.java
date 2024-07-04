import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long step = ((long) Math.floor(a * 2 / 1.5)) / 2;
        long f = 1000000000;

        for (int curT = 1; curT <= t; curT++) {
            long hitX = Long.MIN_VALUE;
            long hitY = Long.MIN_VALUE;

            outerLoop:
            for (long x = -f; x <= f; x += step) {
                for (long y = -f; y <= f; y += step) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if (response.equals("CENTER")) {
                        break outerLoop;
                    } else if (response.equals("HIT")) {
                        hitX = x;
                        hitY = y;
                        break outerLoop;
                    }
                }
            }

            if (hitX == Long.MIN_VALUE || hitY == Long.MIN_VALUE) {
                continue;
            }

            long centerX = findCoordinate(hitX, hitY, b, f, true, scanner);
            long centerY = findCoordinate(hitX, hitY, b, f, false, scanner);

            System.out.println(centerX + " " + centerY);
            if (!scanner.next().equals("CENTER")) {
                System.exit(0);
            }
        }
    }

    private static long findCoordinate(long hitX, long hitY, long b, long f, boolean isX, Scanner scanner) {
        long lowU = 0;
        long highU = Math.min(b, f - (isX ? hitX : hitY));
        while (lowU < highU) {
            long mid = (lowU + highU + 1) / 2;
            System.out.println((isX ? hitX + mid : hitX) + " " + (isX ? hitY : hitY + mid));
            String response = scanner.next();
            if (response.equals("CENTER")) {
                return isX ? hitX + mid : hitY + mid;
            } else if (response.equals("HIT")) {
                lowU = mid;
            } else {
                highU = mid - 1;
            }
        }

        long lowL = 0;
        long highL = Math.min(b, (isX ? hitX : hitY) + f);
        while (lowL < highL) {
            long mid = (lowL + highL + 1) / 2;
            System.out.println((isX ? hitX - mid : hitX) + " " + (isX ? hitY : hitY - mid));
            String response = scanner.next();
            if (response.equals("CENTER")) {
                return isX ? hitX - mid : hitY - mid;
            } else if (response.equals("HIT")) {
                lowL = mid;
            } else {
                highL = mid - 1;
            }
        }

        return (lowU - lowL) / 2 + (isX ? hitX : hitY);
    }
}