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
        int T = IN.nextInt();
        for (int t = 1; t <= T; t++) {
            long X = IN.nextLong();
            long Y = IN.nextLong();
            String result = solve(X, Y);
            OUT.println("Case #" + t + ": " + result);
        }
    }

    private static String solve(long X, long Y) {
        if ((X % 2 == 0 && Y % 2 == 0) || (X % 2 != 0 && Y % 2 != 0)) {
            return "IMPOSSIBLE";
        }

        List<Long> powers = new ArrayList<>(POWERS_OF_TWO);
        String initialDir = (X % 2 == 0) ? (X > 0 ? "E" : "W") : (Y > 0 ? "N" : "S");
        long target = (X % 2 == 0) ? X : Y;
        String answer = findPath(target, powers, initialDir);

        if ("IMPOSSIBLE".equals(answer)) {
            return answer;
        }

        int length = Integer.parseInt(answer.split("_")[1]);
        answer = answer.split("_")[0];

        if (X % 2 != 0) {
            String alternative = findAlternative(X, powers, length, answer, "W", "E");
            return "IMPOSSIBLE".equals(alternative) ? "IMPOSSIBLE" : alternative;
        } else {
            String alternative = findAlternative(Y, powers, length, answer, "S", "N");
            return "IMPOSSIBLE".equals(alternative) ? "IMPOSSIBLE" : alternative;
        }
    }

    private static String findAlternative(long value, List<Long> powers, int length, String baseAnswer, String dir1, String dir2) {
        String answer1 = dir1 + findPathWithOffset(value + 1, powers, length, baseAnswer, dir1);
        if (!answer1.contains("IMPOSSIBLE")) {
            String answer2 = dir2 + findPathWithOffset(value - 1, powers, length, baseAnswer, dir2);
            if (!answer2.contains("IMPOSSIBLE") && answer2.length() < answer1.length()) {
                return answer2;
            }
        } else {
            return dir2 + findPathWithOffset(value - 1, powers, length, baseAnswer, dir2);
        }
        return answer1.contains("IMPOSSIBLE") ? "IMPOSSIBLE" : answer1;
    }

    private static String findPathWithOffset(long value, List<Long> powers, int length, String baseAnswer, String dir) {
        long absValue = Math.abs(value);
        for (int i = 1; i < length; i++) {
            absValue -= powers.get(i);
            baseAnswer = dir + baseAnswer;
        }
        if (absValue > 0) {
            int idx = (length == 0) ? 1 : length;
            absValue -= powers.get(idx);
            baseAnswer += dir;
        }
        return absValue != 0 ? "IMPOSSIBLE" : baseAnswer;
    }

    private static String findPath(long value, List<Long> powers, String dir) {
        long absValue = Math.abs(value);
        List<Long> usedPowers = new ArrayList<>();
        int index = 0;

        while (absValue > 0) {
            int i = 0;
            while (powers.get(++i) < absValue) ;
            if (index == 0) {
                index = i;
            }
            absValue -= powers.get(i);
            usedPowers.add(powers.get(i));
        }

        if (absValue != 0) {
            return "IMPOSSIBLE";
        }

        powers.removeAll(usedPowers);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < usedPowers.size(); i++) {
            answer.append(dir);
        }
        return answer + "_" + index;
    }
}