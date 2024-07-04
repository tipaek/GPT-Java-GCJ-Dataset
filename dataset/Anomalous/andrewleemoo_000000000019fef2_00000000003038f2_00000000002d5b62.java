import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = input.nextInt();
            int y = input.nextInt();
            String result = solveCase(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solveCase(int x, int y) {
        int maxDistance = Math.abs(x) + Math.abs(y);
        int maxExponent = 0;
        int totalUnits = 1;

        while (totalUnits < maxDistance) {
            maxExponent++;
            totalUnits += (1 << maxExponent);
        }

        StringBuilder path = new StringBuilder();
        if (findPath(maxExponent + 1, x, y, path)) {
            return path.reverse().toString();
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static boolean findPath(int exp, int x, int y, StringBuilder path) {
        if (exp == 0) {
            return x == 0 && y == 0;
        }

        int step = 1 << (exp - 1);

        if (x > 0) {
            path.append("E");
            if (findPath(exp - 1, x - step, y, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        } else if (x < 0) {
            path.append("W");
            if (findPath(exp - 1, x + step, y, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }

        if (y > 0) {
            path.append("N");
            if (findPath(exp - 1, x, y - step, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        } else if (y < 0) {
            path.append("S");
            if (findPath(exp - 1, x, y + step, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }
}