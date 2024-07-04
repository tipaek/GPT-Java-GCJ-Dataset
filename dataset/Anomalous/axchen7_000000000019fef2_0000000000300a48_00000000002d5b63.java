import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long stepSize = ((int) Math.floor(a * 2 / 1.5)) / 2;
        long step = stepSize * 2;
        long boundary = 1000000000;

        for (int curT = 1; curT <= t; curT++) {
            long hitX = 0;
            long hitY = 0;

            outerLoop:
            for (long x = -boundary; x <= boundary; x += step) {
                for (long y = -boundary; y <= boundary; y += step) {
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

            long centerX = findCenter(hitX, hitY, b, scanner, true);
            long centerY = findCenter(hitX, hitY, b, scanner, false);

            System.out.println(centerX + " " + centerY);
            if (!scanner.next().equals("CENTER")) {
                System.exit(0);
            }
        }
    }

    private static long findCenter(long hitX, long hitY, long b, Scanner scanner, boolean isX) {
        long lowPositive = 0;
        long highPositive = b;
        long lowNegative = 0;
        long highNegative = b;

        while (lowPositive < highPositive) {
            long mid = (lowPositive + highPositive + 1) / 2;
            System.out.println((isX ? (hitX + mid) : hitX) + " " + (isX ? hitY : (hitY + mid)));
            String response = scanner.next();
            if (response.equals("CENTER")) {
                return 0; // Center found, no need to continue
            } else if (response.equals("HIT")) {
                lowPositive = mid;
            } else {
                highPositive = mid - 1;
            }
        }

        while (lowNegative < highNegative) {
            long mid = (lowNegative + highNegative + 1) / 2;
            System.out.println((isX ? (hitX - mid) : hitX) + " " + (isX ? hitY : (hitY - mid)));
            String response = scanner.next();
            if (response.equals("CENTER")) {
                return 0; // Center found, no need to continue
            } else if (response.equals("HIT")) {
                lowNegative = mid;
            } else {
                highNegative = mid - 1;
            }
        }

        return (lowPositive - lowNegative) / 2 + (isX ? hitX : hitY);
    }
}