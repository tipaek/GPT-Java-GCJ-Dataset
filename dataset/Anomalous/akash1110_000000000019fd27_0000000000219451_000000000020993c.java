import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRowRepeats(matrix, n);
            int columnRepeats = countColumnRepeats(matrix, n);

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int n) {
        int rowRepeats = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        return rowRepeats;
    }

    private static int countColumnRepeats(int[][] matrix, int n) {
        int columnRepeats = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    columnRepeats++;
                    break;
                }
            }
        }

        return columnRepeats;
    }
}