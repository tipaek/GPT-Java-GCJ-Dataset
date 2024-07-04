import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean isCenterFound = false;
            int centerX = 0, centerY = 0;

            if (a == 999999995) {
                isCenterFound = searchCenterInSmallArea();
            }

            if (!isCenterFound) {
                isCenterFound = searchCenterInLargeArea(a);
            }

            if (!isCenterFound) {
                centerX = refineCoordinate(centerX, centerY, true, true);
                centerX = refineCoordinate(centerX, centerY, true, false);
                centerY = refineCoordinate(centerX, centerY, false, true);
                centerY = refineCoordinate(centerX, centerY, false, false);

                isCenterFound = searchCenterInSmallAreaAround(centerX, centerY);
            }

            if (!isCenterFound) {
                System.out.println("FAIL");
            }
        }

        scanner.close();
    }

    private static boolean searchCenterInSmallArea() {
        for (int i = -7; i <= 7; i++) {
            for (int j = -7; j <= 7; j++) {
                if (query(i, j) == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchCenterInLargeArea(int a) {
        boolean hit = false;
        int s1 = 0, s2 = 0;

        for (int i = -1000000000 + a / 2; i <= 1000000000 && !hit; i += a) {
            for (int j = -1000000000 + a / 2; j <= 1000000000 && !hit; j += a) {
                int q = query(i, j);
                if (q == 1) {
                    s1 = i;
                    s2 = j;
                    hit = true;
                }
                if (q == 2) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int refineCoordinate(int s1, int s2, boolean isX, boolean isPositive) {
        double dist = Math.abs((isPositive ? 1000000000 : -1000000000 - (isX ? s1 : s2))) / 4.0;
        double coord1 = (s1 - 1000000000) / 2.0;
        double coord2 = (s1 + 1000000000) / 2.0;

        while (dist > 1) {
            int q = query(isX ? coord1 : s1, isX ? s2 : coord1);
            if (q == 0) {
                coord1 += dist;
            } else if (q == 1) {
                coord1 -= dist;
            } else {
                return (int) ((coord1 + coord2) / 2);
            }
            dist /= 2;
        }

        return (int) ((coord1 + coord2) / 2);
    }

    private static boolean searchCenterInSmallAreaAround(int centerX, int centerY) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                if (query(centerX + i, centerY + j) == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int query(double x, double y) {
        System.out.print(((int) x) + " " + ((int) y));
        String response = scanner.next();
        if (response.equals("MISS")) {
            return 0;
        } else if (response.equals("HIT")) {
            return 1;
        } else {
            return 2;
        }
    }
}