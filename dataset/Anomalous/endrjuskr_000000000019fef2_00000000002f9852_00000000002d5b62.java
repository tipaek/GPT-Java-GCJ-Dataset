import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            StringBuilder result = findPath(new StringBuilder(), x, y, 0, 0, 1);
            if (result == null) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            } else {
                System.out.println(String.format("Case #%d: %s", t, result.toString()));
            }
        }
    }

    public static StringBuilder findPath(StringBuilder path, int targetX, int targetY, int currentX, int currentY, int step) {
        if (targetX == currentX && targetY == currentY) {
            return path;
        }

        if (step > (Math.abs(2 * targetX) + Math.abs(2 * targetY))) {
            return null;
        }

        StringBuilder shortestPath = null;

        StringBuilder eastPath = new StringBuilder(path).append('E');
        eastPath = findPath(eastPath, targetX, targetY, currentX + step, currentY, step * 2);
        if (eastPath != null && (shortestPath == null || shortestPath.length() > eastPath.length())) {
            shortestPath = eastPath;
        }

        StringBuilder westPath = new StringBuilder(path).append('W');
        westPath = findPath(westPath, targetX, targetY, currentX - step, currentY, step * 2);
        if (westPath != null && (shortestPath == null || shortestPath.length() > westPath.length())) {
            shortestPath = westPath;
        }

        StringBuilder northPath = new StringBuilder(path).append('N');
        northPath = findPath(northPath, targetX, targetY, currentX, currentY + step, step * 2);
        if (northPath != null && (shortestPath == null || shortestPath.length() > northPath.length())) {
            shortestPath = northPath;
        }

        StringBuilder southPath = new StringBuilder(path).append('S');
        southPath = findPath(southPath, targetX, targetY, currentX, currentY - step, step * 2);
        if (southPath != null && (shortestPath == null || shortestPath.length() > southPath.length())) {
            shortestPath = southPath;
        }

        return shortestPath;
    }
}