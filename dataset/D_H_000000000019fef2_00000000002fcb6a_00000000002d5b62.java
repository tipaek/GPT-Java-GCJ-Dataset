import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_case = scanner.nextInt();
        for (int testcase = 1; testcase <= num_case; testcase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String ans = findAns(0, 0, 1, x, y, "");
            if (ans == null) {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcase + ": " + ans);
            }
        }
    }

    static String findAns(int x, int y, int jump, int xTarget, int yTarget, String steps) {
        if (x - jump == xTarget && y == yTarget) {
            return steps + "W";
        }
        if (x == xTarget - jump && y == yTarget) {
            return steps + "E";
        }
        if (x == xTarget && y - jump == yTarget) {
            return steps + "S";
        }
        if (x == xTarget && y == yTarget - jump) {
            return steps + "N";
        }

        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if (Math.abs(xTarget) < (jump - Math.abs(yTarget))) {
            return null;
        }

        int shortest = Integer.MAX_VALUE;
        String shortestAns = null;
        String ans = findAns(x - jump, y, jump * 2, xTarget, yTarget, steps + "W");
        if (ans != null && ans.length() < shortest) {
            shortest = ans.length();
            shortestAns = ans;
        }
        ans = findAns(x + jump, y, jump * 2, xTarget, yTarget, steps + "E");
        if (ans != null && ans.length() < shortest) {
            shortest = ans.length();
            shortestAns = ans;
        }
        ans = findAns(x, y - jump, jump * 2, xTarget, yTarget, steps + "S");
        if (ans != null && ans.length() < shortest) {
            shortest = ans.length();
            shortestAns = ans;
        }
        ans = findAns(x, y + jump, jump * 2, xTarget, yTarget, steps + "N");
        if (ans != null && ans.length() < shortest) {
            shortest = ans.length();
            shortestAns = ans;
        }

        return shortestAns;
    }
}
