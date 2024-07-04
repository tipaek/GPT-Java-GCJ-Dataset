import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUT = System.out;
    private static final List<Long> POWERS_OF_TWO = new ArrayList<>();

    static {
        for (int i = 0; i < 32; i++) {
            POWERS_OF_TWO.add(1L << i);  // Using bitwise shift for powers of two
        }
    }

    public static void main(String[] args) {
        int testCases = IN.nextInt();

        for (int t = 1; t <= testCases; t++) {
            long x = IN.nextLong();
            long y = IN.nextLong();
            String result = solve(x, y);
            OUT.println("Case #" + t + ": " + result);
        }
    }

    private static String solve(long x, long y) {
        if (x == 0 && y == 0) {
            return "";
        }
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            return "IMPOSSIBLE";
        }

        List<Long> availablePowers = new ArrayList<>(POWERS_OF_TWO);
        String result;
        if (x % 2 == 0) {
            result = findPath(x, availablePowers, x > 0 ? "E" : "W");
        } else {
            result = findPath(y, availablePowers, y > 0 ? "N" : "S");
        }

        if (!"IMPOSSIBLE".equals(result)) {
            int length = result.length();
            String alternativePath;
            if (x % 2 != 0) {
                alternativePath = tryAlternativePath(x, availablePowers, length, result, "W", "E");
            } else {
                alternativePath = tryAlternativePath(y, availablePowers, length, result, "S", "N");
            }
            if (!"IMPOSSIBLE".equals(alternativePath)) {
                result += alternativePath;
            } else {
                result = "IMPOSSIBLE";
            }
        }

        return result;
    }

    private static String tryAlternativePath(long coordinate, List<Long> availablePowers, int length, String result, String firstDir, String secondDir) {
        String path = firstDir + findAlternativePath(coordinate + 1, availablePowers, firstDir, length, result);
        if (path.contains("IMPOSSIBLE")) {
            path = secondDir + findAlternativePath(coordinate - 1, availablePowers, secondDir, length, result);
        } else {
            String alternativePath = secondDir + findAlternativePath(coordinate - 1, availablePowers, secondDir, length, result);
            if (!alternativePath.contains("IMPOSSIBLE") && alternativePath.length() < path.length()) {
                path = alternativePath;
            }
        }
        return path.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : path;
    }

    private static String findAlternativePath(long coordinate, List<Long> availablePowers, String direction, int length, String result) {
        long absCoordinate = Math.abs(coordinate);
        for (int i = 1; i < length; i++) {
            absCoordinate -= availablePowers.get(i);
            result = direction + result;
        }
        if (absCoordinate > 0) {
            absCoordinate -= availablePowers.get(length == 0 ? 1 : length);
            result += direction;
        }
        return absCoordinate != 0 ? "IMPOSSIBLE" : result;
    }

    private static String findPath(long coordinate, List<Long> availablePowers, String direction) {
        long absCoordinate = Math.abs(coordinate);
        List<Long> usedPowers = new ArrayList<>();
        while (absCoordinate > 0) {
            int i = 0;
            while (availablePowers.get(++i) < absCoordinate) ;
            absCoordinate -= availablePowers.get(i);
            usedPowers.add(availablePowers.get(i));
        }
        if (absCoordinate != 0) {
            return "IMPOSSIBLE";
        }
        availablePowers.removeAll(usedPowers);
        return direction.repeat(usedPowers.size());
    }
}