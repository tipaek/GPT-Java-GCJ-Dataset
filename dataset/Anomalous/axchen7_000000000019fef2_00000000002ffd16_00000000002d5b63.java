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
            boolean foundCenter = false;
            long hitX = 0, hitY = 0;

            // Search for an initial hit
            for (long x = -f; x <= f && !foundCenter; x += s) {
                for (long y = -f; y <= f; y += s) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if (response.equals("CENTER")) {
                        foundCenter = true;
                        break;
                    } else if (response.equals("HIT")) {
                        hitX = x;
                        hitY = y;
                        foundCenter = true;
                        break;
                    }
                }
            }

            if (foundCenter) continue;

            // Binary search for X coordinates
            long lowXU = 0, highXU = b;
            while (lowXU < highXU) {
                long mid = (lowXU + highXU + 1) / 2;
                System.out.println((hitX + mid) + " " + hitY);
                String response = scanner.next();
                if (response.equals("CENTER")) break;
                if (response.equals("HIT")) {
                    lowXU = mid;
                } else {
                    highXU = mid - 1;
                }
            }

            long lowXL = 0, highXL = b;
            while (lowXL < highXL) {
                long mid = (lowXL + highXL + 1) / 2;
                System.out.println((hitX - mid) + " " + hitY);
                String response = scanner.next();
                if (response.equals("CENTER")) break;
                if (response.equals("HIT")) {
                    lowXL = mid;
                } else {
                    highXL = mid - 1;
                }
            }

            long centerX = (lowXU - lowXL) / 2 + hitX;

            // Binary search for Y coordinates
            long lowYU = 0, highYU = b;
            while (lowYU < highYU) {
                long mid = (lowYU + highYU + 1) / 2;
                System.out.println(hitX + " " + (hitY + mid));
                String response = scanner.next();
                if (response.equals("CENTER")) break;
                if (response.equals("HIT")) {
                    lowYU = mid;
                } else {
                    highYU = mid - 1;
                }
            }

            long lowYL = 0, highYL = b;
            while (lowYL < highYL) {
                long mid = (lowYL + highYL + 1) / 2;
                System.out.println(hitX + " " + (hitY - mid));
                String response = scanner.next();
                if (response.equals("CENTER")) break;
                if (response.equals("HIT")) {
                    lowYL = mid;
                } else {
                    highYL = mid - 1;
                }
            }

            long centerY = (lowYU - lowYL) / 2 + hitY;

            System.out.println(centerX + " " + centerY);
            scanner.next();
        }
    }
}