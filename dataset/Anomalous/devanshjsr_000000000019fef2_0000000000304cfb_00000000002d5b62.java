import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int st = 1; st <= t; st++) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            long x1 = Math.abs(x);
            long y1 = Math.abs(y);

            long max = Math.max(2 * x1, 2 * y1);

            List<Long> a1 = new ArrayList<>();
            List<Long> a2 = new ArrayList<>();
            List<Long> a3 = new ArrayList<>();

            for (long i = 0; Math.pow(2, i) <= max; i++) {
                long tmp = (long) Math.pow(2, i);
                a2.add(tmp);
                a1.add(tmp + 1);
                a3.add(2 * tmp - 1);
            }

            String result = getResult(x, y, x1, y1, a1, a2, a3);
            System.out.println("Case #" + st + ": " + result);
        }
    }

    private static String getResult(long x, long y, long x1, long y1, List<Long> a1, List<Long> a2, List<Long> a3) {
        if ((!a2.contains(x1) && !a2.contains(y1)) || x1 == 0 || y1 == 0) {
            if (x1 == 0 && !a3.contains(y1)) {
                return "IMPOSSIBLE";
            } else if (y1 == 0 && !a3.contains(x1)) {
                return "IMPOSSIBLE";
            } else {
                return buildString(x, y, x1, y1, a3);
            }
        } else {
            return handleSpecialCases(x, y, x1, y1, a1, a2, a3);
        }
    }

    private static String buildString(long x, long y, long x1, long y1, List<Long> a3) {
        StringBuilder s = new StringBuilder();
        if (y1 != 0) {
            int index = a3.indexOf(y1);
            char direction = y < 0 ? 'S' : 'N';
            s.append(String.valueOf(direction).repeat(index + 1));
            return s.toString();
        } else if (x1 != 0) {
            int index = a3.indexOf(x1);
            char direction = x < 0 ? 'W' : 'E';
            s.append(String.valueOf(direction).repeat(index + 1));
            return s.toString();
        }
        return "IMPOSSIBLE";
    }

    private static String handleSpecialCases(long x, long y, long x1, long y1, List<Long> a1, List<Long> a2, List<Long> a3) {
        StringBuilder s = new StringBuilder();
        if (a2.contains(x1)) {
            int index = a2.indexOf(x1);
            if (y1 == a1.get(index)) {
                appendSpecialCase(s, x, y, index, "N", "S", "WS", "ES", "WN", "EN");
            } else if (index - 1 > 0 && y1 == a3.get(index - 1)) {
                appendSpecialCase(s, x, y, index + 1, "S", "N", "W", "E", "W", "E");
            } else {
                return "IMPOSSIBLE";
            }
        } else if (a2.contains(y1)) {
            int index = a2.indexOf(y1);
            if (x1 == a1.get(index)) {
                appendSpecialCase(s, x, y, index, "E", "W", "SW", "NW", "SE", "NE");
            } else if (index - 1 > 0 && x1 == a3.get(index - 1)) {
                appendSpecialCase(s, x, y, index + 1, "W", "E", "S", "N", "S", "N");
            } else {
                return "IMPOSSIBLE";
            }
        } else {
            return "IMPOSSIBLE";
        }
        return s.toString();
    }

    private static void appendSpecialCase(StringBuilder s, long x, long y, int index, String posX, String negX, String posXY, String negXY, String posYX, String negYX) {
        s.append(x < 0 ? negX : posX).append(y < 0 ? negXY : posXY);
        for (int i = 0; i < index; i++) {
            s.append(x < 0 ? negYX : posYX);
        }
    }
}