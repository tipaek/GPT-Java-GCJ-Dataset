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
            POWERS_OF_TWO.add(1L << i); // More efficient way to calculate powers of 2
        }
    }

    public static void main(String[] args) {
        int testCases = IN.nextInt();
        for (int t = 1; t <= testCases; t++) {
            long x = IN.nextLong();
            long y = IN.nextLong();
            String result = solveCase(x, y);
            OUT.println("Case #" + t + ": " + result);
        }
    }

    private static String solveCase(long x, long y) {
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            return "IMPOSSIBLE";
        }

        List<Long> powers = new ArrayList<>(POWERS_OF_TWO);
        if (x % 2 == 0) {
            return findPath(x, powers, x > 0 ? "E" : "W");
        } else {
            String answer = findPath(y, powers, y > 0 ? "N" : "S");
            if (!answer.equals("IMPOSSIBLE")) {
                return finalizeAnswer(x, y, answer, powers);
            }
        }
        return "IMPOSSIBLE";
    }

    private static String finalizeAnswer(long x, long y, String initialAnswer, List<Long> powers) {
        int length = initialAnswer.length();
        String answer2, answer3;

        if (x % 2 != 0) {
            answer2 = "W" + findAlternativePath(x + 1, powers, x + 1 > 0 ? "E" : "W", length, initialAnswer);
            if (answer2.contains("IMPOSSIBLE")) {
                answer2 = "E" + findAlternativePath(x - 1, powers, x - 1 > 0 ? "E" : "W", length, initialAnswer);
            } else {
                answer3 = "E" + findAlternativePath(x - 1, powers, x - 1 > 0 ? "E" : "W", length, initialAnswer);
                if (!answer3.contains("IMPOSSIBLE") && answer3.length() < answer2.length()) {
                    answer2 = answer3;
                }
            }
        } else {
            answer2 = "S" + findAlternativePath(y + 1, powers, y + 1 > 0 ? "N" : "S", length, initialAnswer);
            if (answer2.contains("IMPOSSIBLE")) {
                answer2 = "N" + findAlternativePath(y - 1, powers, y - 1 > 0 ? "N" : "S", length, initialAnswer);
            } else {
                answer3 = "N" + findAlternativePath(y - 1, powers, y - 1 > 0 ? "N" : "S", length, initialAnswer);
                if (!answer3.contains("IMPOSSIBLE") && answer3.length() < answer2.length()) {
                    answer2 = answer3;
                }
            }
        }

        return answer2.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : answer2;
    }

    private static String findAlternativePath(long z, List<Long> powers, String direction, int length, String initialAnswer) {
        long zz = Math.abs(z);
        for (int i = 1; i < length; i++) {
            zz -= powers.get(i);
            initialAnswer = direction + initialAnswer;
        }
        if (zz > 0) {
            int index = length == 0 ? 1 : length;
            zz -= powers.get(index);
            initialAnswer = direction + initialAnswer;
        }
        return zz != 0 ? "IMPOSSIBLE" : initialAnswer;
    }

    private static String findPath(long z, List<Long> powers, String direction) {
        long zz = Math.abs(z);
        List<Long> usedPowers = new ArrayList<>();
        while (zz > 0) {
            int i = 0;
            while (powers.get(++i) < zz);
            zz -= powers.get(i);
            usedPowers.add(powers.get(i));
        }
        if (zz != 0) {
            return "IMPOSSIBLE";
        }
        powers.removeAll(usedPowers);
        return direction.repeat(usedPowers.size());
    }
}