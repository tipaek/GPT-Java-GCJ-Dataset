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

        for (int curT = 1; curT <= t; curT++) {
            outerLoop:
            {
                long hitX = 0;
                long hitY = 0;

                for (long x = -boundary; x <= boundary; x += searchStep) {
                    for (long y = -boundary; y <= boundary; y += searchStep) {
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

                long lowXU = 0;
                long highXU = b;
                while (lowXU < highXU) {
                    long mid = (lowXU + highXU + 1) / 2;
                    System.out.println((hitX + mid) + " " + hitY);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowXU = mid;
                    } else if ("MISS".equals(response)) {
                        highXU = mid - 1;
                    }
                }

                long lowXL = 0;
                long highXL = b;
                while (lowXL < highXL) {
                    long mid = (lowXL + highXL + 1) / 2;
                    System.out.println((hitX - mid) + " " + hitY);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowXL = mid;
                    } else if ("MISS".equals(response)) {
                        highXL = mid - 1;
                    }
                }

                long centerX = (lowXU - lowXL) / 2 + hitX;

                long lowYU = 0;
                long highYU = b;
                while (lowYU < highYU) {
                    long mid = (lowYU + highYU + 1) / 2;
                    System.out.println(hitX + " " + (hitY + mid));
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowYU = mid;
                    } else if ("MISS".equals(response)) {
                        highYU = mid - 1;
                    }
                }

                long lowYL = 0;
                long highYL = b;
                while (lowYL < highYL) {
                    long mid = (lowYL + highYL + 1) / 2;
                    System.out.println(hitX + " " + (hitY - mid));
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    } else if ("HIT".equals(response)) {
                        lowYL = mid;
                    } else if ("MISS".equals(response)) {
                        highYL = mid - 1;
                    }
                }

                long centerY = (lowYU - lowYL) / 2 + hitY;

                System.out.println(centerX + " " + centerY);
                System.exit(0);
            }
        }
    }
}