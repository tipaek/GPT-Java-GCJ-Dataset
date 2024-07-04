import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static Map<String, String> pathCache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println("Case #" + (i + 1) + ": " + solve(x, y));
        }
    }

    private static String solve(int x, int y) {
        int totalDistance = Math.abs(x) + Math.abs(y);
        String binaryRepresentation = Integer.toBinaryString(totalDistance);

        int lastUnit = 1 << (binaryRepresentation.length() - 1);

        String result = findPath(x, y, lastUnit);
        return result == null ? "IMPOSSIBLE" : result;
    }

    private static String findPath(int x, int y, int unit) {
        String key = x + "," + y + "," + unit;
        if (pathCache.containsKey(key)) {
            return pathCache.get(key);
        }

        if (unit == 1) {
            if (x == 1 && y == 0) return "E";
            if (x == -1 && y == 0) return "W";
            if (y == 1 && x == 0) return "N";
            if (y == -1 && x == 0) return "S";
            return null;
        }

        int nextX = x + (x < 0 ? unit : -unit);
        int nextY = y + (y < 0 ? unit : -unit);

        String pathX = findPath(nextX, y, unit / 2);
        String pathY = findPath(x, nextY, unit / 2);

        if (pathX != null) {
            pathCache.put(key, pathX + (x < 0 ? "W" : "E"));
            return pathCache.get(key);
        }

        if (pathY != null) {
            pathCache.put(key, pathY + (y < 0 ? "S" : "N"));
            return pathCache.get(key);
        }

        return null;
    }
}