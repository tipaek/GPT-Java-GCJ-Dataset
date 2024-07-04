package foobar;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int length = (int) (Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2)) + 2;
            int[][] path = findPath(x, y, length);

            System.out.print("Case #" + (i + 1) + ": ");
            if (path != null) {
                printPath(path);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void printPath(int[][] path) {
        for (int[] step : path) {
            if (step[0] == 1) System.out.print("E");
            if (step[0] == -1) System.out.print("W");
            if (step[1] == 1) System.out.print("N");
            if (step[1] == -1) System.out.print("S");
        }
        System.out.println();
    }

    private static int[][] findPath(int x, int y, int length) {
        int[][] path = new int[length][2];
        return explorePath(path, 0, 0, 0, x, y);
    }

    private static int[][] explorePath(int[][] path, int index, int currentX, int currentY, int targetX, int targetY) {
        if (currentX == targetX && currentY == targetY) return path;
        if (index >= path.length) return null;

        int stepSize = (int) Math.pow(2, index);

        path[index][0] = -1; path[index][1] = 0;
        if (explorePath(path, index + 1, currentX - stepSize, currentY, targetX, targetY) != null) return path;

        path[index][0] = 1; path[index][1] = 0;
        if (explorePath(path, index + 1, currentX + stepSize, currentY, targetX, targetY) != null) return path;

        path[index][0] = 0; path[index][1] = 1;
        if (explorePath(path, index + 1, currentX, currentY + stepSize, targetX, targetY) != null) return path;

        path[index][0] = 0; path[index][1] = -1;
        if (explorePath(path, index + 1, currentX, currentY - stepSize, targetX, targetY) != null) return path;

        return null;
    }
}