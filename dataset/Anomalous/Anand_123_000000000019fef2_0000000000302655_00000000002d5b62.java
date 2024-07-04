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

    private static String findPath(int currX, int currY, long destX, long destY, String path, int pow) {
        int step = 1 << pow;
        if (currX == destX && currY == destY) {
            return path;
        }
        if (Math.abs(currX) > Math.abs(destX) || Math.abs(currY) > Math.abs(destY)) {
            return "IMPOSSIBLE";
        }
        String eastPath = findPath(currX + step, currY, destX, destY, path + "E", pow + 1);
        String westPath = findPath(currX - step, currY, destX, destY, path + "W", pow + 1);
        String northPath = findPath(currX, currY + step, destX, destY, path + "N", pow + 1);
        String southPath = findPath(currX, currY - step, destX, destY, path + "S", pow + 1);

        return getShortestPath(eastPath, westPath, northPath, southPath);
    }

    private static String getShortestPath(String... paths) {
        String shortest = "IMPOSSIBLE";
        for (String path : paths) {
            if (!path.equals("IMPOSSIBLE") && (shortest.equals("IMPOSSIBLE") || path.length() < shortest.length())) {
                shortest = path;
            }
        }
        return shortest;
    }
}