import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        rowCheck[matrix[i][j]] = false;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                }
            }

            // Checking for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}