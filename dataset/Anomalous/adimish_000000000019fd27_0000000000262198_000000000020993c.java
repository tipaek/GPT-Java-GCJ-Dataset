import java.util.Scanner;

public class LatinSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Checking for duplicate values in rows and columns
            for (int index = 0; index < n; index++) {
                if (hasDuplicates(matrix[index])) {
                    rowRepeats++;
                }

                int[] column = new int[n];
                for (int row = 0; row < n; row++) {
                    column[row] = matrix[row][index];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value < 1 || value > array.length || seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}