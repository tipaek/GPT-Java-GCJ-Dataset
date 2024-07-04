import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sh = (long) (Math.floor(a * 2 / 1.5)) / 2;
        long s = sh * 2;
        long f = 1000000000;

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

            long centerX = binarySearch(hitX, hitY, b, f, scanner, true);
            long centerY = binarySearch(hitX, hitY, b, f, scanner, false);

            System.out.println(centerX + " " + centerY);
            if (!scanner.next().equals("CENTER")) {
                System.exit(0);
            }
        }
    }

    private static long binarySearch(long hitX, long hitY, long b, long f, Scanner scanner, boolean isX) {
        long lowU = 0;
        long highU = Math.min(b, f - (isX ? hitX : hitY));
        long lowL = 0;
        long highL = Math.min(b, (isX ? hitX : hitY) + f);

        while (lowU < highU) {
            long mid = (lowU + highU + 1) / 2;
            System.out.println((isX ? (hitX + mid) : hitX) + " " + (isX ? hitY : (hitY + mid)));
            String response = scanner.next();
            if (response.equals("CENTER")) {
                return 0;
            } else if (response.equals("HIT")) {
                lowU = mid;
            } else {
                highU = mid - 1;
            }
        }

        while (lowL < highL) {
            long mid = (lowL + highL + 1) / 2;
            System.out.println((isX ? (hitX - mid) : hitX) + " " + (isX ? hitY : (hitY - mid)));
            String response = scanner.next();
            if (response.equals("CENTER")) {
                return 0;
            } else if (response.equals("HIT")) {
                lowL = mid;
            } else {
                highL = mid - 1;
            }
        }

        return (lowU - lowL) / 2 + (isX ? hitX : hitY);
    }
}