import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix and calculating the trace and row repeats
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }

            // Calculating the column repeats
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }

            System.out.format("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }
}