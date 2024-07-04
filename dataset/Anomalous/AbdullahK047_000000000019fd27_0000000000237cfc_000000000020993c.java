import java.util.Scanner;

public class Vestigium {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scanner.nextInt();
        for (int t = 1; t <= x; t++) {
            int y = scanner.nextInt();
            int[][] matrix = new int[y][y];

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < y; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = traceFunc(matrix);
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < y; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < y; j++) {
                int[] col = new int[y];
                for (int i = 0; i < y; i++) {
                    col[i] = matrix[i][j];
                }
                if (hasDuplicates(col)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    public static int traceFunc(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static boolean hasDuplicates(int[] array) {
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