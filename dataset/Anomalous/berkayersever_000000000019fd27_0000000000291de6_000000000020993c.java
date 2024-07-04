import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            int[] result = analyzeLatinSquare(matrix);
            System.out.printf("Case #%d: %d %d %d%n", x, result[0], result[1], result[2]);
        }
        input.close();
    }

    public static int[] analyzeLatinSquare(int[][] matrix) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            if (!isUnique(matrix[i])) rowDuplicates++;
        }

        for (int j = 0; j < matrix.length; j++) {
            if (!isColumnUnique(matrix, j)) colDuplicates++;
        }

        return new int[]{trace, rowDuplicates, colDuplicates};
    }

    public static boolean isUnique(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) return false;
            seen[value - 1] = true;
        }
        return true;
    }

    public static boolean isColumnUnique(int[][] matrix, int colIndex) {
        boolean[] seen = new boolean[matrix.length];
        for (int[] row : matrix) {
            if (seen[row[colIndex] - 1]) return false;
            seen[row[colIndex] - 1] = true;
        }
        return true;
    }
}