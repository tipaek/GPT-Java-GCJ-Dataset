import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sh = (long) (Math.floor(a * 2 / 1.5) / 2);
        long s = sh * 2;
        long f = 1000000000;

        for (int curT = 1; curT <= t; curT++) {
            long hitX = 0, hitY = 0;
            boolean foundHit = false;

            for (long x = -f + sh; x + sh <= f; x += s) {
                for (long y = -f + sh; y + sh <= f; y += s) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if (response.equals("CENTER")) {
                        foundHit = true;
                        break;
                    } else if (response.equals("HIT")) {
                        hitX = x;
                        hitY = y;
                        foundHit = true;
                        break;
                    }
                }
                if (foundHit) break;
            }

            if (!foundHit) continue;

            long centerX = findCenter(hitX, hitY, b, true, scanner);
            long centerY = findCenter(hitX, hitY, b, false, scanner);

            System.out.println(centerX + " " + centerY);
            scanner.next(); // Read the final "CENTER" confirmation
        }
    }

    private static long findCenter(long hitX, long hitY, long b, boolean isX, Scanner scanner) {
        long lowU = 0, highU = b;
        while (lowU < highU) {
            long mid = (lowU + highU + 1) / 2;
            if (isX) {
                System.out.println((hitX + mid) + " " + hitY);
            } else {
                System.out.println(hitX + " " + (hitY + mid));
            }
            String response = scanner.next();
            if (response.equals("CENTER")) return 0;
            if (response.equals("HIT")) {
                lowU = mid;
            } else {
                highU = mid - 1;
            }
        }

        long lowL = 0, highL = b;
        while (lowL < highL) {
            long mid = (lowL + highL + 1) / 2;
            if (isX) {
                System.out.println((hitX - mid) + " " + hitY);
            } else {
                System.out.println(hitX + " " + (hitY - mid));
            }
            String response = scanner.next();
            if (response.equals("CENTER")) return 0;
            if (response.equals("HIT")) {
                lowL = mid;
            } else {
                highL = mid - 1;
            }
        }

        return (lowU - lowL) / 2 + (isX ? hitX : hitY);
    }
}