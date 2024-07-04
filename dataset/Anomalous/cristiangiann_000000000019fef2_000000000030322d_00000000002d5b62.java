import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxCoordinate = Math.max(Math.abs(x), Math.abs(y));
            int steps = calculateSteps(maxCoordinate, x, y);

            System.out.print("Case #" + testCase + ": ");
            if (steps == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                int[][] path = findPath(x, y, steps);
                printPath(path);
            }
        }
    }

    private static int calculateSteps(int maxCoordinate, int x, int y) {
        double logBase2 = Math.log(2);
        int steps = (int) Math.ceil(Math.log(maxCoordinate) / logBase2);
        return (x != 0 && y != 0) ? steps + 1 : steps;
    }

    private static void printPath(int[][] path) {
        for (int[] direction : path) {
            if (direction[0] == 1) System.out.print("E");
            else if (direction[0] == -1) System.out.print("W");
            else if (direction[1] == 1) System.out.print("N");
            else if (direction[1] == -1) System.out.print("S");
        }
        System.out.println();
    }

    private static int[][] findPath(int x, int y, int steps) {
        int[][] directions = new int[steps][2];
        return decomposeCoordinates(directions, 0, 0, 0, x, y);
    }

    private static int[][] decomposeCoordinates(int[][] directions, int index, int currentX, int currentY, int targetX, int targetY) {
        if (currentX == targetX && currentY == targetY) return directions;
        if (index >= directions.length) return null;

        int stepSize = (int) Math.pow(2, index);

        directions[index][0] = -1;
        directions[index][1] = 0;
        if (decomposeCoordinates(directions, index + 1, currentX - stepSize, currentY, targetX, targetY) != null) return directions;

        directions[index][0] = 1;
        if (decomposeCoordinates(directions, index + 1, currentX + stepSize, currentY, targetX, targetY) != null) return directions;

        directions[index][0] = 0;
        directions[index][1] = 1;
        if (decomposeCoordinates(directions, index + 1, currentX, currentY + stepSize, targetX, targetY) != null) return directions;

        directions[index][1] = -1;
        if (decomposeCoordinates(directions, index + 1, currentX, currentY - stepSize, targetX, targetY) != null) return directions;

        return null;
    }
}