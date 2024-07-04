import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long step = ((int) Math.floor(a * 2 / 1.5)) / 2;
        long maxCoordinate = 1000000000;

        for (int testCase = 1; testCase <= t; testCase++) {
            long hitX = Long.MIN_VALUE;
            long hitY = Long.MIN_VALUE;

            // Initial grid search
            outerLoop:
            for (long x = -maxCoordinate; x <= maxCoordinate; x += step) {
                for (long y = -maxCoordinate; y <= maxCoordinate; y += step) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    switch (response) {
                        case "CENTER":
                            continue outerLoop;
                        case "HIT":
                            hitX = x;
                            hitY = y;
                            break outerLoop;
                        case "MISS":
                            break;
                    }
                }
            }

            if (hitX == Long.MIN_VALUE) {
                hitX = 0;
                hitY = 0;
            }

            // Binary search for x-coordinate
            long lowX = 0;
            long highX = Math.min(b, maxCoordinate - hitX);
            while (lowX < highX) {
                long mid = (lowX + highX + 1) / 2;
                System.out.println((hitX + mid) + " " + hitY);
                String response = scanner.next();
                switch (response) {
                    case "CENTER":
                        continue outerLoop;
                    case "HIT":
                        lowX = mid;
                        break;
                    case "MISS":
                        highX = mid - 1;
                        break;
                }
            }
            long centerX = hitX + (lowX - (Math.min(b, hitX + maxCoordinate) - lowX)) / 2;

            // Binary search for y-coordinate
            long lowY = 0;
            long highY = Math.min(b, maxCoordinate - hitY);
            while (lowY < highY) {
                long mid = (lowY + highY + 1) / 2;
                System.out.println(hitX + " " + (hitY + mid));
                String response = scanner.next();
                switch (response) {
                    case "CENTER":
                        continue outerLoop;
                    case "HIT":
                        lowY = mid;
                        break;
                    case "MISS":
                        highY = mid - 1;
                        break;
                }
            }
            long centerY = hitY + (lowY - (Math.min(b, hitY + maxCoordinate) - lowY)) / 2;

            // Output the final guess
            System.out.println(centerX + " " + centerY);
            if (!scanner.next().equals("CENTER")) System.exit(0);
        }
    }
}