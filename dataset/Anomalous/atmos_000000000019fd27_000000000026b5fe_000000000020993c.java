import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scan.nextInt();

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Enter the size of the matrix: ");
            int size = scan.nextInt();
            int[][] matrix = new int[size][size];

            System.out.println("Enter the values for the matrix:");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int rowRepeats = countRowDuplicates(matrix);
            int columnRepeats = countColumnDuplicates(matrix);

            System.out.printf("Case #%d: Trace: %d, Row Repeats: %d, Column Repeats: %d%n", t, trace, rowRepeats, columnRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int rowRepeats = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int columnRepeats = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] columnArray = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                columnRepeats++;
            }
        }
        return columnRepeats;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}