import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            results[i] = findPath(0, 0, X, Y, 0, "");
        }

        for (int i = 0; i < results.length; i++) {
            if (results[i].isEmpty()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + results[i]);
            }
        }

        scanner.close();
    }

    private static String findPath(int x, int y, int X, int Y, int p, String path) {
        if (x == X && y == Y) {
            return path;
        }

        if (Math.abs(x) > Math.abs(X) || Math.abs(y) > Math.abs(Y)) {
            return "";
        }

        int step = (int) Math.pow(2, p);
        String[] directions = {"E", "W", "N", "S"};
        int[][] moves = {{step, 0}, {-step, 0}, {0, step}, {0, -step}};
        String bestPath = "";

        for (int i = 0; i < directions.length; i++) {
            String newPath = findPath(x + moves[i][0], y + moves[i][1], X, Y, p + 1, path + directions[i]);
            if (!newPath.isEmpty() && (bestPath.isEmpty() || newPath.length() < bestPath.length())) {
                bestPath = newPath;
            }
        }

        return bestPath;
    }
}