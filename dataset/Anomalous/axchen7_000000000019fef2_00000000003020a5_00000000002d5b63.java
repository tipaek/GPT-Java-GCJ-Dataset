import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sh = (long) (Math.floor(a * 2 / 1.5)) / 2;
        long s = sh * 2;
        long f = 1000000000L;

        for (int curT = 1; curT <= t; curT++) {
            boolean foundCenter = false;

            long hitX = Long.MIN_VALUE;
            long hitY = Long.MIN_VALUE;

            outerLoop:
            for (long x = -f; x <= f; x += s) {
                for (long y = -f; y <= f; y += s) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();

                    switch (response) {
                        case "CENTER":
                            foundCenter = true;
                            break outerLoop;
                        case "HIT":
                            hitX = x;
                            hitY = y;
                            break outerLoop;
                        case "MISS":
                            break;
                    }
                }
            }

            if (foundCenter) continue;

            long centerX = findCoordinate(scanner, hitX, hitY, b, true);
            long centerY = findCoordinate(scanner, hitX, hitY, b, false);

            System.out.println(centerX + " " + centerY);
            if ("CENTER".equals(scanner.next())) {
                break;
            }
        }
    }

    private static long findCoordinate(Scanner scanner, long hitX, long hitY, long b, boolean isX) {
        long lowU = 0;
        long highU = b;
        long coordinate = isX ? hitX : hitY;

        while (lowU < highU) {
            long mid = (lowU + highU + 1) / 2;
            if (isX) {
                System.out.println((coordinate + mid) + " " + hitY);
            } else {
                System.out.println(hitX + " " + (coordinate + mid));
            }

            String response = scanner.next();
            switch (response) {
                case "CENTER":
                    return coordinate + mid;
                case "HIT":
                    lowU = mid;
                    break;
                case "MISS":
                    highU = mid - 1;
                    break;
            }
        }

        long lowL = 0;
        long highL = b;

        while (lowL < highL) {
            long mid = (lowL + highL + 1) / 2;
            if (isX) {
                System.out.println((coordinate - mid) + " " + hitY);
            } else {
                System.out.println(hitX + " " + (coordinate - mid));
            }

            String response = scanner.next();
            switch (response) {
                case "CENTER":
                    return coordinate - mid;
                case "HIT":
                    lowL = mid;
                    break;
                case "MISS":
                    highL = mid - 1;
                    break;
            }
        }

        return (lowU - lowL) / 2 + coordinate;
    }
}