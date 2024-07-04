import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int trace = 0;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + x + " : " + trace);
            countRows(matrix, n);
            countCols(matrix, n);
        }
    }

    public static void countRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        System.out.print(" " + duplicateRowCount);
    }

    public static void countCols(int[][] matrix, int n) {
        int duplicateColCount = 0;

        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    duplicateColCount++;
                    break;
                }
            }
        }

        System.out.print(" " + duplicateColCount);
    }
}