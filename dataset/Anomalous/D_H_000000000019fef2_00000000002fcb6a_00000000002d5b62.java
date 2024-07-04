import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numCases; testCase++) {
            int xTarget = scanner.nextInt();
            int yTarget = scanner.nextInt();
            String result = findPath(0, 0, 1, xTarget, yTarget, "");
            if (result == null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }

    static String findPath(int x, int y, int jump, int xTarget, int yTarget, String path) {
        if (x == xTarget && y == yTarget) {
            return path;
        }
        
        if (Math.abs(xTarget - x) + Math.abs(yTarget - y) > jump) {
            return null;
        }

        String[] directions = {"W", "E", "S", "N"};
        int[][] moves = {{-jump, 0}, {jump, 0}, {0, -jump}, {0, jump}};
        String shortestPath = null;

        for (int i = 0; i < directions.length; i++) {
            int newX = x + moves[i][0];
            int newY = y + moves[i][1];
            String newPath = findPath(newX, newY, jump * 2, xTarget, yTarget, path + directions[i]);
            if (newPath != null && (shortestPath == null || newPath.length() < shortestPath.length())) {
                shortestPath = newPath;
            }
        }

        return shortestPath;
    }
}