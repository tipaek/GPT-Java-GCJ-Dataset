

import java.util.HashSet;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        int[][] results = new int[testCases][3];
        for (int c = 0; c < testCases; c++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int element = input.nextInt();
                    matrix[i][j] = element;
                }
            }

            results[c][0] = sums(matrix);
            results[c][1] = duplicatesinRow(matrix);
            results[c][2] = duplicatesinColumn(matrix);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.format("Case #%d: %d %d %d \n", i+1, results[i][0], results[i][1], results[i][2]);
        }

    }


    private static int sums(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    private static int duplicatesinRow(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (hasDuplicateElementsR(array, i)) sum += 1;
        }
        return sum;
    }

    private static int duplicatesinColumn(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (hasDuplicateElementsC(array, i)) sum += 1;
        }
        return sum;
    }

    private static boolean hasDuplicateElementsR(int[][] array, int row) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[row][i])) return true;
            set.add(array[row][i]);
        }
        return false;
    }

    private static boolean hasDuplicateElementsC(int[][] array, int column) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i][column])) return true;
            set.add(array[i][column]);
        }
        return false;
    }

}
