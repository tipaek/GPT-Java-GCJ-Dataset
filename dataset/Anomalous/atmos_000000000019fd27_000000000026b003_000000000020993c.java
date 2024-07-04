import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCaseCount = scan.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
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
            int rowDuplicates = countRowDuplicates(matrix);
            int colDuplicates = countColumnDuplicates(matrix);

            System.out.printf("Case #%d: trace = %d, row duplicates = %d, column duplicates = %d%n", t, trace, rowDuplicates, colDuplicates);
        }

        scan.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
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