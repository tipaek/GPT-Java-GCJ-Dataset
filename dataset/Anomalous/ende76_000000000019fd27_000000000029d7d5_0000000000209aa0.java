import java.util.Scanner;

public class Solution {

    private static boolean fillMatrix(int[][] matrix, boolean[][] rowFlags, boolean[][] colFlags, int row, int col) {
        int size = rowFlags.length;

        if (row == size) return true;
        if (col == size) return fillMatrix(matrix, rowFlags, colFlags, row + 1, 0);
        if (row == col) return fillMatrix(matrix, rowFlags, colFlags, row, col + 1);

        for (int value = 1; value <= size; value++) {
            if (rowFlags[row][value] || colFlags[col][value]) continue;

            rowFlags[row][value] = true;
            colFlags[col][value] = true;
            matrix[row][col] = value;

            if (fillMatrix(matrix, rowFlags, colFlags, row, col + 1)) return true;

            rowFlags[row][value] = false;
            colFlags[col][value] = false;
        }

        return false;
    }

    private static boolean findDiagonalValues(int[][] matrix, int sum, int startValue, int index) {
        int size = matrix.length;

        if (sum < 0) return false;
        if (index == size) {
            if (sum != 0) return false;

            boolean[][] rowFlags = new boolean[size][size + 1];
            boolean[][] colFlags = new boolean[size][size + 1];

            for (int i = 0; i < size; i++) {
                rowFlags[i][matrix[i][i]] = true;
                colFlags[i][matrix[i][i]] = true;
            }

            return fillMatrix(matrix, rowFlags, colFlags, 0, 0);
        }

        for (int value = startValue; value <= size; value++) {
            matrix[index][index] = value;
            if (findDiagonalValues(matrix, sum - value, value, index + 1)) return true;
        }

        return false;
    }

    private static String[] solvePuzzle(int size, int sum) {
        int[][] matrix = new int[size][size];

        if (!findDiagonalValues(matrix, sum, 1, 0)) return new String[] {"IMPOSSIBLE"};

        String[] result = new String[size + 1];
        result[0] = "POSSIBLE";

        for (int i = 0; i < size; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < size; j++) {
                rowBuilder.append(matrix[i][j]);
                if (j < size - 1) rowBuilder.append(' ');
            }
            result[i + 1] = rowBuilder.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();

            String[] result = solvePuzzle(size, sum);

            System.out.printf("Case #%d: %s\n", t, result[0]);
            for (int i = 1; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}