import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long searchStep = ((int) Math.floor(a * 2 / 1.5)) / 2;
        long stepSize = searchStep * 2;
        long boundary = 1000000000;

        for (int currentTest = 1; currentTest <= t; currentTest++) {
            long hitX = Long.MIN_VALUE;
            long hitY = Long.MIN_VALUE;

            outerLoop:
            for (long x = -boundary; x <= boundary; x += stepSize) {
                for (long y = -boundary; y <= boundary; y += stepSize) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        hitX = x;
                        hitY = y;
                        break;
                    }
                }
            }

            if (hitX == Long.MIN_VALUE) {
                System.exit(0);
            }

            long centerX = findCenterCoordinate(scanner, hitX, hitY, b, true);
            long centerY = findCenterCoordinate(scanner, hitX, hitY, b, false);

            System.out.println(centerX + " " + centerY);
            scanner.next();
            System.exit(0);
        }
    }

    private static long findCenterCoordinate(Scanner scanner, long hitX, long hitY, long b, boolean isX) {
        long lowUpper = 0;
        long highUpper = b;

        while (lowUpper < highUpper) {
            long mid = (lowUpper + highUpper + 1) / 2;
            long testCoordinate = isX ? (hitX + mid) : (hitY + mid);
            System.out.println(isX ? (testCoordinate + " " + hitY) : (hitX + " " + testCoordinate));
            String response = scanner.next();
            if ("CENTER".equals(response)) {
                return testCoordinate;
            } else if ("HIT".equals(response)) {
                lowUpper = mid;
            } else {
                highUpper = mid - 1;
            }
        }

        long lowLower = 0;
        long highLower = b;

        while (lowLower < highLower) {
            long mid = (lowLower + highLower + 1) / 2;
            long testCoordinate = isX ? (hitX - mid) : (hitY - mid);
            System.out.println(isX ? (testCoordinate + " " + hitY) : (hitX + " " + testCoordinate));
            String response = scanner.next();
            if ("CENTER".equals(response)) {
                return testCoordinate;
            } else if ("HIT".equals(response)) {
                lowLower = mid;
            } else {
                highLower = mid - 1;
            }
        }

        return (lowUpper - lowLower) / 2 + (isX ? hitX : hitY);
    }
}