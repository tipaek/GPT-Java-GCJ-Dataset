import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int testCase = 1; testCase <= cases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    matrix[row][column] = scanner.nextInt();
                }
            }

            int[] result = analyzeLatinSquare(matrix, size);
            System.out.printf("Case #%d: %d %d %d%n", testCase, result[0], result[1], result[2]);
        }

        scanner.close();
    }

    private static int[] analyzeLatinSquare(int[][] matrix, int size) {
        int trace = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean columnHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }

                if (!columnSet.add(matrix[j][i])) {
                    columnHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) {
                rowDuplicates++;
            }

            if (columnHasDuplicate) {
                columnDuplicates++;
            }
        }

        return new int[]{trace, rowDuplicates, columnDuplicates};
    }
}