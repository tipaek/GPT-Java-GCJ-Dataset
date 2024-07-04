import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int trace = 0, rowRepeats = 0, colRepeats;
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (col == row) {
                        trace += value;
                    }
                }
                if (!isUniqueRow(matrix[row])) {
                    rowRepeats++;
                }
            }
            colRepeats = countColRepeats(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }

    private static boolean isUniqueRow(int[] row) {
        int length = row.length;
        boolean[] seen = new boolean[length];
        
        for (int value : row) {
            if (seen[value - 1]) {
                return false;
            }
            seen[value - 1] = true;
        }
        return true;
    }

    private static int countColRepeats(int[][] matrix) {
        int size = matrix.length;
        int colRepeats = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size];
            boolean hasDuplicate = false;

            for (int row = 0; row < size; row++) {
                int value = matrix[row][col];
                if (seen[value - 1]) {
                    hasDuplicate = true;
                    break;
                }
                seen[value - 1] = true;
            }

            if (hasDuplicate) {
                colRepeats++;
            }
        }
        return colRepeats;
    }
}