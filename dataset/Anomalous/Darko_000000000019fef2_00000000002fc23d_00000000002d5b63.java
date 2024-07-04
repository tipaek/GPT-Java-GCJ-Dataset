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

        for (int t = 0; t < testCases; t++) {
            if (!processTestCase(scanner)) {
                System.exit(0);
            }
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

        return searchCenter(scanner, left, right, up, down);
    }

    private int findBoundary(Scanner scanner, int low, int high, boolean isHorizontal, boolean positiveDirection) {
        while (low < high) {
            int mid = (low + high) / 2;
            System.out.printf("%d %d\n", isHorizontal ? mid : 0, isHorizontal ? 0 : mid);
            System.out.flush();

            String response = scanner.nextLine().trim();
            switch (response) {
                case "HIT":
                    if (positiveDirection) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                    break;
                case "MISS":
                    if (positiveDirection) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                    break;
                case "CENTER":
                    return Integer.MAX_VALUE;
                default:
                    System.exit(0);
            }
        }
        return low;
    }

    private boolean searchCenter(Scanner scanner, int left, int right, int up, int down) {
        int[] xRange = calculateRange(left, right, true);
        int[] yRange = calculateRange(up, down, false);

        for (int x = xRange[0]; x <= xRange[1]; x++) {
            for (int y = yRange[0]; y <= yRange[1]; y++) {
                System.out.printf("%d %d\n", x, y);
                System.out.flush();

                String response = scanner.nextLine().trim();
                if ("CENTER".equals(response)) {
                    return true;
                } else if (!"HIT".equals(response) && !"MISS".equals(response)) {
                    System.exit(0);
                }
            }
        }
        return false;
    }

    private int[] calculateRange(int low, int high, boolean isHorizontal) {
        int mid = (low + high) / 2;
        int rangeLow = mid - 5;
        int rangeHigh = mid + 5;

        if (low == 0) {
            rangeLow = LIMIT / 4 - 5;
            rangeHigh = LIMIT / 4 + 5;
        } else if (high == 0) {
            rangeLow = -LIMIT / 4 - 5;
            rangeHigh = -LIMIT / 4 + 5;
        }

        return new int[]{rangeLow, rangeHigh};
    }
}