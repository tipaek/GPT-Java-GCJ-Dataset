import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            long destX = sc.nextLong();
            long destY = sc.nextLong();
            String result = findPath(0, 0, destX, destY, "", 0);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static String findPath(long currX, long currY, long destX, long destY, String path, long step) {
        long move = (long) Math.pow(2, step);
        if (currX == destX && currY == destY) {
            return path;
        }
        if (Math.abs(currX) > Math.abs(destX) || Math.abs(currY) > Math.abs(destY)) {
            return "IMPOSSIBLE";
        }

        String eastPath = findPath(currX + move, currY, destX, destY, path + "E", step + 1);
        String westPath = findPath(currX - move, currY, destX, destY, path + "W", step + 1);
        String northPath = findPath(currX, currY + move, destX, destY, path + "N", step + 1);
        String southPath = findPath(currX, currY - move, destX, destY, path + "S", step + 1);

        if (eastPath.equals("IMPOSSIBLE") && westPath.equals("IMPOSSIBLE") && northPath.equals("IMPOSSIBLE") && southPath.equals("IMPOSSIBLE")) {
            return "IMPOSSIBLE";
        }

        return findShortestPath(eastPath, westPath, northPath, southPath);
    }

    private static String findShortestPath(String... paths) {
        String shortestPath = "IMPOSSIBLE";
        int minLength = Integer.MAX_VALUE;

        for (String path : paths) {
            if (!path.equals("IMPOSSIBLE") && path.length() < minLength) {
                shortestPath = path;
                minLength = path.length();
            }
        }

        return shortestPath;
    }
}