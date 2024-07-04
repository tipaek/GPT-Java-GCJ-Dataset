import java.util.Scanner;

public class MatrixTraceAndDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int size = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                String[] values = scanner.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                trace += matrix[row][row];
            }

            int[] badCounts = countBadRowsAndColumns(matrix);
            int badRows = badCounts[0];
            int badCols = badCounts[1];

            System.out.println("Case #" + caseIndex + ": " + trace + " " + badRows + " " + badCols);
        }

        scanner.close();
    }

    private static int[] countBadRowsAndColumns(int[][] matrix) {
        int size = matrix.length;
        int badRows = 0;
        int badCols = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                badRows++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                badCols++;
            }
        }

        return new int[]{badRows, badCols};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // +1 to handle 1-based values
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}