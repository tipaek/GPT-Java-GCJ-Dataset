package datadef.prac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LatinMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] results = calculateMatrixProperties(matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseIndex, results[0], results[1], results[2]);
        }
    }

    public static int[] calculateMatrixProperties(int[][] matrix) {
        int trace = 0;
        int rowsWithDuplicates = 0;
        int colsWithDuplicates = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) {
                rowsWithDuplicates++;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;

            for (int i = 0; i < matrix.length; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }

            if (colHasDuplicate) {
                colsWithDuplicates++;
            }
        }

        return new int[]{trace, rowsWithDuplicates, colsWithDuplicates};
    }
}