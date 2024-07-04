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
            POWERS_OF_TWO.add(1L << i);
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
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            return "IMPOSSIBLE";
        }

        List<Long> powersCopy = new ArrayList<>(POWERS_OF_TWO);
        String primaryDirection = (x % 2 == 0) ? (x > 0 ? "E" : "W") : (y > 0 ? "N" : "S");
        String result = findPath(x % 2 == 0 ? x : y, powersCopy, primaryDirection);

        if (!result.equals("IMPOSSIBLE")) {
            int length = result.length();
            result = optimizePath(x, y, result, length, powersCopy);
        }

        return result;
    }

    private static String optimizePath(long x, long y, String initialResult, int length, List<Long> powers) {
        if (x % 2 != 0) {
            String result = tryDirections(x, length, initialResult, powers, "W", "E");
            return result.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : result;
        } else {
            String result = tryDirections(y, length, initialResult, powers, "S", "N");
            return result.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : result;
        }
    }

    private static String tryDirections(long coord, int length, String initialResult, List<Long> powers, String primaryDir, String secondaryDir) {
        String result = primaryDir + findAlternativePath(coord + 1, powers, primaryDir, length, initialResult);
        if (result.contains("IMPOSSIBLE")) {
            result = secondaryDir + findAlternativePath(coord - 1, powers, secondaryDir, length, initialResult);
        } else {
            String alternativeResult = secondaryDir + findAlternativePath(coord - 1, powers, secondaryDir, length, initialResult);
            if (!alternativeResult.contains("IMPOSSIBLE") && alternativeResult.length() < result.length()) {
                result = alternativeResult;
            }
        }
        return result;
    }

    private static String findAlternativePath(long coord, List<Long> powers, String direction, int length, String initialResult) {
        long absCoord = Math.abs(coord);
        for (int i = 1; i < length; i++) {
            absCoord -= powers.get(i);
            initialResult = direction + initialResult;
        }
        if (absCoord > 0) {
            absCoord -= powers.get(length);
            initialResult += direction;
        }
        return absCoord != 0 ? "IMPOSSIBLE" : initialResult;
    }

    private static String findPath(long coord, List<Long> powers, String direction) {
        long absCoord = Math.abs(coord);
        List<Long> usedPowers = new ArrayList<>();
        while (absCoord > 0) {
            int i = 0;
            while (powers.get(++i) < absCoord);
            absCoord -= powers.get(i);
            usedPowers.add(powers.get(i));
        }
        if (absCoord != 0) {
            return "IMPOSSIBLE";
        }
        powers.removeAll(usedPowers);
        return direction.repeat(usedPowers.size());
    }
}