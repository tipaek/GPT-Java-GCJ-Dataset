package codejam;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            results[i] = "";
        }

        for (int i = 0; i < T; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            findPath(0, 0, X, Y, 0, "", results, i);
        }

        for (int i = 0; i < results.length; i++) {
            if (results[i].isEmpty()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + results[i]);
            }
        }
    }

    private static void findPath(int x, int y, int targetX, int targetY, int step, String path, String[] results, int index) {
        if (x == targetX && y == targetY) {
            if (results[index].isEmpty() || results[index].length() > path.length()) {
                results[index] = path;
            }
            return;
        }

        if (Math.abs(x) > Math.abs(targetX) || Math.abs(y) > Math.abs(targetY)) {
            return;
        }

        int moveDistance = (int) Math.pow(2, step);
        findPath(x + moveDistance, y, targetX, targetY, step + 1, path + "E", results, index);
        findPath(x - moveDistance, y, targetX, targetY, step + 1, path + "W", results, index);
        findPath(x, y + moveDistance, targetX, targetY, step + 1, path + "N", results, index);
        findPath(x, y - moveDistance, targetX, targetY, step + 1, path + "S", results, index);
    }
}