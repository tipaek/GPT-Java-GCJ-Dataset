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
            test:
            {
                long hitX = Long.MIN_VALUE;
                long hitY = Long.MIN_VALUE;
                test2:
                for (long x = -f; x <= f; x += sh) {
                    for (long y = -f; y <= f; y += sh) {
                        System.out.println(x + " " + y);
                        switch (scanner.next()) {
                            case "CENTER":
                                break test;
                            case "HIT":
                                hitX = x;
                                hitY = y;
                                break test2;
                            case "MISS":
                                break;
                        }
                    }
                }
                
                hitX=0;
                hitY=0;

                long lowXU = 0;
                long highXU = Math.min(b, f - hitX);
                while (lowXU < highXU) {
                    long mid = (lowXU + highXU + 1) / 2;
                    System.out.println((hitX + mid) + " " + hitY);
                    switch (scanner.next()) {
                        case "CENTER":
                            break test;
                        case "HIT":
                            lowXU = mid;
                            break;
                        case "MISS":
                            highXU = mid - 1;
                            break;
                    }
                }
                long lowXL = 0;
                long highXL = Math.min(b, hitX + f);
                while (lowXL < highXL) {
                    long mid = (lowXL + highXL + 1) / 2;
                    System.out.println((hitX - mid) + " " + hitY);
                    switch (scanner.next()) {
                        case "CENTER":
                            break test;
                        case "HIT":
                            lowXL = mid;
                            break;
                        case "MISS":
                            highXL = mid - 1;
                            break;
                    }
                }
                long centerX = (lowXU - lowXL) / 2 + hitX;

                long lowYU = 0;
                long highYU = Math.min(b, f - hitY);
                while (lowYU < highYU) {
                    long mid = (lowYU + highYU + 1) / 2;
                    System.out.println(hitX + " " + (hitY + mid));
                    switch (scanner.next()) {
                        case "CENTER":
                            break test;
                        case "HIT":
                            lowYU = mid;
                            break;
                        case "MISS":
                            highYU = mid - 1;
                            break;
                    }
                }
                long lowYL = 0;
                long highYL = Math.min(b, hitY + f);
                while (lowYL < highYL) {
                    long mid = (lowYL + highYL + 1) / 2;
                    System.out.println(hitX + " " + (hitY - mid));
                    switch (scanner.next()) {
                        case "CENTER":
                            break test;
                        case "HIT":
                            lowYL = mid;
                            break;
                        case "MISS":
                            highYL = mid - 1;
                            break;
                    }
                }
                long centerY = (lowYU - lowYL) / 2 + hitY;

                System.out.println(centerX + " " + centerY);
                if (!scanner.next().equals("CENTER")) System.exit(0);
            }
        }
    }
}
