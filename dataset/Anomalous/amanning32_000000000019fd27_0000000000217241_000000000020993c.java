import java.util.Scanner;

class Solution {

    private static int[] calculate(int[][] matrix) {
        int n = matrix.length;
        int trace = 0, rowCount = 0, colCount = 0;

        // Calculate trace of the matrix
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j] - 1]) {
                    rowCount++;
                    break;
                }
                seen[matrix[i][j] - 1] = true;
            }
        }

        // Check for duplicate values in columns
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i] - 1]) {
                    colCount++;
                    break;
                }
                seen[matrix[j][i] - 1] = true;
            }
        }

        return new int[]{trace, rowCount, colCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = calculate(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, result[0], result[1], result[2]);
        }
    }
}