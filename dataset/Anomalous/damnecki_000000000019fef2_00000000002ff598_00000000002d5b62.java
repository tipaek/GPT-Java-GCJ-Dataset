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
            String result = computeResult(x, y);
            OUT.println("Case #" + t + ": " + result);
        }
    }

    private static String computeResult(long x, long y) {
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            return "IMPOSSIBLE";
        }

        List<Long> powers = new ArrayList<>(POWERS_OF_TWO);
        String result;

        if (x % 2 == 0) {
            result = findPath(x, powers, x > 0 ? "E" : "W");
        } else {
            result = findPath(y, powers, y > 0 ? "N" : "S");
        }

        if (!"IMPOSSIBLE".equals(result)) {
            String alternativePath = findAlternativePath(x, y, powers, result.length());
            if (!"IMPOSSIBLE".equals(alternativePath)) {
                result += alternativePath;
            } else {
                result = "IMPOSSIBLE";
            }
        }

        return result;
    }

    private static String findAlternativePath(long x, long y, List<Long> powers, int length) {
        String path1, path2, path3;
        if (x % 2 != 0) {
            path1 = "W" + findPathWithLength(x + 1, powers, x + 1 > 0 ? "E" : "W", length);
            path2 = "E" + findPathWithLength(x - 1, powers, x - 1 > 0 ? "E" : "W", length);
            path3 = "E" + findPathWithLength(x - 1, powers, x - 1 > 0 ? "E" : "W", length);

            if (!"IMPOSSIBLE".equals(path1) && path1.length() < path2.length()) {
                path2 = path1;
            }
            if (!"IMPOSSIBLE".equals(path3) && path3.length() < path2.length()) {
                path2 = path3;
            }
        } else {
            path1 = "S" + findPathWithLength(y + 1, powers, y + 1 > 0 ? "N" : "S", length);
            path2 = "N" + findPathWithLength(y - 1, powers, y - 1 > 0 ? "N" : "S", length);
            path3 = "N" + findPathWithLength(y - 1, powers, y - 1 > 0 ? "N" : "S", length);

            if (!"IMPOSSIBLE".equals(path1) && path1.length() < path2.length()) {
                path2 = path1;
            }
            if (!"IMPOSSIBLE".equals(path3) && path3.length() < path2.length()) {
                path2 = path3;
            }
        }

        return path2.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : path2;
    }

    private static String findPathWithLength(long z, List<Long> powers, String direction, int length) {
        long absZ = Math.abs(z);
        List<Long> usedPowers = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            absZ -= powers.get(i);
            usedPowers.add(powers.get(i));
        }

        if (absZ > 0) {
            absZ -= powers.get(length == 0 ? 1 : length);
            usedPowers.add(powers.get(length == 0 ? 1 : length));
        }

        if (absZ != 0) {
            return "IMPOSSIBLE";
        }

        powers.removeAll(usedPowers);
        return direction.repeat(usedPowers.size());
    }

    private static String findPath(long z, List<Long> powers, String direction) {
        long absZ = Math.abs(z);
        List<Long> usedPowers = new ArrayList<>();

        while (absZ > 0) {
            int i = 0;
            while (powers.get(++i) < absZ) ;
            absZ -= powers.get(i);
            usedPowers.add(powers.get(i));
        }

        if (absZ != 0) {
            return "IMPOSSIBLE";
        }

        powers.removeAll(usedPowers);
        return direction.repeat(usedPowers.size());
    }
}