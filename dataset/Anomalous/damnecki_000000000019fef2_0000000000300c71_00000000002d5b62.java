import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;
    private static final List<Long> POWERS_OF_TWO = new ArrayList<>();

    static {
        for (int i = 0; i < 32; i++) {
            POWERS_OF_TWO.add(1L << i);
        }
    }

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int t = 1; t <= testCases; t++) {
            long x = SCANNER.nextLong();
            long y = SCANNER.nextLong();

            String result;
            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                result = "IMPOSSIBLE";
            } else {
                List<Long> availablePowers = new ArrayList<>(POWERS_OF_TWO);
                if (x % 2 == 0) {
                    result = findPath(x, availablePowers, x > 0 ? "E" : "W");
                } else {
                    result = findPath(y, availablePowers, y > 0 ? "N" : "S");
                }

                if (!result.equals("IMPOSSIBLE")) {
                    int length = result.length();
                    if (x % 2 != 0) {
                        result = findAlternativePath(x, availablePowers, length, result, "W", "E");
                    } else {
                        result = findAlternativePath(y, availablePowers, length, result, "S", "N");
                    }
                }
            }

            OUTPUT.println("Case #" + t + ": " + result);
        }
    }

    private static String findAlternativePath(long coordinate, List<Long> availablePowers, int length, String initialPath, String primaryDir, String secondaryDir) {
        String alternativePath = primaryDir + findPathWithOffset(coordinate + 1, availablePowers, coordinate + 1 > 0 ? secondaryDir : primaryDir, length, initialPath);
        if (alternativePath.contains("IMPOSSIBLE")) {
            alternativePath = secondaryDir + findPathWithOffset(coordinate - 1, availablePowers, coordinate - 1 > 0 ? secondaryDir : primaryDir, length, initialPath);
        } else {
            String secondaryAlternativePath = secondaryDir + findPathWithOffset(coordinate - 1, availablePowers, coordinate - 1 > 0 ? secondaryDir : primaryDir, length, initialPath);
            if (!secondaryAlternativePath.contains("IMPOSSIBLE") && secondaryAlternativePath.length() < alternativePath.length()) {
                alternativePath = secondaryAlternativePath;
            }
        }
        return alternativePath.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : initialPath + alternativePath;
    }

    private static String findPathWithOffset(long coordinate, List<Long> availablePowers, String direction, int length, String initialPath) {
        long absCoordinate = Math.abs(coordinate);
        for (int i = 1; i < length; i++) {
            absCoordinate -= availablePowers.get(i);
            initialPath = direction + initialPath;
        }
        if (absCoordinate > 0) {
            absCoordinate -= availablePowers.get(length == 0 ? 1 : length);
            initialPath += direction;
        }
        return absCoordinate != 0 ? "IMPOSSIBLE" : initialPath;
    }

    private static String findPath(long coordinate, List<Long> availablePowers, String direction) {
        long absCoordinate = Math.abs(coordinate);
        List<Long> usedPowers = new ArrayList<>();
        while (absCoordinate > 0) {
            int i = 0;
            while (availablePowers.get(++i) < absCoordinate);
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