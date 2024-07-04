import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sh = (long) Math.floor(a * 2 / 1.5) / 2;
        long s = sh * 2;
        long f = 1000000000;

        for (int curT = 1; curT <= t; curT++) {
            long hitX = 0;
            long hitY = 0;
            boolean foundHit = false;

            for (long x = -f + sh; x + sh <= f && !foundHit; x += s) {
                for (long y = -f + sh; y + sh <= f && !foundHit; y += s) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    switch (response) {
                        case "CENTER":
                            foundHit = true;
                            break;
                        case "HIT":
                            hitX = x;
                            hitY = y;
                            foundHit = true;
                            break;
                        case "MISS":
                            break;
                    }
                }
            }

            if (foundHit) {
                long centerX = binarySearch(hitX, hitY, b, true, scanner);
                long centerY = binarySearch(hitX, hitY, b, false, scanner);
                System.out.println(centerX + " " + centerY);
                scanner.next(); // Read the final CENTER response
            }
        }
    }

    private static long binarySearch(long hitX, long hitY, long b, boolean isHorizontal, Scanner scanner) {
        long low = 0;
        long high = b;

        while (low < high) {
            long mid = (low + high + 1) / 2;
            long testX = isHorizontal ? hitX + mid : hitX;
            long testY = isHorizontal ? hitY : hitY + mid;

            System.out.println(testX + " " + testY);
            String response = scanner.next();
            switch (response) {
                case "CENTER":
                    return isHorizontal ? testX : testY;
                case "HIT":
                    low = mid;
                    break;
                case "MISS":
                    high = mid - 1;
                    break;
            }
        }

        long low2 = 0;
        long high2 = b;
        while (low2 < high2) {
            long mid = (low2 + high2 + 1) / 2;
            long testX = isHorizontal ? hitX - mid : hitX;
            long testY = isHorizontal ? hitY : hitY - mid;

            System.out.println(testX + " " + testY);
            String response = scanner.next();
            switch (response) {
                case "CENTER":
                    return isHorizontal ? testX : testY;
                case "HIT":
                    low2 = mid;
                    break;
                case "MISS":
                    high2 = mid - 1;
                    break;
            }
        }

        return isHorizontal ? (low - low2) / 2 + hitX : (low - low2) / 2 + hitY;
    }
}