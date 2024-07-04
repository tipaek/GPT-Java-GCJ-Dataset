import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            results[i] = findPath(0, 0, X, Y, 0, "");
        }

        for (int i = 0; i < results.length; i++) {
            if (results[i].isEmpty()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + results[i]);
            }
        }
    }

    public static String findPath(int x, int y, int X, int Y, int p, String path) {
        if (x == X && y == Y) {
            return path;
        }

        if (Math.abs(x) > Math.abs(X) * 8 || Math.abs(y) > Math.abs(Y) * 32) {
            return "";
        }

        int step = (int) Math.pow(2, p);
        String east = findPath(x + step, y, X, Y, p + 1, path + "E");
        String west = findPath(x - step, y, X, Y, p + 1, path + "W");
        String north = findPath(x, y + step, X, Y, p + 1, path + "N");
        String south = findPath(x, y - step, X, Y, p + 1, path + "S");

        String shortestPath = east;
        if (!west.isEmpty() && (shortestPath.isEmpty() || west.length() < shortestPath.length())) {
            shortestPath = west;
        }
        if (!north.isEmpty() && (shortestPath.isEmpty() || north.length() < shortestPath.length())) {
            shortestPath = north;
        }
        if (!south.isEmpty() && (shortestPath.isEmpty() || south.length() < shortestPath.length())) {
            shortestPath = south;
        }

        return shortestPath;
    }
}