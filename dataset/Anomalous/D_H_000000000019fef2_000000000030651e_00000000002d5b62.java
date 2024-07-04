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

    static String findPath(int x, int y, int jump, int xTarget, int yTarget, String steps) {
        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if (jump - Math.abs(xTarget) > Math.abs(yTarget)) {
            return null;
        }

        if (x - jump == xTarget && y == yTarget) {
            return steps + "W";
        }
        if (x + jump == xTarget && y == yTarget) {
            return steps + "E";
        }
        if (x == xTarget && y - jump == yTarget) {
            return steps + "S";
        }
        if (x == xTarget && y + jump == yTarget) {
            return steps + "N";
        }

        String[] directions = {"N", "S", "E", "W"};
        int[][] moves = {{0, jump}, {0, -jump}, {jump, 0}, {-jump, 0}};
        
        for (int i = 0; i < directions.length; i++) {
            String newPath = findPath(x + moves[i][0], y + moves[i][1], jump * 2, xTarget, yTarget, steps + directions[i]);
            if (newPath != null) {
                return newPath;
            }
        }
        
        return null;
    }
}