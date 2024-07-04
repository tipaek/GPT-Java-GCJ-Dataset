import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxLength = (int) (Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2)) + 1;
            int[][] pathArray = decomposeCoordinates(x, y, maxLength);

            System.out.print("Case #" + (caseIndex + 1) + ": ");

            if (pathArray != null) {
                printPath(pathArray);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void printPath(int[][] pathArray) {
        for (int[] direction : pathArray) {
            if (direction[0] == 1) System.out.print("E");
            else if (direction[0] == -1) System.out.print("W");
            else if (direction[1] == 1) System.out.print("N");
            else if (direction[1] == -1) System.out.print("S");
        }
        System.out.println();
    }

    private static int[][] decomposeCoordinates(int x, int y, int maxLength) {
        int[][] directionArray = new int[maxLength][2];
        return findPath(directionArray, 0, 0, 0, x, y);
    }

    private static int[][] findPath(int[][] directionArray, int stepIndex, int currentX, int currentY, int targetX, int targetY) {
        if (currentX == targetX && currentY == targetY) return directionArray;
        if (stepIndex >= directionArray.length) return null;

        int stepDistance = (int) Math.pow(2, stepIndex);

        directionArray[stepIndex][0] = -1;
        directionArray[stepIndex][1] = 0;
        if (findPath(directionArray, stepIndex + 1, currentX - stepDistance, currentY, targetX, targetY) != null) return directionArray;

        directionArray[stepIndex][0] = 1;
        directionArray[stepIndex][1] = 0;
        if (findPath(directionArray, stepIndex + 1, currentX + stepDistance, currentY, targetX, targetY) != null) return directionArray;

        directionArray[stepIndex][0] = 0;
        directionArray[stepIndex][1] = 1;
        if (findPath(directionArray, stepIndex + 1, currentX, currentY + stepDistance, targetX, targetY) != null) return directionArray;

        directionArray[stepIndex][0] = 0;
        directionArray[stepIndex][1] = -1;
        if (findPath(directionArray, stepIndex + 1, currentX, currentY - stepDistance, targetX, targetY) != null) return directionArray;

        return null;
    }
}