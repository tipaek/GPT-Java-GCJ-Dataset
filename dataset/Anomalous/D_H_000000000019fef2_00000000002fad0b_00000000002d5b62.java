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
            System.out.println(xTarget + " " + yTarget);
            
            String result = findPath(0, 0, 1, xTarget, yTarget, "");
            if (result == null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }

    static String findPath(int x, int y, int jump, int xTarget, int yTarget, String steps) {
        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if ((Math.abs(xTarget - x) + Math.abs(yTarget - y)) < jump) {
            return null;
        }

        List<String> possiblePaths = new ArrayList<>();
        possiblePaths.add(findPath(x - jump, y, jump * 2, xTarget, yTarget, steps + "W"));
        possiblePaths.add(findPath(x + jump, y, jump * 2, xTarget, yTarget, steps + "E"));
        possiblePaths.add(findPath(x, y - jump, jump * 2, xTarget, yTarget, steps + "S"));
        possiblePaths.add(findPath(x, y + jump, jump * 2, xTarget, yTarget, steps + "N"));

        String shortestPath = null;

        for (String path : possiblePaths) {
            if (path != null) {
                if (shortestPath == null || path.length() < shortestPath.length()) {
                    shortestPath = path;
                }
            }
        }

        return shortestPath;
    }
}