import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String findPath(int x, int y) {
        if (x % 2 == y % 2) {
            return "IMPOSSIBLE";
        }

        if (x <= 1 && y <= 1) {
            return (x == 1) ? "E" : "N";
        }

        if (x % 2 == 1) {
            if ((x - 1) % 4 == y % 4) {
                return "W" + findPath((x + 1) / 2, y / 2);
            } else {
                return "E" + findPath(x / 2, y / 2);
            }
        }

        if (y % 2 == 1) {
            if ((y - 1) % 4 == x % 4) {
                return "S" + findPath(x / 2, (y + 1) / 2);
            } else {
                return "N" + findPath(x / 2, y / 2);
            }
        }

        return "what the";
    }

    public static String adjustPath(String path, boolean xPositive, boolean yPositive) {
        StringBuilder adjustedPath = new StringBuilder();

        for (char direction : path.toCharArray()) {
            switch (direction) {
                case 'N':
                    adjustedPath.append(yPositive ? "N" : "S");
                    break;
                case 'S':
                    adjustedPath.append(yPositive ? "S" : "N");
                    break;
                case 'W':
                    adjustedPath.append(xPositive ? "W" : "E");
                    break;
                case 'E':
                    adjustedPath.append(xPositive ? "E" : "W");
                    break;
            }
        }

        return adjustedPath.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean xPositive = x >= 0;
            boolean yPositive = y >= 0;

            x = Math.abs(x);
            y = Math.abs(y);

            String path = findPath(x, y);

            if (!path.equals("IMPOSSIBLE")) {
                path = adjustPath(path, xPositive, yPositive);
            }

            System.out.println("Case #" + t + ": " + path);
        }

        scanner.close();
    }
}