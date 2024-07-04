import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long absX = Math.abs(x);
            long absY = Math.abs(y);
            long max = Math.max(2 * absX, 2 * absY);

            List<Long> a1 = new ArrayList<>();
            List<Long> a2 = new ArrayList<>();
            List<Long> a3 = new ArrayList<>();

            for (long i = 0; Math.pow(2, i) <= max; i++) {
                long power = (long) Math.pow(2, i);
                a2.add(power);
                a1.add(power + 1);
                a3.add(2 * power - 1);
            }

            String result = solveCase(absX, absY, x, y, a1, a2, a3);
            System.out.println("Case #" + caseNumber + ": " + result);

            t--;
            caseNumber++;
        }
    }

    private static String solveCase(long absX, long absY, long x, long y, List<Long> a1, List<Long> a2, List<Long> a3) {
        if ((!a2.contains(absX) && !a2.contains(absY)) || absX == 0 || absY == 0) {
            return handleSpecialCases(absX, absY, x, y, a3);
        } else {
            return handleGeneralCases(absX, absY, x, y, a1, a2, a3);
        }
    }

    private static String handleSpecialCases(long absX, long absY, long x, long y, List<Long> a3) {
        StringBuilder s = new StringBuilder();

        if (absX == 0 && !a3.contains(absY)) {
            return "IMPOSSIBLE";
        } else if (absY != 0) {
            int index = a3.indexOf(absY);
            char direction = y < 0 ? 'S' : 'N';
            for (int i = 0; i <= index; i++) {
                s.append(direction);
            }
            return s.toString();
        }

        if (absY == 0 && !a3.contains(absX)) {
            return "IMPOSSIBLE";
        } else if (absX != 0) {
            int index = a3.indexOf(absX);
            char direction = x < 0 ? 'W' : 'E';
            for (int i = 0; i <= index; i++) {
                s.append(direction);
            }
            return s.toString();
        }

        return "IMPOSSIBLE";
    }

    private static String handleGeneralCases(long absX, long absY, long x, long y, List<Long> a1, List<Long> a2, List<Long> a3) {
        StringBuilder s = new StringBuilder();

        if (a2.contains(absX)) {
            int index = a2.indexOf(absX);
            if (absY == a1.get(index)) {
                char first = y < 0 ? 'N' : 'S';
                char second = x < 0 ? 'W' : 'E';
                char third = y < 0 ? 'S' : 'N';
                appendChars(s, first, index);
                s.append(second).append(third);
                return s.toString();
            } else if (index - 1 >= 0 && absY == a3.get(index - 1)) {
                char first = y < 0 ? 'S' : 'N';
                char second = x < 0 ? 'W' : 'E';
                appendChars(s, first, index + 1);
                s.append(second);
                return s.toString();
            }
        } else if (a2.contains(absY)) {
            int index = a2.indexOf(absY);
            if (absX == a1.get(index)) {
                char first = x < 0 ? 'E' : 'W';
                char second = y < 0 ? 'S' : 'N';
                char third = x < 0 ? 'W' : 'E';
                appendChars(s, first, index);
                s.append(second).append(third);
                return s.toString();
            } else if (index - 1 >= 0 && absX == a3.get(index - 1)) {
                char first = x < 0 ? 'W' : 'E';
                char second = y < 0 ? 'S' : 'N';
                appendChars(s, first, index + 1);
                s.append(second);
                return s.toString();
            }
        }

        return "IMPOSSIBLE";
    }

    private static void appendChars(StringBuilder s, char c, int count) {
        for (int i = 0; i < count; i++) {
            s.append(c);
        }
    }
}