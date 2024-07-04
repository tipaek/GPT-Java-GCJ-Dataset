import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static Map<String, String> path = null;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        path = new HashMap<>();
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println("Case #" + (i + 1) + ": " + solve(x, y));
        }
    }

    private static String solve(int x, int y) {
        int total = Math.abs(x) + Math.abs(y);
        String binary = Integer.toBinaryString(total);

        int lastUnit = 1;
        for (int i = 0; i < binary.length() - 1; i++) {
            lastUnit *= 2;
        }

        String result = findPath(x, y, lastUnit);
        return result == null ? "IMPOSSIBLE" : result;
    }

    private static String findPath(int x, int y, int unit) {
        String dp = path.get(Arrays.asList(x, y, unit).toString());
        if (dp != null) {
            return dp;
        }

        int xDirection = -x;
        int yDirection = -y;

        if (unit == 1) {
            if (x == 1 && y == 0) {
                return "E";
            } else if (x == -1 && y == 0) {
                return "W";
            } else if (y == 1 && x == 0) {
                return "N";
            } else if (y == -1 && x == 0) {
                return "S";
            }
        } else {
            int nextX = xDirection > 0 ? x + unit : x - unit;
            int nextY = yDirection > 0 ? y + unit : y - unit;

            String nextXResult = findPath(nextX, y, unit / 2);
            String nextYResult = findPath(x, nextY, unit / 2);

            path.put(Arrays.asList(nextX, y, unit / 2).toString(), nextXResult);
            path.put(Arrays.asList(x, nextY, unit / 2).toString(), nextYResult);

            if (nextXResult == null) {
                if (nextYResult == null) {
                    return null;
                } else {
                    return nextYResult + (yDirection > 0 ? "S" : "N");
                }
            } else {
                if (nextYResult == null) {
                    return nextXResult + (xDirection > 0 ? "W" : "E");
                } else {
                    if (nextXResult.length() > nextYResult.length()) {
                        return nextYResult + (yDirection > 0 ? "S" : "N");
                    } else {
                        return nextXResult + (xDirection > 0 ? "W" : "E");
                    }
                }
            }
        }

        return null;
    }
}
