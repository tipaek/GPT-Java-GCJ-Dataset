import java.util.ArrayList;
import java.util.List;
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
        scanner.close();
    }

    private static String findPath(int x, int y, int jump, int xTarget, int yTarget, String path) {
        if (x == xTarget && y == yTarget) {
            return path;
        }
        if (Math.abs(x - xTarget) > jump || Math.abs(y - yTarget) > jump) {
            return null;
        }

        if (x - jump == xTarget && y == yTarget) return path + "W";
        if (x + jump == xTarget && y == yTarget) return path + "E";
        if (x == xTarget && y - jump == yTarget) return path + "S";
        if (x == xTarget && y + jump == yTarget) return path + "N";

        List<String> possiblePaths = new ArrayList<>();
        possiblePaths.add(findPath(x - jump, y, jump * 2, xTarget, yTarget, path + "W"));
        possiblePaths.add(findPath(x + jump, y, jump * 2, xTarget, yTarget, path + "E"));
        possiblePaths.add(findPath(x, y - jump, jump * 2, xTarget, yTarget, path + "S"));
        possiblePaths.add(findPath(x, y + jump, jump * 2, xTarget, yTarget, path + "N"));

        String shortestPath = null;
        for (String currentPath : possiblePaths) {
            if (currentPath != null && (shortestPath == null || currentPath.length() < shortestPath.length())) {
                shortestPath = currentPath;
            }
        }

        return shortestPath;
    }
}