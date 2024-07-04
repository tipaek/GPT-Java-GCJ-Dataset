import java.util.*;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int st = 1;

        while (t-- > 0) {
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

            String result = processCase(x, y, x1, y1, a1, a2, a3);
            System.out.println("Case #" + st + ": " + result);
            st++;
        }
    }

    private static String processCase(long x, long y, long x1, long y1, List<Long> a1, List<Long> a2, List<Long> a3) {
        if ((!a2.contains(x1) && !a2.contains(y1)) || x1 == 0 || y1 == 0) {
            return handleSpecialCases(x, y, x1, y1, a3);
        } else {
            return handleGeneralCases(x, y, x1, y1, a1, a2, a3);
        }
    }

    private static String handleSpecialCases(long x, long y, long x1, long y1, List<Long> a3) {
        StringBuilder s = new StringBuilder();
        if (x1 == 0 && !a3.contains(y1)) {
            return "IMPOSSIBLE";
        } else if (y1 != 0) {
            return buildStringForAxis(y, y1, a3, "S", "N");
        } else if (y1 == 0 && !a3.contains(x1)) {
            return "IMPOSSIBLE";
        } else if (x1 != 0) {
            return buildStringForAxis(x, x1, a3, "W", "E");
        }
        return s.toString();
    }

    private static String buildStringForAxis(long coord, long coord1, List<Long> a3, String negativeDir, String positiveDir) {
        StringBuilder s = new StringBuilder();
        int index = a3.indexOf(coord1);
        for (int i = 0; i <= index; i++) {
            s.append(coord < 0 ? negativeDir : positiveDir);
        }
        return s.toString();
    }

    private static String handleGeneralCases(long x, long y, long x1, long y1, List<Long> a1, List<Long> a2, List<Long> a3) {
        StringBuilder s = new StringBuilder();
        if (a2.contains(x1)) {
            int index = a2.indexOf(x1);
            if (y1 == a1.get(index)) {
                return buildStringForDiagonal(x, y, index, s, "N", "S", "W", "E");
            } else if (index - 1 >= 0 && y1 == a3.get(index - 1)) {
                return buildStringForStraight(x, y, index, s, "N", "S", "W", "E");
            } else {
                return "IMPOSSIBLE";
            }
        } else if (a2.contains(y1)) {
            int index = a2.indexOf(y1);
            if (x1 == a1.get(index)) {
                return buildStringForDiagonal(y, x, index, s, "W", "E", "S", "N");
            } else if (index - 1 >= 0 && x1 == a3.get(index - 1)) {
                return buildStringForStraight(y, x, index, s, "W", "E", "S", "N");
            } else {
                return "IMPOSSIBLE";
            }
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static String buildStringForDiagonal(long coord1, long coord2, int index, StringBuilder s, String negativeDir1, String positiveDir1, String negativeDir2, String positiveDir2) {
        for (int i = 0; i < index; i++) {
            s.append(coord2 < 0 ? positiveDir1 : negativeDir1);
        }
        s.append(coord1 < 0 ? negativeDir2 : positiveDir2);
        s.append(coord2 < 0 ? negativeDir1 : positiveDir1);
        return s.toString();
    }

    private static String buildStringForStraight(long coord1, long coord2, int index, StringBuilder s, String negativeDir1, String positiveDir1, String negativeDir2, String positiveDir2) {
        for (int i = 0; i < index; i++) {
            s.append(coord1 < 0 ? positiveDir2 : negativeDir2);
        }
        s.append(coord2 < 0 ? negativeDir1 : positiveDir1);
        return s.toString();
    }
}