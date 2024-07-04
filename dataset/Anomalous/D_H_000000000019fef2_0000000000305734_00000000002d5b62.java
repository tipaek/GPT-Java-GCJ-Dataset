import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int testcase = 1; testcase <= numCases; testcase++) {
            int xTarget = scanner.nextInt();
            int yTarget = scanner.nextInt();
            String result = findPath(0, 0, 1, xTarget, yTarget, "");
            if (result == null) {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcase + ": " + result);
            }
        }
    }

    static String findPath(int x, int y, int jump, int xTarget, int yTarget, String path) {
        if (x == xTarget && y == yTarget) {
            return path;
        }
        if (jump > Math.abs(xTarget) + Math.abs(yTarget)) {
            return null;
        }

        if (x - jump == xTarget && y == yTarget) {
            return path + "W";
        }
        if (x + jump == xTarget && y == yTarget) {
            return path + "E";
        }
        if (x == xTarget && y - jump == yTarget) {
            return path + "S";
        }
        if (x == xTarget && y + jump == yTarget) {
            return path + "N";
        }

        String result;

        result = findPath(x - jump, y, jump * 2, xTarget, yTarget, path + "W");
        if (result != null) return result;

        result = findPath(x + jump, y, jump * 2, xTarget, yTarget, path + "E");
        if (result != null) return result;

        result = findPath(x, y - jump, jump * 2, xTarget, yTarget, path + "S");
        if (result != null) return result;

        result = findPath(x, y + jump, jump * 2, xTarget, yTarget, path + "N");
        if (result != null) return result;

        return null;
    }
}