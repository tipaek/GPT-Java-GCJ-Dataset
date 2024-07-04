import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxCoordinate = Math.max(Math.abs(x), Math.abs(y));
            int bitLength = (int) (Math.ceil(Math.log(maxCoordinate) / Math.log(2))) + 1;
            int[][] directions = calculateDirections(x, y, bitLength);
            System.out.print("Case #" + (i + 1) + ": ");

            if (directions != null) {
                printDirections(directions);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void printDirections(int[][] directions) {
        for (int[] direction : directions) {
            if (direction[0] == 1) System.out.print("E");
            if (direction[0] == -1) System.out.print("W");
            if (direction[1] == 1) System.out.print("N");
            if (direction[1] == -1) System.out.print("S");
        }
        System.out.println();
    }

    private static int[][] calculateDirections(int x, int y, int length) {
        int[][] directions = new int[length][2];
        return findPath(directions, 0, 0, 0, x, y);
    }

    private static int[][] findPath(int[][] directions, int index, int currentX, int currentY, int targetX, int targetY) {
        if (currentX == targetX && currentY == targetY) return directions;
        if (index >= directions.length) return null;
        int step = (int) Math.pow(2, index);

        directions[index][0] = -1;
        directions[index][1] = 0;
        if (findPath(directions, index + 1, currentX - step, currentY, targetX, targetY) != null) return directions;

        directions[index][0] = 1;
        directions[index][1] = 0;
        if (findPath(directions, index + 1, currentX + step, currentY, targetX, targetY) != null) return directions;

        directions[index][0] = 0;
        directions[index][1] = 1;
        if (findPath(directions, index + 1, currentX, currentY + step, targetX, targetY) != null) return directions;

        directions[index][0] = 0;
        directions[index][1] = -1;
        if (findPath(directions, index + 1, currentX, currentY - step, targetX, targetY) != null) return directions;

        return null;
    }
}