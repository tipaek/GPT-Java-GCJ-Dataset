import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sh = ((int) Math.floor(a * 2 / 1.5)) / 2;
        long s = sh * 2;
        long f = 1000000000;

        for (int curT = 1; curT <= t; curT++) {
            outerLoop:
            {
                long hitX = Long.MIN_VALUE;
                long hitY = Long.MIN_VALUE;

                for (long x = -f; x <= f; x += s) {
                    for (long y = -f; y <= f; y += s) {
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

                long lowXU = 0, highXU = b, lowXL = 0, highXL = b;
                long temp = 0;

                while (lowXU < highXU) {
                    long mid = (lowXU + highXU + 1) / 2;
                    System.out.println((hitX + mid) + " " + hitY);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowXU = mid;
                    } else {
                        highXU = mid - 1;
                    }
                    if (++temp > 40) System.exit(0);
                }

                while (lowXL < highXL) {
                    long mid = (lowXL + highXL + 1) / 2;
                    System.out.println((hitX - mid) + " " + hitY);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowXL = mid;
                    } else {
                        highXL = mid - 1;
                    }
                }

                long centerX = (lowXU - lowXL) / 2 + hitX;

                long lowYU = 0, highYU = b, lowYL = 0, highYL = b;

                while (lowYU < highYU) {
                    long mid = (lowYU + highYU + 1) / 2;
                    System.out.println(hitX + " " + (hitY + mid));
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowYU = mid;
                    } else {
                        highYU = mid - 1;
                    }
                }

                while (lowYL < highYL) {
                    long mid = (lowYL + highYL + 1) / 2;
                    System.out.println(hitX + " " + (hitY - mid));
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowYL = mid;
                    } else {
                        highYL = mid - 1;
                    }
                }

                long centerY = (lowYU - lowYL) / 2 + hitY;

                System.out.println(centerX + " " + centerY);
                scanner.next();
                System.exit(0);
            }
        }
    }
}