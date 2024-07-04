import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Rene Argento on 03/04/20.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();

        for (int t = 1; t <= tests; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            long trace = 0;
            int rowsWithRepeatedElements = 0;
            int columnsWithRepeatedElements = 0;

            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    matrix[row][column] = scanner.nextInt();
                    if (row == column) {
                        trace += matrix[row][column];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                if (hasRepeatedValueInRow(matrix, i)) {
                    rowsWithRepeatedElements++;
                }
                if (hasRepeatedValueInColumn(matrix, i)) {
                    columnsWithRepeatedElements++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowsWithRepeatedElements + " " +
                    columnsWithRepeatedElements);
        }
    }

    private static boolean hasRepeatedValueInRow(int[][] matrix, int row) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            if (values.contains(matrix[row][i])) {
                return true;
            }
            values.add(matrix[row][i]);
        }
        return false;
    }

    private static boolean hasRepeatedValueInColumn(int[][] matrix, int column) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            if (values.contains(matrix[i][column])) {
                return true;
            }
            values.add(matrix[i][column]);
        }
        return false;
    }

}
