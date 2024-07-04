import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}