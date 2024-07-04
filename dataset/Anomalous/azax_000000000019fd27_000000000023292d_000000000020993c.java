import java.util.Scanner;
import java.io.BufferedInputStream;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            int trace = 0;

            for (int row = 0; row < size; row++) {
                String[] line = scanner.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
                trace += matrix[row][row];
            }

            int[] badCounts = checkMatrix(matrix);
            int badRows = badCounts[0];
            int badCols = badCounts[1];

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + badRows + " " + badCols);
        }

        scanner.close();
    }

    private static int[] checkMatrix(int[][] matrix) {
        int size = matrix.length;
        int badRows = 0;
        int badCols = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                badRows++;
            }
        }

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                badCols++;
            }
        }

        return new int[]{badRows, badCols};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}