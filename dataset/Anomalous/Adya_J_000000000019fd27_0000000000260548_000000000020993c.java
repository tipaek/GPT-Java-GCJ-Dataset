import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + x + ": " + trace);
            countRows(matrix, n);
            countCols(matrix, n);
        }
    }

    public static void countRows(int[][] matrix, int n) {
        int rowCount = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }

        System.out.print(" " + rowCount);
    }

    public static void countCols(int[][] matrix, int n) {
        int colCount = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }

        System.out.print(" " + colCount);
    }
}