import java.util.Scanner;

public class Solution {
    static int targetX;
    static int targetY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            String steps = findSteps(0, 0, "", 1);
            if (steps.isEmpty()) {
                steps = "IMPOSSIBLE";
            }
            System.out.println("Case #" + t + ": " + steps);
        }
    }

    private static String findSteps(int currentX, int currentY, String path, int step) {
        if (currentX == targetX && currentY == targetY) {
            return path;
        }

        if (outOfBounds(currentX, currentY)) {
            return "";
        }

        int east = currentX + power(2, step - 1);
        int west = currentX - power(2, step - 1);
        int north = currentY + power(2, step - 1);
        int south = currentY - power(2, step - 1);

        String moveNorth = findSteps(currentX, north, path + "N", step + 1);
        String moveEast = findSteps(east, currentY, path + "E", step + 1);
        String moveWest = findSteps(west, currentY, path + "W", step + 1);
        String moveSouth = findSteps(currentX, south, path + "S", step + 1);

        return findShortestPath(moveNorth, moveEast, moveWest, moveSouth);
    }

    private static boolean outOfBounds(int currentX, int currentY) {
        return (targetX > 0 && targetY > 0 && (currentX > targetX || currentY > targetY)) ||
               (targetX < 0 && targetY > 0 && (currentX < targetX || currentY > targetY)) ||
               (targetX < 0 && targetY < 0 && (currentX < targetX || currentY < targetY)) ||
               (targetX > 0 && targetY < 0 && (currentX > targetX || currentY < targetY));
    }

    private static String findShortestPath(String... paths) {
        String shortestPath = "";
        int minLength = Integer.MAX_VALUE;
        for (String path : paths) {
            if (!path.isEmpty() && path.length() < minLength) {
                minLength = path.length();
                shortestPath = path;
            }
        }
        return shortestPath;
    }

    private static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; ++i) {
            result *= base;
        }
        return result;
    }
}