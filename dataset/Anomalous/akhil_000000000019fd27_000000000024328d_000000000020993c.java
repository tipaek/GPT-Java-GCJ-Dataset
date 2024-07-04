import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int index = 1; index <= numCases; index++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] results = computeTrace(matrix);
            System.out.printf("Case #%d: %d %d %d%n", index, results[0], results[1], results[2]);
        }
    }

    public static int[] computeTrace(int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicates = false;

            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicates = true;
                }
            }

            if (rowHasDuplicates) {
                repeatedRows++;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicates = false;

            for (int i = 0; i < matrix.length; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicates = true;
                }
            }

            if (colHasDuplicates) {
                repeatedCols++;
            }
        }

        return new int[]{trace, repeatedRows, repeatedCols};
    }
}