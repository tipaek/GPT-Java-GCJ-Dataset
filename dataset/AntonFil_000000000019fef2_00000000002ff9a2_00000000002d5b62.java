import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsCount = sc.nextInt();

        for (int i = 1; i <= testsCount; i++) {
            sc.nextLine();
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Case #" + i + ": " + reachPoint(0, 0, x, y, 1, ""));
        }
        sc.close();
    }

    private static String reachPoint(long curX, long curY, long tarX, long tarY, long step, String path) {
        if (step > 2_000_000_000 || (curX != tarX && dist(curX, tarX) < step) || (curY != tarY && dist(curY, tarY) < step)) {
            return IMPOSSIBLE;
        }
        if (curX == tarX && curY == tarY) {
            return path;
        }
        String p1 = reachPoint(curX + step, curY, tarX, tarY, step * 2, path + "E");
        String p2 = reachPoint(curX - step, curY, tarX, tarY, step * 2, path + "W");
        String p3 = reachPoint(curX, curY + step, tarX, tarY, step * 2, path + "N");
        String p4 = reachPoint(curX, curY - step, tarX, tarY, step * 2, path + "S");
        return findMinPossibleString(p1, p2, p3, p4);
    }

    private static String findMinPossibleString(String... ps) {
        int minLength = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < ps.length; i++) {
            if (ps[i] != IMPOSSIBLE && ps[i].length() < minLength) {
                minLength = ps[i].length();
                index = i;
            }
        }
        return index != -1 ? ps[index] : IMPOSSIBLE;
    }

    private static long dist(long x1, long x2) {
        long res = x1 - x2;
        return res < 0 ? -res : res;
    }
}