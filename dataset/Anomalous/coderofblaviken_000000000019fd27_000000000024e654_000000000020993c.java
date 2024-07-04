import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] == sortedArray[i - 1]) {
                return true;
            }
        }
        return false;
    }
}