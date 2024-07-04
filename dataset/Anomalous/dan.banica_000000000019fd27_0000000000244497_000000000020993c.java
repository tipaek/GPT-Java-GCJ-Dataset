import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    private void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int nTests = sc.nextInt();

        for (int test = 0; test < nTests; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int nInvalidRows = countInvalidRows(matrix, n);
            int nInvalidCols = countInvalidColumns(matrix, n);

            pw.printf("%d %d %d%n", trace, nInvalidRows, nInvalidCols);
        }

        pw.close();
    }

    private int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countInvalidRows(int[][] matrix, int n) {
        int invalidRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    invalidRows++;
                    break;
                }
            }
        }
        return invalidRows;
    }

    private int countInvalidColumns(int[][] matrix, int n) {
        int invalidCols = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    invalidCols++;
                    break;
                }
            }
        }
        return invalidCols;
    }

    public static void main(String[] args) {
        Vestigium sol = new Vestigium();
        sol.run();
    }
}