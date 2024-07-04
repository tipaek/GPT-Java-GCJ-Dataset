import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long searchHalf = ((int) Math.floor(a * 2 / 1.5)) / 2;
        long searchStep = searchHalf * 2;
        long boundary = 1000000000;

        for (int curTest = 1; curTest <= t; curTest++) {
            long hitX = 0;
            long hitY = 0;
            boolean found = false;

            outerLoop:
            for (long x = -boundary; x <= boundary; x += searchStep) {
                for (long y = -boundary; y <= boundary; y += searchStep) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        found = true;
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        hitX = x;
                        hitY = y;
                        break outerLoop;
                    }
                }
            }

            if (found) continue;

            long centerX = binarySearch(scanner, hitX, hitY, b, true);
            long centerY = binarySearch(scanner, hitX, hitY, b, false);

            System.out.println(centerX + " " + centerY);
            if (!"CENTER".equals(scanner.next())) {
                System.exit(0);
            }
        }
    }

    private static long binarySearch(Scanner scanner, long hitX, long hitY, long b, boolean isX) {
        long low = 0;
        long high = b;
        long fixedCoord = isX ? hitY : hitX;

        while (low < high) {
            long mid = (low + high + 1) / 2;
            long variableCoord = isX ? hitX + mid : hitY + mid;
            System.out.println(isX ? (variableCoord + " " + fixedCoord) : (fixedCoord + " " + variableCoord));
            String response = scanner.next();
            if ("CENTER".equals(response)) {
                return variableCoord;
            } else if ("HIT".equals(response)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        long lowCoord = low;
        low = 0;
        high = b;

        while (low < high) {
            long mid = (low + high + 1) / 2;
            long variableCoord = isX ? hitX - mid : hitY - mid;
            System.out.println(isX ? (variableCoord + " " + fixedCoord) : (fixedCoord + " " + variableCoord));
            String response = scanner.next();
            if ("CENTER".equals(response)) {
                return variableCoord;
            } else if ("HIT".equals(response)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        long highCoord = low;
        return (lowCoord - highCoord) / 2 + (isX ? hitX : hitY);
    }
}