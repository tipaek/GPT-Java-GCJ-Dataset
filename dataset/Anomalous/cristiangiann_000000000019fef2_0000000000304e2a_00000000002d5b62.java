import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int steps = (int) (Math.ceil(Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2))) + 1;
            int[][] path = null;

            if ((x + y) % 2 != 0) {
                path = decomposeCoordinates(x, y, steps);
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            if (path != null) {
                printPath(path);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void printPath(int[][] path) {
        for (int[] move : path) {
            if (move[0] == 1) System.out.print("E");
            if (move[0] == -1) System.out.print("W");
            if (move[1] == 1) System.out.print("N");
            if (move[1] == -1) System.out.print("S");
        }
        System.out.println();
    }

    private static int[][] decomposeCoordinates(int x, int y, int steps) {
        int[][] movements = new int[steps][2];
        return decompose(movements, steps - 1, 0, 0, x, y);
    }

    private static int[][] decompose(int[][] movements, int index, int currentX, int currentY, int targetX, int targetY) {
        if (currentX == targetX && currentY == targetY) return movements;
        if (index < 0) return null;

        int power = (int) Math.pow(2, index);
        int[][] result;

        movements[index][0] = -1; movements[index][1] = 0;
        result = decompose(movements, index - 1, currentX - power, currentY, targetX, targetY);
        if (result != null) return result;

        movements[index][0] = 1; movements[index][1] = 0;
        result = decompose(movements, index - 1, currentX + power, currentY, targetX, targetY);
        if (result != null) return result;

        movements[index][0] = 0; movements[index][1] = 1;
        result = decompose(movements, index - 1, currentX, currentY + power, targetX, targetY);
        if (result != null) return result;

        movements[index][0] = 0; movements[index][1] = -1;
        result = decompose(movements, index - 1, currentX, currentY - power, targetX, targetY);
        return result;
    }
}