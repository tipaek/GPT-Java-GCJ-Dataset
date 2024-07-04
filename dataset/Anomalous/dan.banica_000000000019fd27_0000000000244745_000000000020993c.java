import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    private void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int nTests = sc.nextInt();
        int[][] matrix = new int[100][100];

        for (int test = 0; test < nTests; test++) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int invalidRows = countInvalidRows(matrix, n);
            int invalidCols = countInvalidCols(matrix, n);

            pw.println(trace + " " + invalidRows + " " + invalidCols);
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

    private int countInvalidCols(int[][] matrix, int n) {
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
        new Vestigium().run();
    }
}