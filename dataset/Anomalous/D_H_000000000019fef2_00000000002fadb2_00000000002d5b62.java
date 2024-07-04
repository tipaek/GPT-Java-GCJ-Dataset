import java.util.*;

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

    private static String findPath(int x, int y, int jump, int xTarget, int yTarget, String path) {
        if (x == xTarget && y == yTarget) {
            return path;
        }
        if (Math.abs(xTarget - x) + Math.abs(yTarget - y) < jump) {
            return null;
        }

        List<String> possiblePaths = Arrays.asList(
            findPath(x - jump, y, jump * 2, xTarget, yTarget, path + "W"),
            findPath(x + jump, y, jump * 2, xTarget, yTarget, path + "E"),
            findPath(x, y - jump, jump * 2, xTarget, yTarget, path + "S"),
            findPath(x, y + jump, jump * 2, xTarget, yTarget, path + "N")
        );

        String shortestPath = null;

        for (String currentPath : possiblePaths) {
            if (currentPath != null && (shortestPath == null || currentPath.length() < shortestPath.length())) {
                shortestPath = currentPath;
            }
        }

        return shortestPath;
    }
}