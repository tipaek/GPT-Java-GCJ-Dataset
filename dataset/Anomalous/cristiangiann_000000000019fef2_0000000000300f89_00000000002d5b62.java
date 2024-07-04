import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxLength = (int) (Math.ceil(Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2))) + 1;
            int[][] directions = null;

            if ((x + y) % 2 != 0) {
                directions = decomposeCoordinates(x, y, maxLength);
            }

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

    private static int[][] decomposeCoordinates(int x, int y, int length) {
        int[][] directions = new int[length][2];
        return findPath(directions, 0, 0, 0, x, y);
    }

    private static int[][] findPath(int[][] directions, int step, int currentX, int currentY, int targetX, int targetY) {
        if (currentX == targetX && currentY == targetY) return directions;
        if (step >= directions.length) return null;

        int power = (int) Math.pow(2, step);

        directions[step][0] = -1;
        directions[step][1] = 0;
        if (findPath(directions, step + 1, currentX - power, currentY, targetX, targetY) != null) return directions;

        directions[step][0] = 1;
        directions[step][1] = 0;
        if (findPath(directions, step + 1, currentX + power, currentY, targetX, targetY) != null) return directions;

        directions[step][0] = 0;
        directions[step][1] = 1;
        if (findPath(directions, step + 1, currentX, currentY + power, targetX, targetY) != null) return directions;

        directions[step][0] = 0;
        directions[step][1] = -1;
        if (findPath(directions, step + 1, currentX, currentY - power, targetX, targetY) != null) return directions;

        return null;
    }
}