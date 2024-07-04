import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final int LIMIT = 1000000000;

    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().split("\\s+");
        int testCases = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        while (testCases-- > 0) {
            if (processTestCase(scanner)) continue;
        }

        scanner.close();
        System.out.close();
    }

    private boolean processTestCase(Scanner scanner) {
        int left = findBoundary(scanner, -LIMIT, 0, true, false);
        if (left == Integer.MAX_VALUE) return true;

        int right = findBoundary(scanner, 0, LIMIT, true, true);
        if (right == Integer.MAX_VALUE) return true;

        int up = findBoundary(scanner, 0, LIMIT, false, true);
        if (up == Integer.MAX_VALUE) return true;

        int down = findBoundary(scanner, -LIMIT, 0, false, false);
        if (down == Integer.MAX_VALUE) return true;

        int[] xRange = determineRange(left, right, true);
        int[] yRange = determineRange(up, down, false);

        return searchCenter(scanner, xRange, yRange);
    }

    private int findBoundary(Scanner scanner, int low, int high, boolean isHorizontal, boolean isPositive) {
        while (low < high) {
            int mid = (low + high) / 2;
            int x = isHorizontal ? mid : 0;
            int y = isHorizontal ? 0 : mid;
            System.out.printf("%d %d\n", x, y);
            System.out.flush();

            String response = scanner.nextLine().trim();
            switch (response) {
                case "HIT":
                    if (isPositive) low = mid + 1;
                    else high = mid - 1;
                    break;
                case "MISS":
                    if (isPositive) high = mid;
                    else low = mid;
                    break;
                case "CENTER":
                    return Integer.MAX_VALUE;
                default:
                    System.exit(0);
            }
        }
        return low;
    }

    private int[] determineRange(int boundary1, int boundary2, boolean isHorizontal) {
        int center = (boundary1 + boundary2) / 2;
        int offset = LIMIT / 4;
        int lowerBound = center - 5;
        int upperBound = center + 5;

        if (boundary1 == 0 || boundary2 == 0) {
            lowerBound = (isHorizontal ? offset : -offset) - 5;
            upperBound = (isHorizontal ? offset : -offset) + 5;
        }

        return new int[]{lowerBound, upperBound};
    }

    private boolean searchCenter(Scanner scanner, int[] xRange, int[] yRange) {
        for (int x = xRange[0]; x <= xRange[1]; x++) {
            for (int y = yRange[0]; y <= yRange[1]; y++) {
                System.out.printf("%d %d\n", x, y);
                System.out.flush();

                String response = scanner.nextLine().trim();
                if ("CENTER".equals(response)) return true;
                if (!"HIT".equals(response) && !"MISS".equals(response)) System.exit(0);
            }
        }
        System.exit(0);
        return false;
    }
}