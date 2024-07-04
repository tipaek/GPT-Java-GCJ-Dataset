import java.io.*;
import java.util.*;

public class Solution {

    private static final long BORDER = 1_000_000_000;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < t; i++) {
            long hitX = 0, hitY = 0;

            // Search for an initial hit
            outerLoop:
            for (int j = 1; j <= 7; j++) {
                for (int k = 1; k <= 7; k++) {
                    long x = -BORDER + 2 * BORDER * j / 7;
                    long y = -BORDER + 2 * BORDER * k / 7;
                    System.out.println(x + " " + y);
                    System.out.flush();
                    String response = sc.next();
                    validateResponse(response);

                    if (response.equals("HIT") || response.equals("CENTER")) {
                        hitX = x;
                        hitY = y;
                        break outerLoop;
                    }
                }
            }

            long rightmost = binarySearch(hitX, hitY, true, true);
            long upmost = binarySearch(rightmost, hitY, false, false);
            long downmost = binarySearch(rightmost, hitY, false, true);
            long leftmost = binarySearch(hitX, upmost, true, false);

            long centerX = (leftmost + rightmost) / 2;
            long centerY = (upmost + downmost) / 2;

            // Fine-tune to find the center
            boolean centerFound = false;
            for (long dx = -4; dx <= 4 && !centerFound; dx++) {
                for (long dy = -4; dy <= 4 && !centerFound; dy++) {
                    long x = centerX + dx;
                    long y = centerY + dy;
                    System.out.println(x + " " + y);
                    System.out.flush();
                    String response = sc.next();
                    validateResponse(response);

                    if (response.equals("CENTER")) {
                        centerFound = true;
                    }
                }
            }
        }
    }

    private static long binarySearch(long fixed, long variable, boolean isXFixed, boolean findMax) {
        long low = findMax ? fixed : -BORDER;
        long high = findMax ? BORDER : fixed;
        long result = findMax ? low : high;

        while (low <= high) {
            long mid = (low + high) / 2;
            long x = isXFixed ? mid : fixed;
            long y = isXFixed ? variable : mid;
            System.out.println(x + " " + y);
            System.out.flush();
            String response = sc.next();
            validateResponse(response);

            if (response.equals("HIT") || response.equals("CENTER")) {
                result = findMax ? Math.max(result, mid) : Math.min(result, mid);
                if (findMax) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (findMax) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }

    private static void validateResponse(String response) {
        if (response.equals("WRONG")) {
            System.exit(1);
        }
    }
}