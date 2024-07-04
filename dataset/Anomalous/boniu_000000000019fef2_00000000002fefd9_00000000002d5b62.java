import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath(x, y, 1);
            if (result.equals("0")) {
                result = "IMPOSSIBLE";
            }
            System.out.printf("Case #%d: %s%n", t, result);
        }
    }

    public static String findPath(int x, int y, int step) {
        // Check if it's impossible
        if (x % step != 0 || y % step != 0) {
            return "0";
        }
        x /= step;
        y /= step;
        step /= step;

        if (x == 1 && y == 1 && step == 1) {
            return "0";
        }

        if (x == step && y == 0) {
            return "E";
        } else if (x == -step && y == 0) {
            return "W";
        } else if (y == step && x == 0) {
            return "N";
        } else if (y == -step && x == 0) {
            return "S";
        }

        // Explore all possible directions
        String[] results = {
            "E" + findPath(x - 1, y, step * 2),
            "W" + findPath(x + 1, y, step * 2),
            "N" + findPath(x, y - 1, step * 2),
            "S" + findPath(x, y + 1, step * 2)
        };

        int minLen = Integer.MAX_VALUE;
        String bestResult = "0";
        for (String res : results) {
            if (!res.contains("0") && res.length() < minLen) {
                minLen = res.length();
                bestResult = res;
            }
        }

        return bestResult;
    }
}