import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            evaluateMatrix(t, matrix);
        }
    }

    private static void evaluateMatrix(int testCaseNumber, int[][] matrix) {
        int n = matrix.length;
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasRepeats = false, colHasRepeats = false;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j]) && !rowHasRepeats) {
                    rowRepeats++;
                    rowHasRepeats = true;
                }
                if (!colSet.add(matrix[j][i]) && !colHasRepeats) {
                    colRepeats++;
                    colHasRepeats = true;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}