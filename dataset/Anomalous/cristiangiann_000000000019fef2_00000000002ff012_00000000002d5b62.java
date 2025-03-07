package foobar;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int length = (int) (Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2)) + 1;
            int[][] directions = decomposeCoordinates(x, y, length);

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
        int[][] directionArray = new int[length][2];
        return decompose(directionArray, 0, 0, 0, x, y);
    }

    private static int[][] decompose(int[][] array, int index, int sumX, int sumY, int targetX, int targetY) {
        if (sumX == targetX && sumY == targetY) return array;
        if (index >= array.length) return null;

        int power = (int) Math.pow(2, index);

        array[index][0] = -1;
        array[index][1] = 0;
        int[][] result = decompose(array, index + 1, sumX - power, sumY, targetX, targetY);
        if (result != null) return array;

        array[index][0] = 1;
        array[index][1] = 0;
        result = decompose(array, index + 1, sumX + power, sumY, targetX, targetY);
        if (result != null) return array;

        array[index][0] = 0;
        array[index][1] = 1;
        result = decompose(array, index + 1, sumX, sumY + power, targetX, targetY);
        if (result != null) return array;

        array[index][0] = 0;
        array[index][1] = -1;
        result = decompose(array, index + 1, sumX, sumY - power, targetX, targetY);
        if (result != null) return array;

        return null;
    }
}